package com.giiis.asee.qasee;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class FragmentCompartir extends Fragment{
	private final static String KEY_REG_TEXT = "texto";
	private ImageButton buttontwitter;
	private ImageButton buttonfacebook;
	private ImageButton buttongoogle;


    public static FragmentCompartir newInstance(String text) {
    	FragmentCompartir frag = new FragmentCompartir();
         
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
        View rootView = inflater.inflate(R.layout.fragment_compartir, container,
                false);
        // Creamos instancia del TextView.
        TextView tvText =  (TextView)rootView.findViewById(R.id.tvText);
        buttontwitter = (ImageButton) rootView.findViewById(R.id.imageButtontwitter);
        buttonfacebook = (ImageButton) rootView.findViewById(R.id.imageButtonfacebook);
        buttongoogle = (ImageButton) rootView.findViewById(R.id.imageButtongoogle);


        buttontwitter.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				String link = "http://www.twitter.com";
				Intent intent = null;
				intent = new Intent(intent.ACTION_VIEW,Uri.parse(link));
				startActivity(intent);
			}
    });
      
        
        buttonfacebook.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				String link = "http://www.twitter.com";
				Intent intent = null;
				intent = new Intent(intent.ACTION_VIEW,Uri.parse(link));
				startActivity(intent);
			}
    });
        
        
        buttongoogle.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				String link = "http://www.twitter.com";
				Intent intent = null;
				intent = new Intent(intent.ACTION_VIEW,Uri.parse(link));
				startActivity(intent);
			}
    });

        // Recogemos el texto que guardamos al crear el Fragment.
        String text = getArguments().getString(KEY_REG_TEXT);
        /*TODO: Recoger Datos Usuario */
        // Mostramos el texto en el TextView.
        tvText.setText(text);
  
             
        // Devolvemos la vista para que se muestre en pantalla.
        return rootView;
    }
}
