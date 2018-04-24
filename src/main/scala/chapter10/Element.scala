package chapter10

/**
  * Created by Dean on 2018/4/16.
  */
abstract class Element {

  //方法没有实现（等号和方法体），它就是抽象的
  def content:Array[String]

  def height:Int=content.length

  def width:Int=if(height==0)0 else content(0).length

  def above(that:Element):Element={
    new ArrayElement(this.content ++ that.content)
  }
  //zip 构建二元组
  def beside(that:Element):Element={
    new ArrayElement(for((l1,l2)<-this.content zip that.content) yield l1 +l2 )
  }

  override def toString: String = content.mkString("\n")
}
