package game

import `object`._
import cats.effect.unsafe.implicits.global
import doodle.core._
import doodle.image._
import doodle.syntax.all._
import doodle.image.syntax.all._
import doodle.java2d
import doodle.java2d._
import game.Config._
import game.character._

object Game {
  def run(): Unit = {
    val layout = WallLayout.get()
    val pacmanLayout = Pacman.get()
    val pointLayout = PointLayout.get()
    val ghostLayout = GhostLayout.get()
    val game = ghostLayout on pointLayout on pacmanLayout on layout
    val frame = Frame.default.withSize(Config.gameWidth , Config.gameHeight ).withBackground(Config.backgroundColor)
    game.drawWithFrame(frame)
  }

}
