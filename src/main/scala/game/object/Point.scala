package game.`object`

import doodle.algebra
import doodle.core.Color
import doodle.java2d.{Algebra, Picture}
import doodle.syntax.all._
import game.Config

case class Point(diameter:Int) {
  def get():algebra.Picture[Algebra, Unit]  = {
    Picture.circle(diameter).fillColor(Color.sandyBrown).margin((Config.tileSize-diameter)/2).noStroke
  }
}

case class NormalPoint() {
  def get():algebra.Picture[Algebra, Unit] = {
    Point(Config.normalPointSize).get()
  }
}

case class PowerPoint() {
  def get() = {
    Point(Config.powerPointSize).get()
  }
}



