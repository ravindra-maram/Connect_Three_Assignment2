package com.example.connect_three_assignment2;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class Result extends Dialog {
    private final String message;
    private final MainActivity mainActivity;

    // Constructor for the Result dialog
    public Result(@NonNull Context context, String message, MainActivity mainActivity) {
        super(context);
        this.message = message;
        this.mainActivity = mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView textMessage = findViewById(R.id.messageText);
        Button playAgainButton = findViewById(R.id.playAgainButton);
        Button exitButton = findViewById(R.id.exitButton);

        textMessage.setText(message);

        playAgainButton.setOnClickListener(view -> {
            mainActivity.restartMatch();
            dismiss();
        });

        exitButton.setOnClickListener(view -> {
            Intent intent = new Intent(mainActivity, Homescreen.class);
            mainActivity.startActivity(intent);
            mainActivity.finish();
            dismiss();
        });
    }
}
