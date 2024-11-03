package it.unisa.di.mp.socketrawprogressbar;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivity extends Activity {
	private final String TAG ="DEBUG";
	private EditText textToSend;
	private TextView textResponse;
	private EditText textIP;
	private EditText textPort;
	private String IP ="10.0.2.2";
	private String PORT = "12345";
	private ProgressBar progressBarDownload;
	
	String server;
	int port; 
	String strToSend;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout);

		//Bind widgets
		textToSend = (EditText) findViewById(R.id.editTextToSend);
		textResponse = (TextView) findViewById(R.id.textViewResponse);
		textIP = (EditText) findViewById(R.id.editTextIP);
		textPort = (EditText) findViewById(R.id.editTextPort);
		textIP.setText(IP);
		textPort.setText(PORT);
		progressBarDownload = (ProgressBar) findViewById(R.id.progressBar);
		
		progressBarDownload.setVisibility(ProgressBar.INVISIBLE);
		
		Log.d(TAG,"onCreate()");
	}
	
	public void sendButtonClicked(View v) {
		server = textIP.getText().toString();
		port = Integer.parseInt(textPort.getText().toString());
		
		strToSend = textToSend.getEditableText().toString();
		String str = "Send button has been clicked.\n" +
					 "Sending: " + strToSend;
		Toast.makeText(getApplicationContext(),str, Toast.LENGTH_LONG).show();
		
		NetworkTask nt = new NetworkTask();
		textResponse.setText("");
		nt.execute();
	}
	
	
	public void clearButtonClicked(View v) {
		textResponse.setText("");
	}
	
	class NetworkTask extends AsyncTask<Integer, Integer, String> {
		
		@Override
		protected void onPreExecute() {
			progressBarDownload.setVisibility(ProgressBar.VISIBLE);
		}
		
		@Override
		protected String doInBackground(Integer...values) {
			Log.d(TAG,"doInBackground");
			String received_data = "";
			Socket socket = null;
						
			//Connect
			try {
				Log.d(TAG, "Connecting to " + server + ", on port " + port);
				InetAddress serverAddr = InetAddress.getByName(server);
				Log.d(TAG, "serverAddr=" + serverAddr);
				socket = new Socket(serverAddr, port);
			} catch (UnknownHostException e) {
				Log.d(TAG, "UnknownHostException");
				e.printStackTrace();
				return null;
			} catch (IOException e) {
				Log.d(TAG, "IOException");
				e.printStackTrace();
				return null;
			} catch (Exception e) {
				Log.d(TAG, "Exception");
				e.printStackTrace();
				return null;
			}
			
			if (socket == null) {
				Log.d(TAG,"The socket is null");
				Toast.makeText(getApplicationContext(), "The socket is null", Toast.LENGTH_LONG).show();
				return null;
			}

			
			//Send data
			try {
	            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
	            out.println(strToSend);
	            Log.d(TAG, "Client sent message:" +strToSend);
	         } catch (UnknownHostException e) {
	        	 e.printStackTrace();
	         } catch (IOException e) {
	        	 e.printStackTrace();         
	         } catch (Exception e) {
	        	 e.printStackTrace();
	         }
			
			//Receive data
			try {
				BufferedReader in =
				        new BufferedReader(
				            new InputStreamReader(socket.getInputStream()));
				//InputStream in = socket.getInputStream();
				Log.d(TAG,"input stream in: "+in);
				
				String line;
				if ((line = in.readLine()) == null) {
					Log.d(TAG,"Errore");
				}
				
				//Check if File not found
				if (line.equalsIgnoreCase("File not found")) {
					Log.d("DEBUG","File not found!!!");
					return line;
				}

				Log.d(TAG,"line:"+line);
				
				int size = Integer.parseInt(line);
				
				int c;
				while ((c = in.read()) > -1) {
					//Log.d(TAG,"c="+c);
			        received_data += (char)c;
			        publishProgress(100*received_data.length()/size);
			    }
								
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();            
			} catch (Exception e) {
				e.printStackTrace();
			}
		       			
			return received_data;
		}
		
		@Override
		protected void onProgressUpdate(Integer... values) {
			Log.d(TAG,"onProgressUpdate(): "+values[0]);
			progressBarDownload.setProgress(values[0]);
		}
		
		@Override
		protected void onPostExecute(String data) {
			Log.d(TAG,"onPostExecute() - data: "+data);
			progressBarDownload.setVisibility(ProgressBar.INVISIBLE);
			progressBarDownload.setProgress(0);
			textResponse.setText(data);
		}
	}

}
