# DoePlus

DoePlus é um aplicativo Android para gerenciamento de doações, desenvolvido com Java e integrado com Firebase. Este README fornece uma visão geral do projeto, instruções para configuração, uso e contribuição.

## Índice

- [Descrição](#descrição)
- [Funcionalidades](#funcionalidades)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Instalação](#instalação)
- [Uso](#uso)
- [Contribuição](#contribuição)
- [Testes](#testes)
- [Licença](#licença)
- [Contato](#contato)

## Descrição

DoePlus é um aplicativo Android que facilita a administração e o recebimento de doações. O app oferece uma interface amigável para que usuários e organizações possam gerenciar itens doados e acompanhar o status das doações.

## Funcionalidades

- **Cadastro de Itens**: Adicione e gerencie itens disponíveis para doação.
- **Gerenciamento de Doações**: Acompanhe e administre doações feitas e recebidas.
- **Notificações**: Receba notificações sobre atualizações de doações.

## Tecnologias Utilizadas

- **Linguagem de Programação**: Java
- **Plataforma de Desenvolvimento**: [Android Studio](https://developer.android.com/studio)
- **Backend**: [Firebase](https://firebase.google.com/)
  - **Autenticação**: Firebase Authentication
  - **Banco de Dados**: Firebase Realtime Database ou Firestore
  - **Armazenamento**: Firebase Storage (se aplicável)
  - **Notificações**: Firebase Cloud Messaging (se aplicável)

## Instalação

Para configurar o DoePlus no seu ambiente local, siga as etapas abaixo:

1. **Clone o repositório:**

    ```bash
    git clone https://github.com/anderoidy/DoePlus.git
    ```

2. **Abra o projeto no Android Studio:**

    - Inicie o Android Studio.
    - Selecione "Open an existing project".
    - Navegue até o diretório `doe+` e abra o projeto.

3. **Configure o Firebase:**

    - No [Console do Firebase](https://console.firebase.google.com/), crie um novo projeto ou use um existente.
    - Adicione um novo aplicativo Android ao seu projeto Firebase e siga as instruções para baixar o arquivo `google-services.json`.
    - Coloque o arquivo `google-services.json` na pasta `app` do seu projeto Android.

4. **Adicione as dependências do Firebase:**

    - No arquivo `build.gradle` do projeto (nível de projeto), adicione o plugin do Google:

      ```gradle
      buildscript {
          dependencies {
              // Adicione a linha abaixo
              classpath 'com.google.gms:google-services:4.3.15'
          }
      }
      ```

    - No arquivo `build.gradle` do módulo (nível do app), adicione as dependências do Firebase:

      ```gradle
      apply plugin: 'com.google.gms.google-services'

      dependencies {
          // Adicione as linhas abaixo para as dependências do Firebase
          implementation 'com.google.firebase:firebase-auth:22.1.0'
          implementation 'com.google.firebase:firebase-database:20.1.0'
          implementation 'com.google.firebase:firebase-storage:20.1.0'
          // Outras dependências do Firebase conforme necessário
      }
      ```

5. **Sincronize o projeto com os arquivos Gradle**:

    - No Android Studio, clique em "Sync Now" quando solicitado ou use a opção "Sync Project with Gradle Files" no menu.

## Uso

1. **Compile e execute o aplicativo**:
    - Conecte um dispositivo Android ou inicie um emulador.
    - No Android Studio, selecione "Run" para compilar e executar o aplicativo no seu dispositivo ou emulador.

2. **Interaja com o aplicativo**:
    - **Cadastro de Itens**: Use a interface para adicionar novos itens e gerenciar os existentes.
    - **Gerenciamento de Doações**: Acompanhe as doações feitas e recebidas através da interface do aplicativo.

## Contribuição

Contribuições são bem-vindas! Para contribuir com o DoePlus:

1. Faça um fork deste repositório.
2. Crie uma nova branch (`git checkout -b feature/nova-funcionalidade`).
3. Faça suas alterações e commit (`git commit -am 'Adiciona nova funcionalidade'`).
4. Envie para o repositório remoto (`git push origin feature/nova-funcionalidade`).
5. Abra um Pull Request para a branch principal do repositório.

Consulte o arquivo [CONTRIBUTING.md](CONTRIBUTING.md) para diretrizes adicionais sobre como contribuir.

## Testes

Para testar o aplicativo, use os recursos de emulação do Android Studio ou teste em um dispositivo físico. Certifique-se de que as funcionalidades principais, como o cadastro e gerenciamento de itens e doações, estão funcionando conforme esperado.

## Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE). Consulte o arquivo LICENSE para obter detalhes.

## Contato

Para perguntas ou sugestões sobre o DoePlus, entre em contato:

- **Anderson Pereira** 
- **ander.sistemasweb@gmail.com** 
- **https://www.linkedin.com/in/andersistemasweb/** 
