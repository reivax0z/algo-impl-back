package algo.client

import algo.client.Sorts
import algo.client.sort.BubbleSort
import algo.client.sort.ClassicSort
import spock.lang.Specification

class SortsSpec extends Specification {

    def bubbleSort = Mock(BubbleSort)
    def classicSort = Mock(ClassicSort)

    def sorts = new Sorts(
            bubbleSort: bubbleSort,
            classicSort: classicSort
    )

    def "it returns the sort list"() {
        given:

        when:
        def response = sorts.getClients()

        then:
        response.size() == 2
        response.containsAll([bubbleSort, classicSort])
    }

    def "it returns the type of the algo"() {
        given:

        when:
        def response = sorts.getType()

        then:
        response == "SORT"
    }
}
