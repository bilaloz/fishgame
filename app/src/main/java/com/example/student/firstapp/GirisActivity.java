package com.example.student.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GirisActivity extends AppCompatActivity {


    Button GirisYap;
    EditText KullaniciAdi, KullaniciSifre;
    String KulAdi;
    String Sifre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);
        GirisYap = findViewById(R.id.btnGiris);
        KullaniciAdi = findViewById(R.id.kullaniciAdi);
        KullaniciSifre = findViewById(R.id.kullaniciSifre);
        GirisYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                KulAdi = KullaniciAdi.getText().toString();
                Sifre = KullaniciSifre.getText().toString();
                if (KulAdi.equals("Bilal") && Sifre.equals("1234")) {
                    Toast.makeText(GirisActivity.this, "Kullanıcı Giriş Başarılı", Toast.LENGTH_SHORT).show();
                    Intent gorev = new Intent(GirisActivity.this, MainActivity.class);
                    startActivity(gorev);
                } else {
                    Toast.makeText(GirisActivity.this, "Hatalı Giriş", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
