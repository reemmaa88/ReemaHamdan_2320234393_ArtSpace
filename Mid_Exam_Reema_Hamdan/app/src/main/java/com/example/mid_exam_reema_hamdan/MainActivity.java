package com.example.mid_exam_reema_hamdan;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tvCounter;
    private ImageView ivArtwork;
    private TextView tvTitle;
    private TextView tvArtistYear;
    private Button btnPrevious;
    private Button btnNext;

    private int currentIndex = 0;
    private List<Artwork> artworks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCounter = findViewById(R.id.tvCounter);
        ivArtwork = findViewById(R.id.ivArtwork);
        tvTitle = findViewById(R.id.tvTitle);
        tvArtistYear = findViewById(R.id.tvArtistYear);
        btnPrevious = findViewById(R.id.btnPrevious);
        btnNext = findViewById(R.id.btnNext);

        artworks = new ArrayList<>();
        artworks.add(new Artwork(R.drawable.art1, "Mona Lisa", "Leonardo da Vinci", "1503"));
        artworks.add(new Artwork(R.drawable.art2, "The Starry Night", "Vincent van Gogh", "1889"));
        artworks.add(new Artwork(R.drawable.art3, "Guernica", "Pablo Picasso", "1937"));
        artworks.add(new Artwork(R.drawable.art4, "Impression, Sunrise", "Claude Monet", "1872"));
        artworks.add(new Artwork(R.drawable.art5, "The Scream", "Edvard Munch", "1893"));
        artworks.add(new Artwork(R.drawable.art6, "The Persistence of Memory", "Salvador Dalí", "1931"));

        if (savedInstanceState != null) {
            currentIndex = savedInstanceState.getInt("CURRENT_INDEX", 0);
        }

        updateUI();

        btnPrevious.setOnClickListener(v -> {
            if (currentIndex > 0) {
                currentIndex--;
                updateUI();
            }
        });

        btnNext.setOnClickListener(v -> {
            if (currentIndex < artworks.size() - 1) {
                currentIndex++;
                updateUI();
            }
        });

        ivArtwork.setOnClickListener(v -> {
            Artwork currentArtwork = artworks.get(currentIndex);
            Intent intent = new Intent(MainActivity.this, ArtworkDetailsActivity.class);
            intent.putExtra("EXTRA_TITLE", currentArtwork.getTitle());
            intent.putExtra("EXTRA_ARTIST", currentArtwork.getArtist());
            intent.putExtra("EXTRA_YEAR", currentArtwork.getYear());
            startActivity(intent);
        });
    }

    private void updateUI() {
        Artwork currentArtwork = artworks.get(currentIndex);

        ivArtwork.setImageResource(currentArtwork.getImageResId());
        tvTitle.setText(currentArtwork.getTitle());
        tvArtistYear.setText(currentArtwork.getArtist() + " (" + currentArtwork.getYear() + ")");
        tvCounter.setText((currentIndex + 1) + " / " + artworks.size());

        btnPrevious.setEnabled(currentIndex > 0);
        btnNext.setEnabled(currentIndex < artworks.size() - 1);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("CURRENT_INDEX", currentIndex);
    }
}
