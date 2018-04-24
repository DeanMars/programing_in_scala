package chapter12

/**
  * Created by Dean on 2018/4/16.
  */
trait Filtering extends IntQueue{
  abstract override def put(i: Int): Unit = if(i>0) super.put(i)
}
