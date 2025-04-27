package com.example.eigthguidedexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    Spinner names;
    TextView resultLabel;
    TextView selectedNameTextView;


    ArrayAdapter<String> adapter;
    String[] listOfNames = {"Name Here", "Papsi", "Paloma", "Che", "Guevarra",
            "Renz", "Abando", "Lucky Chan", "Lani", "Cawatano"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listOfNames);


        names = findViewById(R.id.spnrNamesGE8);
        resultLabel = findViewById(R.id.tvResultGE8);
        selectedNameTextView = findViewById(R.id.tvSelectedName);

        showSelectedName();
    }

    public void showSelectedName(){
        names.setAdapter(adapter);
        names.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i > 0){

                    selectedNameTextView.setText(listOfNames[i]);

                    Toast.makeText(getApplicationContext(),
                            "Name: " + listOfNames[i],Toast.LENGTH_SHORT).show();
                } else {

                    selectedNameTextView.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
}
