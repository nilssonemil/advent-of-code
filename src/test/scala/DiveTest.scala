import scala.io.Source

class DiveTest extends org.scalatest.funsuite.AnyFunSuite {
  
  test("Submarine has an initial position of 0") {
    assert(0 == new Submarine().position)
  }

  test("Submarine has an initial depth of position 0") {
    assert(0 == new Submarine().depth)
  }

  test("Forward increases horizontal position by X") {
    val sub = new Submarine()
    sub.forward(5)
    assert(5 == sub.position)
  }

  test("Forward increases your depth by aim multipled by X") {
    val sub = new Submarine()
    sub.forward(5)
    assert(0 == sub.depth)
    
    sub.down(3)
    sub.forward(5)
    assert(15 == sub.depth)

    sub.up(5)
    sub.forward(10)
    assert(-5 == sub.depth)
  }

  test("Down increases aim by X") {
    val sub = new Submarine()
    sub.down(5)
    assert(5 == sub.aim)
  }

  test("Up decreases aim by X") {
    val sub = new Submarine() 
    sub.down(13)
    sub.up(5)
    assert(8 == sub.aim)
  }

  test("Commands are registered correctly") {
    val commands: List[String] = Source.fromResource("dive.input").getLines.toList
    val sub = new Submarine()
    commands.foreach { sub.execute_command(_) }
    assert(15 == sub.position)
    assert(60 == sub.depth)
  }

  test("Multiply test data position with depth") {
    val commands: List[String] = Source.fromResource("dive.input").getLines.toList
    val sub = new Submarine()
    commands.foreach { sub.execute_command(_) }
    assert(900 == sub.multiply_position_and_depth())
  }
}
