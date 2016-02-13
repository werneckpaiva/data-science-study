

import org.junit.Test
import org.junit.Assert._


class TestStatistics {

  import Statistics._

  @Test
  def testMean() = {
    val l = List(3, 4, 5)
    assertEquals(4, l.mean, 0)
  }

  @Test
  def testMeanEmpty() = {
    val l:List[Int] = List()
    assertEquals(0, l.mean, 0)
  }

  @Test
  def testMedian_Odd() = {
    val l = List(3, 4, 5)
    assertEquals(4, l.median)
  }

  @Test
  def testMedian_Even() = {
    val l = List(3, 4, 5, 4)
    assertEquals(4, l.median)
  }

  @Test
  def testMode() = {
    val l = List(1, 2, 3, 2, 2)
    assertEquals(List(2), l.mode)
  }

  @Test
  def testRange() = {
    val l = List(5, 3,4)
    assertEquals(2, l.range)
  }

  @Test
  def testMeanDiff() = {
    val l = List(5, 3,4)
    assertEquals(List(1, -1, 0), l.deviantions)
  }

  @Test
  def testVariance() = {
    val l = List(6, 2,4)
    assertEquals(4, l.variance, 0)
  }

  @Test
  def testStdv() = {
    val l = List(6, 2, 4)
    assertEquals(2, l.stdv, 0)
  }

  @Test
  def testQuantile75() = {
    val l = List(2, 3, 5, 1, 8, 7, 9, 6, 10, 4)
    assertEquals(8, l.quantile(0.75))
  }

  @Test
  def testInterquartile() = {
    val l = List(2, 3, 5, 1, 8, 7, 9, 6, 10, 4)
    assertEquals(5, l.interquartileRange())
  }
  
}