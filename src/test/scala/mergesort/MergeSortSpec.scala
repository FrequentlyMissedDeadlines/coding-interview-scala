package mergesort

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class MergeSortSpec extends AnyFlatSpec with should.Matchers {

  it should "sort an Int List" in {
    val unordered: List[Int] = Range(0, 10).reverse.toList

    new MergeSort[Int]().sort(unordered) should be(Range(0, 10).toList)
  }
}
