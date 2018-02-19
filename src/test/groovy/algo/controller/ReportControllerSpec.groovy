package algo.controller

import algo.model.Report
import algo.repository.ReportRepository
import org.springframework.http.HttpStatus
import spock.lang.Specification

class ReportControllerSpec extends Specification {

    def reportRepository = Mock(ReportRepository)

    def controller = new ReportController(
            reportRepository: reportRepository
    )

    def "it allows to get a Report by id"() {
        given:
        def id = 'ID_123'
        def report = new Report()

        when:
        def response = controller.getById(id)

        then:
        1 * reportRepository.findOne(id) >> report

        and:
        response.statusCode == HttpStatus.OK
        response.body == report
    }

    def "it allows to get a Report by type and size"() {
        given:
        def type = "SORT"
        def size = 1000
        def reports = [new Report(), new Report()]

        when:
        def response = controller.getByTypeAndSize(type, size)

        then:
        1 * reportRepository.findByTypeAndSampleSize(type, size) >> reports

        and:
        response.statusCode == HttpStatus.OK
        response.body == reports
        response.body.size() == 2
    }

    def "it allows to save a new Report"() {
        given:
        def input = new Report()
        def report = new Report()

        when:
        def response = controller.saveReport(input)

        then:
        1 * reportRepository.save(input) >> report

        and:
        response.statusCode == HttpStatus.OK
        response.body == report
    }
}
