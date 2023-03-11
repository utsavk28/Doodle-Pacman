package game.`object`

import doodle.core._
import doodle.syntax.all._
import doodle.java2d.{Picture, _}
import game.Config

object WallLayout {
  private def pacmanWallGen(width:Double, height:Double, radius:Double, color:Color, strokeWidth:Double=2) = {
    Picture.roundedRectangle(width, height, radius).strokeColor(color).strokeWidth(strokeWidth)
  }

  def get() = {
    val wallColor = Color.blue
    val wallWidth = Config.wallWidth
    val wallHeight = Config.wallHeight
    val wallRadius = Config.wallRadius
    val sepDist = Config.sepDist
    val outerWall = pacmanWallGen(wallWidth,wallHeight,wallRadius,wallColor)
    val innerWall = pacmanWallGen(wallWidth- sepDist,wallHeight- sepDist,wallRadius - sepDist/2,wallColor)
    val wallLayout = innerWall on outerWall
    wallLayout
  }
}
