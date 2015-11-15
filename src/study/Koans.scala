package study

import scala.collection.mutable


/**
 * Created by akyao on 2015/11/04.
 * http://scala-exercises.47deg.com/koans
 */


object Classes {
  def main(args: Array[String]) {

    // Classes
    def class定義(): Unit ={
      class Point(xc: Int, yc: Int) {
        var x: Int = xc
        var y: Int = yc
        def move(dx: Int, dy: Int) {
          x = x + dx
          y = y + dy
        }
        override def toString(): String = "(" + x + ", " + y + ")";
      }
      val pt = new Point(1, 2)
      println(pt)
      pt.move(10, 10)
      println(pt)
    }

    def varとval(): Unit ={
      class ClassWithValParameter(val name: String)
      class ClassWithVarParameter(var description: String)

      // varは変更可能
      val varClass = new ClassWithVarParameter("Flying character")
      varClass.description = "Flying white character"
    }

    def option(): Unit ={
      val someValue: Option[Double] = Some(20.0)
      val value = someValue match {
        case Some(v) => v
        case None => 0.0
      }
      // OptionってNullチェックを強制させただけとは違うのかねえ。チェック例外をなくしたくせにぬるぽチェックだけ強制化した感じ
    }


    def objects(){
      // Objects(singleton的な)
      object Greeting {
        def english = "Hi"
        def japan = "yo"
      }
      Greeting.english

      // コンパニオンオブジェクト classに対するfactory的な
      class Movie(val name: String, val year: Short)

      object Movie {
        def academyAwardBestMoviesForYear(x: Short) = {
          //These are match statement, more powerful than Java switch statements!
          x match {
            case 1930 => Some(new Movie("All Quiet On the Western Front", 1930))
            case 1931 => Some(new Movie("Cimarron", 1931))
            case 1932 => Some(new Movie("Grand Hotel", 1932))
            case _ => None
          }
        }
      }
      Movie.academyAwardBestMoviesForYear(1932).get.name
      // コンパニオンオブジェクトとclass間のスコープについて
      // privateメソッドもよびだせる。
    }

    // Tuple
    val t = (1, "hello", Console)
    val t3 = new Tuple3(1, "hello", Console) //同じ意味
    t._2 //呼び出し

    // 高階関数

    //lambda
    def lambda = { x: Int => x + 1 }
    def lambda2 = (x:Int) => x + 1
    def lambda5(x:Int) = x + 1
    val inc: Int => Int = x => x + 1 // incはIntを取りIntを返す関数であり、その実態はx => x  1
    val inc2 = (x: Int) => x + 1

    // closure
    def fuck(): Unit ={
      var incrementer = 1
      def closure = (x: Int) => x + incrementer
    }
    //Lists
    def list(): Unit ={
      val list = List(1, 2, 3)
      val listString: List[String] = Nil
      list(0)
      val newList = list.map { i => i * 2}
      val listRange = (1 to 5).toList
      3 :: list //3,1,2,3
    }

    // Maps
    def map(): Unit ={
      val myMap = Map("MI" -> "Michigan", "OH" -> "Ohio", "WI" -> "Wisconsin")
      val myMap2 = Map(("MI", "Michigan"), ("OH", "Ohio"), ("WI", "Wisconsin")) //こっちの方が落ち着くなあ
      val aNewMap = myMap + ("IL" -> "Illinois")
      val mapValues = myMap.values //Iterable[String]
      val aNewMap2 = myMap - "MI"
      val aNewMap3 = myMap -- List("MI", "OH")
      val aNewMap4 = myMap - ("MI", "OH") //おんなじになる
    }

    //Sets
    def set(): Unit = {
      val mySet = Set("Michigan", "Ohio", "Wisconsin", "Iowa")
      val aNewSet = mySet + "Illinois"
      val gochaSet = Set("Michigan", "Ohio", 12)
      val mySet2 = mySet - "Ohio"
      val mySet3 = mySet -- List("Michigan", "Ohio")
      val mySet4 = mySet - ("Michigan", "Ohio")
      // intersect
      // union

    }

    // Formatting
    def formatting(): Unit ={
      val s = "Hello World"
      "Application %s".format(s)
    }

    // パターンマッチ
    def patternMatch(): Unit ={
      val stuff = "blue"
      val myStuff = "blue" match {
        case "red" => println("RED"); 1
        case "blue" => println("BLUE"); 2
        case "green" => println("GREEN"); 3
        case _ => println(stuff); 0 //case _ will trigger if all other cases fail.
      }

      def goldilocks1(expr: Any) = expr match {
        case ("porridge", _) => "eating"
        case ("chair", "Mama") => "sitting"
        case ("bed", "Baby") => "sleeping"
        case _ => "what?"
      }

      def goldilocks2(expr: Any) = expr match {
        case ("porridge", bear) => bear + " said someone's been eating my porridge"
        case ("chair", bear) => bear + " said someone's been sitting in my chair"
        case ("bed", bear) => bear + " said someone's been sleeping in my bed"
        case _ => "what?"
      }

      val EatingRegularExpression = """Eating Alert: bear=([^,]+),\s+source=(.+)""".r //.r turns a String to a regular expression
      val SittingRegularExpression = """Sitting Alert: bear=([^,]+),\s+source=(.+)""".r
      val SleepingRegularExpression = """Sleeping Alert: bear=([^,]+),\s+source=(.+)""".r

      def goldilocks3(expr: String) = expr match {
        case (EatingRegularExpression(bear, source)) => "%s said someone's been eating my %s".format(bear, source)
        case (SittingRegularExpression(bear, source)) => "%s said someone's been sitting on my %s".format(bear, source)
        case (SleepingRegularExpression(bear, source)) => "%s said someone's been sleeping in my %s".format(bear, source)
        case _ => "what?"
      }

      // ?意味不明
      def patternEquals(i: Int, j: Int) = j match {
        case `i` => true
        case _ => false
      }
//      patternEquals(3, 3) should be(true)
//      patternEquals(7, 9) should be(false)
//      patternEquals(9, 9) should be(true)

      // ?意味不明
      val secondElement = List(1, 2, 3) match {
        case x :: xs => xs.head
        case _ => 0
      }
    }

    // Caseクラス
    // 各種メソッド(equals,apply etc)と、コンパニオンオブジェクトが勝手にできる & serializable
    // http://www.ne.jp/asahi/hishidama/home/tech/scala/class.html#h_case_class
    def caseClass(): Unit ={
      abstract class Term
      case class Var(name: String) extends Term
      case class Fun(arg: String, body: Term) extends Term
      case class App(f: Term, v: Term) extends Term
      Fun("x", Fun("y", App(Var("x"), Var("y"))))
    }

    // Range
    def range(): Unit ={
      val zeroTo10 = Range(0, 10)
      val oneTo10Step3 = Range(1, 10, 3)
    }

    // Partially Applied Functions
    def partiallyAppliedFunc(): Unit ={
      def sum(a: Int, b: Int, c: Int) = a + b + c
      val sum3 = sum _
      // sum3: (Int, Int, Int) => Int = <function3>

      val sumC = sum(1, 10, _: Int)
      // sumC: Int => Int = <function1>
    }

    def partialFunctions(): Unit ={
      //http://yuroyoro.hatenablog.com/entry/20100705/1278328898
      //直訳すると部分関数ですが、これはなにかっていうと「特定の引数に対しては結果を返すけど、結果を返せない引数もあるような中途半端な関数」です。

      // う、うーん。。これはあと回し
    }

    // Implicits
    def implicits(): Unit ={
      //http://qiita.com/Miyatin/items/f70cf68e89e4367fcf2e

      // 暗黙的な型変換
      implicit def floatToInt(f: Float) = f.toInt
      implicit def stringToInt(s: String) = s.toInt
      def logInt(i: Int) = println(i)
      logInt(1)
      logInt(0.2f)
      logInt("fuck")

      // 暗黙的な型変換 実際例
      import scala.collection.JavaConversions._
      val javaList: java.util.List[Int] = new java.util.ArrayList[Int]()
      javaList.add(1)
      println(javaList.map(_ * 100).sum) //ここ！

      // TODO implicit引数　変数
    }

    def traits(): Unit = {
      // インターフェース的な？
      trait Similarity {
        def isSimilar(x: Any): Boolean

        def isNotSimilar(x: Any): Boolean = !isSimilar(x)
      }
      class Point(xc: Int, yc: Int) extends Similarity {
        var x: Int = xc
        var y: Int = yc

        def isSimilar(obj: Any) =
          obj.isInstanceOf[Point] &&
            obj.asInstanceOf[Point].x == x
      }
      // 一つのtraitを継承するときはextends 複数の場合は二個目以降をwith

    }

    def for文(): Unit ={
      var sum = 0
      for (i <- Range(0, 10))
        sum += i

      for {x <- Range(1, 10)
           y <- Range(1, 10)} yield (print (x * y))

      val nums = List(List(1), List(2), List(3), List(4), List(5))
      val result = for {
        numList <- nums
        num <- numList
        if(num%2 == 0)
      } yield(num)
    }

    def operator(): Unit ={
      // 前置演算子(前置きメソッド)
      class Stereo {
        def unary_+ = "on"
        def unary_- = "off"
      }
      val stereo = new Stereo
      print(+stereo)
    }

    // Infix Types
    def infixTypes(): Unit ={
      case class Person(name: String) {
        def loves(person: Person) = new Loves(this, person)
      }

      class Loves[A, B](val a: A, val b: B)

      def announceCouple(couple: Person Loves Person) = {
        //Notice our type: Person loves Person!
        couple.a.name + " is in love with " + couple.b.name
      }

      val romeo = new Person("Romeo")
      val juliet = new Person("Juliet")

      print(romeo loves juliet)
    }

    def mutableCollection(): Unit ={

      val myMap = mutable.Map("MI" -> "Michigan", "OH" -> "Ohio", "WI" -> "Wisconsin", "IA" -> "Iowa")
      myMap += "OR" -> "Oregon"

      val mySet = mutable.Set("Michigan", "Ohio", "Wisconsin", "Iowa")
      mySet += "Oregon"
    }

    // sequence
    def sequenceAndArray(): Unit ={
      // collectionの子クラスとして、Map, Set, そしてSeq。ListはSeqの子
      val myseq = for (v <- 1 to 10 if v % 3 == 0) yield v //3,6,9

      // SeqもArrayも同じように絞りこみか
      val seq1 = Seq("hello", "to", "you")
      val seq1Filtered = seq1.filter(_.length > 2)
      val arr1 = Array("hello", "to", "you", "again")
      val arr11Filtered = arr1.filter(_.length > 3)
    }

    // iterable
    def iterable(): Unit ={
      // http://scala-exercises.47deg.com/koans#iterables
      val xs1 = Set(3, 2, 1, 4, 5, 6, 7)
      val ys1 = Set(7, 2, 1, 4, 5, 6, 3)
      print(xs1.sameElements(ys1)) //true

      val xs1b = Set(1, 2, 3)
      val ys1b = Set(3, 2, 1)
      print(xs1b.sameElements(ys1b)) //false ?醜い
      print(xs1b == ys1b) //true
    }

    def traversables(): Unit ={
      // 走査可能
      // traversable <- Iterable <- Seq, Set, Map
      // traversableのメソッドはforeachだけ

      val list = List(4, 6, 7, 8, 9, 13, 14)
      val result1 = list.collect {
        case x: Int if (x % 2 == 0) => x * 3
      }


      val partialFunction1: PartialFunction[Int, Int] = {
        case x: Int if x % 2 == 0 => x * 3
      }
      val partialFunction2: PartialFunction[Int, Int] = {
        case y: Int if y % 2 != 0 => y * 4
      }
      val result2 = list.collect(partialFunction1 orElse partialFunction2)

      list.foreach(num => println(num * 4))

      val array = Array(87, 44, 5, 4, 200, 10, 39, 100)
      print(array.filter(_ < 100))
    }

    // named default arg

    // manifests

    // preconditions

    // extractors

    // byName param

    // Repeated Pram

    // Parent Class

    // EMpty

    // Type sig

    // Uniform Acess

    // Literal Booleans

    // literal Numbers

    // Literal Strings

    // Type Variance

    // Enumerations

    // コンストラクター　複数のコンストラクターの場合
  }
}




