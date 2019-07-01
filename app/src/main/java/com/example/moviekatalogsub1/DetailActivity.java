package com.example.moviekatalogsub1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moviekatalogsub1.data.DataFilm;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        DataFilm dataFilm = getIntent().getParcelableExtra("Extra");

        ImageView poster = (ImageView) findViewById(R.id.posterview);
        poster.setImageResource(dataFilm.getPoster());

        TextView judul = (TextView) findViewById(R.id.judulview);
        judul.setText(dataFilm.getJudul());

        TextView jadwal = (TextView) findViewById(R.id.jadwalview);
        jadwal.setText(dataFilm.getJadwal());

        TextView rate = (TextView) findViewById(R.id.rateview);
        rate.setText(dataFilm.getRate());

        TextView sinopsis = (TextView) findViewById(R.id.sinopsisview);
        sinopsis.setText(dataFilm.getSinopsis());
    }


}
