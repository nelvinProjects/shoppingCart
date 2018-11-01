/**
  * Adds items to checkout and get total back
  * @author Nelvin
  */
object Checkout {
  def main(args: Array[String]): Unit = {
    val apple = new Apple()
    val orange = new Orange()
    println(f"£${till(apple, orange)}%.2f")
    println(f"£${till(apple, apple, apple, orange)}%.2f")
  }
  /**
    * Step 1: Calculate items total
    * @param items fruit objects
    * @return price total
    */
   def till(items: Fruit*): Double = {
    items.count(_.isInstanceOf[Apple]) * new Apple().price +
      items.count(_.isInstanceOf[Orange]) * new Orange().price
  }


}
