package game

import doodle.core.Color

object Config {
  val tileSize = 64
  val tileCount = 10

  val backgroundColor = Color.black

  val sepDist = 10
  val wallWidth = tileSize*tileCount + sepDist*2
  val wallHeight = tileSize + 2*sepDist
  val wallRadius = 15

  val gameWidth = wallWidth + 50
  val gameHeight = wallHeight + 50

  val pacmanSize = 48

  val ghostHeight = 56
  val ghostWidth = 56

  val normalPointSize = 10
  val powerPointSize = 25
}
