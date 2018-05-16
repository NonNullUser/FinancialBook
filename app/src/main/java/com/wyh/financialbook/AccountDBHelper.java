package com.wyh.financialbook;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by wyh on 18-5-16
 */
public class AccountDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Account.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "table_accounts";

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
        stringBuffer.append("CREATE TABLE [packages_info_table] (");
        stringBuffer.append("[_id] INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ");
        stringBuffer.append("[name] TEXT,");
        stringBuffer.append("[password] TEXT)");
        sqLiteDatabase.execSQL(stringBuffer.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
