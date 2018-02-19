package algo.controller;

import algo.model.ClientType;
import algo.model.Report;
import algo.repository.ReportRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(
        basePath = "/report",
        value = "Report",
        description = "Database interactions for Reports",
        produces = "application/json"
)
@RestController
@CrossOrigin(origins = "http://localhost:5000")
@RequestMapping(value = "/report", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReportController {

    @Autowired
    private ReportRepository reportRepository;

    @ApiOperation(value = "Gets all the Reports for a given type and sample size.")
    @RequestMapping(value="/{type}/{size}", method= RequestMethod.GET)
    public ResponseEntity<List<Report>> getByTypeAndSize(
            @ApiParam(name="type", value="The Type of the algorithm to be queried", required=true)
            @PathVariable String type,

            @ApiParam(name="size", value="The Size of the sample to be queried", required=true)
            @PathVariable Integer size) {

        return ResponseEntity.ok(
                reportRepository.findByTypeAndSampleSize(type, size)
        );
    }

    @ApiOperation(value = "Gets the Report matching the given ID.")
    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<Report> getById(
            @ApiParam(name="id", value="The ID of the report to be queried", required=true)
            @PathVariable String id) {

        return ResponseEntity.ok(
                reportRepository.findOne(id)
        );
    }

    @ApiOperation(value = "Creates a new Report in the database.")
    @RequestMapping(value="/save", method= RequestMethod.POST)
    public ResponseEntity<Report> saveReport(
            @ApiParam(name="report", value="The Report to be saved in the DB.", required=true)
            @RequestBody Report report) {

        return ResponseEntity.ok(
                reportRepository.save(report)
        );
    }
}
