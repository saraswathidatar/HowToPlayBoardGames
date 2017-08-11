package com.example.admin.learnchess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class PiecesList extends AppCompatActivity {

    private ImageButton btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pieces_list);

        btnHome = (ImageButton) findViewById(R.id.imageButton11);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    public void openPawn(View view) {
        Intent intent = new Intent(this, Pawn.class);
        startActivity(intent);
    }

    public void openRook(View view) {
        Intent intent = new Intent(this, Rook.class);
        startActivity(intent);
    }

    public void openKnight(View view) {
        Intent intent = new Intent(this, Knight.class);
        startActivity(intent);
    }

    public void openBishop(View view) {
        Intent intent = new Intent(this, Bishop.class);
        startActivity(intent);
    }

    public void openQueen(View view) {
        Intent intent = new Intent(this, Queen.class);
        startActivity(intent);
    }

    public void openKing(View view) {
        Intent intent = new Intent(this, King.class);
        startActivity(intent);
    }

    public void openError(View view) {
        Intent intent = new Intent(this, Error.class);
        startActivity(intent);
    }

}
