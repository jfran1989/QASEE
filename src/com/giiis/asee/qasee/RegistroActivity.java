package com.giiis.asee.qasee;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends ActionBarActivity {

	private EditText editTextNUsuario;
	private EditText editTextNPass;
	private EditText editTextNNombre;
	private EditText editTextNApellido1;
	private EditText editTextNApellido2;
	private EditText editTextNEmail;
	private Button buttonNRegistrar;
	DataBaseManager manager;


	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registro);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		inicializarComponentes();
        manager = new DataBaseManager(this);
        }

	public void inicializarComponentes(){
		editTextNUsuario = (EditText) findViewById(R.id.editTextNUsuario);
		editTextNPass = (EditText) findViewById(R.id.editTextNPass);
		editTextNNombre = (EditText) findViewById(R.id.editTextNNombre);
		editTextNApellido1 = (EditText) findViewById(R.id.editTextNApellido1);
		editTextNApellido2 = (EditText) findViewById(R.id.editTextNApelido2);
		editTextNEmail = (EditText) findViewById(R.id.editTextNEmail);
		buttonNRegistrar = (Button) findViewById(R.id.buttonNRegistrar);
		buttonNRegistrar.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				registrar();
			}
		});
		
	}
	
	public void registrar(){
		Cursor c = manager.buscarUsuarioR(editTextNUsuario.getText().toString());
		if(c.getCount()==0){
		manager.insertarUsuario(editTextNUsuario.getText().toString(), editTextNPass.getText().toString(), editTextNNombre.getText().toString(),
				editTextNApellido1.getText().toString(),editTextNApellido2.getText().toString(), editTextNEmail.getText().toString());
				AlertDialog alertDialog = new AlertDialog.Builder(this).create();
				alertDialog.setTitle("Bienvenido");
				alertDialog.setMessage("Bienvenido a QASE");
				alertDialog.show();
				Intent i = new Intent(getApplicationContext(), QASEEActivity.class);
		        startActivity(i);
		        finish();
		}
		else{
			AlertDialog alertDialog = new AlertDialog.Builder(this).create();
 			alertDialog.setTitle("Error");
 			alertDialog.setMessage("Usuario o contraseña existentes");
 			alertDialog.show();
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.registro, menu);
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
