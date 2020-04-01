package com.example.myapplication1;

import android.provider.BaseColumns;

public class FeedReaderContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private FeedReaderContract() {}

    /* Inner class that defines the table contents */
    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "student";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_EMAIL = "email";
    }
}
