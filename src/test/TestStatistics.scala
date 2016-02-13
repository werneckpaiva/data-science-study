

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
  
}