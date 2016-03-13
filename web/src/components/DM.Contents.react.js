/** @jsx React.DOM */
var React = require('react');

var TbGrade = require('./DM.Contents.TbGrade.react');

var Contents = React.createClass({

    render: function () {
        var jsonArr = this.props.contents;
        console.log(jsonArr);
        return (
            <TbGrade rows={jsonArr}></TbGrade>
        )
    }
});

module.exports = Contents;