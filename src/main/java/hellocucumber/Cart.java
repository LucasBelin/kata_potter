package hellocucumber;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Integer> books;

    public Cart() {
        books = new ArrayList<>();
    }

    public boolean addVolumes(int nbVolumes) {
        //There is only 5 different volumes so cart size can't be greater than 5
        if(books.size() == 5) return false;
        books.add(nbVolumes);
        return true;
    }

    public boolean addVolumes(int[] volumes) {
        //There is only 5 different volumes so cart size can't be greater than 5
        if(books.size() + volumes.length > 5) return false;
        for(int nbVolumes : volumes) {
            books.add(nbVolumes);
        }
        return true;
    }

    public String getPrice() {
        List<Integer> bookSetsUncapped = makeSetsOfUniqueVolumes(5);
        //Make sets of unique volumes with a max set size of 4 to try to get a better discount
        //1 set of five + 1 set of 3 -> 35% discount
        //2 sets of four -> 40% discount
        List<Integer> bookSetsCappedAt4 = makeSetsOfUniqueVolumes(4);

        double totalDiscountUncapped = getTotalDiscountForBookSets(bookSetsUncapped);
        double totalDiscountCapped = getTotalDiscountForBookSets(bookSetsCappedAt4);

        double priceWithBestDiscount = 0;
        if(totalDiscountCapped > totalDiscountUncapped) {
            priceWithBestDiscount = calculatePriceOfBookSets(bookSetsCappedAt4);
        }
        else if(totalDiscountCapped <= totalDiscountUncapped) {
            priceWithBestDiscount = calculatePriceOfBookSets(bookSetsUncapped);
        }
        return priceWithBestDiscount + " euros";
    }

    public double getDiscount(int numberOfUniqueVolumes) {
        if (numberOfUniqueVolumes < 0) throw new IllegalArgumentException("Number of volumes can't be negative.");

        return switch (numberOfUniqueVolumes) {
            case 0, 1 -> 0;
            case 2 -> 0.05;
            case 3 -> 0.1;
            case 4 -> 0.2;
            default -> 0.25;
        };
    }

    public int getNumberOfBooksInCart(List<Integer> books) {
        int nbOfBooks = 0;
        for (int nbVolumes : books) {
            nbOfBooks += nbVolumes;
        }
        return nbOfBooks;
    }

    public int makeSetOfUniqueVolumes(List<Integer> books, int maxSetSize) {
        int setSize = 0;
        for(int i = 0; i < books.size(); i++) {
            if(setSize == maxSetSize) break;
            if(books.get(i) != 0) {
                books.set(i, books.get(i) - 1);
                setSize++;
            }
        }
        return setSize;
    }

    public List<Integer> makeSetsOfUniqueVolumes(int maxSetSize) {
        List<Integer> sets = new ArrayList<>();
        List<Integer> booksCopy = new ArrayList<>(books);
        while(getNumberOfBooksInCart(booksCopy) > 0) {
            sets.add(makeSetOfUniqueVolumes(booksCopy, maxSetSize));
        }
        return sets;
    }

    public List<Integer> getBooks() {
        return books;
    }

    public double calculatePriceOfBookSets(List<Integer> bookSets) {
        double price = 0;
        for(int nbVolumes : bookSets) {
            price += nbVolumes * 8 * (1 - getDiscount(nbVolumes));
        }
        return price;
    }

    public double getTotalDiscountForBookSets(List<Integer> bookSets) {
        double totalDiscount = 0;
        for(int nbVolumes : bookSets) {
            totalDiscount += getDiscount(nbVolumes);
        }
        return totalDiscount;
    }

}
