package vn.edu.ntu.thanhdat.controller;

import java.util.List;

import vn.edu.ntu.thanhdat.model.Product;

public interface ICartController {

    public List<Product> getListProduct();
    public Boolean addToCart(Product product);
    public void clearCart();
    public List<Product> getCart();
    public void addProduct(Product p );
}
