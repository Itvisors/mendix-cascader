## Cascader
Cascader widget based on https://ant.design/components/cascader/.

## Features
- Cascading dropdown to show only options based on previous answer.
- Search for options by typing
- Hover to show sub-menu
- Onchange action
- Set a custom placeholder
- Show complete tree or only label of selected item.
- Default mendix behavior for labeling, visibility and editability.

## Usage
To use the widget you need an object where the options are stored in JSON format (see below) and a response value.

### JSON
The widget needs the list of options in JSON format. The format for 2 layers is:
```[
    {
        "value": "string",
        "label": "string",
        "children": [
            {
                "value": "string",
                "label": "string"
            }
        ]
    }
]```
This format can be extended easily with another layer, by adding another children property, e.g. for 3 layers:

```[
    {
        "value": "string",
        "label": "string",
        "children": [
            {
                "value": "string",
                "label": "string",
                "children": [
                    {
                        "value": "string",
                        "label": "string"
                    }
                ]
            }
        ]
    }
]```

Options can be set to disabled or default by adding a disabled/default boolean to the json, e.g.
```[
    {
        "value": "string",
        "label": "string",
        "disabled": true,
        "children": [
            {
                "value": "string",
                "label": "string",
                "disabled": true,
                "default": true
            }
        ]
    }
]```

The default value is expected to be at the lowest level and the disabled value can be set at every level.
