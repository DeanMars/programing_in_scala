package chapter12

/**
  * Created by Dean on 2018/4/16.
  */
trait Incrementing extends IntQueue{

  abstract override def put(i: Int): Unit = super.put(i+1)

}
