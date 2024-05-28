import scala.util.Random

object BinarySearch {

  // speed: O(log n)
  def binarySearch(list: Seq[Int], item: Int): Int = {
    var low = 0
    var high = list.size - 1


    while (low <= high) {
      val mid: Int = (low + high) / 2
      val guess = list(mid)
      if (guess == item)
        return mid
      else if (guess > item)
        high = mid - 1
      else
        low = mid + 1
    }
    -1
  }

  def recursiveBinarySearch(list: Seq[Int], item: Int)
                           (low: Int = 0, high: Int = list.size - 1): Int = {
    if (low > high) return -1
    var mid = low + (high - low) / 2

    if (list(mid) == item) mid
    else if (list(mid) > item) recursiveBinarySearch(list, item)(low, mid - 1)
    else recursiveBinarySearch(list, item)(mid + 1, high)
  }

  def main(args: Array[String]): Unit = {
    val size = 1000000
    val aList = (1 to size).toList
    val random = new Random(System.currentTimeMillis())
    val newNumber = random.nextInt(size - 1)
    println(s"a list is initialized, and searchable number is $newNumber")
    val initTime = System.currentTimeMillis()
    val result = binarySearch(aList, newNumber)
    val time = System.currentTimeMillis() - initTime
    println(s"result `$result` is found in $time mls")

    println("recursiveBinarySearch")
    val initTimeForRecursive = System.currentTimeMillis()
    val resultRecursive = recursiveBinarySearch(aList, newNumber)(0, aList.size - 1)
    val timeRecursive = System.currentTimeMillis() - initTimeForRecursive
    println(s"Recursive result `$resultRecursive` is found in $timeRecursive mls")
    /*
    result `314289` is found in 43 mls
    recursiveBinarySearch
    Recursive result `314289` is found in 92 mls
     */
  }
}
