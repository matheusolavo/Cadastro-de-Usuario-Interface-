package com.example.cadastrousuario;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //Declarção dos componentes visuais e do adaptador da lista

    RecyclerView recyclerView;
    UserAdapter adapter;
    Button btnCadastrar;

    //Atenção: Atributo estatico (static) permite que os dados persistem na memoria
    //enquanto o app estiver aberto e sejam acessados diretamente por outras telas(activities)
    public static List<String> listaNomes = new ArrayList<>();

    //metodo de inicialização da activity (ponto de entrada da tela)

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //Vincula o arquivo da layout xml (activity_main.xml) a essa classe java
        setContentView(R.layout.activity_main);
        //regra de negocio: insere um texto no topo da lista, caso ela esteja vazia

        if (listaNomes.isEmpty()){
            listaNomes.add("Nomes de Cadastro");

        }
        //mapeamento dos componentes do RecyclearView do XML para o objeto java
        recyclerView = findViewById(R.id.recycle_view);

        //Define o layoutManager: organiza itens da lista nima coluna vertical simples
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Instancia o adaptador passando a nossa lista de nomes
        adapter = new UserAdapter(listaNomes);

        //Conecta o adaptador ao RecyclearView para que os dados sejam desenhados na tela
        recyclerView.setAdapter(adapter);

        //Mapeia o botão de cadastro
        btnCadastrar = findViewById(R.id.btnCadastrar);

        //Configura o evento de clique usado a expressão lambda (java 8+)
        btnCadastrar.setOnClickListener(v ->{
            startActivity(new Intent(MainActivity.this, CreateUser.class));
        });
    }

    //Metodo chamado sempre que a tela volta a ficar visivel para o usuario
    @Override
    protected void onResume(){
        super.onResume();
        //avisar o adaptador que a fonte de dados (listaNomes)pode ter sido alterada
        //na outra tela, forçando a atualização visual da lista
        adapter.notifyDataSetChanged();

    }


}