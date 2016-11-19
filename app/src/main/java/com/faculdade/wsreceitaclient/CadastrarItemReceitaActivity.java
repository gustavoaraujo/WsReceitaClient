package com.faculdade.wsreceitaclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.faculdade.wsreceitaclient.model.Item;
import com.faculdade.wsreceitaclient.model.Receita;

public class CadastrarItemReceitaActivity extends AppCompatActivity {

    Button btnCadItemNaReceita, btnVoltarParaListadeItens;
    EditText edtRegistroAnvisa, edtNomeItemReceita, edtUsoItemReceita, edtUsoInstrucaoReceita, edtContraIndicacao;
    Receita r;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_item_receita);

        r = (Receita) getIntent().getExtras().get("receita");

        bind();

        btnCadItemNaReceita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Item i = new Item();
                i.setNome(edtNomeItemReceita.getText().toString());
                i.setRegAnvisa(Integer.parseInt(edtRegistroAnvisa.getText().toString()));
                i.setUso(edtUsoItemReceita.getText().toString());
                i.setInstrucao(edtUsoInstrucaoReceita.getText().toString());
                i.setContraIndicacao(edtContraIndicacao.getText().toString());

                r.getItensReceita().add(i);

                voltar();
            }
        });

        btnVoltarParaListadeItens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voltar();
            }
        });
    }

    private void voltar() {
        intent = new Intent(getApplicationContext(), ListarItemReceitaActivity.class);
        intent.putExtra("receita", r);
        startActivity(intent);
    }

    private void bind() {
        btnCadItemNaReceita = (Button) findViewById(R.id.btnCadItemNaReceita);
        btnVoltarParaListadeItens = (Button) findViewById(R.id.btnVoltarParaListadeItens);
        edtRegistroAnvisa = (EditText) findViewById(R.id.edtRegistroAnvisa);
        edtNomeItemReceita = (EditText) findViewById(R.id.edtNomeItemReceita);
        edtUsoItemReceita = (EditText) findViewById(R.id.edtUsoItemReceita);
        edtUsoInstrucaoReceita = (EditText) findViewById(R.id.edtUsoInstrucaoReceita);
        edtContraIndicacao = (EditText) findViewById(R.id.edtContraIndicacao);
    }
}
