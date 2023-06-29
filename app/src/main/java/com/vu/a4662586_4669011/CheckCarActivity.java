package com.vu.a4662586_4669011;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.vu.a4662586_4669011.data.DBHelper;

public class CheckCarActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnBack, btnCheckCar;
    EditText etBrand, etModel, etPrice;
    DBHelper DBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_car);

        btnBack = (Button) findViewById(R.id.btnBack);
        btnCheckCar = (Button) findViewById(R.id.btnCheckCar);

        etBrand = (EditText) findViewById(R.id.etBrand);
        etModel = (EditText) findViewById(R.id.etModel);
        etPrice = (EditText) findViewById(R.id.etPrice);

        btnBack.setOnClickListener(this);
        btnCheckCar.setOnClickListener(this);

        DBHelper = new DBHelper(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if(id == R.id.btnBack) {
            goToCarAppPage();
        }
        if(id == R.id.btnCheckCar) {
            viewPrice();
        }
    }

    private void viewPrice() {
        String brand = etBrand.getText().toString().trim();
        String model = etModel.getText().toString().trim();

        if(brand.isEmpty() || model.isEmpty()) {
            Toast.makeText(this, "Please enter both brand and model", Toast.LENGTH_SHORT).show();
            return;
        }

        int price = DBHelper.getPrice(brand, model);

        if(price == -1) {
            Toast.makeText(this, "Car not found", Toast.LENGTH_SHORT).show();
            etPrice.setText("");
        } else {
            etPrice.setText(String.valueOf(price));
        }
    }

    private void goToCarAppPage() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
