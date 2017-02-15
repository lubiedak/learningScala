object Assignment {
  type Set = Int => Boolean;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(168); 

  /**
   * Indicates whether a set contains a given element.
   */
  def contains(s: Set, elem: Int): Boolean = s(elem);System.out.println("""contains: (s: Assignment.Set, elem: Int)Boolean""");$skip(109); 

  /**
   * Returns the set of the one given element.
   */
    def singletonSet(elem: Int): Set = Set(elem);System.out.println("""singletonSet: (elem: Int)Assignment.Set""");$skip(33); 
    
    val s = singletonSet(4);System.out.println("""s  : Assignment.Set = """ + $show(s ));$skip(18); val res$0 = 
    contains(s,4);System.out.println("""res0: Boolean = """ + $show(res$0))}
}
