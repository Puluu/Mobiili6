package com.example.a6assignment;

import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {MyEntity.class}, version = 1)
public abstract class Database extends RoomDatabase {
    public static final String NIMI = "DATABASE";
    public abstract myTableDao myTableDao();
}
