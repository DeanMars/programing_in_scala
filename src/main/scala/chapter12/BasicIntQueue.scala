package chapter12

import scala.collection.mutable.ArrayBuffer

/**
  * Created by Dean on 2018/4/16.
  */
class BasicIntQueue extends IntQueue {
  private val buffer=new ArrayBuffer[Int];
  override def get: Int = buffer.remove(0)
  override def put(i: Int): Unit = buffer+=i
}
