package com.example.connect_three_assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Homescreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
        EditText primaryPlayer = findViewById(R.id.firstPlayer);
        EditText secondaryPlayer = findViewById(R.id.secondPlayer);
        Button startGameButton = findViewById(R.id.playGame);
        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the text from the players
                String getFirstPlayerName = primaryPlayer.getText().toString();
                String getSecondPlayerName = secondaryPlayer.getText().toString();

                // Check if player names are empty
                if (getFirstPlayerName.isEmpty() || getSecondPlayerName.isEmpty()) {
                    Toast.makeText(Homescreen.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(Homescreen.this, MainActivity.class);
                    intent.putExtra("playerOne", getFirstPlayerName);
                    intent.putExtra("playerTwo", getSecondPlayerName);
                    startActivity(intent);
                }
            }
        });
    }
}
