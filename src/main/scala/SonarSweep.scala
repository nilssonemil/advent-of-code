import scala.io.Source

object SonarSweep {
  def measurementsLargerThanPredecessor(measurements: List[Int]) = {
    measurements.map(_.toInt).sliding(2).filter(lastIsGreater).toList.size
  }

  def lastIsGreater(measurements: List[Int]) = {
    measurements.last > measurements.head
  }
  
  def threeMeasurementSlidingWindowSum(measurements: List[String]) = {
    measurements.map(_.toInt).sliding(3).map(_.sum).toList
  }
  
  def slidingWindowMeasurementsLargerThanPredecessor(measurements: List[String]) = {
    measurementsLargerThanPredecessor(threeMeasurementSlidingWindowSum(measurements))
  }

  def main(args: Array[String]): Unit = {
    val sweeps: List[String] = Source.fromResource("sonar-sweep.input").getLines.toList
    println(slidingWindowMeasurementsLargerThanPredecessor(sweeps))
  }
}
