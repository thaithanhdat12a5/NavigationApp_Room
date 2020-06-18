package vn.edu.ntu.thanhdat.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Product")
public class Product {
    @PrimaryKey(autoGenerate = true)
    long id;
    @NonNull
    private String name;
    @NonNull
    private   String description;
    @NonNull
    private int price;
//-------------------------------------------------------------------------


    public Product(@NonNull String name, @NonNull String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
