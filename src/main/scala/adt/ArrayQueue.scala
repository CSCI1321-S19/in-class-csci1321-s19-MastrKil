package adt

import scala.reflect.ClassTag

class ArrayQueue[A: ClassTag] extends MyQueue[A] {

  private var data = Array.fill(10)(null.asInstanceOf[A])
  private var front = 0
  private var end = 0

  def enqueue(a: A): Unit = {
    if((end + 1) % data.length == front){
      val tmp = Array.fill(data.length * 2)(null.asInstanceOf[A])
      for(i <- 0 until data.length - 1) tmp(i) = data((i + front) % data.length)
      front = 0
      end = data.length - 1
      data = tmp
    }
    data(end) = a
    end = (end + 1) % data.length
  }

  def dequeue(): A = {
    val ret = data(front)
    front = (front + 1) % data.length
    ret
  }

  def peek: A = data(front)

  def isEmpty: Boolean = front == end

}