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

    deepLoop(array, defaultValue) {
        if (array.children !== undefined && array.children.length !== 0) {
            for (const i in array.children) {
                if (this.defaultValue.length > 0) {
                    return;
                }
                const newDefaultValue = [...defaultValue];
                newDefaultValue.push(array.value);
                this.deepLoop(array.children[i], newDefaultValue);
            }
        } else {
            if (array.default) {
                defaultValue.push(array.value);
                this.defaultValue = defaultValue;
            }
        }
    }

    componentDidUpdate(prevProps) {
        // Check if options changed
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
    render() {
        if (this.options === undefined) {
            return "";
        }
        return (
            <CascaderUI
                options={this.options}
                defaultValue={this.defaultValue}
                isSearchable={this.props.isSearchable}
                className={this.props.class}
            />
        );
    }
}
