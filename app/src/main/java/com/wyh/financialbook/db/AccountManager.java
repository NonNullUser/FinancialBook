package com.wyh.financialbook.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by wyh on 18-5-18
 */
public class AccountManager {
    private SQLiteDatabase accountDb;
    private AccountDBHelper accountDbHelper;
    private Context context;

    static final String DATABASE_NAME = "Account.db";
    static final int DATABASE_VERSION = 1;
    static final String TABLE_NAME = "table_accounts";

    public AccountManager(Context context) {
        this.context = context;
        accountDbHelper = new AccountDBHelper(context);
        accountDb = accountDbHelper.getWritableDatabase();
    }

    public class AccountDBHelper extends SQLiteOpenHelper {

        public AccountDBHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        public AccountDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        public AccountDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
            super(context, name, factory, version, errorHandler);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("CREATE TABLE [" + TABLE_NAME + "] (");
            stringBuffer.append("[_id] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ");
            stringBuffer.append("[name] TEXT,");
            stringBuffer.append("[password] TEXT)");
            sqLiteDatabase.execSQL(stringBuffer.toString());
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }

    public void insert(String name, String password) {
        accountDb.beginTransaction();
        accountDb.execSQL(String.format("INSERT INTO packages_info_table VALUES(null, ?, ?)"), new Object[]{name, password});
        accountDb.setTransactionSuccessful();
        accountDb.endTransaction();
        accountDb.close();
    }

    public void update(String name, String password) {
        ContentValues values = new ContentValues();
        values.put("name", "name");
        values.put("password", password);
        accountDb.update(TABLE_NAME, values, "name=?", new String[]{name});
        accountDb.close();
    }

    public ArrayList<AccountInfo> queryAll() {
        ArrayList list = new ArrayList();
        Cursor cursor = accountDb.rawQuery("select * from " + TABLE_NAME, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String password = cursor.getString(cursor.getColumnIndex("password"));

            AccountInfo accountInfo = new AccountInfo();
            accountInfo.name = name;
            accountInfo.password = password;

            list.add(accountInfo);
        }
        accountDb.close();
        return list;
    }

    class AccountInfo {
        String name;
        String password;
    }
}
