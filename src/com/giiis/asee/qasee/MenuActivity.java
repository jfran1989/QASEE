package com.giiis.asee.qasee;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.ListActivity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MenuActivity extends ListActivity {

	
    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        //Almacenamos los recursos "string" en un array
        String[] aplicaciones = getResources().getStringArray(R.array.aplicaciones);
        getActionBar().setDisplayHomeAsUpEnabled(true);
     
        //Asociamos el array de recursos a un ListAdapter
        this.setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_menu, R.id.etiqueta, aplicaciones));
         
        ListView lv = getListView();

        //Nos ponemos a escuchar por si se selecciona algún elemento del ListView
        lv.setOnItemClickListener (new OnItemClickListener()
        {
              public void onItemClick(AdapterView<?> parent, View view, int position, long id)
              {
            	  //Elemento seleccionado
		          String aplicacion = ((TextView) view).getText().toString();
		          Intent i = new Intent(getApplicationContext(), AppSelected.class);
		          i.putExtra("aplicacion", aplicacion);
		          startActivity(i);
		         
              }
        });
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
    
  
}
