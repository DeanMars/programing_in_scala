package chapter10

/**
  * Created by Dean on 2018/4/16.
  * 定义工厂对象，隐藏new
  *
  */
abstract class ElementFactory {
  import ElementFactory.elem
  //方法没有实现（等号和方法体），它就是抽象的
  def content:Array[String]

  def height:Int=content.length

  def width:Int=if(height==0)0 else content(0).length

  def above(that:ElementFactory):ElementFactory={
    elem(this.content ++ that.content)
  }
  //zip 构建二元组
  def beside(that:ElementFactory):ElementFactory={
    elem(for((l1,l2)<-this.content zip that.content) yield l1 +l2 )
  }

  override def toString: String = content.mkString("\n")

}

object ElementFactory{

  class ArrayElement(private val conf:Array[String])  extends ElementFactory {
    override def content: Array[String] = conf
  }

  class LineElement(s:String) extends ArrayElement(Array(s)) {
    override def width: Int = s.length
    override def height: Int = 0
  }

  class UniformElement(c:Char,override val height:Int,override val width:Int) extends ElementFactory() {
    private val line=c.toString * width
    def content: Array[String] = Array(line)
  }

  def elem(arr:Array[String]):ElementFactory={
    new ArrayElement(arr)
  }

  def elem(c:Char,h:Int,w:Int):ElementFactory={
    new UniformElement(c,h,w)
  }

  def elem(l:String):ElementFactory={
    new LineElement(l)
  }

  def main(args: Array[String]): Unit = {
    println(ElementFactory.elem(Array("dsad","3w32")).toString)

  }


}




