case class Colour(r: Int, g: Int, b: Int)

def addColours(c1: Colour, c2: Colour): Colour =
  Colour(
    c1.r + c2.r,
    c1.g + c2.g,
    c1.b + c2.b
  )

val red = Colour(255, 0, 0)
val green = Colour(0, 255, 0)
val blue = Colour(0, 0, 255)

def sumColours(cs: List[Colour]): Colour = {
  var res = Colour(0, 0, 0)
  for (c <- cs) res = addColours(res, c)
  res
}

sumColours(List(red, green, blue))
("foo" + "bar") + "baz"
"foo" + ("bar" + "baz")


trait Monoid[A] {
  def op(a1: A, a2: A): A
  def zero: A
}

val stringMonoid = new Monoid[String] {
  def op(s1: String, s2: String) = s1 + s2
  val zero = ""
}

def listMonoid[A] = new Monoid[List[A]] {
  def op(xs: List[A], ys: List[A]) = xs ++ ys
  def zero = Nil
}

val intAdditition = new Monoid[Int] {
  def op(a: Int, b: Int) = a + b
  val zero = 0
}

val colourMonoid = new Monoid[Colour] {
  def op(c1: Colour, c2: Colour) = Colour(
    c1.r + c2.r,
    c1.g + c2.g,
    c1.b + c2.b
  )
  val zero = Colour(0, 0, 0)
}

def foldRight[A, B](zero: B, f: (A, B) => B)(xs: List[A]): B = xs match {
  case Nil   => zero
  case y::ys => f(y, foldRight(zero, f)(ys))
}

def foldRight1[A](zero: A, f: (A, A) => A)(xs: List[A]): A = xs match {
  case Nil   => zero
  case y::ys => f(y, foldRight(zero, f)(ys))
}


foldRight(colourMonoid.zero, colourMonoid.op)(List(red, green, blue))

def sumF = foldRight(colourMonoid.zero, colourMonoid.op)_



val words = List("lorem", "ipsum", "dolor", "set")
foldRight(stringMonoid.zero, stringMonoid.op)(words)


def productMonoid[A, B](a: Monoid[A], b: Monoid[B]): Monoid[(A, B)] = {
  new Monoid[(A,B)] {

    override def op(a1: (A, B), a2: (A, B)): (A, B) =
      (a.op(a1._1, a2._1), b.op(a1._2, a2._2))

    override def zero: (A, B) =
      (a.zero, b.zero)
  }
}

def foldMap[A, B](fa: List[A])(f: A => B)(b: Monoid[B]): B =
  fa.foldLeft(b.zero)((acc, elem) => b.op(acc, f(elem)))


val m = productMonoid(intAdditition, intAdditition)


val p = foldMap(List(1,2,3,4))(a => (1, a))(m)


val mean = p._2 / p._1.toDouble





