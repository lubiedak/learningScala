package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = if (r - c == 0) 1 else c + pascal(c, r - 1)

  /**
   * Exercise 2
   * lubiedak TODO: could be improved, but works fine
   * unfortunately no recurrsion used
   */
  def balance(chars: List[Char]): Boolean = {
    var x = 0
    def ifParenthesisThenBalance(char: Char): Int = {
      char match {
      case '(' =>  x=x+1
      case ')' =>  x=x-1
      case _ => x
      }; x
    }
    val balanceList = chars.map(x => ifParenthesisThenBalance(x))

    !balanceList.contains(-1) && balanceList.last == 0
  }

  /**
   * Exercise 3
   * lubiedak TODO: could be improved, but works fine
   * unfortunately no recurrsion used
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if(coins.isEmpty)
      0
    
    val sortedCoins = coins.sorted;
    val maxOneCoinsCombinations = sortedCoins.map(x => money / x).filter { x => x > 0 }.toArray
    val usedCoins = sortedCoins.take(maxOneCoinsCombinations.size)
    val proposedChange = maxOneCoinsCombinations.map(x => x - x)
    
    
    def nextCombination(): Boolean = {
      var i = 0;
      while (i < proposedChange.size) {
        val currentValue = proposedChange(i)
        val areEqual = proposedChange.deep == maxOneCoinsCombinations.deep
        if (currentValue < maxOneCoinsCombinations(i) && !areEqual) {
          proposedChange(i) = currentValue + 1
          return !areEqual
        } else {
          if (areEqual) return !areEqual
          else proposedChange(i) = 0; i += 1
        }
      }
      true
    }
    var counter = 0
    while (nextCombination()) {
      val amounts = (proposedChange, usedCoins).zipped.map(_ * _)
      if (amounts.sum == money)
        counter += 1
    }

    counter
  }
}
 /* 
  trait A
  case class B(name: String) extends A
  case class C(surname: String, name: String, age: Int) extends A
  
  def fucntion2(char: A) = {
    char match {
      case B(name) => println(name)
      case C(surname, _, 2) => println(surname)
      case C(surname, "przemek", _)     => println(surname)
      case C(surname, _, age) if age > 10 => println(surname)
      case _ => println(_)
     }
 */
