package adt

import collection.mutable

class SLList[A] extends mutable.Buffer[A] {

  import SLList.Node

  private var myHead: Node[A] = null
  private var myTail: Node[A] = null
  private var numElems = 0

  def +=(elem: A): this.type = {

    val newNode = new Node[A](elem, null)
    if (myHead == null) {
      myHead = newNode
    } else {
      myTail.next = newNode
    }
    myTail = newNode

    this
  }
  def +=:(elem: A): this.type = ???
  def apply(n: Int): A = {

    var rover = myHead
    for (_ <- 1 to n) rover = rover.next

    rover.data
  }
  def clear(): Unit = {
    myHead = null
    myTail = null
    numElems = 0
  }
  def insertAll(n: Int, elems: Traversable[A]): Unit = ???
  def length: Int = ???
  def remove(n: Int): A = {
    numElems -= 1
    if (n == 0) {
      val ret = myHead.data
      myHead = myHead.next
      if (myHead == null) myTail = null
      ret
    } else {
      var rover = myHead
      for (_ <- 1 to n - 1) rover = rover.next
      if (rover.next == myTail) myTail = rover
      val ret = rover.next.data
      rover.next = rover.next.next
      ret
    }
  }
  def update(n: Int, newelem: A): Unit = {

    var rover = myHead
    for (_ <- 1 to n) rover = rover.next

    rover.data = newelem
  }

  // Members declared in scala.collection.IterableLike
  def iterator = new Iterator[A] {
    var rover = myHead
    def hasNext: Boolean = rover != null
    def next(): A = {
      val ret = rover.data
      rover = rover.next
      ret
    }
  }

}

object SLList {
  class Node[A](var data: A, var next: Node[A])
}