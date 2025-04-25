package org.media.tilly;

public class basketElements {
    Product product;
    int amount = 0;
    public basketElements(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }
    public void addAmount(int amount) {
        this.amount += amount;

    }
    public Product getProduct() {
        return product;
    }
    public int getAmount() {
        return amount;
    }


}
