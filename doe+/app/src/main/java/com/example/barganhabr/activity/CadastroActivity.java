package com.example.barganhabr.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.barganhabr.R;
import com.example.barganhabr.helper.ConfiguracaoFirebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

public class CadastroActivity extends AppCompatActivity {

    private Button botaoAcessar;
    private EditText campoEmail, campoSenha;
    private Switch tipoAcesso;

    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        inicializarComponetes();
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();

        botaoAcessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = campoEmail.getText().toString();
                String senha = campoSenha.getText().toString();

                if( !email.isEmpty() ) {
                    if (!senha.isEmpty() ) {

                        //Verifica estado do Switch
                        if ( tipoAcesso.isChecked() ) { // Faz Cadastro

                                autenticacao.createUserWithEmailAndPassword(
                                       email, senha
                                ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                       if ( task.isSuccessful()) {
                                            Toast.makeText(CadastroActivity.this,
                                                    "Cadastro realizado com sucesso!",
                                                 Toast.LENGTH_SHORT).show();

                                            //Direcionar para a tela principal do App


                                       } else {
                                            String erroExcecao ="";

                                            try {
                                                throw task.getException();
                                            }catch (FirebaseAuthWeakPasswordException e) {
                                                erroExcecao = "Digite uma senha mais forte!";
                                            }catch (FirebaseAuthInvalidCredentialsException e) {
                                                erroExcecao = "Digite um e-mail válido";
                                            }catch (FirebaseAuthUserCollisionException e) {
                                                erroExcecao = "Esta conta ja foi cadastrada";
                                            }catch (Exception e) {
                                                erroExcecao = "ao cadastrar usuário: " + e.getMessage();
                                                e.printStackTrace();
                                            }

                                            Toast.makeText(CadastroActivity.this, " Erro " + erroExcecao,
                                                    Toast.LENGTH_SHORT).show();
                                       }
                                    }
                                });

                        } else { // Faz Login

                            autenticacao.signInWithEmailAndPassword(
                                    email, senha
                            ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if ( task.isSuccessful() ){
                                        Toast.makeText(CadastroActivity.this,
                                                "Logado com sucesso",
                                                Toast.LENGTH_SHORT).show();

                                        startActivity(new Intent(getApplicationContext(), AnunciosActivity.class));


                                    } else {
                                            Toast.makeText(CadastroActivity.this,
                                                    "Erro ao fazer login: " + task.getException(),
                                                    Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }

                    } else {
                        Toast.makeText(CadastroActivity.this, "Preencha a Senha",
                                Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(CadastroActivity.this, "Preencha o E-mail",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void inicializarComponetes() {
        campoEmail = findViewById(R.id.editCadastroEmail);
        campoSenha = findViewById(R.id.editCadastroSenha);
        botaoAcessar = findViewById(R.id.buttonAcesso);
        tipoAcesso = findViewById(R.id.switchAcesso);
    }
}
