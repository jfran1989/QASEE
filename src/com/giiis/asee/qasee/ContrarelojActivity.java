package com.giiis.asee.qasee;

import java.lang.reflect.Field;

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

public class ContrarelojActivity extends ActionBarActivity {

	private TextView textViewPregunta;
	private TextView textViewNivel;
	private Button buttonA;
	private Button buttonB;
	private Button buttonC;
	private Button buttonD;
	private int correcta;
	private Integer nivel;
	private boolean fail = false;
	private Chronometer cronometro;
	private long tiempo;
	DataBaseManagerQ manager;
	MediaPlayer mediaPlayer;


	String aplicacion;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contrareloj);
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
        cronometro = (Chronometer) findViewById(R.id.chronometerestandar);
        tiempo = 0;
        mediaPlayer = MediaPlayer.create(this,R.raw.ambient_music);
	    mediaPlayer.setLooping(true);
	    mediaPlayer.setVolume(100,100);
        manager = new DataBaseManagerQ(this);
		nivel = 1;
		textViewNivel.setText("Nivel: "+nivel.toString());
		cronometro.start();
		cargarPregunta(nivel);
		jugarEstandar();
	}
	
	
	private void jugarEstandar() throws InterruptedException {
		// TODO Auto-generated method stub CARGAR AQUI LAS PREGUNTAS
		mediaPlayer.start();
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
			mediaPlayer.start();
			cronometro.stop();
			AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
			alertDialog.setTitle("Felicidades");
			alertDialog.setMessage("¡Has aprobado el Examen de la Asignatura!\n Tiempo Total:"+tiempo);
			alertDialog.show();
			alertDialog.setCancelable(false);  
			alertDialog.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {  
	            public void onClick(DialogInterface dialogo1, int id) {  
	            	Intent i = new Intent(getApplicationContext(), MenuActivity.class);
	  			  startActivity(i);
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
			tiempo = SystemClock.elapsedRealtime() - cronometro.getBase();
			nivel++;
			cronometro.setBase(SystemClock.elapsedRealtime());
			cargarPregunta(nivel);

		}
		else{
			fail = true;
			AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
			mediaPlayer = MediaPlayer.create(this,R.raw.music_incorrect);
			mediaPlayer.start();
			alertDialog.setTitle("Ohh Fallaste");
			alertDialog.setMessage("Tiempo Total:"+tiempo);
			alertDialog.show();
			alertDialog.setCancelable(false);  
			alertDialog.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {  
	            public void onClick(DialogInterface dialogo1, int id) {  
	            	Intent i = new Intent(getApplicationContext(), MenuActivity.class);
	  			  startActivity(i);
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
            	 mediaPlayer.start();	            	 return true;
            case R.id.menu_user:
            	 Toast.makeText(this, "Tu Perfil", Toast.LENGTH_SHORT).show();; 
            	 Intent in = new Intent(getApplicationContext(), PerfilActivity.class);
 				 startActivity(in);
 		       	 return true;
            case R.id.menu_settings:
            	Intent inte = new Intent(getApplicationContext(), OpcionesActivity.class);
				 startActivity(inte);Toast.makeText(this, "Opciones", Toast.LENGTH_SHORT).show();; return true;
            case android.R.id.home: 
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
