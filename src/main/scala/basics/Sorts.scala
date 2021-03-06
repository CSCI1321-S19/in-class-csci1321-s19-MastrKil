package basics

object Sorts extends App {

  def bubbleSortInt(arr: Array[Int]): Unit = {
    for (i <- -0 until arr.length - 1; j <- 0 until arr.length - 1 - i) {
      if (arr(j) > arr(j + 1)) {
        val temp = arr(j)
        arr(j) = arr(j + 1)
        arr(j + 1) = temp
      }
    }
  }

  def bubbleSortOrdered[A <% Ordered[A]](arr: Array[A]): Unit = {
    for (i <- -0 until arr.length - 1; j <- 0 until arr.length - 1 - i) {
      if (arr(j) > arr(j + 1)) {
        val temp = arr(j)
        arr(j) = arr(j + 1)
        arr(j + 1) = temp
      }
    }
  }

  def bubbleSort[A](arr: Array[A])(gt: (A,A) => Boolean): Unit = {
    for (i <- -0 until arr.length - 1; j <- 0 until arr.length - 1 - i) {
      if(gt(arr(j), arr(j + 1))) {
        val temp = arr(j)
        arr(j) = arr(j + 1)
        arr(j + 1) = temp
      }
    }
  }

  def quickSort[A](lst: List[A])(lt: (A,A) => Boolean): List[A] = lst match{
    case Nil => Nil
    case h :: Nil => lst
    case pivot :: t => 
      val (less, greater) = t.partition(a => lt(a, pivot))
      quickSort(less)(lt) ::: (pivot :: quickSort(greater)(lt))
  }
  
  def betterQuickSort[A](arr: Array[A])(at: (A,A) => Boolean): Array[A] = {
    ???
  }
  
  val nums = Array.fill(10)(math.random) //util.Random.nextInt(100))
  println(nums.mkString(" "))
  bubbleSort(nums)(_ > _)
  println(nums.mkString(" "))
  quickSort(nums.toList)(_ < _)
  println(nums.mkString(" "))
}