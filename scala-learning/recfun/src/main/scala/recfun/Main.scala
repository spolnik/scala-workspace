package recfun
import common._

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
  def pascal(c: Int, r: Int): Int =
    if (c == 0 || c == r) 1
    else pascal(c - 1, r-1) + pascal(c, r-1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def isOpen(char: Char) = char == '('
    def isClose(char: Char) = char == ')'
    def isMatching(c1: Char, c2: Char) = isOpen(c1) && isClose(c2)

    def isBalanced(input: List[Char], stack: String): Boolean =
      if (input.isEmpty)
        true
      else if (isOpen(input.head))
        isBalanced(input.tail, input.head + stack)
      else if (isClose(input.head))
        !stack.isEmpty && isMatching(stack.head, input.head) && isBalanced(input.tail, stack.tail)
      else
        isBalanced(input.tail, stack)

    isBalanced(chars, "")
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money < 0)
      0
    else if (coins.isEmpty)
      if (money == 0) 1 else 0
    else
      countChange(money, coins.tail) + countChange(money - coins.head, coins)
  }
}
