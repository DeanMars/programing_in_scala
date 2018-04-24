package chapter8

import scala.io.Source

/**
  * Created by Dean on 2018/4/13.
  */
object Chapter8 {


  def main(args: Array[String]): Unit = {
     //printFile("E:\\scala_test\\hello.scala",0)

    //头等函数可以写作匿名字面量，作为值传递
    val x=(x:Int)=>x+1
    println(x)
    println(x(1))
    /*
    //用下划线 _ 当做一个或更多参数的占位符   第一个下划线代表第一个参数，第二个下划线代表第二个参数，不能单个参数重复使用
    val list=List(1,-1,32)
    val list1=list.filter(_>0)
    list1.foreach(println) //只有明确需要函数类型时才可省略_
    val sum=(_:Int)+(_:Int)
    println(sum(2,2))*/

    //部分应用函数  _替换整个参数列表
    /*def sumThree(a:Int,b:Int,c:Int)={ a+b+c}  //此处用lambda表达式会报错
    val sumt=sumThree _
    println(sumt(1,2,3))*/

    //闭包 闭包的是变量的引用
   /* var more=0
    val f=(x:Int)=>x+more
    println(f(1))
    more=10
    println(f(1))*/

    //变长参数
   /* def function1(x:String*)= x.foreach(println)
    function1("123","312")
    function1(List("432","432"):_*)*/

  }


  def printFile(fileName:String,width:Int):Unit={
    //本地函数可以访问包含其函数的参数
    def printLine(line:String,width:Int):Unit={
      if(line.length>width) println(line)
    }
    val file=Source.fromFile(fileName)
    file.getLines().foreach(l=>printLine(l , width))
  }

}
