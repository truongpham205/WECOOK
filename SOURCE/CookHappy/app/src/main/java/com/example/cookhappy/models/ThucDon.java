package com.example.cookhappy.models;

public class ThucDon {
    public String ten, mota, noidung;

    public ThucDon(String ten, String mota, String noidung) {
        this.ten = ten;
        this.mota = mota;
        this.noidung = noidung;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }
}
