package com.projectdroid.app;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	Button button1;
	Button button2;
	Button button3;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//load activity layout
		setContentView(R.layout.activity_main);
		
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

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
			case R.id.Button1:
				Message("Im Button1");
			case R.id.Button2:
				Message("Im Button2");
			case R.id.Button3:
				Message("Im Button3");
			Default:
				System.err.println("null");
		}
	}

}
