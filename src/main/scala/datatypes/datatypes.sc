sealed trait Shape
case class Rectangle(w: Double, h: Double) extends Shape
case class Circle(r: Double) extends Shape

def area(s: Shape) = s match {
  case Rectangle(w, h) => w * h
  case Circle(r)       => Math.PI * r * r
}

area(Circle(3))

sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[A](head: A, tail: List[A]) extends List[A]

Cons(1, Cons(2, Cons(3, Cons(4, Nil))))


object List {

  def apply[A](xs: A*): List[A] =
    if (xs.isEmpty) Nil
    else Cons(xs.head, apply(xs.tail: _*))
}

List(1, 2, 3, 4)









































//sealed trait List[+A]
//case object Nil extends List[Nothing]
//case class Cons[A](head: A, tail: List[A]) extends List[A]
//
//val xs = Cons(1, Cons(2, Cons(3, Cons(4, Nil))))
//
//object List {
//
//  def apply[A](xs: A*): List[A] =
//    if (xs.isEmpty) Nil
//    else Cons(xs.head, apply(xs.tail: _*))
//}
//
//List(1,2,3,4,5)


//object List {
//  def sum(xs: List[Int]): Int = xs match {
//    case Nil         => 0
//    case Cons(x, xs) => x + sum(xs)
//  }
//
//  def apply[A](xs: A*): List[A] =
//    if (xs.isEmpty) Nil
//    else Cons(xs.head, apply(xs.tail: _*))
//}

//List.sum(xs)
//
//List.sum(List(1, 2, 3))
//
//sealed trait Tree[+A]
//case class Leaf[A](v: A)
//case class Branch[A](left: Tree[A], right: Tree[A])

//
//sealed trait Tree[+A]
//case class Leaf[+A](v: A) extends Tree[A]
//case class Branch[+A](left: Tree[A], right: Tree[A])