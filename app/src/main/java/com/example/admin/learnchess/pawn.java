/** Copyright (c) Saraswathi Datar
  * This work is available under the "MIT License".
  * Please see the file LICENSE for license terms
  */

/** Includes a brief description and movement of pawn.
  * Implements TextToSpeech interface and initiates
  * listener, speaks out the text written in layout
  * content_pawn.xml file.
  */

package com.example.admin.learnchess;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Locale;

public class Pawn extends Activity implements TextToSpeech.OnInitListener {

    private TextToSpeech tts;
    private ImageButton btnSpeak;
    private ImageButton btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pawn);

        tts = new TextToSpeech(this, this);
        btnSpeak = (ImageButton) findViewById(R.id.imageButton8);
        btnHome = (ImageButton) findViewById(R.id.imageButton9);

        btnSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakOut();
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onDestroy() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {

            int result = tts.setLanguage(Locale.US);

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
                btnSpeak.setEnabled(true);
                //speakOut();
            }

        } else {
            Log.e("TTS", "Initilization Failed!");
        }
    }


    private void speakOut() {
        String text = "";
        TextView textView = (TextView) findViewById(R.id.textView6);
        text += textView.getText() + ".  ";

        textView = (TextView) findViewById(R.id.textView7);
        text += textView.getText();

        textView = (TextView) findViewById(R.id.textView8);
        text += textView.getText() + ".  ";

        textView = (TextView) findViewById(R.id.textView9);
        text += textView.getText();

        textView = (TextView) findViewById(R.id.textView10);
        text += textView.getText() + ".  ";

        textView = (TextView) findViewById(R.id.textView11);
        text += textView.getText() + ".  ";

        textView = (TextView) findViewById(R.id.textView12);
        text += textView.getText();

        textView = (TextView) findViewById(R.id.textView13);
        text += textView.getText() + ".  ";

        textView = (TextView) findViewById(R.id.textView14);
        text += textView.getText();


        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }
}
