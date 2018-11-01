import org.scalatest.FlatSpec

class CheckoutTest extends FlatSpec {
  "No input into till" should "return 0.00" in {
    assertResult(Checkout.till()) {
      0.00
    }
  }

  "Given customer buy one apple" should "equal 0.60" in {
    assertResult(Checkout.till(new Apple)) {
      0.60
    }
  }

  "Given customer buy orange" should "equal 0.25" in {
    assertResult(Checkout.till(new Orange)) {
      0.25
    }
  }

  "Buy three apple and one orange" should "equal 2.05" in {
    assertResult(Checkout.till(new Apple, new Apple, new Apple, new Orange)) {
      2.05
    }
  }

}
