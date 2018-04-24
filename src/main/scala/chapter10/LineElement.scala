package chapter10

/**
  * Created by Dean on 2018/4/16.
  */

//调用超类构造器 传递参数或参数列表到超类名后面的括号内
class LineElement(s:String) extends ArrayElement(Array(s)) {
  override def width: Int = s.length
  override def height: Int = 0
}
