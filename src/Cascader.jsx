import { Component, createElement } from "react";

import { CascaderUI } from "./components/CascaderUI";
import "./ui/Cascader.css";

export default class Cascader extends Component {
    constructor(props) {
        super(props);
        this.state = {
            updateDate: undefined
        };
        this.options = undefined;
        this.defaultValue = [];
    }

    // loop through array and all children arrays
    deepLoop(array, defaultValue) {
        // If there is another children array with a minimum length, loop through the children array
        if (array.children !== undefined && array.children.length !== 0) {
            for (const i in array.children) {
                // If default length is already filled, skip
                if (this.defaultValue.length > 0) {
                    return;
                }
                // Add value to default value to have the complete trace
                const newDefaultValue = [...defaultValue];
                newDefaultValue.push(array.value);
                this.deepLoop(array.children[i], newDefaultValue);
            }
        } else {
            // This is a lowest 'child'
            if (array.default) {
                defaultValue.push(array.value);
                this.defaultValue = defaultValue;
                // Initialize default value and write back to mendix
                this.props.responseAttribute.setValue(defaultValue.at(-1));
            }
        }
    }

    componentDidUpdate() {
        // Check if options are not yet initialized but are available now
        if (this.options === undefined && this.props.optionsAttribute.status === "available") {
            try {
                this.options = JSON.parse(this.props.optionsAttribute.value);
            } catch (e) {
                this.options = [];
            }
            // recalculate default value
            for (const optionIndex in this.options) {
                this.deepLoop(this.options[optionIndex], []);
            }
            this.setState({ updateDate: new Date() });
        }
    }

    onChange = value => {
        this.props.responseAttribute.setValue(value.at(-1));
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
        let placeholder = undefined;
        if (this.props.placeholder && this.props.placeholder.value) {
            placeholder = this.props.placeholder.value;
        }
        return (
            <CascaderUI
                options={this.options}
                defaultValue={this.defaultValue}
                isSearchable={this.props.isSearchable}
                className={this.props.class}
                onChange={value => this.onChange(value)}
                disabled={this.props.responseAttribute.readOnly}
                changeOnSelect={this.props.allowSelectParents}
                expandTrigger={expandTrigger}
                displayRender={displayRender}
                placeholder={placeholder}
            />
        );
    }
}
