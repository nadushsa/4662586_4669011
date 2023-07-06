package com.vu.a4662586_4669011;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.vu.a4662586_4669011.data.DBHelper;

public class AddCarActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnBack, btnAddCar;

    EditText etBrand, etModel, etPrice;

    DBHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

        databaseHelper = new DBHelper(this);

        btnBack = (Button) findViewById(R.id.btnBack);
        btnAddCar = (Button) findViewById(R.id.btnAddCar);

        etBrand = findViewById(R.id.etBrand);
        etModel = findViewById(R.id.etModel);
        etPrice = findViewById(R.id.etPrice);

        btnAddCar.setOnClickListener(this);
        btnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if(id == R.id.btnAddCar) {
            insertData();
        }

        if(id == R.id.btnBack) {
            goToCarAppPage();
        }
    }

    private void insertData() {
        String brand = etBrand.getText().toString();
        String model = etModel.getText().toString();
        String price = etPrice.getText().toString();

        boolean isInserted = databaseHelper.insertData(brand, model, Integer.parseInt(price));
        if(isInserted) {
            Toast.makeText(AddCarActivity.this, "Data inserted successfully", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(AddCarActivity.this, "Data insert failed", Toast.LENGTH_LONG).show();
        }
    }

    private void goToCarAppPage() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
