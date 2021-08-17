package com.tbd.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.tbd.landmarkbook.databinding.ActivityDetailsBinding;
import com.tbd.landmarkbook.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    ArrayList<LandMark> landMarkArrayList;
    //----------------------------------------------------------//
    private ActivityMainBinding binding;                        // binding area first step
    //----------------------------------------------------------//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //----------------------------------------------------------//
        binding = ActivityMainBinding.inflate(getLayoutInflater()); //
        View view = binding.getRoot();                              // binding area last step
        setContentView(view);                                       //
        //----------------------------------------------------------//
        landMarkArrayList = new ArrayList<>();

        // resimler burda int id ile tanımlanıyor. eklenirken R.drawable.   burdan eklenir.

        LandMark pisa = new LandMark("Pisa", "Italy", R.drawable.pisa);
        LandMark eifel = new LandMark("Eifel", "France", R.drawable.eifel);
        LandMark coloseum = new LandMark("Coloseum", "Italy", R.drawable.coloseum);
        LandMark londonbridge = new LandMark("London bridge", "England", R.drawable.london);

        landMarkArrayList.add(pisa);
        landMarkArrayList.add(eifel);
        landMarkArrayList.add(coloseum);
        landMarkArrayList.add(londonbridge);


        //ADAPTER
        //VERİ KAYNAĞI İLE XML İ VE LİSTVİEWİ BİRBİRİNE BAĞLAYAN YAPI

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                landMarkArrayList.stream().map(landMark -> landMark.name).collect(Collectors.toList()));
        binding.listView.setAdapter(arrayAdapter);


    }
}