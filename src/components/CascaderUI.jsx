import { Component, createElement } from "react";

import { Cascader } from "antd";
import "antd/dist/antd.css";

export class CascaderUI extends Component {
    render() {
        return (
            <Cascader
                options={this.props.options}
                showSearch={this.props.isSearchable}
                className={this.props.className}
                placeholder={this.props.placeholder}
                onChange={value => this.props.onChange(value)}
                defaultValue={this.props.defaultValue}
                disabled={this.props.disabled}
                changeOnSelect={this.props.changeOnSelect}
                expandTrigger={this.props.expandTrigger}
                displayRender={this.props.displayRender}
            />
        );
    }
}
