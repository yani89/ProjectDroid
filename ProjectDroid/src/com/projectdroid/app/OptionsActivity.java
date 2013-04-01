package com.projectdroid.app;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

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
	
	/* soap */
//	private static String SOAP_ACTION1 = "DefaultNamespace";
//	private static String NAMESPACE = "http://webservice.javapapers.com/";
//	private static String METHOD_NAME1="HelloWorld";
//	private static String URL = "http://localhost:8080/SOAPHelloWorld/HelloWorld?wsdl";
	
	private static String SOAP_ACTION1 = "http://tempuri.org/FahrenheitToCelsius";

    private static String SOAP_ACTION2 = "http://tempuri.org/CelsiusToFahrenheit";

    private static String NAMESPACE = "http://tempuri.org/";

    private static String METHOD_NAME1 = "FahrenheitToCelsius";

    private static String METHOD_NAME2 = "CelsiusToFahrenheit";

    private static String URL = "http://www.w3schools.com/webservices/tempconvert.asmx?WSDL";
	
	
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
				SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME1);       

                

                //Use this to add parameters

                request.addProperty("Fahrenheit",edittext.getText().toString());

               

                //Declare the version of the SOAP request

                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

               

                envelope.setOutputSoapObject(request);

                envelope.dotNet = true;
				 try {

                     HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

                    

                     //this is the actual part that will call the webservice

                     androidHttpTransport.call(SOAP_ACTION1, envelope);

                    

                     // Get the SoapResult from the envelope body.

                     SoapObject result = (SoapObject)envelope.bodyIn;



                     if(result != null)

                     {

                           //Get the first property and change the label text

                           edittext.setText(result.getProperty(0).toString());

                     }

                     else

                     {

                           Toast.makeText(getApplicationContext(), "No Response",Toast.LENGTH_LONG).show();

                     }

               } catch (Exception e) {

                     e.printStackTrace();

               }
				

				Toast.makeText(OptionsActivity.this,
				"\nSpinner 1: " + String.valueOf(spinner1.getSelectedItem())+ 
				"\nSpinner 1: " + String.valueOf(edittext.getText()), Toast.LENGTH_SHORT).show();
			}
		});
	}

}