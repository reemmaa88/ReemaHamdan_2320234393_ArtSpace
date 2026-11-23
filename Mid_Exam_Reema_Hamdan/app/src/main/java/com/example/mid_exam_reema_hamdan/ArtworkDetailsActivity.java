package com.example.mid_exam_reema_hamdan;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ArtworkDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artwork_details);

        TextView tvDetails = findViewById(R.id.tvDetails);
        Button btnVisitWebsite = findViewById(R.id.btnVisitWebsite);
        Button btnBack = findViewById(R.id.btnBack);

        Intent intent = getIntent();
        String title = intent.getStringExtra("EXTRA_TITLE");
        String artist = intent.getStringExtra("EXTRA_ARTIST");
        String year = intent.getStringExtra("EXTRA_YEAR");

        if (title == null) title = "Unknown Title";
        if (artist == null) artist = "Unknown Artist";
        if (year == null) year = "Unknown Year";

        tvDetails.setText("Title: " + title + "\nArtist: " + artist + "\nYear: " + year);

        final String searchQuery = title + " " + artist;
        btnVisitWebsite.setOnClickListener(v -> {
            Uri webpage = Uri.parse("https://www.google.com/search?q=" + Uri.encode(searchQuery));
            Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
            startActivity(webIntent);
        });

        btnBack.setOnClickListener(v -> finish());
    }
}
