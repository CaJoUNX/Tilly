package org.media.tilly;

import java.util.List;

public interface basketInterface {
    void addProduct(basketElements product);


    void removeProduct(int id);

    void removeAllProducts();
    public List<basketElements> getProducts();

}
