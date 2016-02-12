

object LinearAlgebra {
  implicit def listToLinearAlgebraVector[T](l: Traversable[T])(implicit n: Numeric[T]) = new LinearAlgebraClass(l)
}

class LinearAlgebraClass[T](v: Traversable[T])(implicit n: Numeric[T]) {
  import n._;
  import LinearAlgebra._;

  def sumAll():T = if (v.isEmpty) n.zero else v.reduce(_+_)

  def +(w:Traversable[T]):Traversable[T] = opZipped(_+_)(w)
  def -(w:Traversable[T]):Traversable[T] = opZipped(_-_)(w)
  def *(w:Traversable[T]):T = opZipped(_*_)(w).sumAll
  def *(c:T):Traversable[T] = v.map(c.*)
  def square():T = v * v
  def magnitude():Double = Math.sqrt(v.square.toDouble)
  def distance(w:Traversable[T]):Double = Math.sqrt((v - w).square.toDouble)

  private def opZipped(f:(T, T)=>T)(w:Traversable[T]): Traversable[T] = for((x,y) <- (v zip w)) yield f(x, y)

  def zip(w:Traversable[T]):Traversable[(T, T)] = {
    (v, w) match {
      case (x::tailV, y::tailW) => (x, y) :: tailV.zip(tailW)
      case _ => Nil
    }
  }
}
