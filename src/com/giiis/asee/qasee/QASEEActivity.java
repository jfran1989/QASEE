package com.giiis.asee.qasee;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class QASEEActivity extends ActionBarActivity {
	private EditText editTextUsuario;
	private EditText editTextPassword;
	private Button buttonEntrar;
	private Button buttonRegistrar;
	DataBaseManager manager;
	MediaPlayer mediaPlayer;
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qasee);
        manager = new DataBaseManager(this);
        iniciarComponentes();
    }

    public void iniciarComponentes(){
    	editTextUsuario = (EditText) findViewById(R.id.editTextUsuario);
    	editTextPassword = (EditText) findViewById(R.id.editTextPassword);
    	buttonEntrar = (Button) findViewById(R.id.buttonEntrar);
    	buttonRegistrar = (Button) findViewById(R.id.buttonRegistrar);
    	mediaPlayer = MediaPlayer.create(this,R.raw.theme_music);
        mediaPlayer.setVolume(100,100);
    	//mediaPlayer.start();
    	buttonEntrar.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Entrar();
				
			}
		});
    	buttonRegistrar.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(), RegistroActivity.class);
		          startActivity(i);
			}
		});

    }
    
    public void Entrar(){
    	 Cursor c;
    	 String usuario = (editTextUsuario.getText()).toString() ;
    	 String pass = (editTextPassword.getText()).toString();
    	 c = manager.buscarUsuario(usuario, pass);
    	 if(c.getCount()>0){
    		 Intent i = new Intent(getApplicationContext(), MenuActivity.class);
    		 startActivity(i);
    	 }
    	 else{
    		AlertDialog alertDialog = new AlertDialog.Builder(this).create();
 			alertDialog.setTitle("Error");
 			alertDialog.setMessage("Usuario o contraseña inexistentes");
 			alertDialog.show();
    	 }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.qasee, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
