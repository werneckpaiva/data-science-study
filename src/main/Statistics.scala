

object Statistics {
  implicit def listToStatistics[T](l: List[T])(implicit n: Numeric[T]) = new StatisticsClass(l)
}

class StatisticsClass[T](v: List[T])(implicit n: Numeric[T]) {
  import n._;
  import LinearAlgebra._
  import Statistics._

  def mean():Double = if (v.size > 0) v.sumAll.toDouble() / v.size else 0
  def median():T = { val s = v.sorted; s(v.size / 2) }

  def mode():List[T] = {
    val vCounter = v.counter
    val maxCounter = vCounter.values.max
    vCounter.filter{case(k, c) => c==maxCounter}.keys.toList
  }

  def range():T = v.max - v.min

  def deviantions():List[Double] = {
    val m = v.mean
    v.map(x => x.toDouble - m)
  }

  def variance():Double = v.deviantions.square / (v.size - 1)
  def stdv():Double = Math.sqrt(v.variance)
}