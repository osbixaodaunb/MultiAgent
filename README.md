# Análise de dados em tempo real baseado em multiagentes

## Trabalho de sistemas multi agentes para disciplina de paradigmas

Esta aplicação consiste em coletar dados em tempo real e criar uma nova análise a cada instante de tempo, a aplicabilidade é variada e a solução pode ser utilizada em vários campos como tráfego de rede, variação da bolsa de valores, mercado de moedas, variação de temperatura de um ambiente e varias opções aonde o conceito de Analytics é aplicável.

## Multiagenes utilizados:

    * _InsertAgent_: Insere dados na base;
    * _ReaderAgent_: Pega os dados da base e envia para o _ReceiverAgent_ em tempo real;
    * _ReceiverAgent_: Recebe os dados do _ReaderAgent_ e plota o gráfico em tempo real;

## Comunicação:

 Utilizamos inform para fazer a comunicação entre os agentes
