package com.projectdroid.app;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button button1;
	Button button2;
	Button button3;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//load activity layout
		setContentView(R.layout.activity_main);
		
		button1 = (Button)findViewById(R.id.Button1) ;
		button1.setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View v) {
                 Message("I'm button1");
            }
          });
		button2 = (Button)findViewById(R.id.Button2);
		button2.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				Message("I'm button2");
			}
		});
		button3 = (Button)findViewById(R.id.Button3);
		button3.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v){
				Message("I'm button3");
			}
		});
		//activated button controll
 	}

	public void Message(String Msg){
		 Toast.makeText(MainActivity.this, Msg.toString(), Toast.LENGTH_SHORT).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}