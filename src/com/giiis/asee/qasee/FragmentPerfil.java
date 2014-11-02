package com.giiis.asee.qasee;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentPerfil extends Fragment {
	    private final static String KEY_REG_TEXT = "texto";
	    public static String Usuario;
	    public static String Nombre;
	    public static String Ape1;
	    public static String Ape2;
	    public static String Email;
	 
	    public static FragmentPerfil newInstance(String text) {
	    	FragmentPerfil frag = new FragmentPerfil();
	         
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
	        View rootView = inflater.inflate(R.layout.frament_perfil, container,
	                false);
	        // Creamos instancia del TextView.
	        TextView tvText =  (TextView)rootView.findViewById(R.id.tvText);
	        TextView textViewVPerfilU =  (TextView)rootView.findViewById(R.id.textViewVPerfilU);
	        TextView textViewVPerfilN =  (TextView)rootView.findViewById(R.id.TextViewVPerfilN);
	        TextView textViewVPerfilA1 =  (TextView)rootView.findViewById(R.id.TextViewVPerfilA1);
	        TextView textViewVPerfilA2 =  (TextView)rootView.findViewById(R.id.textViewVPerfilA2);
	        TextView textViewVPerfilEM =  (TextView)rootView.findViewById(R.id.textViewVPerfilEM);

	        // Recogemos el texto que guardamos al crear el Fragment.
	        String text = getArguments().getString(KEY_REG_TEXT);
	        /*TODO: Recoger Datos Usuario */
	        // Mostramos el texto en el TextView.
	        tvText.setText(text);
	        textViewVPerfilU.setText("Usuario Ejemplo");
	        textViewVPerfilN.setText("Nombre Ejemplo");
	        textViewVPerfilA1.setText("Primer Apellido Ejemplo");
	        textViewVPerfilA2.setText("Segundo Apellido Ejemplo");
	        textViewVPerfilEM.setText("Email Ejemplo");
	             
	        // Devolvemos la vista para que se muestre en pantalla.
	        return rootView;
	    }
}
