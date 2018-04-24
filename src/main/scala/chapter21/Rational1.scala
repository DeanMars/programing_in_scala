package chapter21

/**
  * Created by Dean on 2018/4/10.
  */
class Rational1(n:Int, d:Int) {
  //先决条件检查
  require(d!=0)
  //辅助构造器
  def this(n:Int)=this(n,1)

  val g=gcd(n,d)
  //添加字段 使add方法中的that可以访问到n,d的值
  val numer=n/g
  val denom=d/g

  def +(that:Rational1):Rational1={
    new Rational1(numer*that.denom +denom*that.numer, denom*that.denom)
  }


  def *(that:Rational1):Rational1={
    new Rational1(numer*that.numer,denom*that.denom)
  }


  def gcd(a:Int,b:Int):Int={
    if(b==0) a else gcd(b,a%b)
  }

  //重写toString方法
  override def toString: String = numer+"/"+denom


}

object Rational1{
  implicit def int2Rational(i:Int):Rational1={
    new Rational1(i,1)
  }

  def main(args: Array[String]): Unit = {
    println(new Rational1(1,2) + 1)

    println(2 + new Rational1(1,2))

  }
}



