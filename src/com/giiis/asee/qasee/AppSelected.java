package com.giiis.asee.qasee;
import java.lang.reflect.Field;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
 
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class AppSelected extends Activity
{
	private Button buttonEstandar;
	private Button buttonContra;
	private Button buttonMulti;
	
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        this.setContentView(R.layout.activity_app_selected);
        this.getOverflowMenu();
                 
        Intent i = getIntent();
        String aplicacion = i.getStringExtra("aplicacion");
        if (aplicacion.equals("ASEE")){
        	int id = R.drawable.aseelogo; 
        	((ImageView)findViewById(R.id.imageViewapp)).setImageResource(id);
        	
        }
        if (aplicacion.equals("PI")){
        	int id = R.drawable.pilogo; 
        	((ImageView)findViewById(R.id.imageViewapp)).setImageResource(id);
        	
        }
        if (aplicacion.equals("EDI")){
        	int id = R.drawable.edilogo; 
        	((ImageView)findViewById(R.id.imageViewapp)).setImageResource(id);
        	
        }
        if (aplicacion.equals("Crear Nuevas Preguntas")){
        	Intent ia = new Intent(getApplicationContext(), CreateQuestionActivity.class);
        	startActivity(ia);
        }
        iniciarComponentes(aplicacion);
         
    }
    
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.app_selected, menu);
        return true;
    }
    
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_sound_off:
            	 Toast.makeText(this, "Sonido Off", Toast.LENGTH_SHORT).show();;
            	 return true;
            case R.id.menu_sound_on:
            	 Toast.makeText(this, "Sonido ON", Toast.LENGTH_SHORT).show();;
            	 return true;
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
    
    public void iniciarComponentes(final String aplicacion){
    	
    	buttonEstandar = (Button) findViewById(R.id.button1Estadar);
    	buttonEstandar.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(), EstandarActivity.class);
		        i.putExtra("aplicacion", aplicacion);
				startActivity(i);
				 finish();

			}
		});
    	buttonContra = (Button) findViewById(R.id.buttonContra);
    	buttonContra.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(), ContrarelojActivity.class);
				   i.putExtra("aplicacion", aplicacion);
		          startActivity(i);
		          finish();


			}
		});
    	buttonMulti = (Button) findViewById(R.id.buttonMulti);
    	buttonMulti.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(), MultijugadorActivity.class);
		          startActivity(i);
		          finish();

			}
		});
    	
    	
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
