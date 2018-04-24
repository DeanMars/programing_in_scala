package chapter21

/**
  * Created by Dean on 2018/4/20.
  */
object Chapter21 {
  //隐式定义为编译器为了修正类型错误而允许插入到程序中的定义

  implicit def IntToString(i:Int):String= i.toString
  implicit def StringToInt(i:String):Int= i.toInt

  def sumPrint(a: Int,b:Int)={
    println(a+b)
  }

  def main(args: Array[String]): Unit = {
    println( 123.trim + "123")
    println(sumPrint("1",2))
  }


}


