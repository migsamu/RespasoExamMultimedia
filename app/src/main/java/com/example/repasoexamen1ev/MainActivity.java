package com.example.repasoexamen1ev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String[] vehiculos = {"Seleccione un vehuculo", "Motos", "Coches"};
    protected static final String INFORMACION = "com.example.repasoexamen1ev.datos";

    private Switch swComenzar;
    private ImageButton ibVehiculo;
    private Spinner sVehiculos;
    private boolean esVisible;
    private TextView tvMotivo;
    private CheckBox cbMotivo1, cbMotivo2, cbMotivo3;
    private String motivo1, motivo2, motivo3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        crearSpinner();
    }

    public void init() {
        swComenzar = (Switch) findViewById(R.id.swComenzar);
        swComenzar.setChecked(false);

        ibVehiculo = (ImageButton) findViewById(R.id.ibVehiculos);
        sVehiculos = (Spinner) findViewById(R.id.sVehiculos);

        ibVehiculo.setVisibility(View.GONE);
        sVehiculos.setVisibility(View.GONE);

        cbMotivo1 = (CheckBox) findViewById(R.id.cbMotivo1);
        cbMotivo2 = (CheckBox) findViewById(R.id.cbMotivo2);
        cbMotivo3 = (CheckBox) findViewById(R.id.cbMotivo3);

        tvMotivo = (TextView) findViewById(R.id.tvMotivo);
        tvMotivo.setVisibility(View.GONE);

        cbMotivo1.setVisibility(View.GONE);
        cbMotivo2.setVisibility(View.GONE);
        cbMotivo3.setVisibility(View.GONE);
    }

    public void comenzar(View v) {
        if (swComenzar.isChecked()) {
            sVehiculos.setVisibility(View.VISIBLE);
            ibVehiculo.setVisibility(View.VISIBLE);
        } else {
            ibVehiculo.setVisibility(View.GONE);
            sVehiculos.setVisibility(View.GONE);
        }
    }

    public void crearSpinner() {
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, vehiculos);
        sVehiculos.setAdapter(adapter);


        sVehiculos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (sVehiculos.getSelectedItemPosition()) {
                    case 1:
                        ibVehiculo.setImageResource(R.drawable.icon);
                        ibVehiculo.setVisibility(View.VISIBLE);
                        cbMotivo1.setText("Necesidad");
                        cbMotivo2.setText("Capricho");
                        cbMotivo3.setText("Ligar");
                        tvMotivo.setVisibility(View.VISIBLE);
                        cbMotivo1.setVisibility(View.VISIBLE);
                        cbMotivo2.setVisibility(View.VISIBLE);
                        cbMotivo3.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        ibVehiculo.setImageResource(R.drawable.gtr);
                        ibVehiculo.setVisibility(View.VISIBLE);
                        cbMotivo1.setText("Carreras");
                        cbMotivo2.setText("Capricho");
                        cbMotivo3.setText("Dejar atras a los Lambo");
                        tvMotivo.setVisibility(View.VISIBLE);
                        cbMotivo1.setVisibility(View.VISIBLE);
                        cbMotivo2.setVisibility(View.VISIBLE);
                        cbMotivo3.setVisibility(View.VISIBLE);
                        break;
                    case 0:
                        ibVehiculo.setVisibility(View.GONE);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void enviarInfo(View view) {

        if (cbMotivo1.isChecked()) {
            motivo1 = cbMotivo1.getText().toString();
        }
        if (cbMotivo2.isChecked()) {
            motivo2 = cbMotivo2.getText().toString();
        }
        if (cbMotivo3.isChecked()) {
            motivo3 = cbMotivo3.getText().toString();
        }
        if (motivo1 == null && motivo2 == null && motivo3 == null) {
            Toast.makeText(this, "Debe elegir al menos 1 motivo", Toast.LENGTH_SHORT).show();
        } else {
            String datos = motivo1 + "\n" + motivo2 + "\n" + motivo3;

            Intent pantallaInfo = new Intent(this, Informacion.class);
            pantallaInfo.putExtra(INFORMACION, datos);
            startActivity(pantallaInfo);
        }
    }

}