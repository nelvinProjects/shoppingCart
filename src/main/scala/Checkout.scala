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
    println(f"£${tillWithOffers(apple, apple)}%.2f")
    println(f"£${tillWithOffers(orange, orange, orange)}%.2f")
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

  /**
    * Step 2: Calculate items with offers
    * @param items fruit objects
    * @return price total
    */
  def tillWithOffers(items: Fruit*): Double = {
    offers(items.count(_.isInstanceOf[Apple]), new Apple().price, true) +
      offers(items.count(_.isInstanceOf[Orange]), new Orange().price, false)
  }

  /**
    * Works out fruit total after offer
    * @param count the fruit count
    * @param price fruit price
    * @param isApple whether its apple or not
    * @return item total after offer
    */
  def offers(count: Int, price: Double, isApple: Boolean): Double = {
    isApple match {
      case true => ((count / 2) + (count % 2)) * price
      case true if count == 1 => count * price
      case false => (((count / 3) * 2) + (count % 3)) * price
      case false if count < 3 => count * price
      case _ => 0
    }
  }
}
