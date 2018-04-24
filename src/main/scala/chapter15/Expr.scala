package chapter15

/**
  * Created by Dean on 2018/4/17.
  */
//sealed 封闭类 只能在类定义的文件之内定义子类。  当模式匹配未考虑所有情况时，会有编译警告
sealed abstract class Expr
case class Var(name:String) extends Expr
case class Number(num:Double) extends Expr
case class UnOp(operator:String,args:Expr)extends Expr
case class BinOp(operator:String,left:Expr,right:Expr) extends Expr


//样本类便捷性
//自动添加类名一致的工厂方法
//样本类参数列表中的参数隐式获得了val前缀，被当做字段来维护
//添加了toString hashCode equals 的自然实现

object Expr{
  def main(args: Array[String]): Unit = {
    //println(Var("123").name)


    //des5(UnOp("-",UnOp("-",Var("das"))))

    //使用模式替换简单标识符，如拆分元组并把值分配给变量
/*    val myTuple=(1,"a")
    val (a,b)=myTuple;
    println(a)
    println(b)*/

    //用模式结构变量
    val op=BinOp("asd",Number(1),Number(2))
    val BinOp(s,l,r)=op
    println(s)
    println(l)
    println(r)



    val first=new PartialFunction[List[Int],Int] {
      override def isDefinedAt(x: List[Int]): Boolean = x match {
        case x::y::_ =>true
        case _ =>false
      }
      override def apply(v1: List[Int]):Int= v1 match {
        case x::y::_ =>y
      }
    }
    //用在偏函数的样本序列（函数体）上 简化上面 https://blog.csdn.net/bluishglc/article/details/50995939
    val second:List[Int]=>Int={
      case x::y::_ =>y
    }


    //for中的模式，不匹配的会被丢弃
    val result=List(Some("a"),None,Some("b"))
    for(Some(x)<-result) println(x)

  }


  //模式匹配，始终以值作为结果
  //自动break永远不会进入下一个表达式
  //没有模式匹配到会有MatchError异常抛出

  //构造器模式  支持深度匹配 检查对象构造器是否参数是否符合提供的模式的
  def simplifyTop(e:Expr):Expr=e match {
      case UnOp("-",UnOp("-",e)) =>e
      case BinOp("+",e,Number(0)) =>e
      case BinOp("*",e,Number(1))=>e
        //通配_ 默认全匹配
      case _ => e
  }

  //常量模式 仅匹配自身，任何字面量都可以作为常量
  def des(a:Any)= a match {
    case 5 => println("5")
    case "123"=>println("123")
    case true=>println("true")
    case Nil=>println("nil")
    case _=>println("_")
  }
  //变量模式 类似匹配符模式，匹配所有
  def des1(a:Any)= a match {
    case 5 => println("5")
    case someEles=>println("123")

  }
  //序列模式
  def des2(a:Any)= a match {
      //匹配0开头的二元列表
    case List(0,_) =>println("12313")
      //匹配0开头任意长度的list
    case List(0,_*) =>println("3123")
  }
  //元组模式
  def des3(a:Any)= a match {
    case (0,_,_)=>println("e32312")
    case (0,_)=>println("dsd")
  }
  //类型模式
  def des4(a:Any)=a match {
    case s:String => println(s.length)
    case m:Map[_,_]=>println(m.size)
      //有类型擦除，Array有特殊处理可用，不能用Map[Int,Int]
    case y:Array[String]=>println(y.length)
  }
  //变量绑定  变量匹配成功就将变量设置成匹配的对象
  def des5(a:Any)= a match {
    case UnOp("-",a @ UnOp("-",e)) =>println(a);a
  }

  //模式守卫 if之后的内容为true才匹配成功
  def des6(a:Any)= a match {
      //模式是线性的，模式变量只允许在模式中出现一次
    //case BinOp("+",x,x)=>BinOp("*",x,Number(2))
    case BinOp("+",x,y) if(x==y)=> BinOp("*",x,Number(2))
  }

  //option 类型
  def show(s:Option[String])= s match {
    case Some(s) => s
    case None =>"?"
  }




}