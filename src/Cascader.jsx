import { Component, createElement, Fragment } from "react";

import { CascaderUI } from "./components/CascaderUI";
import "./ui/Cascader.css";
import { Alert } from "./components/Alert";

export default class Cascader extends Component {
    constructor(props) {
        super(props);
        this.state = {
            updateDate: undefined
        };
        this.options = undefined;
        this.value = undefined;
        this.initialized = false;
        this.setByWidget = false;
    }

    // loop through array and all children arrays
    deepLoop(array, value) {
        // If there is another children array with a minimum length, loop through the children array
        if (array.children !== undefined && array.children.length !== 0) {
            for (const i in array.children) {
                // If default length is already filled, skip
                if (this.value && this.value.length > 0) {
                    return;
                }
                // Add value to default value to have the complete trace
                const newValue = [...value];
                newValue.push(array.value);
                this.deepLoop(array.children[i], newValue);
            }
        } else {
            // This is a lowest 'child'
            if (array.default) {
                value.push(array.value);
                this.value = value;
                // Initialize default value and write back to mendix
                this.setResponse(value);
            }
        }
    }

    componentDidUpdate(prevProps) {
        // Check if options are not yet initialized but are available now
        if (this.props.optionsAttribute.status === "available") {
            if (
                this.props.responseAttribute &&
                prevProps.responseAttribute.value !== this.props.responseAttribute.value
            ) {
                if (this.setByWidget) {
                    this.setByWidget = false;
                } else {
                    try {
                        this.value = JSON.parse(this.props.responseAttribute.value);
                    } catch (e) {
                        this.value = undefined;
                    }
                    this.setState({ updateDate: new Date() });
                }
            }
            // If options not yet set or if options have been changed
            if (this.options === undefined || prevProps.optionsAttribute !== this.props.optionsAttribute) {
                try {
                    this.options = JSON.parse(this.props.optionsAttribute.value);
                } catch (e) {
                    this.options = [];
                }
                if (this.initialized === false) {
                    // Calculate default value if widget not yet initialized
                    for (const optionIndex in this.options) {
                        this.deepLoop(this.options[optionIndex], []);
                    }
                }

                this.initialized = true;
                this.setState({ updateDate: new Date() });
            }
        }
    }

    // Set response attribute to either the complete tree or only the selected option
    setResponse = value => {
        if (this.props.completeTreeResponse) {
            this.props.responseAttribute.setValue(JSON.stringify(value));
        } else {
            if (value) {
                this.props.responseAttribute.setValue(value.at(-1));
            } else {
                this.props.responseAttribute.setValue(value);
            }
        }
        this.value = value;
        this.setByWidget = true;
    };

    onChange = value => {
        this.setResponse(value);
        //Call on change action if there is one
        if (this.props.onChangeAction && this.props.onChangeAction.canExecute) {
            this.props.onChangeAction.execute();
        }
    };

    // Just show the latest item.
    displayRender = value => value.at(-1);

    render() {
        if (this.options === undefined) {
            return "";
        }
        const expandTrigger = this.props.expandOnHover ? "hover" : "click";
        const displayRender = this.props.onlyShowLabel ? this.displayRender : undefined;
        let placeholder;
        if (this.props.placeholder && this.props.placeholder.value) {
            placeholder = this.props.placeholder.value;
        }
        const validationFeedback = this.props.responseAttribute.validation;
        return (
            <Fragment>
                <CascaderUI
                    options={this.options}
                    value={this.value}
                    isSearchable={this.props.isSearchable}
                    className={this.props.class}
                    onChange={value => this.onChange(value)}
                    disabled={this.props.responseAttribute.readOnly}
                    changeOnSelect={this.props.allowSelectParents}
                    expandTrigger={expandTrigger}
                    displayRender={displayRender}
                    placeholder={placeholder}
                />
                <Alert>{validationFeedback}</Alert>
            </Fragment>
        );
    }
}
