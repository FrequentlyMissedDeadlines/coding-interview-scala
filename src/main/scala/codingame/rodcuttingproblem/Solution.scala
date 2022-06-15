package codingame.rodcuttingproblem

import math._
import scala.util._
import scala.io.StdIn._


object Solution extends App {
  val l = readLine.toInt
  val n = readLine.toInt
  val values = (0 until n).map(_ => (readLine split " ").filter(_ != "").map (_.toInt)).map { case Array(a,b) => (a,b) }.toList

  var memo = Map[Int, Long]()
  def recSolve(remainingSize: Int): Long = {
    if (memo.contains(remainingSize)) {
      memo(remainingSize)
    } else {
      val sol: Long = remainingSize match {
        case 0 => 0
        case _ => values.filter(i => i._1 <= remainingSize).map(i => i._2 + recSolve(remainingSize - i._1)).maxOption.getOrElse(0)
      }
      memo = memo + (remainingSize -> sol)
      sol
    }
  }

  println(recSolve(l))
}