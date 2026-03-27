# 📱 Cadastro de Usuários - Android

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Status](https://img.shields.io/badge/status-em%20desenvolvimento-yellow?style=for-the-badge)

## 📌 Sobre o Projeto
Este projeto é um aplicativo Android desenvolvido em Java com o objetivo de realizar o cadastro simples de usuários. O sistema permite inserir nome e e-mail e exibir essas informações em uma lista dinâmica utilizando RecyclerView. O projeto foi criado com foco educacional para demonstrar conceitos fundamentais do desenvolvimento Android, como navegação entre telas, manipulação de listas e atualização de interface.

## ✨ Funcionalidades
✔️ Cadastro de usuários com nome e e-mail  
✔️ Exibição dos usuários em lista dinâmica  
✔️ Navegação entre telas (Activities)  
✔️ Atualização automática da lista ao retornar  

## 🧱 Estrutura do Projeto
com.example.cadastrousuario  
- MainActivity.java → Tela principal com lista de usuários  
- CreateUser.java → Tela de cadastro  
- UserAdapter.java → Adaptador do RecyclerView  

## 🧩 Funcionamento do Sistema
Ao iniciar o aplicativo, o usuário visualiza uma lista de nomes na tela principal. Caso não existam usuários cadastrados, é exibido um item padrão. Ao clicar no botão de cadastro, o usuário é redirecionado para outra tela onde pode inserir nome e e-mail. Ao salvar, o usuário é adicionado à lista e a aplicação retorna automaticamente para a tela principal, que é atualizada dinamicamente.

Os dados são armazenados temporariamente em memória através de uma lista estática:

public static List<String> listaNomes = new ArrayList<>();

A atualização da lista ocorre automaticamente quando a tela volta a ficar ativa:

@Override
protected void onResume(){
    super.onResume();
    adapter.notifyDataSetChanged();
}

## 🏠 MainActivity
Responsável por inicializar o RecyclerView, configurar o LayoutManager, conectar o Adapter e gerenciar a navegação para a tela de cadastro. Também garante que a lista seja atualizada sempre que o usuário retornar.

## ➕ CreateUser
Responsável por capturar os dados inseridos pelo usuário, validar o nome e adicionar o novo usuário à lista antes de retornar à tela principal.

if(!nome.isEmpty()){
    MainActivity.listaNomes.add(nome +"("+email+")");
    finish();
}

## 📋 UserAdapter
Classe responsável por conectar os dados ao RecyclerView. Gerencia a criação dos itens da lista, a associação dos dados e a quantidade de elementos exibidos. Utiliza o padrão ViewHolder para melhorar a performance e evitar chamadas repetidas ao findViewById.

## 🔄 Fluxo da Aplicação
MainActivity → CreateUser → MainActivity (lista atualizada)

## 🚀 Tecnologias Utilizadas
- Java  
- Android SDK  
- RecyclerView  
- Material Design (TextInputEditText)  

## ⚠️ Limitações
- Os dados não são persistidos (armazenamento apenas em memória)  
- Não há validação de e-mail  
- Não é possível editar ou excluir usuários  

## 💡 Melhorias Futuras
- Implementar persistência de dados com SQLite ou Firebase  
- Adicionar validação de e-mail  
- Permitir edição e exclusão de usuários  
- Melhorar o design da interface  


## 📄 Licença
Este projeto é destinado para fins acadêmicos e aprendizado.
