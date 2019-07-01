package com.example.moviekatalogsub1;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.moviekatalogsub1.adapter.FilmAdapter;
import com.example.moviekatalogsub1.data.DataFilm;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] judulFilm;
    private String[] jadwalFilm;
    private String[] rateFilm;
    private String[] sinopsisFilm;
    private TypedArray posterFilm;
    private ArrayList<DataFilm> dataFilms;

    private FilmAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.list_view);

        adapter = new FilmAdapter(this);


        init();
        tambahItem();

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(MainActivity.this,DetailActivity.class);
                i.putExtra("Extra",dataFilms.get(position));
                startActivity(i);

            }
        });



    }

    private void init(){
        judulFilm = getResources().getStringArray(R.array.data_judul);
        jadwalFilm = getResources().getStringArray(R.array.data_jadwal);
        rateFilm = getResources().getStringArray(R.array.data_rate);
        sinopsisFilm = getResources().getStringArray(R.array.data_sinopsis);
        posterFilm = getResources().obtainTypedArray(R.array.data_poster);
    }


    private void tambahItem(){
        dataFilms = new ArrayList<>();

        for (int i = 0 ; i < judulFilm.length; i++){
            DataFilm film = new DataFilm();

            film.setPoster(posterFilm.getResourceId(i,-1));
            film.setJudul(judulFilm[i]);
            film.setJadwal(jadwalFilm[i]);
            film.setRate(rateFilm[i]);
            film.setSinopsis(sinopsisFilm[i]);

            dataFilms.add(film);
        }

        adapter.setDataFilmArrayList(dataFilms);

    }


}
