package com.projectdroid.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends Activity implements OnClickListener{
	Button button1;
	Button button2;
	Button button3;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//load activity layout
		setContentView(R.layout.activity_main);

 	}

	public void Message(String Msg){
		 Toast.makeText(HomeActivity.this, Msg.toString(), Toast.LENGTH_SHORT).show();
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		//call the base class to include system menus 
		super.onCreateOptionsMenu(menu);
		

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
