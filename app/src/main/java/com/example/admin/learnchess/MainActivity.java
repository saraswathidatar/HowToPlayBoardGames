/** Copyright (c) Saraswathi Datar
  * This work is available under the "MIT License".
  * Please see the file LICENSE for license terms
  */

/** This is the first screen that gets launched when app
  * starts. Registers all the activities used in the app
  */

package com.example.admin.learnchess;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
        if (id == R.id.action_help) {
            return true;
        }

        if (id == R.id.action_about_us) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void openSetTheBoard(View view) {
        Intent intent = new Intent(this, SetupTheBoard.class);
        startActivity(intent);
    }

    public void openPiecesList(View view) {
        Intent intent = new Intent(this, PiecesList.class);
        startActivity(intent);
    }

    public void openError(View view){
        Intent intent = new Intent(this, Error.class);
        startActivity(intent);
    }

    public void openHelp(MenuItem item){
        Intent intent = new Intent(this, Help.class);
        startActivity(intent);
    }

    public void openAbout(MenuItem item) {
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }
}
