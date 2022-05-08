package fibonacci

import org.openjdk.jmh.annotations.{Benchmark, Fork, Measurement, Warmup}
import org.openjdk.jmh.infra.Blackhole
import scala.annotation.tailrec

class FibonacciBenchmark {

  def fibonacci(n: Int): BigInt = n match {
    case 0 | 1 => n
    case _ => fibonacci(n - 2) + fibonacci(n - 1)
  }

  def iterativeFibonacci(n: Int): BigInt = {
    var a: BigInt = 0
    var b: BigInt = 1
    var i = 0

    while (i < n) {
      val tmp: BigInt = a + b
      a = b
      b = tmp
      i = i + 1
    }

    a
  }

  @tailrec
  private def tailRecFibonacci(n: Int, a: BigInt = 0, b: BigInt = 1) : BigInt = n match {
    case 0 => a
    case 1 => b
    case _ => tailRecFibonacci(n - 1, b, a + b)
  }

  def nonAnnotatedTailRecFibonacci(n: Int, a: BigInt = 0, b: BigInt = 1) : BigInt = n match {
    case 0 => a
    case 1 => b
    case _ => tailRecFibonacci(n - 1, b, a + b)
  }

  @Benchmark
  @Warmup(iterations = 2)
  @Fork(value = 2)
  @Measurement(iterations = 2)
  def recursive(blackHole: Blackhole): BigInt = {
    val fib20 = fibonacci(20)
    blackHole.consume(fib20)
    fib20
  }

  @Benchmark
  @Warmup(iterations = 2)
  @Fork(value = 2)
  @Measurement(iterations = 2)
  def iterative(blackHole: Blackhole): BigInt = {
    val fib20 = iterativeFibonacci(20)
    blackHole.consume(fib20)
    fib20
  }

  @Benchmark
  @Warmup(iterations = 2)
  @Fork(value = 2)
  @Measurement(iterations = 2)
  def tailRecursive(blackHole: Blackhole): BigInt = {
    val fib20 = tailRecFibonacci(20)
    blackHole.consume(fib20)
    fib20
  }

  @Benchmark
  @Warmup(iterations = 2)
  @Fork(value = 2)
  @Measurement(iterations = 2)
  def nonAnnotatedTailRecursive(blackHole: Blackhole): BigInt = {
    val fib20 = nonAnnotatedTailRecFibonacci(20)
    blackHole.consume(fib20)
    fib20
  }
}