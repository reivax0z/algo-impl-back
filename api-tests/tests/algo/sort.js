var expect = require('expect.js');
var util = require('../util.js');

describe('/algo/sort/{iteration}/{size}',function() {
    it('should get back the report',function() {

        var nbIterations = 10;
        var sampleSize = 100;

        var endpoint = '/algo/sort/' + nbIterations + '/' + sampleSize;

        util.executeRequest('GET', endpoint)
            .then(function success(result) {
                // check the response data
                expect(result.nbIterations).to.be(nbIterations);
                expect(result.sampleSize).to.be(sampleSize);
                expect(result.reportItems.length).to.be(2);
            });
    });
});