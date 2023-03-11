package game.util


object Enum {
  object GhostDirections extends Enumeration {
    type GhostDirection = Value
    val Left = Value("left")
    val Right = Value("right")
    val Up = Value("up")
    val Down = Value("down")
  }
}
