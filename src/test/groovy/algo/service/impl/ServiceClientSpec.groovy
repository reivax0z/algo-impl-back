package algo.service.impl

import algo.client.sort.ClassicSort
import spock.lang.Specification

class ServiceClientSpec extends Specification {

    def service = new ServiceClient()

    def "it serves the client and computes the time spent"() {
        given:
        def input = [1] as Integer[]
        def client = Mock(ClassicSort) {
            compute(input) >> {
                sleep(100)
                return [0] as Integer[]
            }
        }

        when:
        def response = service.serve(client, input)

        then:
        response >= 100L
    }
}
