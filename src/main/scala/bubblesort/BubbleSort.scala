package bubblesort

import scala.annotation.tailrec

class BubbleSort[A] (implicit ev: A => Ordered[A]) {
  def sort(list: List[A]): List[A] = {
    @tailrec
    def sortRec(iteration: List[A], source: List[A], result: List[A]) : List[A]= source match {
      case h1 :: h2 :: rest => if(ev(h1) > h2) sortRec(iteration, h1 :: rest, result :+ h2) else sortRec(iteration, h2 :: rest, result :+ h1)
      case l:: Nil => sortRec(iteration, Nil, result :+ l)
      case Nil => if(iteration.isEmpty) result else sortRec(iteration.dropRight(1), result, Nil )
    }

    sortRec(list, list, Nil)
  }
}
