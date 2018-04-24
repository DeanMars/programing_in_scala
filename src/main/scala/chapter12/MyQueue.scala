package chapter12

/**
  * Created by Dean on 2018/4/16.
  */
class MyQueue extends BasicIntQueue with Doubling {

}


object MyQueue{
  def main(args: Array[String]): Unit = {
    /*val queue=new MyQueue
    queue.put(10)
    println(queue.get)
    println(queue.mf)*/

    //方法的调用由类和混入的特质的线性化决定的
    //混入的顺序很重要，越靠近右侧的特质越先起作用。当你调用带混入的类的方法时，最右侧特质的方法首先被调用。如果那个方法调用了super，它调用其左侧特质的方法，以此类推。
    val q=new BasicIntQueue with Incrementing with Filtering
    q.put(-10)
    println(q.get)


  }
}
