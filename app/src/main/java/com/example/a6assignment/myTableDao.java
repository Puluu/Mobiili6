package com.example.a6assignment;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface myTableDao {
    @Query("select * from myentity order by id desc")
    List<MyEntity> getAllInDescendingOrder();

    @Insert
    void InsertMyEntity(MyEntity myEntity);



}
