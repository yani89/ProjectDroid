package com.projectdroid.app;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
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
	
    private static String SOAP_ACTION1 = "http://localhost:8080/SOAPHelloWorld/";
    private static String NAMESPACE = "http://tempuri.org/";
    private static String METHOD_NAME1 = "hello";
    private static String URL = "http://192.168.1.114:8080/SOAPHelloWorld/HelloWorld?wsdl";


	
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settinglayout);
		btnSubmit = (Button) findViewById(R.id.btnSubmit);
		
		edittext2 = (EditText) findViewById(R.id.editText2);
		edittext3 = (EditText) findViewById(R.id.editText3);
		
		btnSubmit.setOnClickListener(new View.OnClickListener()

        {
                  @Override
                  public void onClick(View v)
                  {
                	  	ActionSoapPost me = new ActionSoapPost();
                	  	me.execute();
                  }
                  
        });
		
   }
	
	/*send to string web services
	 * 
	 * 
	 */
	public class ActionSoapPost extends AsyncTask<Void, Void, Void>
	{

		@Override
		protected Void doInBackground(Void... arg0) {
			// TODO Auto-generated method stub
			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME1); 
			request.addProperty("Hello",edittext2.getText().toString());
			
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
			envelope.setOutputSoapObject(request);

            envelope.dotNet = true;
            try {

                HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
                androidHttpTransport.call(SOAP_ACTION1, envelope);
                SoapObject result = (SoapObject)envelope.bodyIn;
                if(result != null)
                {
                	edittext3.setText(result.getProperty(0).toString());
                }
                else
                {
                      Toast.makeText(getApplicationContext(), "No Response",Toast.LENGTH_LONG).show();
                }
          } catch (Exception e) {
                e.printStackTrace();
          }
			return null;
		}
		
		//return null;
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


}