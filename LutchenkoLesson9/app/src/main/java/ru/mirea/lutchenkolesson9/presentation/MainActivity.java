package ru.mirea.lutchenkolesson9.presentation;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import ru.mirea.lutchenko.data.data.repository.MovieRepositoryImpl;
import ru.mirea.lutchenko.data.data.storage.MovieStorage;
import ru.mirea.lutchenko.data.data.storage.sharedprefs.SharedPrefMovieStorage;
import ru.mirea.lutchenko.domain.domain.models.Movie;
import ru.mirea.lutchenko.domain.domain.repository.MovieRepository;
import ru.mirea.lutchenko.domain.domain.usecases.GetFavoriteFilmUseCase;
import ru.mirea.lutchenko.domain.domain.usecases.SaveFilmToFavoriteUseCase;
import ru.mirea.lutchenkolesson9.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText text = findViewById(R.id.editText1);
        TextView textView = findViewById(R.id.movieList);

        MovieStorage sharedPrefMovieStorage = new SharedPrefMovieStorage(this);
        MovieRepository movieRepository = new MovieRepositoryImpl(sharedPrefMovieStorage);

        findViewById(R.id.saveFavFilm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean result = new SaveFilmToFavoriteUseCase(movieRepository).execute(new Movie(2, text.getText().toString()));
                textView.setText(String.format("Save result %s", result));
            }
        });

        findViewById(R.id.showFavFilm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Movie movie = new GetFavoriteFilmUseCase(movieRepository).execute();
//                textView.setText(String.format("Save result %s", movie.getName()));
                if (movie != null) {
                    textView.setText(String.format("Favorite movie: %s", movie.getName()));
                } else {
                    textView.setText("No favorite movie found.");
                }
            }
        });
    }
}