/** @jsx React.DOM */

var React = require('React');
var AppStore = require('../stores/AppStore');

var $ = require('jquery');

var Header = require('./DM.Header.react.js');
var Body = require('./DM.Body.react.js');

var Contents = require('./DM.Contents.react.js');
var Status = require('./DM.Status.react.js');


function getDMState() {
    var state = {
        infoGrade: AppStore.getAll(),
        uploadStatus: AppStore.getStatus()
    };
    console.log(state);
    return state;
}
var DM = React.createClass({

    getInitialState: function () {
        return getDMState();
    },
    componentDidMount: function () {
        AppStore.addChangeListener(this._onChange);
    },
    componentWillUnmount: function () {
        AppStore.removeChangeListener(this._onChange);
    },
    _onChange: function () {
        this.setState(getDMState());
    },
    render: function () {

        return (
            <div>
                <Header/>
                <Body/>
                <Contents contents={this.state.infoGrade}/>
                <Status status={this.state.uploadStatus}/>
            </div>

        )
    }
});

module.exports = DM;