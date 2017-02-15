object intSets {
	def fresh(x: Int) : IntSet = new NonEmpty(x, Empty, Empty)
                                                  //> fresh: (x: Int)IntSet

  val t1 = fresh(5)                               //> t1  : IntSet = {.5.}
  val t2 = t1 incl 4                              //> t2  : IntSet = {{.4.}5.}
  
}

abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}

object Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
  override def toString = "."
  def union(other: IntSet) = other
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true
  
  def incl(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this
  
  def union(other: IntSet): IntSet =
  	((left union right) union other) incl elem
  	
  override def toString = "{" + left + elem + right + "}"
}