MANUAL DE INSTRUÇÕES — SISTEMA DE LOCADORA DE VEÍCULOS
======================================================

1. PRÉ-REQUISITOS
-----------------
- Java Development Kit (JDK 8 ou superior) instalado.
- Verifique no terminal digitando:
  javac -version

2. ARQUIVOS DO PROJETO
----------------------
Certifique-se de que todos os 12 arquivos .java estão na mesma pasta:
- Alugavel.java
- Veiculo.java
- Carro.java
- Moto.java
- Caminhao.java
- Cliente.java
- Pagamento.java
- CalculadoraDeMulta.java
- Locacao.java
- Funcionario.java
- Locadora.java
- Main.java

3. COMO COMPILAR PELO TERMINAL
------------------------------
1. Abra o terminal na pasta onde estão os arquivos.
2. Execute o comando abaixo para compilar todas as classes:
   javac *.java

4. COMO EXECUTAR PELO TERMINAL
------------------------------
1. Na mesma pasta, inicie o sistema executando:
   java Main

5. ROTEIRO DE USO DO MENU INTERATIVO
------------------------------------
O sistema já inicia com 3 veículos (1 Carro, 1 Moto e 1 Caminhão), 1 Cliente e 1 Funcionário pré-cadastrados para facilitar os testes:

- Para ver o Polimorfismo (calcularValorDiaria e obterDescricao):
  Digite "1" (Veículos) e depois "1" (Listar Todos).

- Para testar a Interface Alugavel e o Polimorfismo em reservar():
  Digite "1" (Veículos) e depois "6" (Testar Reserva Direta via Interface Alugavel).

- Para registrar uma Locação (Composição com Pagamento e uso de Alugavel):
  No menu principal, digite "4" (Locações) -> "2" (Registrar Nova Locação).
  Informe o código do cliente (0), código do funcionário (0), ID do veículo (1) e a quantidade de dias (ex.: 4).

- Para testar a Dependência com CalculadoraDeMulta:
  No menu "4" (Locações), escolha a opção "3" (Calcular Multa por Atraso), informe o código da locação (0) e os dias de atraso (ex.: 2).

- Para devolver um veículo via Interface Alugavel:
  No menu "4" (Locações), escolha a opção "4" (Devolver Veículo) e informe o código da locação (0).