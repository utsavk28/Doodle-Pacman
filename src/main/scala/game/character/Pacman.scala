package game.character

import doodle.core._
import doodle.{algebra}
import doodle.java2d.{Algebra, Picture}
import doodle.syntax.all._
import game.Config
import game.`object`.EmptyTitle

object Pacman {
  private def genPacmanLayout(titleNo:Int, pacman: algebra.Picture[Algebra, Unit]): algebra.Picture[Algebra, Unit] = {
    titleNo match {
      case 0 => Picture.empty
      case 7 => pacman.beside(genPacmanLayout(6,pacman))
      case n => EmptyTitle().get().beside(genPacmanLayout(n-1,pacman))
    }
  }
  def get() = {
    val triangle = Picture.triangle(Config.pacmanSize,3*Config.pacmanSize/4).fillColor(Config.backgroundColor).noStroke
    val triangle2 = triangle.rotate(90.degrees).originAt(Landmark(Coordinate.percent(-70), Coordinate.percent(0)))
    val circle = Picture.circle(Config.pacmanSize).fillColor(Color.yellow).noStroke
    val pacman: algebra.Picture[Algebra, Unit] = triangle2 on circle
    val pacmanLayout = genPacmanLayout(Config.tileCount,pacman)
    pacmanLayout
  }
}