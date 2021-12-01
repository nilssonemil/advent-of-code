import scala.io.Source

class SonarSweepTest extends org.scalatest.funsuite.AnyFunSuite {
  test("Read test input to list") {
    val actual: List[String] = Source.fromResource("sonar-sweep.input").getLines.toList
    val expected = List("199", "200", "208", "210", "200", "207", "240", "269", "260", "263")
    assert(expected.equals(actual))
  }

  test("Test data has 7 measurements larger than previous") {
    val sweeps: List[String] = Source.fromResource("sonar-sweep.input").getLines.toList
    
    assert(SonarSweep.measurementsLargerThanPredecessor(sweeps.map(_.toInt)) == 7)
  }

  test("measurement windows") {
    val sweeps: List[String] = Source.fromResource("sonar-sweep.input").getLines.toList
    val expected = List(607, 618, 618, 617, 647, 716, 769, 792)
    val actual = SonarSweep.threeMeasurementSlidingWindowSum(sweeps)
    assert(expected.equals(actual))
  }

  test("Test data has 5 measurement window increases") {
    val sweeps: List[String] = Source.fromResource("sonar-sweep.input").getLines.toList
    assert(5 == SonarSweep.slidingWindowMeasurementsLargerThanPredecessor(sweeps))
  }
}
