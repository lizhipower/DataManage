var AppDispatcher = require('../dispatchers/AppDispatcher');
var AppConstants = require('../constants/AppConstants');
var EventEmitter = require('events').EventEmitter;
var assign = require('object-assign');
//var TodoWebAPIUtils = require('../utils/TodoWebAPIUtils');


var _data = {};
var _status = 'normal';
var CHANGE_EVENT = 'change';

var AppStore = assign({}, EventEmitter.prototype, {
    getAll: function () {
        return _data;
    },
    getStatus: function () {
        return _status
    },
    get: function (id) {
        return _data[id];
    },
    emitChange: function () {
        this.emit(CHANGE_EVENT);
    },
    addChangeListener: function (callback) {
        this.on(CHANGE_EVENT, callback)
    },
    removeChangeListener: function (callback) {
        this.removeListener(CHANGE_EVENT, callback);
    }

});


AppDispatcher.register(function (payload) {
    var action = payload.action;
    var actionType = action.actionType;

    switch (actionType) {
        case AppConstants.FILE_UPLOADED:
            console.log('file uploaded');
            console.log(action);
            fileUploaded(action.item);
            break;


        default:
            return true;

    }
    AppStore.emitChange();

    return true;
});
function fileUploaded(items) {
    var content = items.content,
        status = items.status;

    _status = status;

    if (status == 'success') {
        _data = content;
    }
}


module.exports = AppStore;