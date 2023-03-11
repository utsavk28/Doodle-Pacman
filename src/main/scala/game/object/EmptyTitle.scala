package game.`object`

import doodle.algebra
import doodle.java2d.{Algebra, Picture}
import doodle.syntax.all._
import game.Config

case class EmptyTitle() {
  def get(): algebra.Picture[Algebra, Unit] = {
    Picture.empty.margin(Config.tileSize / 2)
  }
}
