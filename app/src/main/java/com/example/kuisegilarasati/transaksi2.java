package com.example.kuisegilarasati;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class transaksi2 extends AppCompatActivity {

        private TextView tipeMember, jnsKelamin, altPelanggan, namaBarang,
                jumlahBarang, hargaBarang, totalHarga, discHarga, discMember,
                jumlahBayar, nmPelanggan;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.layout_transaksi2);

            nmPelanggan = (TextView) findViewById(R.id.nmPelanggan);
            tipeMember = (TextView) findViewById(R.id.tipeMember);
            jnsKelamin = (TextView) findViewById(R.id.jnsKelamin);
            altPelanggan = (TextView) findViewById(R.id.altPelanggan);
            namaBarang = (TextView) findViewById(R.id.namaBarang);
            jumlahBarang = (TextView) findViewById(R.id.jumlahBarang);
            hargaBarang = (TextView) findViewById(R.id.hargaBarang);
            totalHarga = (TextView) findViewById(R.id.totalHarga);
            discHarga = (TextView) findViewById(R.id.discHarga);
            discMember = (TextView) findViewById(R.id.discMember);
            jumlahBayar = (TextView) findViewById(R.id.jumlahBayar);

            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                nmPelanggan.setText("Nama Pelanggan: " +extras.getString("namaPelanggan"));
                tipeMember.setText("Tipe Member: " + extras.getString("tipePelanggan"));
                jnsKelamin.setText("Jenis Kelamin: "  + extras.getString("jenisKelamin"));
                altPelanggan.setText("Alamat Pelanggan: " + extras.getString("alamat"));
                namaBarang.setText("Nama Barang: " + extras.getString("namaBarang"));
                jumlahBarang.setText("Jumlah Barang: Rp." + extras.getInt("jumlahBarang"));
                hargaBarang.setText("Harga Barang: Rp." + extras.getInt("hargaBarang"));
                totalHarga.setText("Total Harga: " +extras.getDouble("totalHarga"));
                discMember.setText("Discount Member: Rp." +extras.getDouble("diskonMember"));
                discHarga.setText("Discount Harga: Rp."+ extras.getDouble("diskonHarga"));
                jumlahBayar.setText("Jumlah Bayar: Rp." + extras.getDouble("jumlahBayar"));
            }
        }
    }
