package chapter12

/**
  * Created by Dean on 2018/4/16.
  */
//只能混入IntQueue的子类
trait Doubling extends IntQueue{

  //特质中的super是动态绑定，
  abstract override def put(i: Int): Unit = super.put(i*2)

  def mf:String="12321"

}
