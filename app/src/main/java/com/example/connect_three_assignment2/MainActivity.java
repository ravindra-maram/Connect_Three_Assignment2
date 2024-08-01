package com.example.connect_three_assignment2;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.connect_three_assignment2.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private final List<int[]> combinationList = new ArrayList<>();
    private int[] boxPositions = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int playerTurn = 1;
    private int totalSelectedBoxes = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Adding winning combinations to the list
        combinationList.add(new int[]{0, 1, 2});
        combinationList.add(new int[]{3, 4, 5});
        combinationList.add(new int[]{6, 7, 8});
        combinationList.add(new int[]{0, 3, 6});
        combinationList.add(new int[]{1, 4, 7});
        combinationList.add(new int[]{2, 5, 8});
        combinationList.add(new int[]{2, 4, 6});
        combinationList.add(new int[]{0, 4, 8});

        String firstPlayer = getIntent().getStringExtra("playerOne");
        String secondPlayer = getIntent().getStringExtra("playerTwo");
        binding.firstPlayerName.setText(firstPlayer); // Set first player's name
        binding.secondPlayerName.setText(secondPlayer); // Set second player's name

        // Set onClickListeners for each box
        binding.image1.setOnClickListener(view -> {
            if (isBoxSelectable(0)) {
                performAction((ImageView) view, 0);
            }
        });

        binding.image2.setOnClickListener(view -> {
            if (isBoxSelectable(1)) {
                performAction((ImageView) view, 1);
            }
        });

        binding.image3.setOnClickListener(view -> {
            if (isBoxSelectable(2)) {
                performAction((ImageView) view, 2);
            }
        });

        binding.image4.setOnClickListener(view -> {
            if (isBoxSelectable(3)) {
                performAction((ImageView) view, 3);
            }
        });

        binding.image5.setOnClickListener(view -> {
            if (isBoxSelectable(4)) {
                performAction((ImageView) view, 4);
            }
        });

        binding.image6.setOnClickListener(view -> {
            if (isBoxSelectable(5)) {
                performAction((ImageView) view, 5);
            }
        });

        binding.image7.setOnClickListener(view -> {
            if (isBoxSelectable(6)) {
                performAction((ImageView) view, 6);
            }
        });

        binding.image8.setOnClickListener(view -> {
            if (isBoxSelectable(7)) {
                performAction((ImageView) view, 7);
            }
        });

        binding.image9.setOnClickListener(view -> {
            if (isBoxSelectable(8)) {
                performAction((ImageView) view, 8);
            }
        });
    }

    private void performAction(ImageView imageView, int selectedBoxPosition) {
        boxPositions[selectedBoxPosition] = playerTurn;
        if (playerTurn == 1) {
            imageView.setImageResource(R.drawable.x);
            if (checkResults()) {
                Result resultDialog = new Result(MainActivity.this, binding.firstPlayerName.getText().toString()
                        + " you won 😎😎😎", MainActivity.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            } else if (totalSelectedBoxes == 9) {
                Result resultDialog = new Result(MainActivity.this, "It's a Draw", MainActivity.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            } else {
                changePlayerTurn(2);
                totalSelectedBoxes++;
            }
        } else {
            imageView.setImageResource(R.drawable.o);
            if (checkResults()) {
                Result resultDialog = new Result(MainActivity.this, binding.secondPlayerName.getText().toString()
                        + " you won 😎😎😎", MainActivity.this);
                resultDialog.setCancelable(false);
                resultDialog.show();
            } else if (totalSelectedBoxes == 9) {
                Result resultDialog = new Result(MainActivity.this, "It's a Draw", MainActivity.this); // Show draw message
                resultDialog.setCancelable(false);
                resultDialog.show();
            } else {
                changePlayerTurn(1);
                totalSelectedBoxes++;
            }
        }
    }

    private void changePlayerTurn(int currentPlayerTurn) {
        playerTurn = currentPlayerTurn;
        if (playerTurn == 1) {
            binding.firstPlayerName.setBackgroundResource(R.drawable.border);
            binding.secondPlayerName.setBackgroundResource(R.drawable.box);
        } else {
            binding.secondPlayerName.setBackgroundResource(R.drawable.border);
            binding.firstPlayerName.setBackgroundResource(R.drawable.box);
        }
    }

    private boolean checkResults() {
        for (int[] combination : combinationList) {
            if (boxPositions[combination[0]] == playerTurn &&
                    boxPositions[combination[1]] == playerTurn &&
                    boxPositions[combination[2]] == playerTurn) {
                return true;
            }
        }
        return false;
    }

    private boolean isBoxSelectable(int boxPosition) {
        return boxPositions[boxPosition] == 0;
    }

    public void restartMatch() {
        boxPositions = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        playerTurn = 1;
        totalSelectedBoxes = 1;

        // Reset the images of all boxes
        binding.image1.setImageResource(R.drawable.box);
        binding.image2.setImageResource(R.drawable.box);
        binding.image3.setImageResource(R.drawable.box);
        binding.image4.setImageResource(R.drawable.box);
        binding.image5.setImageResource(R.drawable.box);
        binding.image6.setImageResource(R.drawable.box);
        binding.image7.setImageResource(R.drawable.box);
        binding.image8.setImageResource(R.drawable.box);
        binding.image9.setImageResource(R.drawable.box);
    }
}
