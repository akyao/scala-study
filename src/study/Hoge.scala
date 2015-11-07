package study

/**
 * Created by akyao on 2015/11/04.
 * http://scala-exercises.47deg.com/koans
 */


object Classes {
  def main(args: Array[String]) {

    // Classes
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

    class ClassWithValParameter(val name: String)
    class ClassWithVarParameter(var description: String)

    // varは変更可能
    val varClass = new ClassWithVarParameter("Flying character")
    varClass.description = "Flying white character"

    // Option
    val someValue: Option[Double] = Some(20.0)
    val value = someValue match {
      case Some(v) => v
      case None => 0.0
    }
    // OptionってNullチェックを強制させただけとは違うのかねえ。チェック例外をなくしたくせにぬるぽチェックだけ強制化した感じ

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

    // パターンマッチ

    // Caseクラス

    // Range

    // partial FUnctions

    // Implicits

    // Traits

    // For

    // InFIX

    // Infix Types

    // mutable

    // sequence

    // iterable

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




