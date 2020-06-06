package vn.edu.ntu.dinhtuyen.controller;

import java.util.List;

import vn.edu.ntu.dinhtuyen.model.Product;

public interface ICartController {

    public List<Product> getListProduct();
    public Boolean addToCart(Product product);
    public void clearCart();
    public List<Product> getCart();
}
