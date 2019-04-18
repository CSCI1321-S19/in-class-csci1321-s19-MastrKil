package adt

import collection.mutable

class BSTMap[K, V](p: (K, K) => Boolean) extends mutable.Map[K, V] {

  import BSTMap._

  private var root: Node[K, V] = null

  // Members declared in scala.collection.mutable.MapLike
  def -=(key: K): this.type = {
    def removeNode(n: Node[K, V]): Node[K, V] = {
      if (n == null) n else {
        if (p(key, n.key)){
          n.left = removeNode(n.left)
          n
        }
        else if (p(n.key, key)) {
          n.right = removeNode(n.right)
          n
        }
        else{
          if(n.left == null) n.right
          else if(n.right == null) n.left
          else{
            if(n.left.right == null){
              n.left.right = n.right
              n.left
            } else {
              // def helper goes here
            }
          }
        }
      }
    }
    root = removeNode(root)
    this
  }

  def +=(kv: (K, V)): this.type = {
    def addNode(n: Node[K, V]): Node[K, V] = {
      if (n == null) new Node(kv._1, kv._2, null, null)
      else {
        if (p(kv._1, n.key)) n.left = addNode(n.left)
        else if (p(n.key, kv._1)) n.right = addNode(n.right)
        else n.value = kv._2
        n

      }
    }
    root = addNode(root)

    this
  }

  // Members declared in scala.collection.MapLike
  def get(key: K): Option[V] = {

        def getNode(n: Node[K,V]): Option[V] = {
          if(n == null) None
          else if(p(key, n.key) && p(n.key,key)) Some(n.value)
          else{
            if(p(key, n.key)) getNode(n.left)
            else getNode(n.right)
          }
        }
    getNode(root)
    
    var rover = root
    while (rover != null && p(rover.key, key) && !p(key, rover.key)) {
      if (p(key, rover.key)) rover = rover.left
      else rover = rover.right
    }
    if (rover == null) None else Some(rover.value)
  }
  def iterator = new Iterator[(K, V)] {

    private val stack = new ListStack[Node[K, V]]()

    private def pushAllLeft(n: Node[K, V]): Unit = {
      if (n != null) {
        stack.push(n)
        pushAllLeft(n.left)
      }
    }

    pushAllLeft(root)

    def hasNext(): Boolean = !stack.isEmpty

    def next(): (K, V) = {
      val ret = stack.pop()
      pushAllLeft(ret.right)
      ret.key -> ret.value
    }
  }

  override def update(key: K, value: V): Unit = {
    this += ((key, value))
  }

  def preOrder(n: Node[K, V], visit: (K, V) => Unit): Unit = {
    if (n != null) {
      visit(n.key, n.value)
      preOrder(n.left, visit)
      preOrder(n.right, visit)
    }
  }

  def postOrder(n: Node[K, V], visit: (K, V) => Unit): Unit = {
    if (n != null) {
      postOrder(n.left, visit)
      postOrder(n.right, visit)
      visit(n.key, n.value)
    }
  }

  def inOrder(n: Node[K, V], visit: (K, V) => Unit): Unit = {
    if (n != null) {
      postOrder(n.left, visit)
      visit(n.key, n.value)
      postOrder(n.right, visit)
    }
  }

}

object BSTMap {
  class Node[K, V](val key: K, var value: V, var left: Node[K, V], var right: Node[K, V])
}