package datatypes

sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[A](head: A, tail: List[A]) extends List[A]


object List {
  def sum(xs: List[Int]): Int = xs match {
    case Nil         => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def apply[A](xs: A*): List[A] =
    if (xs.isEmpty) Nil
    else Cons(xs.head, apply(xs.tail: _*))
}