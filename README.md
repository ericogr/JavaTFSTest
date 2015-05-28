#JavaTFSTest
Este é um projeto para demonstrar a utilização do SDK do TFS para Java em uma aplicação JavaFX com Maven.

#Compilação
Para compilar é necessário:
 - Git client
 - Java JDK8
 - Maven 3
 - Acesso a internet

Com estas ferramentas instaladas, vamos baixar o fonte e compilar com o Maven:

```sh
git clone https://github.com/ericogr/JavaTFSTest.git
cd JavaTFSTest
mvn clean install
```
Será criada uma pasta target com os artefatos da compilação dentro. Execute o run.cmd no windows ou run.sh para linux/unix

***Linux***
```sh
cd target
./run.sh
```

***Windows***
```cmd
cd target
./run.cmd
```

#Outras informações
O SDK da Microsoft utiliza bibliotecas nativas e precisa de um parâmetro específico na linha de comando do java para funcionar: 

```sh
-Dcom.microsoft.tfs.jni.native.base-directory="libs/native"
```

Observação: O local "libs/native" deve ser substituído pelo local onde as bibliotecas nativas estão. Note que é a pasta principal, NÃO use a específica de seu SO.

Site oficial com o SDK da Microsoft: https://www.microsoft.com/en-us/download/details.aspx?id=22616
