package sort

import bubblesort.BubbleSort
import mergesort.MergeSort
import org.openjdk.jmh.annotations.{Benchmark, Fork, Measurement, Warmup}
import org.openjdk.jmh.infra.Blackhole

class SortBenchmark {

  @Benchmark
  @Warmup(iterations = 2)
  @Fork(value = 2)
  @Measurement(iterations = 2)
  def BubbleSort(blackHole: Blackhole): List[Int] = {
    val sorted = new BubbleSort[Int]().sort(Range(0, 50).reverse.toList)
    blackHole.consume(sorted)
    sorted
  }

  @Benchmark
  @Warmup(iterations = 2)
  @Fork(value = 2)
  @Measurement(iterations = 2)
  def MergeSort(blackHole: Blackhole): List[Int] = {
    val sorted = new MergeSort[Int]().sort(Range(0, 50).reverse.toList)
    blackHole.consume(sorted)
    sorted
  }
}
