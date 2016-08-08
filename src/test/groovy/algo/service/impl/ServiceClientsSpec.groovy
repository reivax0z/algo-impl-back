package algo.service.impl

import algo.client.IClient
import algo.client.IClientList
import algo.helper.HelperImpl
import algo.model.ClientType
import algo.model.Item
import spock.lang.Ignore
import spock.lang.Specification

class ServiceClientsSpec extends Specification {

    def serviceClient = Mock(ServiceClient)
    def helper = Mock(HelperImpl)

    def service = new ServiceClients(
            serviceClient: serviceClient,
            helper: helper
    )

    def "it serves the clients"() {
        given:
        def size = 1000
        def it = 10
        def client = Mock(IClient) {
            getName() >> 'name'
        }
        def clients = Mock(IClientList) {
            getType() >> ClientType.SORT
            getClients() >> [client]
        }

        when:
        def response = service.serve(it, clients, size)

        then:
        20 * helper.help(*_) >> new Item(timeSpent: 100)

        and:
        response.nbIterations == 10
        response.sampleSize == 1000
        response.reportItems.size() == 1

        and:
        response.reportItems[0].algoName == 'name'
        response.reportItems[0].avgTime == 100

        and:
        response.reportItems[0].timePerIteration.size() == 10
        response.reportItems[0].timePerSample.size() == 10

    }

    @Ignore
    def "it serves the clients - Cheks in more details - Not working"() {
        given:
        def size = 1000
        def it = 10
        def client = Mock(IClient) {
            getName() >> 'name'
        }
        def clients = Mock(IClientList) {
            getType() >> ClientType.SORT
            getClients() >> [client]
        }

        when:
        def response = service.serve(it, clients, size)

        then:
        10 * helper.help(serviceClient, client, size, iter) >> new Item(timeSpent: 1)
        10 * helper.help(serviceClient, client, sample, sample) >> new Item()

        and:
        response.nbIterations == 10
        response.sampleSize == 1000
        response.reportItems.size() == 1

        and:
        response.reportItems[0].algoName == 'name'
        response.reportItems[0].avgTime == 100

        and:
        response.reportItems[0].timePerIteration.size() == 10
        response.reportItems[0].timePerSample.size() == 10

        where:
        iter << [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        sample << [100, 200, 300, 400, 500, 600, 700, 800, 900, 1000]
    }
}
