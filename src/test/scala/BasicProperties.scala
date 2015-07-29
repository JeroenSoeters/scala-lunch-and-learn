import org.scalacheck.Prop._
import org.scalacheck.Properties

object BasicProperties extends Properties("Demo") {

  property("reversing a list twice") = forAll { (xs: List[Int]) =>
    xs.reverse.reverse == xs
  }

  property("taking the first 2 characters") = forAll { (s: String) =>
    s.take(2).length == 2
  }
}
