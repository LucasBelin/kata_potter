package hellocucumber;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UnitTests {

    @Test
    void addOneVolumeShouldBeTrue() {
        Cart cart = new Cart();
        Assertions.assertTrue(cart.addVolumes(1));
    }

    @Test
    void addOneVolumeToFullCartShouldBeFalse() {
        Cart cart = new Cart();
        cart.addVolumes(new int[] {0, 0, 0, 0, 0 });
        Assertions.assertFalse(cart.addVolumes(1));
    }

    @Test
    void addTwoSetsOfVolumesShouldBeTrue() {
        Cart cart = new Cart();
        Assertions.assertTrue(cart.addVolumes(new int[] {1, 1}));
    }

    @Test
    void addTwoSetsOfVolumesToFullCartShouldBeFalse() {
        Cart cart = new Cart();
        cart.addVolumes(new int[] {1, 1, 1, 1});
        Assertions.assertFalse(cart.addVolumes(new int[] {1, 1}));
    }

    @Test
    void negativeAmountOfBooksShouldThrowException() {
        Cart cart = new Cart();
        assertThrows(IllegalArgumentException.class, () -> {cart.getDiscount(-1);});
    }

    @Test
    void noBooksShouldGetNoDiscount() {
        Cart cart = new Cart();
        Assertions.assertEquals(0, cart.getDiscount(0));
    }

    @Test
    void oneBookShouldGetNoDiscount() {
        Cart cart = new Cart();
        Assertions.assertEquals(0, cart.getDiscount(1));
    }

    @Test
    void twoBooksShouldGetFivePercentDiscount() {
        Cart cart = new Cart();
        Assertions.assertEquals(0.05, cart.getDiscount(2));
    }

    @Test
    void threeBooksShouldGetTenPercentDiscount() {
        Cart cart = new Cart();
        Assertions.assertEquals(0.1, cart.getDiscount(3));
    }

    @Test
    void fourBooksShouldGetTwentyPercentDiscount() {
        Cart cart = new Cart();
        Assertions.assertEquals(0.2, cart.getDiscount(4));
    }

    @Test
    void fiveBooksShouldGetTwentyFivePercentDiscount() {
        Cart cart = new Cart();
        Assertions.assertEquals(0.25, cart.getDiscount(5));
    }

    @Test
    void numberOfBooksShouldBeOne() {
        Cart cart = new Cart();
        cart.addVolumes(1);
        Assertions.assertEquals(1, cart.getNumberOfBooksInCart(cart.getBooks()));
    }

    @Test
    void numberOfBooksShouldBeTwelve() {
        Cart cart = new Cart();
        cart.addVolumes(new int[] {2, 2, 2, 5, 1});
        Assertions.assertEquals(12, cart.getNumberOfBooksInCart(cart.getBooks()));
    }

    @Test
    void priceShouldBeEight() {
        Cart cart = new Cart();
        cart.addVolumes(1);
        Assertions.assertEquals("8.0 euros", cart.getPrice());
    }

    @Test
    void priceShouldBeThirty() {
        Cart cart = new Cart();
        cart.addVolumes(new int[] {1, 1, 1, 1, 1});
        Assertions.assertEquals("30.0 euros", cart.getPrice());
    }

    @Test
    void priceShouldBe51EurosAnd20Cents() {
        Cart cart = new Cart();
        cart.addVolumes(new int[] {2, 2, 2, 1, 1});
        Assertions.assertEquals("51.2 euros", cart.getPrice());
    }

    @Test
    void priceOfBookSetsShouldBeEight() {
        Cart cart = new Cart();
        cart.addVolumes(1);
        Assertions.assertEquals(8, cart.calculatePriceOfBookSets(cart.getBooks()));
    }

    @Test
    void priceOfBookSetsShouldBeThirty() {
        Cart cart = new Cart();
        cart.addVolumes(new int[] {1, 1, 1, 1, 1});
        List<Integer> sets = cart.makeSetsOfUniqueVolumes(5);
        Assertions.assertEquals(30, cart.calculatePriceOfBookSets(sets));
    }

    @Test
    void priceOfBookSetsShouldBe51EurosAnd60Cents() {
        Cart cart = new Cart();
        cart.addVolumes(new int[] {2, 2, 2, 1, 1});
        List<Integer> sets = cart.makeSetsOfUniqueVolumes(5);
        Assertions.assertEquals(51.6, cart.calculatePriceOfBookSets(sets));
    }

    @Test
    void priceOfBookSetsShouldBe51EurosAnd20Cents() {
        Cart cart = new Cart();
        cart.addVolumes(new int[] {2, 2, 2, 1, 1});
        List<Integer> sets = cart.makeSetsOfUniqueVolumes(4);
        Assertions.assertEquals(51.2, cart.calculatePriceOfBookSets(sets));
    }

    @Test
    void setShouldBeOne() {
        Cart cart = new Cart();
        cart.addVolumes(2);
        Assertions.assertEquals(1, cart.makeSetOfUniqueVolumes(cart.getBooks(), 5));
    }

    @Test
    void setShouldBeThree() {
        Cart cart = new Cart();
        cart.addVolumes(new int[] {1, 1, 1});
        Assertions.assertEquals(3, cart.makeSetOfUniqueVolumes(cart.getBooks(), 5));
    }

    @Test
    void setShouldBeFive() {
        Cart cart = new Cart();
        cart.addVolumes(new int[] {1, 1, 1, 1, 1});
        Assertions.assertEquals(5, cart.makeSetOfUniqueVolumes(cart.getBooks(), 5));
    }

    @Test
    void setShouldBeFour() {
        Cart cart = new Cart();
        cart.addVolumes(new int[] {1, 1, 1, 1, 1});
        Assertions.assertEquals(4, cart.makeSetOfUniqueVolumes(cart.getBooks(), 4));
    }
}
