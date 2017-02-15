object Assignment {
  type Set = Int => Boolean

  /**
   * Indicates whether a set contains a given element.
   */
  def contains(s: Set, elem: Int): Boolean = s(elem)
                                                  //> contains: (s: Assignment.Set, elem: Int)Boolean

  /**
   * Returns the set of the one given element.
   */
    def singletonSet(elem: Int): Set = Set(elem)  //> singletonSet: (elem: Int)Assignment.Set
    
    val s = singletonSet(4)                       //> s  : Assignment.Set = Set(4)
    contains(s,4)                                 //> res0: Boolean = true
}