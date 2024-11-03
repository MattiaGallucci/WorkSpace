package it.unisa.di.mp.socketraw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private final String TAG = "DEBUG";
    private EditText textToSend;
    private TextView textResponse;
    private EditText textIP;
    private EditText textPort;
    private String IP = "www.repubblica.it";
    private String PORT = "80";
    private String GET_REQ = "GET /home HTTP/1.1\n"
            + "Host: www.repubblica.it\n"
            + "\n";

    String server;
    int port;
    String strToSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate()");
        setContentView(R.layout.layout);

        //Bind widgets
        textToSend = (EditText) findViewById(R.id.editTextToSend);
        textToSend.setText(GET_REQ);
        textResponse = (TextView) findViewById(R.id.textViewResponse);
        //textResponse.setHint(GET_HINT);
        textResponse.setMovementMethod(new ScrollingMovementMethod());
        textIP = (EditText) findViewById(R.id.editTextIP);
        textIP.setText(IP);
        textPort = (EditText) findViewById(R.id.editTextPort);
        textPort.setText(PORT);
    }


    public void sendButtonClicked(View v) {
        server = textIP.getText().toString();
        port = Integer.parseInt(textPort.getText().toString());

        strToSend = textToSend.getEditableText().toString();
        String str = "Send button has been clicked.\n" +
                "Sending: " + strToSend;
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();

        NetworkTask nt = new NetworkTask();
        textResponse.setText("");
        nt.execute();
    }


    public void clearButtonClicked(View v) {
        textResponse.setText("");
    }

    class NetworkTask extends AsyncTask<Integer, Integer, String> {

        @Override
        protected String doInBackground(Integer... values) {
            Log.d(TAG, "doInBackground");
            String received_data = "";
            Socket socket = null;
            InetAddress serverAddr;

            //Connect
            try {
                Log.d(TAG, "Connecting to " + server + ", on port " + port);
                serverAddr = InetAddress.getByName(server);
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
                Log.d(TAG, "The socket is null");
                return null;
            }


            //Send data
            try {
                PrintWriter out = new PrintWriter(new
                        BufferedWriter(new
                        OutputStreamWriter(socket.getOutputStream())), true);
                out.println(strToSend);
                Log.d("Client", "Client sent message:" + strToSend);
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
                Log.d(TAG, "input stream in: " + in);

                String line;
                while ((line = in.readLine()) != null) {
                    Log.d("DEBUG", "read line: |" + line + "|");
                    received_data += line + "\n";
                    if (line.length() == 0) break; //Una linea vuota fa uscire dal loop, altrimenti con un web server si rimane in attesa infinita
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
        protected void onPostExecute(String data) {
            Log.d(TAG, "onPostExecute() - data=" + data);
            textResponse.setText(data);
        }
    }

}