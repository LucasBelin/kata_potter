package hellocucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {

    private Cart cart;

    @Given("A cart")
    public void init_cart() {
        this.cart = new Cart();
    }

    @When("I add a book of volume 1 to the cart")
    public void i_add_a_book_of_volume_1_to_the_cart() {
        cart.addVolumes(1);
    }

    @Then("The cart price is {string}")
    public void the_cart_price_is(String expectedAnswer) {
        Assertions.assertEquals(expectedAnswer, cart.getPrice());
    }
}