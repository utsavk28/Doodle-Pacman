package game.`object`

import doodle.algebra
import doodle.java2d.{Algebra, Picture}
import doodle.syntax.all._
import game.Config

object PointLayout {
  private def generatePoints(count:Int): algebra.Picture[Algebra, Unit] = {
    count match {
      case 0 => Picture.empty
      case 3 => PowerPoint().get().beside(generatePoints(2))
      case n => {
        if (n > 7)
          EmptyTitle().get().beside(generatePoints(n-1))
        else
          NormalPoint().get().beside(generatePoints(n-1))
      }
    }
  }

  def get() = {
    val normalPointLayout = generatePoints(Config.tileCount)
    normalPointLayout
  }
}