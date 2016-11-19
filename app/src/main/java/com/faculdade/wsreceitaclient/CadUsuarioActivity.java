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

public class CadUsuarioActivity extends AppCompatActivity {

    Button btnCadUser, btnTelaLogin;
    EditText edtCadLogin, edtCadSenha, edtCrm, edtNome;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_usuario);

        bind();

        btnCadUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Usuario u = new Usuario();
                u.setLogin(edtCadLogin.getText().toString());
                u.setSenha(edtCadSenha.getText().toString());

                String txtCrm = edtCrm.getText().toString();

                if (txtCrm != "") {
                    u.getMedico().setCrm(txtCrm);
                    u.getMedico().setNome(edtNome.getText().toString());
                } else {
                    u.setMedico(null);
                }

                String message = new UsuarioController().CadastrarUsuario(u);

                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
            }
        });

        btnTelaLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), LoginActivity.class);

                startActivity(intent);
            }
        });
    }

    private void bind() {
        btnCadUser = (Button) findViewById(R.id.btnCadUser);
        btnTelaLogin = (Button) findViewById(R.id.btnTelaLogin);
        edtCadLogin = (EditText) findViewById(R.id.edtCadLogin);
        edtCadSenha = (EditText) findViewById(R.id.edtCadSenha);
        edtCrm = (EditText) findViewById(R.id.edtCrm);
        edtNome = (EditText) findViewById(R.id.edtNome);
    }
}
