package com.projectdroid.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OptionsActivity extends Activity {
   
	private Spinner spinner1;
	private Button btnSubmit;
	private EditText edittext;
	
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settinglayout);
        
        //addListenerOnSpineerItemSelection();
        addListenerOnButton();
    }

//	private void addListenerOnSpineerItemSelection() {
//		// TODO Auto-generated method stub
//		spinner1 = (Spinner) findViewById(R.id.spinner1);
//		spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
//	}

	public void addListenerOnButton(){
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		edittext = (EditText) findViewById(R.id.editText1);
		btnSubmit = (Button) findViewById(R.id.btnSubmit);
		
		
		
		btnSubmit.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				Toast.makeText(OptionsActivity.this,
				"\nSpinner 1: " + String.valueOf(spinner1.getSelectedItem())+ 
				"\nSpinner 1: " + String.valueOf(edittext.getText()), Toast.LENGTH_SHORT).show();
			}
		});
	}

}