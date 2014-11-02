package com.giiis.asee.qasee;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class PerfilActivity extends FragmentActivity implements ActionBar.TabListener {
	private ViewPager vPager;
	private TabsAdapter tAdapter;
	private ActionBar aBar;
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_perfil);
	    getActionBar().setDisplayHomeAsUpEnabled(true);
	         
	    vPager = (ViewPager)findViewById(R.id.pager);
	    tAdapter = new TabsAdapter(getSupportFragmentManager());
	    aBar = getActionBar();
	         
	    vPager.setAdapter(tAdapter);
	    aBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	    
	    for (String title : getResources().getStringArray(R.array.tabs)) {
	        aBar.addTab(aBar.newTab().setText(title).setTabListener(this));
	    }
	    
	    
	    
	 // Habilitar swipe entre tabs.
	    vPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
	     
	        @Override
	        public void onPageSelected(int position) {
	            aBar.setSelectedNavigationItem(position);
	        }
	     
	        @Override
	        public void onPageScrolled(int arg0, float arg1, int arg2) {
	        }
	     
	        @Override
	        public void onPageScrollStateChanged(int arg0) {
	        }
	    });
	}
	
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		vPager.setCurrentItem(tab.getPosition());
		
	}

	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	public void onTabReselected(Tab tab, FragmentTransaction ft) {
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
	
	public class TabsAdapter extends FragmentPagerAdapter {
		 
	    public TabsAdapter(android.support.v4.app.FragmentManager fm) {
	        super(fm);
	    }
	 
	    @Override
	    public Fragment getItem(int index) {
	        if(index < 4) {
	            switch(index) {
	            case 0:
	                return FragmentPerfil.newInstance("Ver Usuario");
	            case 1:
	                return FragmentEditarPerfil.newInstance("Editar Usuario");
	            case 2:
	                return FragmentSuprPerfil.newInstance("Borrar Usuario");

	            }
	        }
	        return null;
	    }
	 
	    @Override
	    public int getCount() {
	        return 3;
	    }
	 
	}

}