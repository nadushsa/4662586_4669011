package com.vu.a4662586_4669011.data;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "car.db";
    public static final String TABLE_NAME = "car_table";
    public static final String CAR_ID = "ID";
    public static final String CAR_BRAND = "BRAND";
    public static final String CAR_MODEL = "MODEL";
    public static final String CAR_PRICE = "PRICE";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PRODUCT_TABLE = "CREATE TABLE " + TABLE_NAME
                + "(" + CAR_ID + " INTEGER " + "PRIMARY KEY AUTOINCREMENT, "
                + CAR_BRAND + " TEXT, "
                + CAR_MODEL + " TEXT, "
                + CAR_PRICE + " INTEGER)";

        db.execSQL(CREATE_PRODUCT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insertData(String brand, String model, int price) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(CAR_BRAND, brand);
        contentValues.put(CAR_MODEL, model);
        contentValues.put(CAR_PRICE, price);

        long result = db.insert(TABLE_NAME, null, contentValues);

        return result != -1;
    }

    @SuppressLint("Range")
    public int getPrice(String brand, String model) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {CAR_PRICE};
        String selection = CAR_BRAND + " = ? AND " + CAR_MODEL + " = ? ";
        String[] selectionArgs = {brand, model};

        Cursor cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null);

        int price = -1;

        if (cursor.moveToFirst()) {
            price = cursor.getInt(cursor.getColumnIndex(CAR_PRICE));
        }

        cursor.close();
        return price;
    }
}
