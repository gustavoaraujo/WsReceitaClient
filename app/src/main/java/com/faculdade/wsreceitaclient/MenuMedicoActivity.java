package com.faculdade.wsreceitaclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuMedicoActivity extends AppCompatActivity {

    Button btnBusPaciente, btnCadPaciente, btnCadReceita, btnBusReceita, btnSair;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_medico);

        bind();

        btnBusPaciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), BuscarPacienteActivity.class);
                startActivity(intent);
            }
        });

        btnBusReceita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), BuscarReceitaActivity.class);
                startActivity(intent);
            }
        });

        btnCadPaciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), CadastrarPacienteActivity.class);
                startActivity(intent);
            }
        });

        btnCadReceita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), CadastrarReceitaActivity.class);
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
        btnCadPaciente = (Button) findViewById(R.id.btnCadPaciente);
        btnCadReceita = (Button) findViewById(R.id.btnCadReceita);
        btnBusReceita = (Button) findViewById(R.id.btnBusReceita);
        btnSair = (Button) findViewById(R.id.btnSair);
    }
}
