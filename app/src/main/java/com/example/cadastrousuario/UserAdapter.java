package com.example.cadastrousuario;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

//Classes adapter:gerencia a criação eo preenchimento dos itens na RecycleView
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{
    //Atributo privado que armazena a referencia dos dados que serão exibidos
    private List<String> listaUsuarios;

    //Construtor que permite que a MainActivity "entregue" a lista de dados para este adapter
    public UserAdapter(List<String>lista){
        this.listaUsuarios = lista;

    }

    //metodo 1:Cria do zero o visual de uma linha da lista (+ViewHolder)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        //LayoutInflater transforma o arquivo XML em um objeto View java
        //Aqui usamos um Layout padrão do Android(simple_list_item_1)para facilitar
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1,parent, false);

        //Retorna uma nova transferencia da nossa classe interna ViewHolder coma a view Criada
        return new ViewHolder(view);
    }

    //Metodo 2: Vincula os dados de um objeto de lista a uma linha especifica da tela
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,int position){
        //Recupera os dados da lista de acordo com a posição que o android esta desenhando agora
        String nome = listaUsuarios.get(position);

        //define o texto no componente visual que esta guardado dentro de 'holder'
        holder.tvNome.setText(nome);
    }

    //metodo 3: informa ao android quanto itens a lista possui ao todo
    @Override
    public int getItemCount(){
        //se a lista existir, retorna o tamanho. Se não, retorna zero
        return listaUsuarios != null ? listaUsuarios.size():0;
    }

    //classe interna ViewHolder:servir para "segurar" as referências de cada linha
    //isso evita chamadas respectivas ao findViewByid melhorando a performance do RecycleView
    public class ViewHolder extends  RecyclerView.ViewHolder{
            // Referência para o TextView da linha
        TextView tvNome;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            //faz o mapeamento do ID do layout para o objeto java
            //android.R.id.text1 é o ID padrão do layout 'simple_list_item1
            tvNome = itemView.findViewById((android.R.id.text1));
        }

    }

}
