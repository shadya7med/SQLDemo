package com.iti.example.sqldemo.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * import contract class that defines the database schema
 * This is class should be in database package
 * */
import com.iti.example.sqldemo.database.DatabaseContract.PetEntry;

import java.util.ArrayList;



/**
 * Contains the business logic needed by the App ,
 * also contains inner class that extends openHelper class.
 *
 * */
public class SqlAdapter {


    private Context context ;
    private SqlAdapter sqlAdapter ;
    private SqlHelper dbHelper;


    /*has to be called to initialize Context*/
    public static void init(Context _context)
    {
        context = _context.getApplicationContext() ;
    }
    private SqlAdapter() {

        dbHelper = new SqlHelper(context);
    }

    //called to get instance of SqlAdapter
    public SqlAdapter getSharedAdapter(){

        if (sqlAdapter == null) sqlAdapter = new SqlAdapter() ;
        return sqlAdapter ;
    }

    public long insertRow(ArrayList<String> values){
        long insertedRowId = 0;

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues modifiedRow =  new ContentValues();
        //set Values for each COLUMN
        modifiedRow.put(COLUMN_1,values.get(0));
        modifiedRow.put(COLUMN_2,values.get(1));
        //insert the modified row into the table
        insertedRowId = db.insert(TABLE_NAME,null,modifiedRow);

        return insertedRowId;
    }

    /**
     * - inner openHelper class that is used to open,manage (create and upgrade) and connect with a
     *   SQLite database.
     * - contains onCreate,onUpgrade alongside with some other methods to create and modify tables in
     * the database
     * - Also contains some constants related to the database itself such as :
     *      - DATABASE_VERSION
     *      - DATABASE_NAME
     *
     *
     * */

    private class SqlHelper extends SQLiteOpenHelper{


        /**
         * DATABASE_VERSION : to indicate any modification done by the onUpgrade method.
         * DATABASE_NAME : to specify the name of the current database.
         * */
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "pets.db";


        /**
         * CREATE SQL to create the desired table
         * */
        private String SQL_CREATE_PETS_TABLE =  "CREATE TABLE " + PetEntry.TABLE_NAME + " ("
                + PetEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + PetEntry.COLUMN_PET_NAME + " TEXT NOT NULL, "
                + PetEntry.COLUMN_PET_BREED + " TEXT, "
                + PetEntry.COLUMN_PET_GENDER + " INTEGER NOT NULL, "
                + PetEntry.COLUMN_PET_WEIGHT + " INTEGER NOT NULL DEFAULT 0);";

        /**
         * DROP SQL to drop current table inorder to delete it or upgrade it
         * */
        private String SQL_DROP_PET_TABLE = "DROP TABLE IF EXISTS " + PetEntry.TABLE_NAME ;

        public SqlHelper( Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        /**
         * this method is used by the helper to create tables in a database
         */

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_PETS_TABLE);
        }

        /**
         * The implementation should use this method to drop tables, add tables,
         * or do anything else it needs to upgrade to the new schema version.
         *
         *
         */

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(SQL_DROP_PET_TABLE);
            db.execSQL(SQL_CREATE_PETS_TABLE);

        }
    }


}
