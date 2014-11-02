package com.giiis.asee.qasee;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MultijugadorActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_multijugador);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.multijugador, menu);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		return true;
	}

	@Override
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
         case android.R.id.home: // ID del boton
             finish(); 
         default:
             return super.onOptionsItemSelected(item);
     }
 }
}
