package codingame.robberyoptimisation

import scala.annotation.tailrec
import scala.io.StdIn.readLine

class RobberyOptimization {
  var memo: Array[Long] = Array()

  def Solve(values: List[Long]): Long = {
    memo = new Array(values.length)
    recSolve(values)
  }

  def recSolve(remaining: List[Long], consumed: Int = 0): Long = {
    remaining match {
      case a::Nil => Math.max(0L, a)
      case a::b::Nil => Math.max(0L, Math.max(a,b))
      case a::b::l => if (memo(consumed) > 0) {
        memo(consumed)
      } else {
        val tmp = Math.max(a + recSolve(l, consumed + 2), recSolve(b::l, consumed + 1))
        memo(consumed) = tmp
        tmp
      }
    }
  }
}

object Solution extends App {
  val values = (for(i <- 0 until readLine.toInt) yield readLine.toLong).toList
  println(new RobberyOptimization().Solve(values))
}