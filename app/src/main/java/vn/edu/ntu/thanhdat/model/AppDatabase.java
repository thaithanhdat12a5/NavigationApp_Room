package vn.edu.ntu.thanhdat.model;

import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = {Product.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract IDaoProduct getProductDAO();
}
