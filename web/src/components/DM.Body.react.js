/** @jsx React.DOM */
var React = require('react');
var $ = require('jquery');

var WebAPI = require('../utils/TodoWebAPIUtils');
var Body = React.createClass({
    handleUpload: function (e) {
        e.preventDefault();
        if (window.FormData) {
            var formData = new FormData();
            console.log(document.getElementById('fileUpload').files[0]);
            formData.append('fileUpload', document.getElementById('fileUpload').files[0]);
            console.log(formData);
            WebAPI.fileUpload(formData);
        }
    },
    _onChange: function () {

    },
    render: function () {
        return (
            <div id="body">
                <form enctype="multipart/form-data">
                    <input type="file" id="fileUpload" name="file" size="50"/>
                    <br/>
                    <input type="submit" value="doSubmit" onClick={this.handleUpload}/>
                </form>
            </div>
        )
    }
});

module.exports = Body;