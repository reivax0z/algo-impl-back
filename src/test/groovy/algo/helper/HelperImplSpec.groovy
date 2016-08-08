package algo.helper

import algo.client.IClient
import algo.service.IServiceClient
import algo.util.Generator
import spock.lang.Specification

class HelperImplSpec extends Specification {

    def generator = Mock(Generator)

    def helper = new HelperImpl(
            generator: generator
    )

    def "it helps the item"() {
        given:
        def serviceClient = Mock(IServiceClient)
        def client = Mock(IClient)

        when:
        def response = helper.help(serviceClient, client, 10, 100)

        then:
        1 * generator.generateInput(10) >> [1]
        1 * serviceClient.serve(client, [1]) >> 10

        and:
        response.iteration == 100
        response.timeSpent == 10
    }
}
