package study

/**
 * Created by akyao on 2015/11/15.
 */
class AtmarkIt {

  def main (args: Array[String]) {
    // http://www.atmarkit.co.jp/fjava/index/index_scala.html

    def page1(): Unit ={
      // EclipseでScalaプログラミングを始めるための基礎
      // http://www.atmarkit.co.jp/ait/articles/1202/10/news122.html
      def filterNames(list: List[String], len: Int) = list.filter(_.length() >= len).map(_.toUpperCase)

      // Scalaの特徴

    }

    def page2(): Unit ={
      // Scalaプログラミングで知っておきたい基本構文まとめ
      // http://www.atmarkit.co.jp/ait/articles/1203/02/news118.html

      // 変数定義
      var var1:String = "fuck"
      var var2 = "hoge"
      var var3a, var3b = "aaa"
      // valは再代入不可
      val aaa = ""

      // シンボルリテラル
      val s1 = 'Symbol
      val s2 = scala.Symbol("Symbol")
      // http://www.ne.jp/asahi/hishidama/home/tech/scala/string.html#h_Symbol
      // symbolの場合、同じ値であれば同じインスタンス。Stringはそうではない

      // Scalaの演算子は全てメソッド
      1 + 2  //  = 1 .+(2)

      // Scalaの == はStringでも使える
    }

    def page3(): Unit ={
      // 基本的なコレクション4タイプと制御構文・例外
      // http://www.atmarkit.co.jp/ait/articles/1203/15/news119.html
      // 可変・不変
      // シーケンス、マップ、タプル

      val list1 = List(1,2,3)
      3 :: list1 // = list1.::("Scala")

      val map1 = Map[String,Int]("Scala"->1,"Java"->2,"Ruby"->3)

      val t1 = ("Scala",10)
      // 22個まで

      // if
      val x = 0
      if(x == 0) println("x = 0")
      val result = if(x == 0) "x is zero" else "x is not zero"
      // scalaは最後に評価された式をifの戻りとして返す。= 三項演算子
      val result2 = if(x == 0) "x is Zero" // elseの場合Unitが返される

      // for basic
      for(item <- List(1,2)) println("item = " + item)
      // for filter
      for(
        item <- List(1, 2, 3) //ジェネレータ
        if item > 2 //フィルタ
      ) println("item = " + item)
      // for yield
      val newList = for(item <- List(1,2,3)) yield item * 1000

      // whileとdoWhileもあるよ

      // 例外処理
      val resultError = try {
          "a".toInt
        } catch {
          case e:NumberFormatException => println("exception!"); throw e
        } finally {
          println("finally!")
        }

    }
  }
}
