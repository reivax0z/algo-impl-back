package algo.controller;

import algo.client.Sorts;
import algo.model.Report;
import algo.service.impl.ServiceClients;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(
        basePath = "/algo",
        value = "Algo",
        description = "Various Algorithm implementations",
        produces = "application/json"
)
@RestController
@CrossOrigin(origins = "http://localhost:5000")
@RequestMapping(value = "/algo", produces = MediaType.APPLICATION_JSON_VALUE)
public class AlgoController {

    @Autowired
    private Sorts sorts;
    @Autowired
    private ServiceClients service;

    @ApiOperation(value = "Calls various Sorting algorithm implementations and " +
            "returns a report of the computation results.")
    @RequestMapping(value="/sort/{iteration}/{size}", method= RequestMethod.GET)
    public ResponseEntity<Report> sort(
            @ApiParam(name="iteration", value="The number of Iterations to be performed", required=true)
            @PathVariable Integer iteration,

            @ApiParam(name="size", value="The Size of the samples to performed the algorithm against", required=true)
            @PathVariable Integer size) {

        return ResponseEntity.ok(
                service.serve(
                        iteration,
                        sorts,
                        size
                )
        );
    }
}
