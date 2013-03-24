package com.projectdroid.app;


import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;


public class MainActivity extends TabActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 super.onCreate(savedInstanceState);
	     setContentView(R.layout.tabmenu);
	     TabHost tabHost = getTabHost();      
	       
	     tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("Home").setContent(new Intent(this,HomeActivity.class)));
	       
	     tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("Setting").setContent(new Intent(this, OptionsActivity.class)));
	     tabHost.setCurrentTab(1); 
		//load activity layout
		//setContentView(R.layout.activity_main);

 	}

	

}
