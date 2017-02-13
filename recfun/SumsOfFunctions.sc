//Nice generic ways for a sum of functions on x in betwen [a,b]

object SumsOfFunctions {
  def id(x: Int) : Int = x                        //> id: (x: Int)Int
  def cube(x: Int) : Int = x*x*x                  //> cube: (x: Int)Int
  def fact(x: Int) : Int = if(x==0) 1 else x * fact(x-1)
                                                  //> fact: (x: Int)Int
  def sum(f: Int => Int, a: Int, b: Int): Int = {
    if(a>b) 0
    else f(a) + sum(f, a+1,b)
  }                                               //> sum: (f: Int => Int, a: Int, b: Int)Int
  
  
  val cubes = sum(cube, 1, 5)                     //> cubes  : Int = 225
  val sumNormal = sum(id, 1, 5)                   //> sumNormal  : Int = 15
  val sumFactorials = sum(fact, 1, 5)             //> sumFactorials  : Int = 153
  
  
}