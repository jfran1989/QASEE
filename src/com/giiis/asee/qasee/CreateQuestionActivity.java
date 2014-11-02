package com.giiis.asee.qasee;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.appcompat.R.string;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class CreateQuestionActivity extends ActionBarActivity {

	private final static String[] tipopreguntas = { "ASEE", "PI", "EDI",
        "General" };
	public EditText editTextCPregunta;
	public EditText editTextCO1;
	public EditText editTextCO2;
	public EditText editTextCO3;
	public EditText editTextCO4;
	private EditText editTextCNivel;
	private EditText editTextCCorrecta;
	private Spinner  spinner;
	private EditText editTextCTP;
	public Button buttonCreaPregunta;
	DataBaseManagerQ manager;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_question);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		
		inicializarComponentes();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create_question, menu);
		return true;
	}

	public void inicializarComponentes(){
	
		editTextCTP = (EditText) findViewById(R.id.editTextCTP);
		editTextCPregunta = (EditText) findViewById(R.id.editTextCPregunta);
		editTextCO1 = (EditText) findViewById(R.id.editTextCO1);
		editTextCO2 = (EditText) findViewById(R.id.editTextCO2);
		editTextCO3 = (EditText) findViewById(R.id.editTextCO3);
		editTextCO4 = (EditText) findViewById(R.id.editTextCO4);
		buttonCreaPregunta = (Button) findViewById(R.id.buttonCreaPregunta);
		editTextCNivel = (EditText) findViewById(R.id.editTextCNivel);
		editTextCCorrecta = (EditText)findViewById(R.id.editTextCCorrecta);
        manager = new DataBaseManagerQ(this);

		
		buttonCreaPregunta.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				creaPregunta();
				
			}
		});
		
	}
	
	
	void creaPregunta(){
		
		Integer ni = Integer.parseInt(editTextCNivel.getText().toString());
		Integer cc = Integer.parseInt(editTextCCorrecta.getText().toString());
		String a = editTextCTP.getText().toString();
		String A = a.toUpperCase();
		if(A.equals("ASEE") ||A.equals("PI") || A.equals("EDI")){
		manager.insertarPregunta(editTextCPregunta.getText().toString(), ni,a , editTextCO1.getText().toString(), editTextCO2.getText().toString(), editTextCO3.getText().toString(), editTextCO4.getText().toString(), cc);
	
		  Intent i = new Intent(getApplicationContext(), AppSelected.class);
		  startActivity(i);
		}else{
			AlertDialog alertDialog = new AlertDialog.Builder(this).create();
 			alertDialog.setTitle("Error");
 			alertDialog.setMessage("Tipo inexistente");
 			alertDialog.show();
			
		}
	}
	public void onItemSelected(AdapterView<?> parent, View view,
			int position, long id) {
		// TODO Auto-generated method stub
    	parent.getItemAtPosition(position);

	}
	
	public class SpinnerActivity extends Activity implements OnItemSelectedListener {

	    public void onNothingSelected(AdapterView<?> parent, View view, 
	            int pos, long id) {
	        // Another interface callback
	    	parent.getItemAtPosition(pos);
	    }

		@Override
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {
			// TODO Auto-generated method stub
	    	parent.getItemAtPosition(position);

		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
			// TODO Auto-generated method stub
			
		}
		
		public boolean onOptionsItemSelected(MenuItem item) {
		    switch (item.getItemId()) {
		    case android.R.id.home: // ID del boton
		        finish(); // con finish terminamos el activity actual, con lo que volvemos
		                  // al activity anterior (si el anterior no ha sido cerrado)
		        return true;
		    }
		    return super.onOptionsItemSelected(item);
		}
	};
}
