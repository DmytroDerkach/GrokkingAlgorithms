import scala.::
import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer
import scala.util.Random

object SelectionSort {
  // speed: O(n^2)
  def selectionSort(list: List[Int]): List[Int] = {
    def findSmallest(list: collection.mutable.ListBuffer[Int]): Int = {
      var smallest = list.head
      var smallestIndex = 0
      for (i <- 1 until list.size) {
        if (list(i) < smallest) {
          smallest = list(i)
          smallestIndex = i
        }
      }
      smallestIndex
    }


    val listBuffer = list.to(collection.mutable.ListBuffer)
    val sortedList = new ListBuffer[Int]()
    for (_ <- list.indices) {
      val indexOfSmallest = findSmallest(listBuffer)
      val element = listBuffer.remove(indexOfSmallest)
      sortedList.addOne(element)
    }
    sortedList.toList

  }

  def selectionSortRecursion(list: List[Int]): List[Int] = {
    @tailrec
    def selectSortHelper(list: List[Int], accumList: List[Int] = List[Int]()): List[Int] = {

      list match {
        case Nil => accumList
        case _ => {
          val min = list.min
          val requiredList = list.filter(_ != min)
          selectSortHelper(requiredList, accumList ::: List.fill(list.length - requiredList.length)(min))
        }
      }
    }

    selectSortHelper(list)
  }

  def main(args: Array[String]): Unit = {
    val n = 100
    val random = new Random()
    val list = List.fill(n)(random.nextInt(500))

    println(s"the list is generated with size $n")
    val initTime = System.currentTimeMillis()
    val sortedList = selectionSort(list)
    val time = System.currentTimeMillis() - initTime
    println(s"list `${sortedList.take(10)}` is sorted in $time mls")

    val initTimeRecursion = System.currentTimeMillis()
    val sortedListRecursion = selectionSortRecursion(list)
    val timeRecursion = System.currentTimeMillis() - initTimeRecursion
    println(s"list `${sortedListRecursion.take(10)}` is sorted in $timeRecursion mls")

  }
}
