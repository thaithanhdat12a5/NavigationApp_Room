package vn.edu.ntu.thanhdat.controller;

import android.content.Context;

import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

import vn.edu.ntu.thanhdat.model.AppDatabase;
import vn.edu.ntu.thanhdat.model.IDaoProduct;
import vn.edu.ntu.thanhdat.model.Product;

public class CartControllerBD implements ICartController {
    AppDatabase database;
    List<Product> shoppingCart = new ArrayList<>();
    IDaoProduct daoProduct;
    public CartControllerBD(Context context)
    {
        database= Room.databaseBuilder(context,
                AppDatabase.class,"appbd")
                .allowMainThreadQueries()
                .build();
        daoProduct=database.getProductDAO();
    }


    @Override
    public List<Product> getListProduct() {
        return daoProduct.getListProduct();
    }


    @Override
    public void addProduct(Product p) {
        daoProduct.insertProduct(p);
    }


    @Override
    public Boolean addToCart(Product product) {
        if(!shoppingCart.contains(product)) {
            shoppingCart.add(product);
            return true;
        }
        return false;
    }


    @Override
    public List<Product> getCart() {
        return shoppingCart;
    }


    @Override
    public void clearCart() {
        shoppingCart.clear();
    }

}
