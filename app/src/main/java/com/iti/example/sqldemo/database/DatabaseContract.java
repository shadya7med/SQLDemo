package com.iti.example.sqldemo.database;


import android.provider.BaseColumns;

/**
 * This is a contract class to describe the database schema to
 * avoid misspelling
 * This is class should be in database package
 *
 * */

public final class DatabaseContract  {

    //to prevent this class from being instantiated
    private DatabaseContract(){}

    /**
     * Inner class for each table(entry)
     * to create more tables follow same pattern as the following entry.
     * BaseColumns provide entry class with _id & count properties
     * table fields as String constants
     *
     * */
    public static final class PetEntry implements BaseColumns{

        /**
         * Fields:
         * _ID :
         *       Description: Unique id for each row
         *       Type : INTEGER
         *
         * COLUMNS_PET_NAME :
         *       Description: name field to contain name for each pet
         *       Type : TEXT
         *
         * COLUMNS_PET_BREED :
         *       Description: breed field to contain the breed for each pet
         *       Type : TEXT
         *
         * COLUMNS_PET_GENDER :
         *       Description: breed field to contain the gender for each pet
         *       Type : TEXT
         *
         * COLUMNS_PET_WEIGHT :
         *       Description: breed field to contain the weight for each pet
         *       Type : TEXT
         *
         *
         *
         * */
        public static final String TABLE_NAME = "pets";
        public static final String _ID = BaseColumns._ID ;
        public static final String COLUMN_PET_NAME = "name";
        public static final String COLUMN_PET_BREED = "breed";
        public static final String COLUMN_PET_GENDER = "gender";
        public final static String COLUMN_PET_WEIGHT = "weight";

        /**
         * Possible values for the gender of the pet.
         */
        public static final int GENDER_UNKNOWN = 0;
        public static final int GENDER_MALE = 1;
        public static final int GENDER_FEMALE = 2;



    }

}
