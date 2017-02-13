//Nice generic ways for a sum of functions on x in betwen [a,b]

//Higher order functions
object SumsOfFunctions {
  def id(x: Int): Int = x                         //> id: (x: Int)Int
  def cube(x: Int): Int = x * x * x               //> cube: (x: Int)Int
  def fact(x: Int): Int = if (x == 0) 1 else x * fact(x - 1)
                                                  //> fact: (x: Int)Int
  def sum(f: Int => Int, a: Int, b: Int): Int = {
    if (a > b) 0
    else f(a) + sum(f, a + 1, b)
  }                                               //> sum: (f: Int => Int, a: Int, b: Int)Int

  val cubes = sum(cube, 1, 5)                     //> cubes  : Int = 225
  val cubes2 = sum(x => x * x * x, 1, 5)          //> cubes2  : Int = 225

  val sumNormal = sum(id, 1, 5)                   //> sumNormal  : Int = 15
  val sumNormal2 = sum(x => x, 1, 5)              //> sumNormal2  : Int = 15

  val sumFactorials = sum(fact, 1, 5)             //> sumFactorials  : Int = 153

  def sum2(f: Int => Int, a: Int, b: Int) = {
    def loop(a: Int, acc: Int): Int =
      if (a > b) acc
      else loop(a + 1, f(a) + acc)
    loop(a, 0)
  }                                               //> sum2: (f: Int => Int, a: Int, b: Int)Int

  sum2(x => x * x, 3, 5)                          //> res0: Int = 50




  //Podejscie przekozackie:
  def sum3(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0
      else f(a) + sumF(a + 1, b)
    sumF
  }                                               //> sum3: (f: Int => Int)(Int, Int) => Int
  
  def sumCubes = sum3(x => x*x*x)                 //> sumCubes: => (Int, Int) => Int
  val cubes3 = sumCubes(1,5)                      //> cubes3  : Int = 225
}