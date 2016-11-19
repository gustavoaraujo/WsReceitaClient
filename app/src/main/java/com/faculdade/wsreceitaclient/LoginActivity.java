package com.faculdade.wsreceitaclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.faculdade.wsreceitaclient.controller.UsuarioController;
import com.faculdade.wsreceitaclient.model.Usuario;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogar, btnCadastrar;
    private EditText edtLogin, edtSenha;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bind();
        cadastrarClick();
        logarClick();
    }

    private void bind() {
        btnLogar = (Button) findViewById(R.id.btnLogar);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        edtLogin = (EditText) findViewById(R.id.edtLogin);
        edtSenha = (EditText) findViewById(R.id.edtSenha);
    }

    private void cadastrarClick() {
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), CadUsuarioActivity.class);

                startActivity(intent);
            }
        });
    }

    private void logarClick() {
        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario u = new Usuario();
                u.setLogin(edtLogin.getText().toString());
                u.setSenha(edtSenha.getText().toString());

                Usuario result = new UsuarioController().LogarUsuario(u);

                if (result.getLogin() == "") {
                    Toast.makeText(getApplicationContext(), "Deu ruim", Toast.LENGTH_LONG).show();
                } else {
                    Login.usuario = result;
                    if (result.getMedico() == null) {
                        intent = new Intent(getApplicationContext(), MenuFarmaciaActivity.class);
                    } else {
                        intent = new Intent(getApplicationContext(), MenuMedicoActivity.class);
                    }

                    startActivity(intent);
                }
            }
        });
    }
}
