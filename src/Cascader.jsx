import { Component, createElement } from "react";

import { CascaderUI } from "./components/CascaderUI";
import "./ui/Cascader.css";

export default class Cascader extends Component {
    render() {
        return (
            <CascaderUI
                options={this.props.optionsAttribute.value}
                isSearchable={this.props.isSearchable}
                className={this.props.class}
            />
        );
    }
}
