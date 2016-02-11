package linearalgebra

object LinearAlgebraVector {
  implicit def listToLinearAlgebraVector[T](l: List[T])(implicit n: Numeric[T]) = new LinearAlgebraVectorClass(l)
}

class LinearAlgebraVectorClass[T](v: List[T])(implicit n: Numeric[T]) {
  import n._;
  import LinearAlgebraVector._;

  def sumAll():T = v.reduce{ (x, y) => x + y }

  def +(w:List[T]):List[T] = opZipped(_+_)(w)
  def -(w:List[T]):List[T] = opZipped(_-_)(w)
  def *(w:List[T]):T = opZipped(_*_)(w).sumAll
  def *(c:T):List[T] = v.map(c.*)
  def square():T = v * v
  def magnitude():Double = Math.sqrt(v.square.toDouble)
  def distance(w:List[T]):Double = Math.sqrt((v - w).square.toDouble)

  private def opZipped(f:(T, T)=>T)(w:List[T]): List[T] = for((x,y) <- (v zip w)) yield f(x, y)
}


//  def add(w:List[T]):List[T] = (v zip w).map{case (x, y) => f(x, y)}