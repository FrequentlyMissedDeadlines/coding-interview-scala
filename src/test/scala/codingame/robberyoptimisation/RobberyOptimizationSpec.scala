package codingame.robberyoptimisation

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class RobberyOptimizationSpec extends AnyFlatSpec with should.Matchers {

  it should "return 75 for 20 Houses" in {
    val Houses_20: List[Long] = List(2, 5, 10, 2, 4, 8, 5, 2, 6, 7, 7, 6, 11, 12, 5, 9, 6, 10, 7, 9)
    RobberyOptimization().Solve(Houses_20) should be(75)
  }

  it should "return 31 for 5 Houses" in {
    val Houses_5: List[Long] = List(1, 15, 10, 13, 16)
    RobberyOptimization().Solve(Houses_5) should be(31)
  }
}
