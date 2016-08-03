package algo.controller;

import algo.client.Sorts;
import algo.model.Report;
import algo.service.impl.Service;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(basePath = "/algo", value = "Algo", description = "Algo Implementations", produces = "application/json")
@RestController
@CrossOrigin(origins = "http://localhost:5000")
@RequestMapping(value = "/algo", produces = MediaType.APPLICATION_JSON_VALUE)
public class AlgoController {

    @Autowired
    private Sorts sorts;
    @Autowired
    private Service service;

    @RequestMapping(value="/sort/{iteration}/{size}", method= RequestMethod.GET)
    public ResponseEntity<Report> sort(@PathVariable Integer iteration,
                                       @PathVariable Integer size) {

        return ResponseEntity.ok(
                service.serve(
                        iteration,
                        sorts.getClients(),
                        size
                )
        );
    }
}
