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
    def pascal(c: Int, r: Int): Int = if(r-c==0) 1 else c + pascal(c, r-1)
  
  /**
   * Exercise 2
   * lubiedak TODO: could be improved, but works fine
   * unfortunately no recurrsion used
   */
    def balance(chars: List[Char]): Boolean = {
      var x = 0
      def ifParenthesisThenBalance(char: Char): Int = {
        if(char=='(')
          x=x+1
        else if(char==')')
          x=x-1
        x
      }
      val balanceList = chars.map(x=> ifParenthesisThenBalance(x))
      
      !balanceList.contains(-1) && balanceList.last == 0
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = ???
  }
