import { Component, createElement } from "react";

import { HelloWorldSample } from "./components/HelloWorldSample";
import "./ui/Cascader.css";

export default class Cascader extends Component {
    render() {
        return <HelloWorldSample sampleText={this.props.sampleText} />;
    }
}
