import org.junit.Test
import org.junit.Assert._


class TestLinearAlgebra {

  import LinearAlgebra._
  
  @Test
  def testSum() = {
    val v = List(1, 2, 3)
    assertEquals(6, v.sumAll());
  }

  @Test
  def testSum_EmptyInt() = {
    val v:List[Int] = List()
    assertEquals(0, v.sumAll());
  }

  @Test
  def testSum_EmptyFloat() = {
    val v:List[Double] = List()
    assertEquals(0.0, v.sumAll(), 0);
  }

  @Test
  def testAddVectors() = {
    val v = List(1, 2, 3)
    val w = List(4, 5, 6)
    assertEquals(List(5, 7, 9), v + w);
    assertEquals(w + v, v + w);
  }

  @Test
  def testAddEmptyVectors() = {
    val v:List[Int] = List()
    val w:List[Int] = List()
    assertEquals(List(), v + w);
  }

  @Test
  def testAddVectorsWithDifferentSizes() = {
    val v = List(1, 2, 3, 4)
    val w = List(5, 6, 7)
    assertEquals(List(6, 8, 10), v + w);
  }

  @Test
  def testSubtractVectors() = {
    val v = List(4, 5, 6)
    val w = List(1, 1, 2)
    assertEquals(List(3, 4, 4), v - w);
  }

  @Test
  def testDotVectors() = {
    val v = List(4, 5, 6)
    val w = List(2, 3, 4)
    assertEquals(47, v * w);
  }

  @Test
  def testScalarMultiply() = {
    val v = List(4, 5, 6)
    assertEquals(List(8, 10, 12), v * 2);
  }

  @Test
  def testSumOfSquares() = {
    val v = List(4, 5, 6)
    assertEquals(77, v square);
  }

  @Test
  def testMagnitude() = {
    val v = List(2, 4, 4)
    assertEquals(6.0, v.magnitude, 0);
  }

  @Test
  def testDistance() = {
    val v = List(3, 9, 11)
    val w = List(1, 5, 7)
    assertEquals(6.0, v.distance(w), 0);
  }

  @Test
  def testCounter() = {
    val v = List(1, 2, 3, 1, 2, 2, 3, 4)
    assertEquals(Map(1->2, 2->3, 3->2, 4->1), v.counter);
  }

  
}