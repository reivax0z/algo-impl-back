package algo.util

import spock.lang.Specification

class GeneratorSpec extends Specification {

    def generator = new Generator()

    def "it generates random values"() {
        when:
        def response = generator.generateInput(2)

        then:
        response.size() == 2
    }
}
