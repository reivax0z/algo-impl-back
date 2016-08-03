package algo.client.sort

import algo.client.sort.ClassicSort
import spock.lang.Specification

class ClassicSortSpec extends Specification {

    def sort = new ClassicSort()

    def "it sorts!"() {
        given:
        def input = [3, 1, 5, 2, 8, 6, 9]

        when:
        def result = sort.compute(input.toArray(new int[0]))

        then:
        result == [1, 2, 3, 5, 6, 8, 9]
    }
}