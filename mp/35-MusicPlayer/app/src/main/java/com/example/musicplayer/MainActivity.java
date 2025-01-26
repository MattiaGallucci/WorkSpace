package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private final String TAG ="DEBUG";
    private AudioManager am;
    private MediaPlayer mp;
    private TextView textVolume;
    private TextView textBrano;
    private String filename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        //Widgets
        textVolume = (TextView) findViewById(R.id.textViewVolume);
        textBrano = (TextView) findViewById(R.id.textViewBrano);

        am = (AudioManager) getSystemService(AUDIO_SERVICE);
        textVolume.setText(""+am.getStreamVolume(AudioManager.STREAM_MUSIC));
    }


    /*
     * setStreamVolume(.,.,flags)
     * flags (int): definiti in audioManager.java
     * possono essere specificati in questa chiamata per ottenere vari effetti:
     *
     * ESEMPI:
     *
     * public static final int FLAG_REMOVE_SOUND_AND_VIBRATE = 1 << 3;
     * Removes any sounds/vibrate that may be in the queue, or are playing (related to
     * changing volume).

     * public static final int FLAG_VIBRATE = 1 << 4;
     * Whether to vibrate if going into the vibrate ringer mode.
     *
     * public static final int FLAG_FIXED_VOLUME = 1 << 5;
     * Indicates to VolumePanel that the volume slider should be disabled as user
     * cannot change the stream volume
     */


    public void buttonDecreaseVolume(View v) {
        int cur_vol = am.getStreamVolume(AudioManager.STREAM_MUSIC);
        cur_vol--;
        am.setStreamVolume(AudioManager.STREAM_MUSIC, cur_vol, 0);
        textVolume.setText(""+am.getStreamVolume(AudioManager.STREAM_MUSIC));
    }

    public void buttonIncreaseVolume(View v) {
        int cur_vol = am.getStreamVolume(AudioManager.STREAM_MUSIC);
        cur_vol++;
        am.setStreamVolume(AudioManager.STREAM_MUSIC, cur_vol, 0);
        textVolume.setText(""+am.getStreamVolume(AudioManager.STREAM_MUSIC));
    }

    public void buttonPlay(View v) {
        Log.d(TAG,"buttonPlay pressed");
        if (mp == null) {
            Toast.makeText(getApplicationContext(), "Nessun brano selezionato", Toast.LENGTH_SHORT).show();
            return;
        }
        mp.start();
    }

    public void buttonStop(View v) {
        Log.d(TAG,"buttonStop pressed");
        if (mp != null) {
            mp.stop();
            //Per evitare il problema del MediaPlayer error "start called in state 64"
            //Apparentemente il metodo stop non funziona come dovrebbe stando al diagramma
            //di stato del MediaPlayer (vedi documentazione Android)
            //in quanto chiamando mp.play() dopo mp.stop() si ottiene l'errore
            //ricaricare il brano porta il mediaplayer nello stato Prepared che serve per start().
            mp.release();
            //mp = MediaPlayer.create(this, getResources().getIdentifier(filename, "raw", getPackageName()));
            mp = null;
            textBrano.setText("");
        }
    }

    public void buttonPause(View v) {
        Log.d(TAG,"buttonPause pressed");
        if (mp != null) {
            mp.pause();
        }
    }

    public void buttonSelezionaBrano(View v) {
        String str = v.getTag().toString();
        Log.d(TAG,"Loading "+filename);
        int id = getResources().getIdentifier(str, "raw", getPackageName());
        if (id == 0) {
            Log.d(TAG,"Il brano "+str+" non e' stato trovato fra le risorse");
            return;
        }
        filename = str;

        if (mp != null) {
            mp.stop();
            mp.release();
        }

        //mp = MediaPlayer.create(this, getResources().getIdentifier(filename, "raw", getPackageName()));
        mp = MediaPlayer.create(this, id);
        textBrano.setText(((Button) v).getText());
    }

}
