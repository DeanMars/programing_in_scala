package chapter16

/**
  * Created by Dean on 2018/4/19.
  */
class Chapter16 {

}

object Chapter16{


  def main(args: Array[String]): Unit = {
    val a=List("1","2")
    val b=List("3","4")
    println("4"::a)
    println(a:::b)

  }


  def isort1(xs:List[Int]):List[Int]=if(xs.isEmpty) Nil else insert(xs.head,isort(xs.tail))

  def insert1(x:Int,xs:List[Int]):List[Int]=if(xs.isEmpty || x <=xs.head ) x::xs else xs.head :: insert(x,xs.tail)

  //List 模式匹配  xs 转成  x::xs1
  def isort(xs:List[Int]):List[Int]=xs match {
    case List()=>List()
    case x::xs1=>insert(x,isort(xs1))
  }
  def insert(x:Int,xs:List[Int]):List[Int]=xs match {
    case List()=>List(x)
    case y::ys=> if(x<=y) x::xs else y::insert(x,ys)
  }


}
