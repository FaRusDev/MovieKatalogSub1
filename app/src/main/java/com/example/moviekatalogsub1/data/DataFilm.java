package com.example.moviekatalogsub1.data;

import android.os.Parcel;
import android.os.Parcelable;

public class DataFilm implements Parcelable {

    private int poster;
    private String judul;
    private String jadwal;
    private String rate;
    private String sinopsis;


    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getJadwal() {
        return jadwal;
    }

    public void setJadwal(String jadwal) {
        this.jadwal = jadwal;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.poster);
        dest.writeString(this.judul);
        dest.writeString(this.jadwal);
        dest.writeString(this.rate);
        dest.writeString(this.sinopsis);
    }

    public DataFilm() {
    }

    protected DataFilm(Parcel in) {
        this.poster = in.readInt();
        this.judul = in.readString();
        this.jadwal = in.readString();
        this.rate = in.readString();
        this.sinopsis = in.readString();
    }

    public static final Parcelable.Creator<DataFilm> CREATOR = new Parcelable.Creator<DataFilm>() {
        @Override
        public DataFilm createFromParcel(Parcel source) {
            return new DataFilm(source);
        }

        @Override
        public DataFilm[] newArray(int size) {
            return new DataFilm[size];
        }
    };
}
