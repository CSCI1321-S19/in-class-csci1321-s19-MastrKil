package adt

import org.junit.Test
import org.junit.Assert._

class TestArrayQueue {

  @Test def emptyOnCreate() = {

    val q = new ArrayQueue[Int]
    assertTrue(q.isEmpty)

  }

  @Test def addOneToQueue() = {

    val q = new ArrayQueue[Int]
    q.enqueue(10)
    assertFalse(q.isEmpty)
    assertEquals(10, q.peek)
    assertEquals(10, q.dequeue())
    assertTrue(q.isEmpty)

  }

  @Test def addRemoveAdd() = {

    val q = new ArrayQueue[Int]

    val nums1 = Array(1, 2, 3)
    for (n <- nums1) q.enqueue(n)
    for (n <- nums1) assertEquals(n, q.dequeue())

    val nums2 = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14)
    for (n <- nums2) q.enqueue(n)
    for (n <- nums2) assertEquals(n, q.dequeue())

    assertTrue(q.isEmpty)

  }

}