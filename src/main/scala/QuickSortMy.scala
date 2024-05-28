import scala.util.Random

object QuickSortMy {

  // the speed of quick sort depends on pivot
  // the worst time is O(n^2) // when we have sorted list and we take very first element
  // average time is O(n*log n)  // when we take the random element forom the list
  def quickSort(list: List[Int]): List[Int] = {
    if (list.size < 2)
      list
    else {
      val pivot = list.head
      val less = list.tail.filter(_ <= pivot)
      val greater = list.tail.filter(_ > pivot)
      quickSort(less) ++ List(list.head) ++ quickSort(greater)
    }
  }

  def main(args: Array[String]): Unit = {
    val n = 100
    val random = new Random()
    val aList = List.fill(n)(random.nextInt(500))
    println(quickSort(aList).take(20))
  }
}
