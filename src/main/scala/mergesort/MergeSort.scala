package mergesort

import scala.annotation.tailrec

class MergeSort[A](implicit ev: A => Ordered[A]) {

  def sort(list: List[A]): List[A] = {
    val m = list.length / 2
    if (m == 0) list
    else {
      @tailrec
      def merge(ls: List[A], rs: List[A], acc: List[A] = List()): List[A] = (ls, rs) match {
        case (Nil, _) => acc ++ rs
        case (_, Nil) => acc ++ ls
        case (l :: ls1, r :: rs1) =>
          if (ev(l) < r) merge(ls1, rs, acc :+ l)
          else merge(ls, rs1, acc :+ r)
      }
      val (l, r) = list splitAt m
      merge(sort(l), sort(r))
    }
  }
}
