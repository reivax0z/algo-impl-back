package algo.service.impl

import algo.client.Sorts
import algo.client.sort.ClassicSort
import algo.model.ClientType
import algo.util.Generator
import spock.lang.Specification

class ServiceClientsSpec extends Specification {

    def generator = Mock(Generator)
    def serviceClient = Mock(ServiceClient)

    def service = new ServiceClients(
            generator: generator,
            serviceClient: serviceClient
    )

    def "it serves the clients"() {
        given:
        def size = 1000
        def it = 10
        def client = Mock(ClassicSort) {
            getName() >> 'name'
        }
        def clients = Mock(Sorts) {
            getType() >> ClientType.SORT
            getClients() >> [client]
        }

        when:
        def response = service.serve(it, clients, size)

        then:
        10 * generator.generateInput(size) >> [1]
        10 * serviceClient.serve(client, [1]) >> 100

        and:
        response.nbIterations == 10
        response.sampleSize == 1000
        response.reportItems.size() == 1

        and:
        response.reportItems[0].algoName == 'name'
        response.reportItems[0].avgTime == 100
        response.reportItems[0].timePerIteration.size() == 10
    }
}
