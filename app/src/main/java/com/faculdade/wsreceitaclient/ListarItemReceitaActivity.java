package com.faculdade.wsreceitaclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.faculdade.wsreceitaclient.controller.ReceitaController;
import com.faculdade.wsreceitaclient.model.Item;
import com.faculdade.wsreceitaclient.model.Receita;
import com.faculdade.wsreceitaclient.model.ResultCadastroReceita;

import java.util.ArrayList;

public class ListarItemReceitaActivity extends AppCompatActivity {

    ListView lvItensReceita;
    Button btnCadItemReceita, btnCadReceitaComItens, btnVoltarListaItem;
    Receita r;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_item_receita);

        r = (Receita) getIntent().getExtras().get("receita");

        bind();

        ArrayList<Item> lstReceita = r.getItensReceita();

        if (lstReceita.size() > 0) {
            String[] arrayCat = new String[lstReceita.size()];
            arrayCat = lstReceita.toArray(arrayCat);

            ArrayAdapter aa = new ArrayAdapter(getApplicationContext(), android.R.layout.select_dialog_item, arrayCat);
            lvItensReceita.setAdapter(aa);
        }

        btnCadItemReceita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), CadastrarItemReceitaActivity.class);
                intent.putExtra("receita", r);
                startActivity(intent);
            }
        });

        btnCadReceitaComItens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (r.getItensReceita().size() == 0) {
                    Toast.makeText(getApplicationContext(), "Deve-se cadastrar itens na receita", Toast.LENGTH_LONG).show();
                } else {
                    ResultCadastroReceita resultCadastroReceita = new ReceitaController().CadastrarReceitaMedica(r);
                    Toast.makeText(getApplicationContext(), resultCadastroReceita.getMsg(), Toast.LENGTH_LONG).show();
                }
            }
        });

        btnVoltarListaItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), CadastrarReceitaActivity.class);
                intent.putExtra("receita", r);
                startActivity(intent);
            }
        });
    }

    private void bind() {
        btnCadItemReceita = (Button) findViewById(R.id.btnCadItemReceita);
        btnCadReceitaComItens = (Button) findViewById(R.id.btnCadReceitaComItens);
        btnVoltarListaItem = (Button) findViewById(R.id.btnVoltarListaItem);
        lvItensReceita = (ListView) findViewById(R.id.lvItensReceita);
    }
}
