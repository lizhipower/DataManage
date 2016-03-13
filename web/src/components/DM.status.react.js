/** @jsx React.DOM */
var React = require('react');
var Status = React.createClass({

    render: function () {
        var status = this.props.status;
        var StatusContent;
        if (status == 'normal') {
            StatusContent = 'Please Upload Your File';
        } else if (status == 'success') {
            StatusContent = 'Success to upload';
        } else {
            StatusContent = 'Fail to upload your file.';
        }
        return (
            <div>
                <p>{StatusContent}</p>
            </div>
        )
    }
});

module.exports = Status;