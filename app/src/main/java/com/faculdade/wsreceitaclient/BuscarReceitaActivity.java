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
import com.faculdade.wsreceitaclient.controller.ReceitaController;
import com.faculdade.wsreceitaclient.model.NumeroReceita;
import com.faculdade.wsreceitaclient.model.Paciente;
import com.faculdade.wsreceitaclient.model.Receita;

import java.util.ArrayList;

public class BuscarReceitaActivity extends AppCompatActivity {

    Button btnProcReceita, btnCancelar, btnVoltarMenuMedico;
    EditText edtReceita;
    TextView tvResReceita;
    Intent intent;

    public Receita r;
    public ReceitaController rc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_receita);

        bind();

        rc = new ReceitaController();

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(r.isUtilizada()) {
                    Toast.makeText(getApplicationContext(), "A receita já foi utilizada.", Toast.LENGTH_LONG).show();
                }
                else {
                    String s = rc.CancelarReceitaMedica(new NumeroReceita(r.getNumReceita()));
                    Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
                }
            }
        });

        btnProcReceita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtPaciente = edtReceita.getText().toString();
                String avisoCrm = "Favor buscar uma receita por número de receita.";

                if(txtPaciente == "") {
                    Toast.makeText(getApplicationContext(), avisoCrm, Toast.LENGTH_LONG).show();
                }
                else {
                    int NumeroReceita = Integer.parseInt(edtReceita.getText().toString());
                    Receita r = rc.ObterReceitaMedica(new NumeroReceita(NumeroReceita));

                    if(r == null || r == new Receita())
                        Toast.makeText(getApplicationContext(), avisoCrm, Toast.LENGTH_LONG).show();
                    else
                        tvResReceita.setText(r.toString());

                }
            }
        });

        btnVoltarMenuMedico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), MenuMedicoActivity.class);
                startActivity(intent);
            }
        });
    }

    private void bind() {
        btnProcReceita = (Button) findViewById(R.id.btnProcReceita);
        btnCancelar = (Button) findViewById(R.id.btnCancelar);
        btnVoltarMenuMedico = (Button) findViewById(R.id.btnVoltarMenuMedico);
        edtReceita = (EditText) findViewById(R.id.edtReceita);
        tvResReceita = (TextView) findViewById(R.id.tvResReceita);
    }
}
