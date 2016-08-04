var request = require('request');

var server = 'localhost';
var port = '8080';
var app = 'algo-impl';

var URL = 'http://'+ server +':'+ port + '/' + app;

var executeRequest = function(method, url, body) {
    var defer = protractor.promise.defer();

    var options = {
        uri: URL + url,
        method: method,
        body: body,
        json: true
    };

    // method can be ‘GET’, ‘POST’ or ‘PUT’
    request(options, function(error, response, body) {

        if (error || response.statusCode >= 400) {
            defer.reject({
                error : error,
                message : response
            });
        } else {
            defer.fulfill(body);
        }
    });

    // Return a promise so the caller can wait on it for the request to complete
    return defer.promise;
};
exports.executeRequest = executeRequest;