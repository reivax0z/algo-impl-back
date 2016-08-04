var expect = require('expect.js');
var assert = require('assert');
var util = require('../util.js');

describe('/report/save', function() {

    var endpoint = '/report/save';
    var body = {
        type: "SORT",
        nbIterations: 10,
        sampleSize: 100,
        reportItems: [
            {
                algoName: "Classic Sort",
                avgTime: 0,
                timePerIteration: {
                    "0": 0,
                    "1": 0,
                    "2": 0,
                    "3": 0,
                    "4": 0,
                    "5": 0,
                    "6": 0,
                    "7": 1,
                    "8": 0,
                    "9": 0
                }
            },
            {
                algoName: "Bubble Sort",
                avgTime: 0,
                timePerIteration: {
                    "0": 0,
                    "1": 0,
                    "2": 0,
                    "3": 0,
                    "4": 0,
                    "5": 0,
                    "6": 0,
                    "7": 0,
                    "8": 0,
                    "9": 0
                }
            }
        ]
    };

    it('should save the report in DB', function() {

        util.executeRequest('POST', endpoint, body)
            .then(function(result) {
                // check the response data
                expect(result.id).not.to.be.null;
                assert.equal(result.nbIterations, 10);
                assert.equal(result.sampleSize, 100);
                assert.equal(result.type, "SORT");
                assert.equal(result.reportItems.length, 2);
            });
    });
});