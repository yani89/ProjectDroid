package com.projectdroid.app;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.app.Activity;
import android.os.AsyncTask;
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
	private EditText edittext,edittext2,edittext3;
	private TextView textView;
	
	private static final String MethodName = "hello";
	private static final String Namespace = "http://ya/";
	private static final String url = "http://192.168.1.114:8080/WebService/Test?wsdl";
	
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settinglayout);
        
        //addListenerOnSpineerItemSelection();
        //addListenerOnButton();
        
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		
		textView = (TextView) findViewById(R.id.textView3);

		btnSubmit = (Button) findViewById(R.id.btnSubmit);
		
        
   }

	public class actionSoap extends AsyncTask<Void, Void,Void>
	{
		
		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			SoapObject soapOb = new SoapObject(OptionsActivity.Namespace, OptionsActivity.MethodName);
			SoapSerializationEnvelope soapSerial = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			soapSerial.setOutputSoapObject(soapOb);
			
			try
			{
				HttpTransportSE httpTran = new HttpTransportSE(OptionsActivity.url);
				httpTran.debug = true;
				httpTran.call(OptionsActivity.Namespace+ OptionsActivity.MethodName, soapSerial);
				Object objectResult = (Object)soapSerial.getResponse();
				textView.setText(objectResult.toString());
				return null;
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			return null;
		}
		
		
	}
	

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