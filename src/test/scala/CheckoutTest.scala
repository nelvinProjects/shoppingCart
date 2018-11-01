import org.scalatest.FlatSpec

class CheckoutTest extends FlatSpec {
  //  Step 1 Tests
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

  // Step 2 Tests
  "No input" should "return 0" in {
    assertResult(Checkout.tillWithOffers()) {
      0.00
    }
  }

  "Buy two apple with offer" should "equal 0.60" in {
    assertResult(Checkout.tillWithOffers(new Apple, new Apple)) {
      0.60
    }
  }

  "Buy three orange with offer" should "equal 0.50" in {
    assertResult(Checkout.tillWithOffers(new Orange, new Orange, new Orange)) {
      0.50
    }
  }

  "Buy two apple and three orange" should "equal 1.10" in {
    assertResult(Checkout.tillWithOffers(new Apple, new Apple, new Orange, new Orange, new Orange)) {
      1.10
    }
  }

  "Buy three apple and one orange with offer" should "equal 1.45" in {
    assertResult(Checkout.tillWithOffers(new Apple, new Apple, new Apple, new Orange)) {
      1.45
    }
  }
}
