import { Component, createElement } from "react";

import { Cascader } from "antd";
import "antd/dist/antd.css";

export class CascaderUI extends Component {
    onChange(value) {
        console.log(value);
    }

    render() {
        let options;

        try {
            options = JSON.parse(this.props.options);
        } catch (e) {
            options = [];
        }

        return <Cascader options={options} showSearch={this.props.isSearchable} placeholder="Please select" />;
    }
}
