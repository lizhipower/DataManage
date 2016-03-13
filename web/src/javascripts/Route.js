/** @jsx React.DOM */
var React = require('react');
var ReactRouter = require('react-router');
var hashHistory = ReactRouter.hashHistory;
var Router = ReactRouter.Router;
var Route = ReactRouter.Route;
var IndexRoute = ReactRouter.IndexRoute;

var DM = require('../components/DM.react');

var Routes = React.createClass({
    render: function () {
        return (
            <Router history={hashHistory}>
                <Route path="/" component={DM}>

                </Route>
            </Router>
        );
    }
});
module.exports = Routes;