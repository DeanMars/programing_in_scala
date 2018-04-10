package chapter6

/**
  * Created by Dean on 2018/4/10.
  */
class Rational(n:Int,d:Int) {
  //先决条件检查
  require(d!=0)
  //辅助构造器
  def this(n:Int)=this(n,1)

  val g=gcd(n,d)
  //添加字段 使add方法中的that可以访问到n,d的值
  val numer=n/g
  val denom=d/g

  def +(that:Rational):Rational={
    new Rational(numer*that.denom +denom*that.numer, denom*that.denom)
  }
  //方法重载
  def +(i:Int):Rational= new Rational(numer+i*denom,denom)

  def *(that:Rational):Rational={
    new Rational(numer*that.numer,denom*that.denom)
  }


  def gcd(a:Int,b:Int):Int={
    if(b==0) a else gcd(b,a%b)
  }



  //重写toString方法
  override def toString: String = numer+"/"+denom


}


object Rational{
  def main(args: Array[String]): Unit = {
    val ra=new Rational(4,6);
    println(ra)

    val ra1=new Rational(1,3);

    println("ra+ra1="+(ra+ra1))
    println("ra+ra1="+ra*ra1)

  }
}
