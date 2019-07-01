package com.example.moviekatalogsub1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moviekatalogsub1.R;
import com.example.moviekatalogsub1.data.DataFilm;

import java.util.ArrayList;

public class FilmAdapter extends BaseAdapter {

    private Context ctx;
    private ArrayList<DataFilm> dataFilmArrayList;



    public FilmAdapter(Context ctx) {
        this.ctx = ctx;
    }

    public void setDataFilmArrayList(ArrayList<DataFilm> dataFilmArrayList) {
        this.dataFilmArrayList = dataFilmArrayList;
    }

    public ArrayList<DataFilm> getDataFilmArrayList() {
        return dataFilmArrayList;
    }

    @Override
    public int getCount() {
        return dataFilmArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataFilmArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(ctx).inflate(R.layout.item_list,parent,false);
        }

        ViewHolder viewHolder = new ViewHolder(convertView);
        DataFilm dataFilm = (DataFilm) getItem(position);
        viewHolder.bind(dataFilm,position);

        return convertView;
    }

    public class ViewHolder{
        private ImageView poster;
        private TextView judul;
        private TextView jadwal;
        private TextView rate;

        ViewHolder(View v){
            poster = v.findViewById(R.id.poster_view);
            judul = v.findViewById(R.id.judul_view);
            jadwal = v.findViewById(R.id.jadwal_view);
            rate = v.findViewById(R.id.rate_view);
        }

        void bind(DataFilm d,int p){
            poster.setImageResource(d.getPoster());
            judul.setText(d.getJudul());
            jadwal.setText(d.getJadwal());
            rate.setText(d.getRate());
        }

    }

}
