package com.vu.a4662586_4669011;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CheckCarActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_car);

        btnBack = (Button) findViewById(R.id.btnBack);

        btnBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if(id == R.id.btnBack) {
            goToCarAppPage();
        }
    }

    private void goToCarAppPage() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
