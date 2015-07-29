import monoids.{Colour, Monoid}
import org.scalacheck.{Gen, Properties}
import org.scalacheck.Prop.forAll


object ColourMonoidProperties extends Properties("ColourAddition") {

  val M = new Monoid[Colour] {
    def op(c1: Colour, c2: Colour) = Colour(
      c1.r + c2.r,
      c1.g + c2.g,
      c1.b + c2.b
    )
    val zero = Colour(0, 0, 0)
  }
  type T = Colour
  val Z: Colour = M.zero

  val colors: Gen[Colour] =
    for {
      r <- Gen.choose(0, 255)
      g <- Gen.choose(0, 255)
      b <- Gen.choose(0, 255)
    } yield Colour(r, g, b)


  property("Z is the neutral operator") = forAll(colors) { (v: T) =>
    Z ++ v == v && v ++ Z == v
  }

  property("op is associative") = forAll(colors, colors, colors) { (a: T, b: T, c: T) =>
    a ++ (b ++ c) == (a ++ b) ++ c
  }
}

