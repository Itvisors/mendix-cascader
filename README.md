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
To use the widget you need an object where the options are stored in JSON format (see below) and a response value. In the additional properties one has multiple options to let the widget behave how you want, e.g. by allowing users to search or to expand submenus by hover over them.

By default only the selected item is returned in the respose. However, one can choose to get the complete tree in the response. This tree is then returned in JSON format ["value"], where the item in the first column is placed first, then the second one, etc. 

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
]
```
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
]
```

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
]
```

The default value is expected to be at the lowest level and the disabled value can be set at every level.
