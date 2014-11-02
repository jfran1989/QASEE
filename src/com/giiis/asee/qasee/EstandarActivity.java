package com.giiis.asee.qasee;

import java.lang.reflect.Field;
import java.util.TimerTask;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class EstandarActivity extends ActionBarActivity {

	private TextView textViewPregunta;
	private TextView textViewNivel;
	private Button buttonA;
	private Button buttonB;
	private Button buttonC;
	private Button buttonD;
	private int correcta;
	private Integer nivel;
	private boolean fail = false;
	DataBaseManagerQ manager;
	MediaPlayer mediaPlayer;

	String aplicacion;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_estandar);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		 Intent i = getIntent();
	        aplicacion = i.getStringExtra("aplicacion");
	        if (aplicacion.equals("ASEE")){
	        	int id = R.drawable.aseelogo; 
	        	((ImageView)findViewById(R.id.imageViewEstandar)).setImageResource(id);
	        	
	        }
	        if (aplicacion.equals("PI")){
	        	int id = R.drawable.pilogo; 
	        	((ImageView)findViewById(R.id.imageViewEstandar)).setImageResource(id);
	        	
	        }
	        if (aplicacion.equals("EDI")){
	        	int id = R.drawable.edilogo; 
	        	((ImageView)findViewById(R.id.imageViewEstandar)).setImageResource(id);
	        	
	        }
		try {
	        this.getOverflowMenu();
			iniciarComponentes();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void iniciarComponentes() throws InterruptedException{
		textViewPregunta = (TextView) findViewById(R.id.textViewCPregunta);
		textViewNivel = (TextView) findViewById(R.id.textViewNivel);
		buttonA = (Button) findViewById(R.id.buttonA);
		buttonB = (Button) findViewById(R.id.buttonB);
		buttonC = (Button) findViewById(R.id.buttonC);
		buttonD = (Button) findViewById(R.id.buttonD);
	    mediaPlayer = MediaPlayer.create(this,R.raw.ambient_music);
	    mediaPlayer.setLooping(true);
	    mediaPlayer.setVolume(100,100);
        manager = new DataBaseManagerQ(this);
       /* manager.insertarPregunta("En C++ �A qu� le llamamos funci�n?", 1,"EDI","Secci�n del programa que realiza una tarea", "Resoluci�n de un problema", "Comando de preprocesador", "Secuencia de escape",  1);
        
        manager.insertarPregunta("En la estructura de programas de C++ �Qu� tipo de programaci�n usamos?", 2,"EDI" , "Binaria", "Modular", "Anticuada", "Todas las anteriores", 2);
        manager.insertarPregunta("�De qu� se encarga la funci�n principal?", 3, "EDI", "Ejecutar las otras funciones", "Es la funci�n controladora", "No puede haber m�s de una funci�n", "Todas las anteriores", 4);
        manager.insertarPregunta("�C�mo creamos una funci�n?", 4, "EDI", " iterate(nombre);", "crea_funci�n_con_nombre", "tipodedato nombre parametros;", "56_dofuction;", 3);
        manager.insertarPregunta("�Qu� es un comando de preprocesador?", 5, "EDI", "El comando que compila el programa", "Un comando en binario", "Un tipo de dato primitivo", "Se ejecuta y realiza una acci�n precompilada", 4);
        manager.insertarPregunta("�Para que usamos el comando #include?", 6, "EDI", "Para salir", "Para incluir las librer�as", "Para mostrar una vista previa", "Para simular un enter", 2);
        manager.insertarPregunta("�Para qu� incluimos la librer�a <iostream>?", 7, "EDI", " Para usar un flujo de entrada y salida", "Para ver en negritas el cout", "Para incluir las librer�as", "Para salir", 1);
        manager.insertarPregunta(" Un ejemplo de como usar el cout es:", 8, "EDI", "cout<<Hola mundo\n", "cout>>numero;", " cout = 10;", "cout(pause);", 1);
        manager.insertarPregunta("�Qu� es una cadena?", 9, "EDI", "Un conjunto de signos <<", "Cuando ponemos ;", "Una combinaci�n de letras, n�meros o caracteres especiales", "Un numero binario muy largo", 3);
        manager.insertarPregunta("Es un dato de tipo Char:", 10, "EDI", "26", "'b'", "1.5608", "True/False", 2);

        manager.insertarPregunta("Prueba ASEE", 10, "ASEE", "FUNCIONA", "EN", "EDI", "SOLO", 3);

        manager.insertarPregunta("Prueba ASEE", 10, "PI", "FUNCIONA", "EN", "EDI", "SOLO", 3);
*/
		nivel = 1;
		textViewNivel.setText("Nivel: "+nivel.toString());
		//textViewNota.setText("Nota: "+nota.toString()+" de 10");
		//cronometro.setBase(0);
		cargarPregunta(nivel);
		jugarEstandar();
	}
	
	
	private void jugarEstandar() throws InterruptedException {
		// TODO Auto-generated method stub CARGAR AQUI LAS PREGUNTAS
		//mediaPlayer.start();
		textViewNivel.setText("Nivel: "+nivel.toString());
		//textViewNota.setText("Nota: "+nota.toString()+"\ de 10");
			buttonA.setOnClickListener(new Button.OnClickListener() {
				public void onClick(View v) {
					comprobarCorrecta(fail,1);
					if(nivel <=10 && !fail)
						try {
							jugarEstandar();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

				}
			});
			buttonB.setOnClickListener(new Button.OnClickListener() {
				public void onClick(View v) {
					comprobarCorrecta(fail,2);
					if(nivel <=10 && !fail)
						try {
							jugarEstandar();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

				}
			});
			buttonC.setOnClickListener(new Button.OnClickListener() {
				public void onClick(View v) {
					comprobarCorrecta(fail,3);
					if(nivel <=10 && !fail)
						try {
							jugarEstandar();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

				}
			});
			buttonD.setOnClickListener(new Button.OnClickListener() {
				public void onClick(View v) {
					comprobarCorrecta(fail,4);
					if(nivel <=10 && !fail)
						try {
							jugarEstandar();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

				}
			});
			
		if(nivel == 10){
		    mediaPlayer = MediaPlayer.create(this,R.raw.music_correct);
		   // mediaPlayer.start();
			AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
			alertDialog.setTitle("Felicidades");
			alertDialog.setMessage("�Has aprobado el Examen de la Asignatura!");
			alertDialog.show();
			alertDialog.setCancelable(false);  
			alertDialog.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {  
	            public void onClick(DialogInterface dialogo1, int id) {  
	            	Intent i = new Intent(getApplicationContext(), MenuActivity.class);
	  			  startActivity(i);
	  			  finish(); 
	            }  
	        }); 
			alertDialog.show();
			 
			
		}
	}

	
	
	private void cargarPregunta(int nivel){
		Cursor c = manager.cargarPreguntaAleatoria(aplicacion, nivel);
		try{
			
			if(c.moveToFirst()) {
				textViewPregunta.setText(c.getString(1));
				buttonA.setText("A."+c.getString(4));
				buttonB.setText("B."+c.getString(5));
				buttonC.setText("C."+c.getString(6));
				buttonD.setText("D."+c.getString(7));
				correcta = c.getInt(8);
				
			}
			
		} catch(Exception e){
			Log.e("Error","Error al leer la base de datos");
		}
		
		
		
		
		
		
	}
	private void comprobarCorrecta(boolean fail, int opcion){
		/*TODO:  Ver cual de las preguntas es correcta y devolver el fail*/

		if(opcion == correcta){
			nivel++;
			cargarPregunta(nivel);

		}
		else{
			fail = true;
			AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
			mediaPlayer = MediaPlayer.create(this,R.raw.music_incorrect);
			//mediaPlayer.start();
			alertDialog.setTitle("Ohh Fallaste");
			alertDialog.setMessage("Tu nota final es un : "+nivel);
			alertDialog.show();
			alertDialog.setCancelable(false);  
			alertDialog.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {  
	            public void onClick(DialogInterface dialogo1, int id) {  
	            	Intent i = new Intent(getApplicationContext(), MenuActivity.class);
	  			  startActivity(i);
	  			  finish(); 
	            }  
	        }); 
			alertDialog.show();
			
		}
	}
	@Override
	
	 public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.app_selected, menu);
	        return true;
	    }
	    
	    public boolean onOptionsItemSelected(MenuItem item) {
	        switch (item.getItemId()) {
	            case R.id.menu_sound_off:
	            	 Toast.makeText(this, "Sonido Off", Toast.LENGTH_SHORT).show();;
	            	 mediaPlayer.setVolume(0, 0);
	            	 return true;
	            case R.id.menu_sound_on:
	            	 Toast.makeText(this, "Sonido ON", Toast.LENGTH_SHORT).show();;
	            	 mediaPlayer.setVolume(100, 100);
	            	// mediaPlayer.start();	            	 
	            	 return true;
	            case R.id.menu_user:
	            	 Toast.makeText(this, "Tu Perfil", Toast.LENGTH_SHORT).show();; 
	            	 Intent in = new Intent(getApplicationContext(), PerfilActivity.class);
	 				 startActivity(in);
	 		       	 return true;
	            case R.id.menu_settings:
	            	Intent inte = new Intent(getApplicationContext(), OpcionesActivity.class);
	 				 startActivity(inte);Toast.makeText(this, "Opciones", Toast.LENGTH_SHORT).show();; return true;
	            case android.R.id.home: // ID del boton
	                finish(); 
	            default:
	                return super.onOptionsItemSelected(item);
	        }
	    }
	 private void getOverflowMenu() {

	        try {
	           ViewConfiguration config = ViewConfiguration.get(this);
	           Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
	           if(menuKeyField != null) {
	               menuKeyField.setAccessible(true);
	               menuKeyField.setBoolean(config, false);
	           }
	       } catch (Exception e) {
	           e.printStackTrace();
	       }
	   }
}
