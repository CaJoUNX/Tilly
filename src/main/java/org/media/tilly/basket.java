package org.media.tilly;

import java.util.ArrayList;
import java.util.List;

public class basket implements basketInterface {
    List<basketElements> products = new ArrayList<basketElements>();
    public basket() {
    }
    public void addProduct(basketElements product) {
        products.add(product);
    }


    public void addProduct(String item) {

    }



    @Override
    public void removeProduct(int id) {
        products.removeIf(product -> product.getProduct().getId() == id);
    }

    @Override
    public void removeAllProducts() {
        products.clear();

    }

    public List<basketElements> getProducts() {
        return products;
    }

}
