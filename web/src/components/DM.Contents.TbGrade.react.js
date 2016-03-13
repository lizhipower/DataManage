/** @jsx React.DOM */
var React = require('react');
var $ = require('jquery');
var TbGrade = React.createClass({

    render: function () {
        var ROWS = this.props.rows;
        var Header;
        console.log(ROWS);

        if (!$.isEmptyObject(ROWS)) {
            var Rows;
            if ($.isArray(ROWS)) {
                Rows = ROWS.map(function (vRows) {
                    Header = getHeader(vRows);
                    return (
                        <tr>{getTdArr(vRows)}</tr>
                    )
                });
            } else {
                Header = getHeader(ROWS);
                Rows = <tr>{getTdArr(ROWS)}</tr>;
            }

        }

        return (
            <table>
                {Header}
                {Rows}
            </table>
        )
    }
});
function getHeader(ele) {
    var Header;
    var thArr = [];
    for (var key in ele) {
        console.log(key);
        thArr.push(<th>{key}</th>);
    }
    Header = <tr>{thArr}</tr>;
    return Header;
}
function getTdArr(ROWS) {
    var tdArr = [];
    for (var k in ROWS) {
        var vRow = ROWS[k];
        var tdTemp;
        if (typeof(vRow) == "string") {
            console.log('string', vRow);
            tdTemp = <td>{vRow}</td>;
        } else {
            console.log('obj', vRow);
            tdTemp = <td>
                <TbGrade rows={vRow}></TbGrade>
            </td>;
        }
        tdArr.push(tdTemp);
    }

    return tdArr;
}
module.exports = TbGrade;