package com.giiis.asee.qasee;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentEditarPerfil  extends Fragment{
	 private final static String KEY_REG_TEXT = "texto";
	    public static String Usuario;
	    public static String Nombre;
	    public static String Ape1;
	    public static String Ape2;
	    public static String Email;
	    public Button buttonConfirmarEdit;
	 
	    public static FragmentEditarPerfil newInstance(String text) {
	    	FragmentEditarPerfil frag = new FragmentEditarPerfil();
	         
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
	        View rootView = inflater.inflate(R.layout.fragment_editperfil, container,
	                false);
	        // Creamos instancia del TextView.
	        TextView tvText =  (TextView)rootView.findViewById(R.id.tvText);
	        TextView textViewVPerfilU =  (TextView)rootView.findViewById(R.id.textViewVEPerfilU);
	        TextView editTextVPerfilN =  (TextView)rootView.findViewById(R.id.editTextVEPerfilN);
	        TextView editTextVPerfilA1 =  (TextView)rootView.findViewById(R.id.editTextVEPerfilA1);
	        TextView editTextVPerfilA2 =  (TextView)rootView.findViewById(R.id.editTextVEPerfilA2);
	        TextView editTextVPerfilEM =  (TextView)rootView.findViewById(R.id.editTextVEPerfilEM);
	        Button buttonConfirmarEdit = (Button)rootView.findViewById(R.id.buttonConfirmaEdit);
	        // Recogemos el texto que guardamos al crear el Fragment.
	        String text = getArguments().getString(KEY_REG_TEXT);
	        /*TODO: Recoger Datos Usuario */
	        // Mostramos el texto en el TextView.
	        tvText.setText(text);
	       
	        // Devolvemos la vista para que se muestre en pantalla.
	        return rootView;
	    }
}
