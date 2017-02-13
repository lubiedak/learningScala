object MapReduce {
  def mapReduce(map: Int => Int, reduce: (Int, Int) => Int, init: Int)(a: Int, b: Int): Int = {
    if (a > b) init
    else reduce(map(a), mapReduce(map, reduce, init)(a + 1, b))
  } //> mapReduce: (map: Int => Int, reduce: (Int, Int) => Int, init: Int)(a: Int, b
  //| : Int)Int

  def product(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b)
  //> product: (f: Int => Int)(a: Int, b: Int)Int
  def sum(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x + y, 0)(a, b)
  //> sum: (f: Int => Int)(a: Int, b: Int)Int

  def fact(n: Int): Int = product(x => x)(1, n) //> fact: (n: Int)Int

  fact(5) //> res0: Int = 120
}