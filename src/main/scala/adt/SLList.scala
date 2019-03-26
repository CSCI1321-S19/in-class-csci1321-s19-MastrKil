package adt

import collection.mutable

class SLList[A] extends mutable.Buffer[A] {
  
  import SLList.Node
  
  private var myHead: Node[A] = null
  private var myTail: Node[A] = null
  private var numElems = 0
  
  def +=(elem: A): this.type = {

    val newNode = new Node[A](elem,null)
    if(myHead == null){
      myHead = newNode
    } else {
      myTail.next = newNode
    }
    myTail = newNode
  
    this
  }
  def +=:(elem: A): this.type = {
    
    val newNode = new Node[A](elem, null)
    if(myHead == null){
      myHead = newNode
    } else{
      ???
    }
    
    this
  }
  def apply(n: Int): A = ???
  def clear(): Unit = {
    myHead = null
    myTail = null
    numElems = 0
  }
  def insertAll(n: Int, elems: Traversable[A]): Unit = ???
  def length: Int = ???
  def remove(n: Int): A = ???
  def update(n: Int, newelem: A): Unit = ???

  // Members declared in scala.collection.IterableLike
  def iterator: Iterator[A] = ???
  
}

object SLList {
    class Node[A](var data: A, var next: Node[A])
}