package puyo


import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.canvas.Canvas
import scalafx.scene.Scene
import scalafx.animation.AnimationTimer
import scalafx.scene.input.KeyCode
import scalafx.scene.input.KeyEvent

object Main extends JFXApp {
  val canvasWidth = 6 * Renderer.CellSize
  val canvasHeight = 12 * Renderer.CellSize
  stage = new JFXApp.PrimaryStage {
    title = "Puyo"
    scene = new Scene(canvasWidth, canvasHeight) {
      val canvas = new Canvas(canvasWidth, canvasHeight)
      val gc = canvas.graphicsContext2D
      val renderer = new Renderer(gc)
      val board = new Board

      onKeyPressed = (ke: KeyEvent) => {
        ke.code match {
          case KeyCode.Up => board.upPressed()
          case KeyCode.Down => board.downPressed()
          case KeyCode.Left => board.leftPressed()
          case KeyCode.Right => board.rightPressed()
          case _ =>
        }
      }

      onKeyReleased = (ke: KeyEvent) => {
        ke.code match {
          case KeyCode.Up => board.upPressed()
          case KeyCode.Down => board.downPressed()
          case KeyCode.Left => board.leftPressed()
          case KeyCode.Right => board.rightPressed()
          case _ =>
        }
      }

      var lastTime = -1L
      val timer = AnimationTimer(time => {
        if (lastTime != -1) {
          val delay = (time - lastTime) / 1e9
          board.update(delay)
          renderer.render(board)
        }
        lastTime = time

      })
      timer.start

      content = canvas
    }
  }
}