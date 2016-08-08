var expect = require('expect.js');
var assert = require('assert');
var util = require('../util.js');

describe('/report/{id}', function() {

    var endpoint = '/report/';
    var body = {
        type: "SORT",
        nbIterations: 2,
        sampleSize: 100,
        reportItems: [
            {
                algoName: "Classic Sort",
                avgTime: 2000,
                timePerIteration: [
                    {
                        iteration: 0,
                        timeSpent: 1
                    },
                    {
                        iteration: 1,
                        timeSpent: 2
                    }
                ],
                timePerSample: [
                    {
                        iteration: 50,
                        timeSpent: 1
                    },
                    {
                        iteration: 100,
                        timeSpent: 2
                    }
                ]
            }
        ]
    };

    it('should get the report in DB', function() {

        util.executeRequest('POST', endpoint + 'save', body)
            .then(function(result) {
                var id = result.id;

                util.executeRequest('GET', endpoint + id)
                    .then(function(result) {
                        // check the response data
                        assert.equal(result.id, id);
                        assert.equal(result.nbIterations, 2);
                        assert.equal(result.sampleSize, 100);
                        assert.equal(result.type, "SORT");

                        assert.equal(result.reportItems.length, 1);
                        assert.equal(result.reportItems[0].algoName, 'Classic Sort');
                        assert.equal(result.reportItems[0].avgTime, 2000);

                        expect(result.reportItems[0].timePerIteration).not.to.be.null;
                        expect(result.reportItems[0].timePerSample).not.to.be.null;
                    });
            });
    });
});