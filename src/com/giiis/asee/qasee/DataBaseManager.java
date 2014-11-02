package com.giiis.asee.qasee;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DataBaseManager {

	public static final String TABLE_NAME = "usuarios";
	
	public static final String CN_ID = "_id";
	public static final String CN_NAME = "nombre";
	public static final String CN_APE1 = "apellido1";
	public static final String CN_APE2 = "apellido2";
	public static final String CN_PASS = "contrasenia";
	public static final String CN_EMAIL = "email";
	public static final String CN_USUARIO = "usuario";
	
	
	public static final String CREATE_TABLE = "create table " + TABLE_NAME+ " ("
			+ CN_ID + " integer primary key autoincrement,"
			+ CN_USUARIO + " text not null,"
			+ CN_PASS + " text not null,"
			+ CN_NAME + " text not null,"
			+ CN_APE1 + " text not null,"
			+ CN_APE2 + " text,"
			+ CN_EMAIL + " text not null);";
	
	
	private DbHelper helper;
	private SQLiteDatabase db;
	public DataBaseManager ( Context context){
		
		helper = new DbHelper(context);
        db = helper.getWritableDatabase();
	}
	
	
	private ContentValues generarContentValues(String usuario, String password, String nombre, String apellido1, String apellido2, String email ){
		ContentValues valores = new ContentValues();
		valores.put(CN_USUARIO, usuario);
		valores.put(CN_PASS, password);
		valores.put(CN_NAME, nombre);
		valores.put(CN_APE1, apellido1);
		valores.put(CN_APE2, apellido2);
		valores.put(CN_EMAIL,email);
		
		return valores;
		
		
	}
	public void insertarUsuario (String usuario, String password, String nombre, String apellido1, String apellido2, String email ){
		
		db.insert(TABLE_NAME, null, generarContentValues(usuario,  password, nombre,  apellido1, apellido2,  email ));
		
	}
	
	public void borrarUsuario (String usuario){
		
		db.delete(TABLE_NAME, CN_USUARIO + "=?", new String[]{usuario});
	}
	
	public void modificarUsuario(String usuario, String nuevacontrasenia, String nuevonombre, String nuevoapellido1, String nuevoapellido2, String nuevoemail){
		db.update(TABLE_NAME, generarContentValues(usuario, nuevacontrasenia,nuevonombre,nuevoapellido1, nuevoapellido2, nuevoemail), CN_USUARIO + "=?" , new String []{usuario});
	}
	
	
	
	public Cursor cargarCursorUsuarios(){
		
		String[] columnas = new String[]{CN_USUARIO,CN_PASS,CN_NAME, CN_APE1, CN_APE2, CN_EMAIL};
		return db.query(TABLE_NAME, columnas, null, null,null,null,null);
		
	}
	
	public Cursor buscarUsuario(String usuario, String password) {
		
		return db.rawQuery("SELECT * FROM usuarios WHERE usuario='"+usuario+"' AND contrasenia='"+password+"' ;",null);
	}

	public Cursor buscarUsuarioR(String usuario) {
		
		return db.rawQuery("SELECT * FROM usuarios WHERE usuario='"+usuario+"' ;",null);
	}
}
