package vn.edu.ntu.thanhdat.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface IDaoProduct {
    @Insert
    public void insertProduct(Product...products);
    @Update
    public void updateProduct(Product...products);
    @Delete
    public void deleteProduct(Product...products);
    @Query("Select *From Product")
    List<Product> getListProduct();
    @Query("Select * From Product Where id = :id")
    public Product getProductById(long id);

}
