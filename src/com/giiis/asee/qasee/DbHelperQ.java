package com.giiis.asee.qasee;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelperQ extends SQLiteOpenHelper {

	private static final String DB_NAME = "preguntas.sqlite";
	private static final int DB_SCHEME_VERSION = 1;
	
	
	public DbHelperQ(Context context) {
		super(context, DB_NAME, null, DB_SCHEME_VERSION);
		// TODO Auto-generated constructor stub
	}

	public void onCreate (SQLiteDatabase db){
		
		db.execSQL(DataBaseManagerQ.CREATE_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
}
