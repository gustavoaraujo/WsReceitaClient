package com.faculdade.wsreceitaclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.faculdade.wsreceitaclient.model.Paciente;
import com.faculdade.wsreceitaclient.model.Receita;

import java.util.ArrayList;

public class VerReceitasPacienteActivity extends AppCompatActivity {

    Paciente paciente;
    Button btnVoltarTelaPaciente;
    ListView lvReceitas;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_receitas_paciente);

        btnVoltarTelaPaciente = (Button) findViewById(R.id.btnVoltarTelaPaciente);

        paciente = (Paciente) getIntent().getExtras().get("paciente");

        ArrayList<Receita> lstReceita = paciente.getReceitas();

        String[] arrayCat = new String[lstReceita.size()];
        arrayCat = lstReceita.toArray(arrayCat);

        ArrayAdapter aa = new ArrayAdapter(getApplicationContext(),android.R.layout.select_dialog_item,arrayCat);
        lvReceitas.setAdapter(aa);

        btnVoltarTelaPaciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), BuscarPacienteActivity.class);
                intent.putExtra("Paciente", paciente);
                startActivity(intent);
            }
        });
    }
}
