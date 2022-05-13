package bubblesort

import bubblesort.BubbleSort
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class BubbleSortSpec extends AnyFlatSpec with should.Matchers {

  it should "sort an Int List" in {
    val unordered: List[Int] = Range(0, 10).reverse.toList

    new BubbleSort[Int]().sort(unordered) should be(Range(0, 10).toList)
  }
}
