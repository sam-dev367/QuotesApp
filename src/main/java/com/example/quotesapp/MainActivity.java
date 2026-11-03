package com.example.quotesapp;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView tvQuote;
    private Button btnNextQuote, btnShare;

    // Array/Collection storing motivational and inspirational quotes[cite: 4]
    private String[] quotes = {
        "The best way to get started is to quit talking and begin doing. - Walt Disney",
        "The pessimist sees difficulty in every opportunity. The optimist sees opportunity in every difficulty. - Winston Churchill",
        "Don't let yesterday take up too much of today. - Will Rogers",
        "It's not whether you get knocked down, it's whether you get up. - Vince Lombardi",
        "Failure will never overtake me if my determination to succeed is strong enough. - Og Mandino",
        "We may encounter many defeats but we must not be defeated. - Maya Angelou"
    };

    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components (TextView and Buttons)
        tvQuote = findViewById(R.id.tvQuote);
        btnNextQuote = findViewById(R.id.btnNextQuote);
        btnShare = findViewById(R.id.btnShare);

        random = new Random();

        // Display an initial quote when the app launches
        displayRandomQuote();

        // Click listener for the next-quote button to perform random selection and UI updates[cite: 4]
        btnNextQuote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayRandomQuote();
            }
        });

        // Click listener for share button to trigger Android system share intent[cite: 4]
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentQuote = tvQuote.getText().toString();
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, currentQuote);
                startActivity(Intent.createChooser(shareIntent, "Share Quote Via"));
            }
        });
    }

    // Helper method for random selection and TextView manipulation[cite: 4]
    private void displayRandomQuote() {
        int index = random.nextInt(quotes.length);
        tvQuote.setText(quotes[index]);
    }
}