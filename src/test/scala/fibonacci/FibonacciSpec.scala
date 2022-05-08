package fibonacci

import collection.mutable.Stack
import org.scalatest._
import flatspec._
import matchers._

class FibonacciSpec extends AnyFlatSpec with should.Matchers {

  it should "return Fib20" in {
    val fib = new FibonacciBenchmark()
    fib.fibonacci(20) should be(6765)
    fib.iterativeFibonacci(20) should be(6765)
    fib.nonAnnotatedTailRecFibonacci(20) should be(6765)
  }
}
