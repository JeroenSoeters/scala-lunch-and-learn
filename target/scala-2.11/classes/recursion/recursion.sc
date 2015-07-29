def factorial(n: Int): Int =
  if (n == 1) 1
  else n * factorial(n - 1)


def sum(xs: List[Int]): Int = xs match {
  case Nil   => 0
  case y::ys => y + sum(ys)
}

def product(xs: List[Int]): Int = xs match {
  case Nil => 1
  case y::ys => y * product(ys)
}

def length(xs: List[String]): Int = xs match {
  case Nil => 0
  case x::xs => x.length + length(xs)
}

def fold[A, B](zero: B, f: (A, B) => B)(xs: List[A]): B = xs match {
  case Nil   => zero
  case x::xs => f(x, fold(zero, f)(xs))
}

def sumLeft(xs: List[Int], acc: Int): Int = xs match {
  case Nil   => acc
  case x::xs => sumLeft(xs, acc + x)
}

sumLeft(List(1,2,3,4), 0)

(((0 + 1) + 2) + 3) + 4

1 + (2 + (3 + (4 + 0)))

(((0 + 1) + 2) + 3) + 4


def foldRight[A, B](zero: B, f: (A, B) => B)(xs: List[A]): B = xs match {
  case Nil   => zero
  case x::xs => f(x, foldRight(zero, f)(xs))
}

def foldLeft[A, B](zero: B, f: (B, A) => B)(xs: List[A]): B = xs match {
  case Nil   => zero
  case x::xs => foldLeft(f(zero, x), f)(xs)
}


1 + (2 + (3 + (4 + 0)))

(((0 + 1) + 2) + 3) + 4

def sumF = foldRight[Int, Int](0, (_ + _))_
def lenghtF = foldRight[String, Int](0, (_.length + _))_

def sumL(xs: List[Int], acc: Int): Int = xs match {
  case Nil   => acc
  case x::xs => sumL(xs, x + acc)
}
//
//def foldLeft[A, B](zero: B, f: (B, A) => B)(xs: List[A]): B = xs match {
//  case Nil   => zero
//  case x::xs => foldLeft(f(zero, x), f)(xs)
//}

sumL(List(1,2,3,4), 0)
//def factorial(n: Int): Int =
//  if (n == 1) n
//  else n * factorial(n - 1)
//
//def sum(xs: List[Int]): Int = xs match {
//  case Nil   => 0
//  case x::xs => x + sum(xs)
//}
//
//def product(xs: List[Int]): Int = xs match {
//  case Nil   => 1
//  case x::xs => x * product(xs)
//}
//
//def length(xs: List[String]): Int = xs match {
//  case Nil   => 0
//  case x::xs => x.length + length(xs)
//}
//
//length(List("Apple", "Banana", "Pear"))
//
//// 1 + (2 + (3 + (4 + 0)))
//
//
//def foldRight[A, B](zero: B, f: (A, B) => B)(xs: List[A]): B = xs match {
//  case Nil   => zero
//  case y::ys => f(y, foldRight(zero, f)(ys))
//}
//
//def sumF = foldRight(0, (x, y) => x + y)_
//def productF = foldRight(1, (_ * _))_
//
//sumF(List(1,2,3,4,5))
//productF(List(1,2,3,4,5))
//
//def sum1(xs: List[Int]): Int = xs match {
//  case Nil => acc
//  case y::ys => sum1(ys, acc + y)
//}
//
//// ((((0 + 1) + 2) + 3) + 4)
//def foldleft[a, b](zero: b, f: (b, a) => b)(xs: list[a]): b = xs match {
//  case nil   => zero
//  case y::ys => foldleft(f(zero, y), f)(ys)
//}
//

