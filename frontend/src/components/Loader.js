import React from "react";

const Loader = (props) => {
  return (
    <tr>
      <td>
        <div className="ui basic segment">
          <div className="ui active inverted dimmer">
            <div
              className="ui large text loader"
              style={{
                marginTop: `${props.topMargin}px`,
                marginLeft: `${props.leftMargin}px`,
              }}
            >
              {props.text}
            </div>
          </div>
        </div>
      </td>
    </tr>
  );
};

export default Loader;
