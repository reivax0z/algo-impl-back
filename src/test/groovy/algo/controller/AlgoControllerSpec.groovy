package algo.controller

import algo.client.Sorts
import algo.model.Report
import algo.service.impl.ServiceClients
import org.springframework.http.HttpStatus
import spock.lang.Specification

class AlgoControllerSpec extends Specification {

    def service = Mock(ServiceClients)
    def sorts = Mock(Sorts)

    def controller = new AlgoController(
            service: service,
            sorts: sorts
    )

    def "the sort method"() {
        given:
        def expectedBody = new Report()

        when:
        def response = controller.sort(10, 100)

        then:
        1 * service.serve(10, sorts, 100) >> expectedBody

        and:
        response != null
        response.statusCode == HttpStatus.OK
        response.body == expectedBody
    }
}
