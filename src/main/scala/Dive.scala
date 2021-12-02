import scala.io.Source

class Submarine() {
  var position = 0
  var depth = 0
  var aim = 0

  def forward(value: Int) = {
    position += value
    depth += aim * value
  }
  def down(value: Int) = aim += value
  def up(value: Int) = aim -= value

  def execute_command(command: String) = command.split(" ") match {
    case Array(command_name, command_value) => execute(command_name, command_value.toInt)
    case _ => throw new RuntimeException(s"Unknown command: $command")
  }

  private[this] def execute(command_name: String, command_value: Int) = command_name match {
    case "forward"  => forward(command_value)
    case "down"     => down(command_value)
    case "up"       => up(command_value)
  }

  def multiply_position_and_depth(): Int = position * depth
}

object Dive {
  
  def main(args: Array[String]): Unit = {
    val commands: List[String] = Source.fromResource("dive.input").getLines.toList
    val sub = new Submarine()
    commands.foreach { sub.execute_command(_) }
    println(sub.multiply_position_and_depth())
  }
}
