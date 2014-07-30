package models;

import play.data.validation.Constraints;

import play.data.validation.Constraints;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by josh_powell on 7/28/14.
 */
public class Product {

    @Constraints.Required
    public String ean;
    @Constraints.Required
    public String name;

    public String description;

    private static List<Product> products;

    public Product() {}

    public Product(String ean, String name, String description) {
        this.ean = ean;
        this.name = name;
        this.description = description;
    }

    public static List<Product> findAll() {
        return new ArrayList<Product>(products);
    }

    public static Product findByEan(String ean) {
        for (Product candidate : products) {
            if( candidate.ean.equals(ean)) {
                return candidate;
            }
        }
        return null;
    }

    public static List<Product> findByName(String term) {
        final List<Product> results = new ArrayList<Product>();
        for (Product candidate : products) {
            if( candidate.name.toLowerCase().contains(term.toLowerCase())) {
                results.add(candidate);
            }
        }
        return results;
    }

    public static boolean remove(Product product) {
        return products.remove(product);
    }

    public void save() {
        products.remove(findByEan(this.ean));
        products.add(this);
    };

    public String toString() {
        return String.format("%s - %s", ean, name);
    }

    static {
        products = new ArrayList<Product>();
        products.add(new Product("111111111111", "Paperclips-1", "Paperclips description 1"));
        products.add(new Product("222222222222", "Paperclips-2", "Paperclips description 2"));
        products.add(new Product("333333333333", "Paperclips-3", "Paperclips description 3"));
        products.add(new Product("444444444444", "Paperclips-4", "Paperclips description 4"));
        products.add(new Product("555555555555", "Paperclips-5", "Paperclips description 5"));
    }


}
