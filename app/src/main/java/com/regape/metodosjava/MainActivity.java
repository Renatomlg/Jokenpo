package com.regape.metodosjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view) {
        this.opcaoSelecionada("Pedra");

    }

    public void selecionadoPapel(View view) {
        this.opcaoSelecionada("Papel");

    }

    public void selecionadoTesoura(View view) {
        this.opcaoSelecionada("Tesoura");

    }

    public void opcaoSelecionada(String escolhaUsuario) {

        ImageView imagemResultado = findViewById(R.id.resultado); // troca imagem
        TextView textResultado = findViewById(R.id.mensagem); // troca texto


        int num = new Random().nextInt(3);
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        String escolhaApp = opcoes[num];

        switch (escolhaApp) {
            case "Pedra":
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "Papel":
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;


        }
        if (
                (escolhaApp == "Tesoura" && escolhaUsuario == "Papel") ||
                        (escolhaApp == "Papel" && escolhaUsuario == "Pedra") ||
                        (escolhaApp == "Pedra" && escolhaUsuario == "Tesoura")
        ) { // App ganhador
            textResultado.setText("Você Perdeu! :(");

        } else if (
                (escolhaApp == "Papel" && escolhaUsuario == "Tesoura") ||
                        (escolhaApp == "Pedra" && escolhaUsuario == "Papel") ||
                        (escolhaApp == "Tesoura" && escolhaUsuario == "Pedra")

        ) { //Usuario Ganhador
            textResultado.setText("Você Ganhou! :)");


        } else { // Empate

            textResultado.setText("Empate! :|");
        }


    }

}
