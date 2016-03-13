/**
 * Created by ZhiLI on 2015/12/21.
 * Email: lizhipower@gmail.com
 */
var AppDispatcher = require('../dispatchers/AppDispatcher');
var AppConstants = require('../constants/AppConstants');

var AppServerActions = {
    fileUploaded: function (items) {
        AppDispatcher.handleServerAction({
            actionType: AppConstants.FILE_UPLOADED,
            item: items
        });
    }

};

module.exports = AppServerActions;