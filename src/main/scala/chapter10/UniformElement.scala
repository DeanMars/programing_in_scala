package chapter10

/**
  * Created by Dean on 2018/4/16.
  */
//类中的字段和方法属于同一命名空间，这让字段可以重写类中的无参方法。同时，同一类中禁止使用相同的名称定义字段和方法
class UniformElement(c:Char,override val height:Int,override val width:Int) extends Element() {
  private val line=c.toString * width
  def content: Array[String] = Array(line)
}
