package com.faculdade.wsreceitaclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.faculdade.wsreceitaclient.controller.PacienteController;
import com.faculdade.wsreceitaclient.model.Paciente;

public class CadastrarPacienteActivity extends AppCompatActivity {

    Button btnCadPaciente, btnVoltarCadPacienteMedico;
    EditText edtCadNomePaciente, edtCadCpfPaciente;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_paciente);

        bind();

        btnCadPaciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Paciente p = new Paciente();
                p.setNome(edtCadNomePaciente.getText().toString());
                p.setCPF(edtCadCpfPaciente.getText().toString());

                String s = new PacienteController().CadastrarPaciente(p);

                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
            }
        });

        btnVoltarCadPacienteMedico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), MenuMedicoActivity.class);
                startActivity(intent);
            }
        });
    }

    private void bind() {
        btnCadPaciente = (Button) findViewById(R.id.btnCadPaciente);
        btnVoltarCadPacienteMedico = (Button) findViewById(R.id.btnVoltarCadPacienteMedico);
        edtCadNomePaciente = (EditText) findViewById(R.id.edtCadNomePaciente);
        edtCadCpfPaciente = (EditText) findViewById(R.id.edtCadCpfPaciente);
    }
}
