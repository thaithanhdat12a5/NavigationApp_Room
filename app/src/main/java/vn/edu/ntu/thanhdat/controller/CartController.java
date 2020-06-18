package vn.edu.ntu.thanhdat.controller;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.thanhdat.model.Product;

public class CartController extends Application implements ICartController {

    List<Product> listProduct = new ArrayList<>();
    List<Product> cart = new ArrayList<>();

    public CartController() {
//        listProduct.add(new Product("Xoài cát", 60000, "Xoài cát Hỏa lộc loại 1"));
//        listProduct.add(new Product("Khoai lang", 45000, "Khoang lang tím giống nhật"));
//        listProduct.add(new Product("Me thái", 65000, "Me thái lan nhập khẩu"));
//        listProduct.add(new Product("Ổi", 60000, "Ổi chua"));
//        listProduct.add(new Product("Mận tím", 50000, "Mận tím tây bắc"));
//        listProduct.add(new Product("Táo đỏ", 60000, "Táp đỏ mỹ "));
//        listProduct.add(new Product("Sầu riêng Khánh Sơn", 90000, "Sầu riêng loại 1"));
    }

    @Override
    public List<Product> getListProduct() {
        return listProduct;
    }

    @Override
    public void addProduct(Product p) {
        listProduct.add(p);
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
