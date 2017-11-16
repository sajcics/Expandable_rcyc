package com.example.ssajcic.expandable_rcycv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ssajcic.expandable_rcycv.Adapter.MovieAdapter;
import com.example.ssajcic.expandable_rcycv.Data.Movie;
import com.example.ssajcic.expandable_rcycv.Data.MovieCategory;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView list;
    private List<Movie> movies = null;
    private MovieAdapter adapter = null;
    private ArrayList<Object> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (RecyclerView) findViewById(R.id.rcycMovies);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        list.setLayoutManager(layoutManager);

        generateDummyData();
    }

    private void generateDummyData() {
        movies = new ArrayList<>();
        movies.add(new Movie("Murder on the Orient Express"));
        data.add(new MovieCategory("Crime", movies));

        movies = new ArrayList<>();
        movies.add(new Movie("The Matrix"));
        movies.add(new Movie("The Fifth Element"));
        movies.add(new Movie("Aliens"));
        data.add(new MovieCategory("Sci-fi", movies));

        movies = new ArrayList<>();
        movies.add(new Movie("The Mummy"));
        data.add(new MovieCategory("Fantasy", movies));

        adapter = new MovieAdapter(data);
        list.setAdapter(adapter);
    }
}
