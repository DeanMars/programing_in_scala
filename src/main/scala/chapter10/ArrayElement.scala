package chapter10

/**
  * Created by Dean on 2018/4/16.
  */
//定义参数化字段  用val或者var定义，同时定义同名的参数和字段的写法
class ArrayElement(private val conf:Array[String])  extends Element {

  override def content: Array[String] = conf

}
