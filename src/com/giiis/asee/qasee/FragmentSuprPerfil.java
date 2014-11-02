package com.giiis.asee.qasee;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentSuprPerfil extends Fragment{
	
	  private final static String KEY_REG_TEXT = "texto";
	   
	    public Button bborrar;
	
	    
	    public static FragmentSuprPerfil newInstance(String text) {
	    	FragmentSuprPerfil frag = new FragmentSuprPerfil();
	         
	        Bundle args = frag.getArguments();
	        if(args == null)
	            args = new Bundle();
	         
	        args.putString(KEY_REG_TEXT, text);
	        frag.setArguments(args);
	         
	        return frag;
	    }

	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	        // Inflamos la Vista que se debe mostrar en pantalla.
	        View rootView = inflater.inflate(R.layout.fragment_canceperfil, container,
	                false);
	        // Creamos instancia del TextView.
	        TextView tvText =  (TextView)rootView.findViewById(R.id.tvText);
	        final TextView BorrarC =  (TextView)rootView.findViewById(R.id.editTextVSPerfil);
	        Button bborrar = (Button)rootView.findViewById(R.id.buttonBorrar);
	        // Recogemos el texto que guardamos al crear el Fragment.
	        String text = getArguments().getString(KEY_REG_TEXT);
	        /*TODO: Recoger Datos Usuario */
	        // Mostramos el texto en el TextView.
	        tvText.setText(text);
	       bborrar.setOnClickListener(new Button.OnClickListener() {
				public void onClick(View v) {
				/*TODO: Borrar Usuarios */
					if(BorrarC.getText().equals("Borrar")){
						
					}
					else{
						
					}
				}
	    });
	             
	        // Devolvemos la vista para que se muestre en pantalla.
	        return rootView;
	    }

}
