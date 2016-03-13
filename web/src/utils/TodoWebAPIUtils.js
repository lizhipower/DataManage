/**
 * Created by ZhiLI on 2015/12/21.
 * Email: lizhipower@gmail.com
 */
var AppServerActions = require('../actions/ServerActionCreators');
var Promise = require('es6-promise').Promise;
var $ = require('jquery');

var TodoWebAPIUtils = {
    fileUpload: function (data) {
        var fileUploadUrl = '/DataManage/FileUpload';
        console.log('pre pre promise');
        console.log(data);
        var xhr = new XMLHttpRequest();
        xhr.open('POST', fileUploadUrl);
        // 定义上传完成后的回调函数
        xhr.onload = function (data) {
            var items;
            if (xhr.status === 200) {
                console.log('上传成功');
                var uploadContent = JSON.parse(data.target.response);
                console.log(uploadContent);
                items = {
                    content: uploadContent,
                    status: 'success'
                };
            } else {
                console.log('出错了');
                items = {
                    content: uploadContent,
                    status: 'success'
                };

            }
            AppServerActions.fileUploaded(items);

        };
        xhr.send(data);
        //var fileUploadPromise = Promise.resolve(
        //    $.ajax({
        //        type: "POST",
        //        url: fileUploadUrl,
        //        contentType: false,
        //        processType: false,
        //        cache: false,
        //        data: data,
        //        dataType: "JSON"
        //}));
        console.log('pre promise');
        //fileUploadPromise.then(function (fileContents) {
        //    //AppServerActions.getAllTodoItems(allTodoItems);
        //    console.log('promise success')
        //    console.log(fileContents);
        //});
    }


};

module.exports = TodoWebAPIUtils;