package hellocucumber;

public class Main {

    public static void main(String[] args) {
        Cart cart = new Cart();
        cart.addVolumes(new int[] {2, 2, 2, 1, 1});
        System.out.println(cart.getPrice());
    }

}