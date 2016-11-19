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
import com.faculdade.wsreceitaclient.model.Receita;

import java.util.ArrayList;

public class CadastrarReceitaActivity extends AppCompatActivity {

    Button btnAvReceita, btnVoltarCadReceita;
    EditText edtCadNumReceita, edtCadCpf;
    Intent intent;
    Receita r;
    Paciente p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_receita);

        bind();

        r = (Receita) getIntent().getExtras().get("receita");

        if (r == null) {
            r = new Receita();
        } else {
            edtCadCpf.setText(r.getPaciente().getCPF());
            edtCadNumReceita.setText(r.getNumReceita());
        }


        btnAvReceita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Paciente> pacientes = new PacienteController().GetPaciente();

                for (Paciente pac : pacientes)
                    if (pac.getCPF() == edtCadCpf.getText().toString()) {
                        p = pac;
                        break;
                    }

                if (p == null) {
                    Toast.makeText(getApplicationContext(), "Não existe paciente com esse CPF. Favor cadastrar.", Toast.LENGTH_LONG).show();
                } else {
                    r.setNumReceita(Integer.parseInt(edtCadNumReceita.getText().toString()));
                    r.setMedico(Login.usuario.getMedico());
                    r.setPaciente(p);

                    intent = new Intent(getApplicationContext(), MenuMedicoActivity.class);
                    intent.putExtra("receita", r);
                    startActivity(intent);
                }
            }
        });

        btnVoltarCadReceita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), MenuMedicoActivity.class);
                startActivity(intent);
            }
        });
    }

    private void bind() {
        btnAvReceita = (Button) findViewById(R.id.btnAvReceita);
        btnVoltarCadReceita = (Button) findViewById(R.id.btnVoltarCadReceita);
        edtCadNumReceita = (EditText) findViewById(R.id.edtCadNumReceita);
        edtCadCpf = (EditText) findViewById(R.id.edtCadCpf);
    }
}
