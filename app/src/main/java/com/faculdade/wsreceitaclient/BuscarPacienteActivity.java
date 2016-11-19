package com.faculdade.wsreceitaclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.faculdade.wsreceitaclient.controller.PacienteController;
import com.faculdade.wsreceitaclient.model.Medico;
import com.faculdade.wsreceitaclient.model.Paciente;

import java.util.ArrayList;

public class BuscarPacienteActivity extends AppCompatActivity {

    Button btnProcPaciente, btnConsultas, btnVoltarMenuMedico;
    EditText edtPaciente;
    TextView tvResPaciente;
    Intent intent;

    public Paciente p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_paciente);

        bind();

        p = (Paciente) getIntent().getExtras().get("paciente");

        if(p == null)
            p = new Paciente();
        else {
            tvResPaciente.setText(p.toString());
        }

        btnConsultas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(p == new Paciente()) {
                    Toast.makeText(getApplicationContext(), "Favor buscar um paciente.", Toast.LENGTH_LONG).show();
                }
                else {
                    intent = new Intent(getApplicationContext(), VerReceitasPacienteActivity.class);
                    intent.putExtra("paciente", p);
                    startActivity(intent);
                }
            }
        });

        btnProcPaciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtPaciente = edtPaciente.getText().toString();
                String avisoCrm = "Favor buscar um paciente por cpf.";

                if(txtPaciente == "") {
                    Toast.makeText(getApplicationContext(), avisoCrm, Toast.LENGTH_LONG).show();
                }
                else {
                    ArrayList<Paciente> pacientes = new PacienteController().GetPaciente();
                    for(Paciente pac: pacientes)
                        if (pac.getCPF() == txtPaciente) {
                            p = pac;
                            tvResPaciente.setText(p.toString());
                        }


                    if(p == new Paciente())
                        Toast.makeText(getApplicationContext(), avisoCrm, Toast.LENGTH_LONG).show();
                }
            }
        });

        btnVoltarMenuMedico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Login.usuario.getMedico() != null && Login.usuario.getMedico() != new Medico())
                    intent = new Intent(getApplicationContext(), MenuMedicoActivity.class);
                else
                    intent = new Intent(getApplicationContext(), MenuFarmaciaActivity.class);

                startActivity(intent);
            }
        });
    }

    private void bind() {
        btnProcPaciente = (Button) findViewById(R.id.btnProcPaciente);
        btnConsultas = (Button) findViewById(R.id.btnConsultas);
        btnVoltarMenuMedico = (Button) findViewById(R.id.btnVoltarMenuMedico);
        edtPaciente = (EditText) findViewById(R.id.edtPaciente);
        tvResPaciente = (TextView) findViewById(R.id.tvResPaciente);
    }
}
