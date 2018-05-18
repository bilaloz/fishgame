package com.example.student.firstapp;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txtSkor;
    TextView txtSayac;
    int skor = 0;
    ImageView fish1,fish2,fish3,fish4,fish5,fish6,fish7,fish8,fish9;
    ImageView [] fishArray;
    Handler handler;
    Runnable runnable ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Tanimla(); //Java ile Xml Arasındaki kodları bu metodda eşleştirdik (Burası Kalabalık Olmaması için)
        Hide(); //Program ilk açıldığında ekrandaki resimlerin kaybolması ve random resim atması için bunu yaptık.

        new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                //Her 1 Saniye Geçtikten Sonra Yapılan İşlemler
                txtSayac.setText("Kalan Zaman = "+millisUntilFinished/1000);

            }
            @Override
            public void onFinish() {
                //30 Saniye Geçince Yapılacak İşlemler
                txtSayac.setText("Zaman Doldu Skorunuz : "+skor); //Skoru Ekrana Yazıcak
                txtSayac.setTextColor(Color.parseColor("#827717")); //Yazı Rengini Değiştirecek
                handler.removeCallbacks(runnable); //Run halindeki komutu durdurucak
                ResimSakla(); //Ve Ekrandaki resimler bu metod içerisinde saklanacak
            }
        }.start(); //Start Komumu ile süremizi başlattık
    }
    private void Hide() {

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() { //Program her çalıştığında bu işlemi yapacak
                ResimSakla(); //Program her çalıştığında resimleri saklayacak
                Random r = new Random(); //Program her çalıştığında random sayı üretecek
                int fish = r.nextInt(8-0); //ürettiği random sayıyı bir değişkene atatık değer aralığını 0-8 dizi indisine göre verdik
                fishArray[fish].setVisibility(View.VISIBLE);//Üretilen random sayının görünürlüğünü açtık
                handler.postDelayed(this,1000); //Gecikmesini 1 saniye olarak yaptık her 1 saniyede bu kodlar çalışıcak
            }
        };
        handler.post(runnable); //Post ederek başlattıö
    }
    private void ResimSakla() {
        /*
        for (int i = 0; i<fishArray.length;i++){
            fishArray[i].setVisibility(View.INVISIBLE);//Resimleri sakladık  diğer yöntem
        }*/
        for (ImageView image : fishArray){
            image.setVisibility(View.INVISIBLE); //Resimleri sakladık
        }
    }
    private void Tanimla() {
        txtSkor = findViewById(R.id.txtSkor);
        fish1 = findViewById(R.id.imgOrtaUstSol);
        fish2 = findViewById(R.id.imgOrtaUst);
        fish3 = findViewById(R.id.imgOrtaUstSag);
        fish4 = findViewById(R.id.imgOrta);
        fish5 = findViewById(R.id.imgOrtaSol);
        fish6 = findViewById(R.id.imgOrtaSag);
        fish7 = findViewById(R.id.imgOrtaAlt);
        fish8 = findViewById(R.id.imgOrtaAltSol);
        fish9 = findViewById(R.id.imgOrtaAltSag);
        txtSayac = findViewById(R.id.txtZaman);

        fishArray = new ImageView[]{fish1,fish2,
                fish3,fish4,fish5,              //Resimleri bir diziye attık
                fish6,fish7,fish8,fish9
         };
    }
    public void FishPress(View view) { //Balıklara Tıklanma Olayını Ele Alıyor
        skor++; //Balığa her tıklandığında skor arttı
        txtSkor.setText("Skor = "+skor); //Ve skoru ekrana yazdık.
    }
}
