package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void

    private void insert(String Name, String Email) {
        FeedReaderDbHelper dbHelper = new FeedReaderDbHelper(this);
        // Gets the data repository in write mode
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME, Name);
        values.put(FeedReaderContract.FeedEntry.COLUMN_EMAIL, Email);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(FeedReaderContract.FeedEntry.TABLE_NAME, null, values);
    }

    private void delete(String Name) {
        FeedReaderDbHelper dbHelper = new FeedReaderDbHelper(this);
        // Gets the data repository in write mode
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Define 'where' part of query.
        String selection = FeedReaderContract.FeedEntry.COLUMN_NAME + " LIKE ?";
        // Specify arguments in placeholder order.
        String[] selectionArgs = {Name};
        // Issue SQL statement.
        int deletedRows = db.delete(FeedReaderContract.FeedEntry.TABLE_NAME, selection, selectionArgs);
    }

}
