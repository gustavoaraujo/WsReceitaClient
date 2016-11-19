package com.faculdade.wsreceitaclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuFarmaciaActivity extends AppCompatActivity {

    Button btnBusPaciente, btnBusReceitaFarmacia, btnSair;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_farmacia);
        
        bind();

        btnBusPaciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), BuscarPacienteActivity.class);
                startActivity(intent);
            }
        });

        btnBusReceitaFarmacia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), BuscarReceitaFarmaciaActivity.class);
                startActivity(intent);
            }
        });

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });
    }

    private void bind() {
        btnBusPaciente = (Button) findViewById(R.id.btnBusPaciente);
        btnBusReceitaFarmacia = (Button) findViewById(R.id.btnBusReceitaFarmacia);
        btnSair = (Button) findViewById(R.id.btnSair);
    }
}
