import { Component, createElement } from "react";

import { Cascader } from "antd";
import "antd/dist/antd.css";

export class CascaderUI extends Component {
    onChange(value) {
        console.log(value);
    }

    render() {
        return (
            <Cascader
                options={this.props.options}
                showSearch={this.props.isSearchable}
                className={this.props.className}
                placeholder="Please select"
                defaultValue={this.props.defaultValue}
            />
        );
    }
}
