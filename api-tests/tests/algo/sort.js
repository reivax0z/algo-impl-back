var assert = require('assert');
var util = require('../util.js');

describe('/algo/sort/{iteration}/{size}', function() {

    var nbIterations = 10;
    var sampleSize = 100;

    var endpoint = '/algo/sort/' + nbIterations + '/' + sampleSize;

    it('should get back the report', function() {

        util.executeRequest('GET', endpoint)
            .then(function(result) {
                // check the response data
                assert.equal(result.nbIterations, nbIterations);
                assert.equal(result.sampleSize, sampleSize);
                assert.equal(result.reportItems.length, 2);
            });
    });
});