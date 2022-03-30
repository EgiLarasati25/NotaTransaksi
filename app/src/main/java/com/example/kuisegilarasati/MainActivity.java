package com.example.kuisegilarasati;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_transaksi1);
    }

    public void prosesData(View view){
        EditText nmPelanggan, altPelanggan, jmlBarang;
        RadioGroup JnsKelamin, TipePelanggan, NamaBarang;
        RadioButton kelamin, tipe, namaBarang;

        // Edit Text Handle
        nmPelanggan = (EditText) findViewById(R.id.nmPelanggan);
        altPelanggan = (EditText) findViewById(R.id.altPelanggan);
        jmlBarang = (EditText) findViewById(R.id.jmlBarang);
        String namaString = nmPelanggan.getText().toString().trim();
        String alamatString = altPelanggan.getText().toString().trim();
        Integer jmlBarangInt = Integer.parseInt(jmlBarang.getText().toString().trim());

        // Group Handle

        // Jenis Kelamin
        JnsKelamin = (RadioGroup) findViewById(R.id.JnsKelamin);
        int idKelaminSelected = JnsKelamin.getCheckedRadioButtonId();
        kelamin = (RadioButton) findViewById(idKelaminSelected);
        String kelaminString = kelamin.getText().toString().trim();

        // Tipe Pelanggan
        TipePelanggan = (RadioGroup) findViewById(R.id.TipePelanggan);
        int idTipePelangganSelected = TipePelanggan.getCheckedRadioButtonId();
        tipe = (RadioButton) findViewById(idTipePelangganSelected);
        String tipePelangganString = tipe.getText().toString().trim();

        // Nama Barang
        NamaBarang = (RadioGroup) findViewById(R.id.NamaBarang);
        int idNamaBarangSelected = NamaBarang.getCheckedRadioButtonId();
        namaBarang = (RadioButton) findViewById(idNamaBarangSelected);
        String namaBarangString = namaBarang.getText().toString().trim();

        double diskonHarga, diskonMember, totalHarga,jumlahBayar, totalDiskonMember, totalDiskonHarga;
        int hargaBarang;

        // Diskon member berdasarkan jenis member
        switch (tipePelangganString){
            case "Gold":
                diskonMember = 0.4;
                break;
            case "Silver":
                diskonMember = 0.2;
                break;
            case "Biasa":
                diskonMember = 0.6;
                break;
            default:
                diskonMember = 0;
        }

        switch (namaBarangString){
            case "Android":
                hargaBarang = 3000000;
                diskonHarga = 0.30;
                break;
            case "Iphone":
                hargaBarang = 5000000;
                diskonHarga = 0.10;
                break;
            case "Windows Phone":
                hargaBarang = 2000000;
                diskonHarga = 0.20;
                break;
            default:
                hargaBarang = 0;
                diskonHarga = 0;
        }
        totalHarga = hargaBarang * jmlBarangInt;
        totalDiskonMember = totalHarga * diskonMember;
        totalDiskonHarga = totalHarga * diskonHarga;
        jumlahBayar = totalHarga - totalDiskonMember - totalDiskonHarga;

        Intent intent = new Intent(this, transaksi2.class);
        intent.putExtra("tipePelanggan", tipePelangganString );
        intent.putExtra("namaPelanggan", namaString);
        intent.putExtra("jenisKelamin", kelaminString);
        intent.putExtra("alamat", alamatString);
        intent.putExtra("namaBarang", namaBarangString);
        intent.putExtra("jumlahBarang", jmlBarangInt);
        intent.putExtra("hargaBarang", hargaBarang);
        intent.putExtra("totalHarga", totalHarga);
        intent.putExtra("diskonMember", totalDiskonMember);
        intent.putExtra("diskonHarga", totalDiskonHarga);
        intent.putExtra("jumlahBayar", jumlahBayar);
        try {
            startActivity(intent);

        }catch (Exception ignored){

        }

    }
}