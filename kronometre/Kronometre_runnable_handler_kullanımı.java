package com.tbd.runnablehandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView textView;
    int number ;
    Runnable runnable;
    Handler handler;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        number = 0;
    }

    public  void  start (View view){

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                textView.setText("Time : " + number);
                number++;
                textView.setText("Time :" + number);
                handler.postDelayed(runnable, 1000); //en son handker kullanarak bu runnable ı başlatıyoruum.
            }
        };
        handler.post(runnable);
        button.setEnabled(false);  // bu satır buttonu tekrar tıklanamaz hale getirir.

        
        /*  BU KOD BLOĞU KULLANICI ARAYÜZÜNÜ KİLİTLER BUNUN YERİNE THREAD KULLANILMASI GEREKİR.
        while (number <100){
            textView.setText("Time : " + number);
            number++;
            textView.setText("Time :" + number);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        */


    }

    public void stop (View view){

        button.setEnabled(true);
        handler.removeCallbacks(runnable); // runnable ı kapatmak için
        number = 0;

        textView.setText("Time : " + number);
    }
}