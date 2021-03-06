/** Copyright (c) Saraswathi Datar
  * This work is available under the "MIT License".
  * Please see the file LICENSE for license terms
  */

/** Challenges option from main menu has a youtube player
  * for lessons on rules and movement. Currently, it is working
  * on emulator and not on phone so I have this error page. Once I
  * have it running, will update the code.
  */

package com.example.admin.learnchess;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

public class Error extends AppCompatActivity {

    private ImageButton btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnHome = (ImageButton) findViewById(R.id.imageButton10);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}
