/** Copyright (c) Saraswathi Datar
  * This work is available under the "MIT License".
  * Please see the file LICENSE for license terms
  */

/** Implements TextToSpeech interface and initiates
  * listener, speaks out the text written in layout
  * content_rook.xml file.
  */

package com.example.admin.learnchess;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Locale;

public class Rook extends AppCompatActivity implements TextToSpeech.OnInitListener  {

    private TextToSpeech tts;
    private ImageButton btnSpeak;
    private ImageButton btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rook);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tts = new TextToSpeech(this, this);
        btnHome = (ImageButton) findViewById(R.id.imageButton13);
        btnSpeak = (ImageButton) findViewById(R.id.imageButton14);

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
            }

        } else {
            Log.e("TTS", "Initilization Failed!");
        }
    }

    private void speakOut() {
        String text = "";
        TextView textView;

        textView = (TextView) findViewById(R.id.textView19);
        text += textView.getText().toString() + ". ";

        textView = (TextView) findViewById(R.id.textView20);
        text += textView.getText().toString();

        textView = (TextView) findViewById(R.id.textView21);
        text += textView.getText().toString() + ". ";

        textView = (TextView) findViewById(R.id.textView22);
        text += textView.getText().toString();

        textView = (TextView) findViewById(R.id.textView23);
        text += textView.getText().toString() + ". ";

        textView = (TextView) findViewById(R.id.textView24);
        text += textView.getText().toString() + ". ";

        textView = (TextView) findViewById(R.id.textView25);
        text += textView.getText().toString();

        textView = (TextView) findViewById(R.id.textView26);
        text += textView.getText().toString() + ". ";

        textView = (TextView) findViewById(R.id.textView27);
        text += textView.getText().toString() + ". ";

        textView = (TextView) findViewById(R.id.textView28);
        text += textView.getText().toString() + ". ";

        textView = (TextView) findViewById(R.id.textView29);
        text += textView.getText().toString() + ". ";

        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }
}
