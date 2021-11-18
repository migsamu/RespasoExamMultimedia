package com.example.repasoexamen1ev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Informacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);
        getInfo();
    }

    public void getInfo() {
        Intent main = getIntent();
        String datos = main.getStringExtra(MainActivity.INFORMACION);

        TextView tvDatos = (TextView) findViewById(R.id.tvDatos);
        tvDatos.setText(datos);
    }

    public void volver(View v) {
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }


}