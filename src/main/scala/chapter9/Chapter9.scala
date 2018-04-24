package chapter9

import java.io.{File, PrintWriter}


/**
  * Created by Dean on 2018/4/18.
  */
class Chapter9 {

}

object Chapter9{
  //函数柯里化（Currying）
  def curriedSum(x:Int)(y:Int):Int=x+y

  //op的类型是Double=>Double，是一个入参和返回都是Double类型的函数
  def twice(op:Double=>Double,x:Double)=op(op(x))

  //借贷模式
  def withPrintWriter(file:File)(op:PrintWriter=>Unit)={
    val writer=new PrintWriter(file)
    try{
      op(writer)
    }finally {
      writer.close()
    }
  }


  def byNameAssert(a:Boolean,op: ()=>Boolean)={
    if(a && !op()){
      throw new AssertionError()
    }else{
      println("ok")
    }
  }
  //传名函数  op: ()=>Boolean  简写为 op: =>Boolean 中间有空格
  def byNameAssert1(a:Boolean,op: =>Boolean)={
    if(a && !op){
      throw new AssertionError()
    }else{
      println("ok")
    }
  }



  def main(args: Array[String]): Unit = {
/*    val a=curriedSum(1)_
    println(a)
    val b= a(2)
    //{} 替换（）使用，仅在传入一个参数时有效
    println{b}*/
    //Currying 之后用{}替代最后一个（）
   // withPrintWriter(new File("date.txt")){w=>w.print(new Date())}

    byNameAssert(true,()=>5>3)
    byNameAssert1(true,5>3) //传名函数可以省略（）=>


  }





}