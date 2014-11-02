package com.giiis.asee.qasee;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DataBaseManagerQ {
public static final String TABLE_NAME = "preguntas";
	
	public static final String CN_ID = "_id";
	public static final String CN_PREGUNTA = "pregunta";
	public static final String CN_NIVEL = "nivel";
	public static final String CN_TIPO = "tipo";
	public static final String CN_OP1 = "opcion1";
	public static final String CN_OP2 = "opcion2";
	public static final String CN_OP3 = "opcion3";
	public static final String CN_OP4 = "opcion4";
	public static final String CN_OPCORRECTA = "correcta";

	
	
	public static final String CREATE_TABLE = "create table " + TABLE_NAME+ " ("
			+ CN_ID + " integer primary key autoincrement,"
			+ CN_PREGUNTA + " text not null,"
			+ CN_NIVEL + " integer not null,"
			+ CN_TIPO + " text not null,"
			+ CN_OP1 + " text not null,"
			+ CN_OP2 + " text not null,"
			+ CN_OP3 + " text not null,"
			+ CN_OP4 + " text not null,"
			+ CN_OPCORRECTA + " integer not null);";
	
	
	private DbHelperQ helper;
	private SQLiteDatabase db;
	public DataBaseManagerQ ( Context context){
		
		helper = new DbHelperQ(context);
        db = helper.getWritableDatabase();
	}
	
	
	private ContentValues generarContentValues(String pregunta, Integer nivel, String tipo, String op1, String op2,String op3,String op4, Integer correcta ){
		ContentValues valores = new ContentValues();
		valores.put(CN_PREGUNTA.toUpperCase(), pregunta);
		valores.put(CN_NIVEL, nivel);
		valores.put(CN_TIPO.toUpperCase(), tipo);
		valores.put(CN_OP1.toUpperCase(), op1);
		valores.put(CN_OP2.toUpperCase(), op2);
		valores.put(CN_OP3.toUpperCase(),op3);
		valores.put(CN_OP4.toUpperCase(),op4);
		valores.put(CN_OPCORRECTA,correcta);
		return valores;
		
		
	}
	public void insertarPregunta (String pregunta, Integer nivel, String tipo, String op1, String op2,String op3,String op4, Integer correcta ){
		
		db.insert(TABLE_NAME, null, generarContentValues(pregunta,nivel,tipo,op1,op2,op3,op4,correcta ));
		
	}
	
	public void borrarPregunta (String pregunta){
		
		db.delete(TABLE_NAME, CN_PREGUNTA + "=?", new String[]{pregunta});
	}
	
	public void modificarPregunta(String pregunta, Integer nivel, String tipo, String op1, String op2,String op3,String op4, Integer correcta ){
		db.update(TABLE_NAME, generarContentValues(pregunta,nivel,tipo,op1,op2,op3,op4,correcta ), CN_PREGUNTA + "=?" , new String []{pregunta});
	}
	
	
	
	public Cursor buscarPregunta(String pregunta) {
		
		return db.rawQuery("SELECT * FROM preguntas WHERE pregunta='"+pregunta+"' ;",null);
	}


	
	public Cursor cargarPreguntaAleatoria(String tipo, int nivel){
		return db.rawQuery("SELECT * FROM preguntas WHERE tipo='"+tipo+"' AND nivel='"+nivel+"' ORDER BY RANDOM() LIMIT 1 ;",null);
		
	}
}
