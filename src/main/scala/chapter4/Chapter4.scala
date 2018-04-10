package chapter4

/**
  * Created by Dean on 2018/4/10.
  */
class Chapter4 {
  private var b="123";

  def p1(): Unit ={
    println(Chapter4.a) //直接访问伴生对象的私有成员
  }

}

object Chapter4{
  private val a="456";
  def p2(c:Chapter4): Unit ={
    println(c.b) //直接访问伴生类中的私有成员
  }
  def apply(): Chapter4 = new Chapter4()
  def main(args: Array[String]): Unit = {
    val cc=Chapter4(); //通过apply创建对象
    val cc1=Chapter4(); //通过apply创建对象
    p2(cc)
    cc1.b="789"
    p2(cc1)
    p2(cc)
    cc.p1()
  }
}



