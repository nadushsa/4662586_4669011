package com.vu.a4662586_4669011;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnAddCar, btnCheckCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCheckCar = (Button) findViewById(R.id.btnAddCar);
        btnAddCar = (Button) findViewById(R.id.btnCheckCar);

        btnAddCar.setOnClickListener(this);
        btnCheckCar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if(id == R.id.btnAddCar) {
            goToAddCarPage();
        }
        if(id == R.id.btnCheckCar) {
            goToCheckCarPage();
        }
    }

    private void goToAddCarPage() {
        Intent intent = new Intent(this, AddCarActivity.class);
        startActivity(intent);
    }

    private void goToCheckCarPage() {
        Intent intent = new Intent(this, CheckCarActivity.class);
        startActivity(intent);
    }
}