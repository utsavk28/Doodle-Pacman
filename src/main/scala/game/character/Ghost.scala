package game.character

import doodle.core._
import doodle.syntax.all._
import doodle.{algebra}
import doodle.java2d.{Picture, _}
import game.Config
import game.`object`.EmptyTitle
import game.util.Enum.GhostDirections
import game.util.Enum.GhostDirections._

case class Ghost(color:Color,direction: GhostDirection) {
  private def ghostEyes(): algebra.Picture[Algebra, Unit] = {
    val eix = direction match {
      case Up => 0
      case Down => 0
      case Right => -4
      case Left => 4
    }
    val eiy = direction match {
      case Up => -13
      case Down => -2
      case Right => -8
      case Left => -8
    }
    val ex = direction match {
      case Up => 0
      case Down => 0
      case Right => -25
      case Left => 25
    }
    val ey = direction match {
      case Up => -200
      case Down => -50
      case Right => 0
      case Left => 0
    }

    val eyeOut = Picture.
      roundedRectangle(14, 18, 20).
      fillColor(Color.white).noStroke.margin(2).
      noStroke.
      originAt(Landmark(Coordinate.percent(0), Coordinate.percent(-75)))
    val eyeInside = Picture.circle(8).fillColor(Color.blue).noStroke.
      originAt(eix, eiy)
    val eye = eyeInside on eyeOut
    val eyes = (eye beside eye).
      originAt(Landmark(Coordinate.percent(ex), Coordinate.percent(ey)))
    eyes
  }

  private def ghostLegs(): algebra.Picture[Algebra, Unit] = {
    val leftLeg = Picture.triangle(2 * Config.ghostHeight / 5, 4 * Config.ghostWidth / 25 + 1).rotate(-90.degrees).noStroke.fillColor(color)
    val reverseLeftLeg = leftLeg.rotate(180.degrees)
    val leg = leftLeg beside reverseLeftLeg
    val gap = Picture.square(4 * Config.ghostWidth / 25)
    val legs = (leg beside gap beside leg.rotate(180.degrees)).
      originAt(Landmark(Coordinate.percent(0), Coordinate.percent(135)))
    legs
  }

  def get():algebra.Picture[Algebra, Unit] = {
    val head = Picture.circle(4*Config.ghostWidth/5).noStroke.fillColor(color).
      originAt(Landmark(Coordinate.percent(0), Coordinate.percent(-25)))

    val eyes = ghostEyes()
    val body = Picture.rectangle(4*Config.ghostWidth/5,Config.ghostHeight/3).noStroke.fillColor(color).
      originAt(Landmark(Coordinate.percent(0), Coordinate.percent(75)))
    val legs = ghostLegs()
    val ghost = ((eyes on head) on body on legs).originAt(Landmark(Coordinate.percent(0),Coordinate.percent(10)))
    ghost.margin((Config.tileSize-4*Config.ghostWidth/5)/2)
  }
}

object GhostLayout {

  private def genGhostLayout(titleNo: Int): algebra.Picture[Algebra, Unit] = {
    titleNo match {
      case 0 => Picture.empty
      case 2 => Ghost(Color.skyBlue,GhostDirections.Left).get().beside(genGhostLayout(1))
      case 9 => Ghost(Color.hotpink,GhostDirections.Down).get().beside(genGhostLayout(8))
      case 8 => Ghost(Color.red,GhostDirections.Right).get().beside(genGhostLayout(7))
      case n => EmptyTitle().get().beside(genGhostLayout(n - 1))
    }
  }


  def get(): algebra.Picture[Algebra, Unit] = {
    val ghostLayout = genGhostLayout(Config.tileCount)
    ghostLayout
  }
}
