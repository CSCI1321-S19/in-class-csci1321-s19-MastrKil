package puyo

class Puyo(val x: Int, val y: Int, val color: PuyoColor.Value) extends Boba {

  override def fall(): Puyo = {
    new Puyo(x, y+1, color)
  }

}