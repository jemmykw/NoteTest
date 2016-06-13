package com.desaininteraksi.musicalbook.notetest;

import android.content.pm.ActivityInfo;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;

import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.AudioEvent;
import be.tarsos.dsp.io.android.AudioDispatcherFactory;
import be.tarsos.dsp.pitch.PitchDetectionHandler;
import be.tarsos.dsp.pitch.PitchDetectionResult;
import be.tarsos.dsp.pitch.PitchProcessor;


public class MainActivity extends ActionBarActivity {
    double a0 = 440.0/4;
    int fs=22050;
    int n=1024;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);

        AudioDispatcher dispatcher = AudioDispatcherFactory.fromDefaultMicrophone(fs, n, 0);
        dispatcher.addAudioProcessor(new PitchProcessor(PitchProcessor.PitchEstimationAlgorithm.FFT_YIN, fs, n, new PitchDetectionHandler() {

            TextView text = (TextView) findViewById(R.id.textView);
            TextView noteText = (TextView) findViewById(R.id.noteView);
            @Override
            public void handlePitch(PitchDetectionResult pitchDetectionResult,
                                    AudioEvent audioEvent) {
                final float pitchInHz = pitchDetectionResult.getPitch();
                final FrequencyTable f = new FrequencyTable();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        NadaDasar note = f.getNadaDasar((double)pitchInHz);

                        if (pitchInHz>=a0) {
                            text.setText("Frequency : " + pitchInHz + " || Note : " + note.getNama() + note.getOktaf());
                            noteText.setText(note.getNama());
                        }

                    }
                });

            }
        }));
        new Thread(dispatcher,"Audio Dispatcher").start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
