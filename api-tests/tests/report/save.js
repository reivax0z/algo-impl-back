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
                timePerIteration: [
                    {
                        iteration: 0,
                        timeSpent: 1
                    },
                    {
                        iteration: 1,
                        timeSpent: 2
                    },
                    {
                        iteration: 2,
                        timeSpent: 3
                    },
                    {
                        iteration: 3,
                        timeSpent: 2
                    },
                    {
                        iteration: 4,
                        timeSpent: 2
                    },
                    {
                        iteration: 5,
                        timeSpent: 2
                    },
                    {
                        iteration: 6,
                        timeSpent: 2
                    },
                    {
                        iteration: 7,
                        timeSpent: 2
                    },
                    {
                        iteration: 8,
                        timeSpent: 2
                    },
                    {
                        iteration: 9,
                        timeSpent: 3
                    }
                ],
                timePerSample: [
                    {
                        iteration: 10,
                        timeSpent: 0
                    },
                    {
                        iteration: 20,
                        timeSpent: 1
                    },
                    {
                        iteration: 30,
                        timeSpent: 1
                    },
                    {
                        iteration: 40,
                        timeSpent: 1
                    },
                    {
                        iteration: 50,
                        timeSpent: 2
                    },
                    {
                        iteration: 60,
                        timeSpent: 2
                    },
                    {
                        iteration: 70,
                        timeSpent: 2
                    },
                    {
                        iteration: 80,
                        timeSpent: 2
                    },
                    {
                        iteration: 90,
                        timeSpent: 2
                    },
                    {
                        iteration: 100,
                        timeSpent: 3
                    }
                ]
            },
            {
                algoName: "Bubble Sort",
                avgTime: 0,
                timePerIteration: [
                    {
                        iteration: 0,
                        timeSpent: 5
                    },
                    {
                        iteration: 1,
                        timeSpent: 5
                    },
                    {
                        iteration: 2,
                        timeSpent: 7
                    },
                    {
                        iteration: 3,
                        timeSpent: 6
                    },
                    {
                        iteration: 4,
                        timeSpent: 5
                    },
                    {
                        iteration: 5,
                        timeSpent: 5
                    },
                    {
                        iteration: 6,
                        timeSpent: 5
                    },
                    {
                        iteration: 7,
                        timeSpent: 5
                    },
                    {
                        iteration: 8,
                        timeSpent: 8
                    },
                    {
                        iteration: 9,
                        timeSpent: 14
                    }
                ],
                timePerSample: [
                    {
                        iteration: 10,
                        timeSpent: 0
                    },
                    {
                        iteration: 20,
                        timeSpent: 1
                    },
                    {
                        iteration: 30,
                        timeSpent: 1
                    },
                    {
                        iteration: 40,
                        timeSpent: 2
                    },
                    {
                        iteration: 50,
                        timeSpent: 2
                    },
                    {
                        iteration: 60,
                        timeSpent: 4
                    },
                    {
                        iteration: 70,
                        timeSpent: 6
                    },
                    {
                        iteration: 80,
                        timeSpent: 8
                    },
                    {
                        iteration: 90,
                        timeSpent: 10
                    },
                    {
                        iteration: 100,
                        timeSpent: 14
                    }
                ]

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