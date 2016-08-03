package algo.service.impl

import algo.client.sort.ClassicSort
import algo.util.Generator
import spock.lang.Specification

class ServiceSpec extends Specification {

    def generator = Mock(Generator)

    def service = new Service(
            generator: generator
    )

    def "it serves the clients"() {
        given:
        def size = 1000
        def it = 10
        def clients = [Mock(ClassicSort) {
            getName() >> 'name'
            compute(_ as Integer[]) >> [0]
        }]

        when:
        def response = service.serve(it, clients, size)

        then:
        10 * generator.generateInput(size) >> [1]

        and:
        response.nbIterations == 10
        response.sampleSize == 1000
        response.reportItems.size() == 1

        and:
        response.reportItems[0].algoName == 'name'
        response.reportItems[0].avgTime == 0
        response.reportItems[0].timePerIteration != null
        response.reportItems[0].timePerIteration.size() == 10
    }
}
