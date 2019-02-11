package puyo

class Puyo(val x: Int, val y: Int, val color: PuyoColor.Value) extends Boba {

  override def move(dx: Int, dy: Int): Puyo = {
    new Puyo(x + dx, y + dy, color)
  }

}