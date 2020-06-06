package vn.edu.ntu.dinhtuyen.controller;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.dinhtuyen.model.Product;

public class CartController extends Application implements ICartController {

    List<Product> listProduct = new ArrayList<>();
    List<Product> cart = new ArrayList<>();

    public CartController() {
        listProduct.add(new Product("Mango", "this is mango Malaysia", 60000));
        listProduct.add(new Product("Apple", "this is apple Malaysia", 60000));
        listProduct.add(new Product("Lemon", "this is lemon Malaysia", 60000));
        listProduct.add(new Product("Banana", "this is banana Malaysia", 60000));
        listProduct.add(new Product("Tomato", "this is tomato Malaysia", 60000));
        listProduct.add(new Product("Kiwi", "this is kiwi Malaysia", 60000));
    }

    @Override
    public List<Product> getListProduct() {
        return listProduct;
    }

    @Override
    public Boolean addToCart(Product product) {
        if(!cart.contains(product)) {
            cart.add(product);
            return true;
        }
        return false;
    }

    @Override
    public List<Product> getCart() {
        return cart;
    }

    @Override
    public void clearCart() {
        cart.clear();
    }
}
