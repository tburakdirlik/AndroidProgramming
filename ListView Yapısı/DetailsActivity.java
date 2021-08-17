package com.tbd.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.tbd.landmarkbook.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {


    //---------------------------------------------------------------------------------------------//
    private ActivityDetailsBinding binding;                                                        // binding area first step
    //---------------------------------------------------------------------------------------------//
    //TextView nameText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //------------------------------------------------------------------------------------------//
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());                              // binding area last step
        View view = binding.getRoot(); // inflate kodumuzla xml i birbirine bağlamaya çalıştığımız yer
        setContentView(view);                                                                       //
        //------------------------------------------------------------------------------------------//

        /*
        nameText = findViewById(R.id.nameText);  Bu verimsiz bir işlem
        çünkü tek tek id eşlenmeye çalışılıyor. arka planda verimsiz bir iş
        android view binding adlı teknolojiyle bu iş çözdü bunu kullanacağız.
        1)
        build.gradle(module ) -->  buraya gidip android kısmının içine şu kodu yapıştırıyoruz

         buildFeatures {
          viewBinding true
                        }

        sonrasında sync now a basıyoruz
        */

        binding.countryText.setText("tessts ");
    }
}