import { Component, createElement } from "react";

import { Cascader } from "antd";

export class CascaderUI extends Component {
    render() {
        return (
            <Cascader
                options={this.props.options}
                showSearch={this.props.isSearchable}
                className={this.props.className}
                placeholder={this.props.placeholder}
                onChange={value => this.props.onChange(value)}
                value={this.props.value}
                disabled={this.props.disabled}
                changeOnSelect={this.props.changeOnSelect}
                expandTrigger={this.props.expandTrigger}
                displayRender={this.props.displayRender}
            />
        );
    }
}
