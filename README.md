# Sistema de Locadora de Veículos

Trabalho Final de Programação Orientada a Objetos (Java).

Programa de terminal para gerenciar uma locadora: cadastro de veículos (carro, moto e caminhão), clientes e funcionários, registro de locações, cálculo de multa por atraso e devolução de veículos. Toda a navegação é feita por menus numerados.

---

## 1. Pré-requisitos

- Java JDK 8 ou superior.
- Para verificar a instalação, digite no terminal:

```
javac -version
```

---

## 2. Estrutura do projeto

```
POO-Trabalho_Final/
├── src/          → código-fonte (.java)
│   ├── Alugavel.java
│   ├── Veiculo.java
│   ├── Carro.java
│   ├── Moto.java
│   ├── Caminhao.java
│   ├── Cliente.java
│   ├── Funcionario.java
│   ├── Pagamento.java
│   ├── CalculadoraDeMulta.java
│   ├── Locacao.java
│   ├── Locadora.java
│   └── Main.java
├── bin/          → arquivos compilados (.class), gerados automaticamente
└── README.md
```

---

## 3. Como executar

### Opção A — VS Code
1. Abra a pasta `POO-Trabalho_Final` no VS Code (com a extensão *Extension Pack for Java*).
2. Abra o arquivo `src/Main.java`.
3. Clique em **Run**, acima do método `main`, ou pressione **F5**.
4. Use o terminal do VS Code para interagir com os menus.

### Opção B — Terminal
Na pasta `POO-Trabalho_Final`, execute:

```
javac -encoding UTF-8 -d bin src/*.java
java -cp bin Main
```

> Se o* acentos aparec*rem errados no terminal do Windows* execute `chcp 65001` ant*s.

---

## 4.*Dados pré-cadastrados

|*Tipo        | Registro            *                               |*Identificação |
|-------------|---*----------------------------------*--------------|---------------|
| *arro       | Fi*t Pulse — ABC-1111 — diária R$ 120*00 * limpeza R$ 30,00 | ID 1 |
| Mo*o        | Honda CG 160 — XYZ-2222*— diária R* 80,00 − desconto R$ 10,00 | ID 2*|
| Caminhão    | Volvo FH — TRK-3*33*— diária R$ 300,00 + carga R* 150,00 | ID 3 |
| Cliente     | C*r*os Silva — CPF 123.456.789-*0                   | Código 0    * |*| Funcionário | Ana Souza         *                                 |*Código 0      |

---

## 5. Men*s

Digite o número da opção e pres*ione **Enter**. A opção **0** volt* ao menu anter*or (no menu principal, encerra*o sistema).

### Menu principal
| *pção | Função |
|-*-----|--------|
| 1 | Veículos (*rota) |
| 2 | Clientes |
| 3 | Fun*ionários |
| 4 | Locações |
| 0 | *air |*
### 1 — Veículos (Frota)
| Opção * Função |*|-------|--------|
| 1 | L*sta todos os veículos (ID, descriç*o, diária final e*status) |
| 2 | Busca um veículo*pelo ID |
| 3 | Cadastra um carro **laca, modelo, diária base, taxa de*lim*eza) |
| 4 | Cadastra uma moto (pl*ca, modelo, diária base, desconto *conômico) |*| 5 | Cadastra um caminhão (placa,*modelo,*diária base, adicional de carga) |*| 6 | Test* a interface `Alugavel`: reserva e*devolve cada veículo*|

### 2 — Clientes
| Opção | Funç*o |
|-------*--------|
| 1 | Lista todos os*clientes |
| 2 | Busca um cliente *elo código |
| 3 | Cadast*a um cliente (nome e*CPF) |
| 4 | Remove um cliente pel* código |*
### 3 — Funcionários
| Opção | Fu*ção |
|-------|*-------|
| 1 | Lista todos os func*onários |
| 2*| Cadastra um funcionário (nome)*|

### 4 — Locações
| Opção | Funç*o |
|-------|*-------|
| 1 | Lista as locações (*liente, ve*culo, dias e total pago) |
| 2 * Registra uma locação (cliente, fu*cionário, veículo dispon*vel e dias) |
| 3 | Calcula a mult* por*atraso de uma locação |
| 4 |*Encerra a locação e devolve o veíc*lo |*
---

## 6. Regras de cálculo

| C*lculo | F*rmula |
|---------|---------|
| Di*ria do*carro | diária base + taxa de limp*za |
| Diária da moto | diária bas* − desconto econômico |
| Diária d* caminhão | di*ria base + adicional de carga |
| *otal da locação | diária final × d*as |
| Multa por atraso | R$ 50,00*× dias de*atraso |

---

## 7. Exemplo rápid* de uso

1* Menu principal → **4***(Locações) → **2** (Registrar Nova*Locação).
2.*Código do cliente: **0** ·*Código do funcionário: **0** · ID *o veículo: **1** ·*Dias: **3**.
3. O sistema most*a o resumo com total de **R$ 450,0*** (R$ 150,00 × 3).
4. Op*ão **3** → locação **0** → **2** d*as de atraso*→ multa de **R$ 100,00**.
5* Opção **4** → locação **0** → o v*ículo volta a fic*r **Disponível**.

---

## 8.*Conceitos de POO demonstrados*
| Conceito | Onde ver no sistema *
|*---------|---------------------|
|*Herança |*`Carro`, `Moto` e `Camin*ao` herdam de `Veiculo` |
| Class* abstrata e interface | `Veicul*` (abstrata) e `Alugavel`*(interface) |
| Polimorfismo |*Veículos → opção 1 (`calcularValor*ia*ia`, `obterDescricao`) e opção * (`reservar`, `devolver`) |*| Composição | `Locacao` cria o se* `Pagamento`* `Main` cria a `Locadora` |
| Agre*ação | `Locadora` guarda a*lista de `Veiculo` |
| Associação *imples | `Locacao` possui `Cliente* e `Veiculo* |
| Dependência | `Locacao` usa `*alculadora*eMulta` (Locações → opção 3) |
| M*mbros estáticos | `contadorVeiculo*` e `*erarProximoId()` geram o*ID dos veículos |

---*
## 9. Cuidados

- Em campos num*ricos, digite **apenas números**. *et*as ou campo vazio encerram o progr*ma com erro*
- Use **ponto** como separador de*imal (ex.: `120.50`).
- IDs de veí*ulos começam em **1**.*Códigos de clientes, funcionários * locações começam em **0**.*- Ao remover um cliente, os código* seguintes diminuem em 1. Liste no*amente antes de escolher.*- Um veículo alugado só pode ser l*cado de novo depois de devolvido.
* A mult* é apenas exibida; não é somada ao*total da*locação.
- A opção 6 de Veículos d*ixa todos os veículos disponíveis *o final, inclusive os alugados.
- *s d*dos ficam só na memória e são perd*dos ao sair do programa.