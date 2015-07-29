package monoids

case class Colour(r: Int, g: Int, b: Int) {
  def ++(v: Colour) = Colour(
    r + v.r,
    g + v.g,
    b + v.b
  )
}
