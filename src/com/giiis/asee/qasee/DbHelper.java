package com.giiis.asee.qasee;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper{

	private static final String DB_NAME = "usuarios.sqlite";
	private static final int DB_SCHEME_VERSION = 1;
	
	
	public DbHelper(Context context) {
		super(context, DB_NAME, null, DB_SCHEME_VERSION);
		// TODO Auto-generated constructor stub
	}

	public void onCreate (SQLiteDatabase db){
		
		db.execSQL(DataBaseManager.CREATE_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
