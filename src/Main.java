import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private Scanner scanner;
    private Locadora locadora;
    private ArrayList<Cliente> clientes;
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Locacao> locacoes;

    public Main() {
        this.scanner = new Scanner(System.in);
        this.locadora = new Locadora("Locadora Central");
        this.clientes = new ArrayList<Cliente>();
        this.funcionarios = new ArrayList<Funcionario>();
        this.locacoes = new ArrayList<Locacao>();

        Carro carroInicial = new Carro("ABC-1111", "Fiat Pulse", 120.0, 30.0);
        Moto motoInicial = new Moto("XYZ-2222", "Honda CG 160", 80.0, 10.0);
        Caminhao caminhaoInicial = new Caminhao("TRK-3333", "Volvo FH", 300.0, 150.0);

        this.locadora.adicionarVeiculo(carroInicial);
        this.locadora.adicionarVeiculo(motoInicial);
        this.locadora.adicionarVeiculo(caminhaoInicial);

        this.clientes.add(new Cliente("Carlos Silva", "123.456.789-00"));
        this.funcionarios.add(new Funcionario("Ana Souza"));
    }

    public void menuPrincipal() {
        while (true) {
            System.out.println("\n==============================");
            System.out.println("Sistema da " + this.locadora.getNome());
            System.out.println("==============================");
            System.out.println("1 - Veículos (Frota)");
            System.out.println("2 - Clientes");
            System.out.println("3 - Funcionários");
            System.out.println("4 - Locações");
            System.out.println("0 - Sair");
            System.out.println("==============================");
            System.out.print("Digite uma opção: ");
            String opcao = this.scanner.nextLine();

            if (opcao.equals("1")) {
                this.menuVeiculos();
            } else if (opcao.equals("2")) {
                this.menuClientes();
            } else if (opcao.equals("3")) {
                this.menuFuncionarios();
            } else if (opcao.equals("4")) {
                this.menuLocacoes();
            } else if (opcao.equals("0")) {
                System.out.println("Aplicação encerrada");
                break;
            } else {
                System.out.println("Opção inválida");
            }
        }
    }

    public void menuVeiculos() {
        while (true) {
            System.out.println("\n==============================");
            System.out.println("Veículos (Frota)");
            System.out.println("==============================");
            System.out.println("1 - Listar Todos (Polimorfismo)");
            System.out.println("2 - Buscar por ID");
            System.out.println("3 - Inserir Carro");
            System.out.println("4 - Inserir Moto");
            System.out.println("5 - Inserir Caminhão");
            System.out.println("6 - Testar Reserva Direta via Interface Alugavel");
            System.out.println("0 - Voltar");
            System.out.println("==============================");
            System.out.print("Digite uma opção: ");
            String opcao = this.scanner.nextLine();

            if (opcao.equals("1")) {
                this.listarVeiculos();
            } else if (opcao.equals("2")) {
                this.buscarVeiculo();
            } else if (opcao.equals("3")) {
                this.inserirCarro();
            } else if (opcao.equals("4")) {
                this.inserirMoto();
            } else if (opcao.equals("5")) {
                this.inserirCaminhao();
            } else if (opcao.equals("6")) {
                this.testarInterfaceAlugavel();
            } else if (opcao.equals("0")) {
                break;
            } else {
                System.out.println("Opção inválida");
            }
        }
    }

    public void listarVeiculos() {
        ArrayList<Veiculo> frota = this.locadora.getVeiculos();
        if (frota.size() == 0) {
            System.out.println("Nenhum veículo encontrado");
            return;
        }
        for (int i = 0; i < frota.size(); i++) {
            Veiculo veiculo = frota.get(i);
            String status = "Disponível";
            if (!veiculo.isDisponivel()) {
                status = "Alugado";
            }
            System.out.println("ID = " + veiculo.getIdentificador() + " | " + veiculo.obterDescricao()
                    + " | Diária Final = R$ " + veiculo.calcularValorDiaria() + " | Status = " + status);
        }
    }

    public void buscarVeiculo() {
        System.out.print("Digite o ID do veículo: ");
        int identificadorBusca = Integer.parseInt(this.scanner.nextLine());

        Veiculo veiculo = this.locadora.buscarVeiculoPorId(identificadorBusca);
        if (veiculo != null) {
            System.out.println("ID = " + veiculo.getIdentificador() + " | " + veiculo.obterDescricao()
                    + " | Diária Final = R$ " + veiculo.calcularValorDiaria());
        } else {
            System.out.println("Veículo não encontrado");
        }
    }

    public void testarInterfaceAlugavel() {
        ArrayList<Veiculo> frota = this.locadora.getVeiculos();
        System.out.println("\n--- Teste da Interface Alugavel ---");
        for (int i = 0; i < frota.size(); i++) {
            Alugavel itemAlugavel = frota.get(i);
            itemAlugavel.reservar();
            itemAlugavel.devolver();
        }
    }

    public void inserirCarro() {
        System.out.print("Placa: ");
        String placa = this.scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = this.scanner.nextLine();
        System.out.print("Valor da diária base: ");
        double valorDiaria = Double.parseDouble(this.scanner.nextLine());
        System.out.print("Taxa de limpeza: ");
        double taxaLimpeza = Double.parseDouble(this.scanner.nextLine());

        Carro novoCarro = new Carro(placa, modelo, valorDiaria, taxaLimpeza);
        this.locadora.adicionarVeiculo(novoCarro);
        System.out.println("Carro inserido com sucesso (ID = " + novoCarro.getIdentificador() + ")");
    }

    public void inserirMoto() {
        System.out.print("Placa: ");
        String placa = this.scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = this.scanner.nextLine();
        System.out.print("Valor da diária base: ");
        double valorDiaria = Double.parseDouble(this.scanner.nextLine());
        System.out.print("Desconto econômico: ");
        double descontoEconomico = Double.parseDouble(this.scanner.nextLine());

        Moto novaMoto = new Moto(placa, modelo, valorDiaria, descontoEconomico);
        this.locadora.adicionarVeiculo(novaMoto);
        System.out.println("Moto inserida com sucesso (ID = " + novaMoto.getIdentificador() + ")");
    }

    public void inserirCaminhao() {
        System.out.print("Placa: ");
        String placa = this.scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = this.scanner.nextLine();
        System.out.print("Valor da diária base: ");
        double valorDiaria = Double.parseDouble(this.scanner.nextLine());
        System.out.print("Adicional de carga: ");
        double adicionalCarga = Double.parseDouble(this.scanner.nextLine());

        Caminhao novoCaminhao = new Caminhao(placa, modelo, valorDiaria, adicionalCarga);
        this.locadora.adicionarVeiculo(novoCaminhao);
        System.out.println("Caminhão inserido com sucesso (ID = " + novoCaminhao.getIdentificador() + ")");
    }

    public void menuClientes() {
        while (true) {
            System.out.println("\n==============================");
            System.out.println("Clientes");
            System.out.println("==============================");
            System.out.println("1 - Listar Todos");
            System.out.println("2 - Buscar por Código");
            System.out.println("3 - Inserir");
            System.out.println("4 - Remover");
            System.out.println("0 - Voltar");
            System.out.println("==============================");
            System.out.print("Digite uma opção: ");
            String opcao = this.scanner.nextLine();

            if (opcao.equals("1")) {
                this.listarClientes();
            } else if (opcao.equals("2")) {
                this.buscarCliente();
            } else if (opcao.equals("3")) {
                this.inserirCliente();
            } else if (opcao.equals("4")) {
                this.removerCliente();
            } else if (opcao.equals("0")) {
                break;
            } else {
                System.out.println("Opção inválida");
            }
        }
    }

    public void listarClientes() {
        if (this.clientes.size() == 0) {
            System.out.println("Nenhum registro encontrado");
            return;
        }
        for (int i = 0; i < this.clientes.size(); i++) {
            Cliente cliente = this.clientes.get(i);
            System.out.println("Código = " + i + " | Nome = " + cliente.getNome() + " | CPF = "
                    + cliente.getDocumentoCpf());
        }
    }

    public void buscarCliente() {
        System.out.print("Digite o código do cliente: ");
        int codigoCliente = Integer.parseInt(this.scanner.nextLine());

        if (codigoCliente >= 0 && codigoCliente < this.clientes.size()) {
            Cliente cliente = this.clientes.get(codigoCliente);
            System.out.println("Código = " + codigoCliente + " | Nome = " + cliente.getNome()
                    + " | CPF = " + cliente.getDocumentoCpf());
        } else {
            System.out.println("Cliente não encontrado");
        }
    }

    public void inserirCliente() {
        System.out.print("Nome: ");
        String nome = this.scanner.nextLine();
        System.out.print("CPF: ");
        String documentoCpf = this.scanner.nextLine();

        Cliente novoCliente = new Cliente(nome, documentoCpf);
        this.clientes.add(novoCliente);
        System.out.println("Registro inserido com sucesso");
    }

    public void removerCliente() {
        System.out.print("Código do cliente para remover: ");
        int codigo = Integer.parseInt(this.scanner.nextLine());

        if (codigo >= 0 && codigo < this.clientes.size()) {
            this.clientes.remove(codigo);
            System.out.println("Registro removido com sucesso");
        } else {
            System.out.println("Código inválido");
        }
    }

    public void menuFuncionarios() {
        while (true) {
            System.out.println("\n==============================");
            System.out.println("Funcionários");
            System.out.println("==============================");
            System.out.println("1 - Listar Todos");
            System.out.println("2 - Inserir");
            System.out.println("0 - Voltar");
            System.out.println("==============================");
            System.out.print("Digite uma opção: ");
            String opcao = this.scanner.nextLine();

            if (opcao.equals("1")) {
                this.listarFuncionarios();
            } else if (opcao.equals("2")) {
                this.inserirFuncionario();
            } else if (opcao.equals("0")) {
                break;
            } else {
                System.out.println("Opção inválida");
            }
        }
    }

    public void listarFuncionarios() {
        if (this.funcionarios.size() == 0) {
            System.out.println("Nenhum registro encontrado");
            return;
        }
        for (int i = 0; i < this.funcionarios.size(); i++) {
            Funcionario funcionario = this.funcionarios.get(i);
            System.out.println("Código = " + i + " | Nome = " + funcionario.getNome());
        }
    }

    public void inserirFuncionario() {
        System.out.print("Nome do funcionário: ");
        String nome = this.scanner.nextLine();

        Funcionario novoFuncionario = new Funcionario(nome);
        this.funcionarios.add(novoFuncionario);
        System.out.println("Registro inserido com sucesso");
    }

    public void menuLocacoes() {
        while (true) {
            System.out.println("\n==============================");
            System.out.println("Locações");
            System.out.println("==============================");
            System.out.println("1 - Listar Todas");
            System.out.println("2 - Registrar Nova Locação");
            System.out.println("3 - Calcular Multa por Atraso");
            System.out.println("4 - Devolver Veículo (Encerrar)");
            System.out.println("0 - Voltar");
            System.out.println("==============================");
            System.out.print("Digite uma opção: ");
            String opcao = this.scanner.nextLine();

            if (opcao.equals("1")) {
                this.listarLocacoes();
            } else if (opcao.equals("2")) {
                this.inserirLocacao();
            } else if (opcao.equals("3")) {
                this.calcularMultaLocacao();
            } else if (opcao.equals("4")) {
                this.devolverVeiculoLocacao();
            } else if (opcao.equals("0")) {
                break;
            } else {
                System.out.println("Opção inválida");
            }
        }
    }

    public void listarLocacoes() {
        if (this.locacoes.size() == 0) {
            System.out.println("Nenhum registro encontrado");
            return;
        }
        for (int i = 0; i < this.locacoes.size(); i++) {
            Locacao locacao = this.locacoes.get(i);
            System.out.println("Código = " + i + " | Cliente = " + locacao.getCliente().getNome()
                    + " | Veículo = " + locacao.getVeiculo().getModelo() + " | Dias = " + locacao.getDias()
                    + " | Total Pago = R$ " + locacao.getPagamento().getValorPago());
        }
    }

    public void inserirLocacao() {
        if (this.clientes.size() == 0 || this.funcionarios.size() == 0) {
            System.out.println("Cadastre pelo menos um cliente e um funcionário antes de locar.");
            return;
        }

        this.listarClientes();
        System.out.print("Código do cliente: ");
        int codigoCliente = Integer.parseInt(this.scanner.nextLine());
        if (codigoCliente < 0 || codigoCliente >= this.clientes.size()) {
            System.out.println("Cliente inválido");
            return;
        }
        Cliente clienteEscolhido = this.clientes.get(codigoCliente);

        this.listarFuncionarios();
        System.out.print("Código do funcionário responsável: ");
        int codigoFuncionario = Integer.parseInt(this.scanner.nextLine());
        if (codigoFuncionario < 0 || codigoFuncionario >= this.funcionarios.size()) {
            System.out.println("Funcionário inválido");
            return;
        }
        Funcionario funcionarioEscolhido = this.funcionarios.get(codigoFuncionario);

        this.listarVeiculos();
        System.out.print("ID do veículo: ");
        int identificadorVeiculo = Integer.parseInt(this.scanner.nextLine());
        Veiculo veiculoEscolhido = this.locadora.buscarVeiculoPorId(identificadorVeiculo);

        if (veiculoEscolhido == null) {
            System.out.println("Veículo não encontrado");
            return;
        }
        if (!veiculoEscolhido.isDisponivel()) {
            System.out.println("Este veículo já está alugado no momento");
            return;
        }

        System.out.print("Quantidade de dias da locação: ");
        int dias = Integer.parseInt(this.scanner.nextLine());

        Locacao novaLocacao = new Locacao(clienteEscolhido, veiculoEscolhido, dias);
        this.locacoes.add(novaLocacao);

        funcionarioEscolhido.registrarLocacao(novaLocacao);
        System.out.println("Locação registrada com sucesso!");
    }

    public void calcularMultaLocacao() {
        if (this.locacoes.size() == 0) {
            System.out.println("Nenhuma locação cadastrada");
            return;
        }
        this.listarLocacoes();
        System.out.print("Código da locação: ");
        int codigoLocacao = Integer.parseInt(this.scanner.nextLine());

        if (codigoLocacao >= 0 && codigoLocacao < this.locacoes.size()) {
            Locacao locacao = this.locacoes.get(codigoLocacao);
            System.out.print("Quantidade de dias de atraso: ");
            int diasAtraso = Integer.parseInt(this.scanner.nextLine());

            double multa = locacao.calcularMultaAtraso(diasAtraso);
            System.out.println("Valor da multa por atraso = R$ " + multa);
        } else {
            System.out.println("Código de locação inválido");
        }
    }

    public void devolverVeiculoLocacao() {
        if (this.locacoes.size() == 0) {
            System.out.println("Nenhuma locação cadastrada");
            return;
        }
        this.listarLocacoes();
        System.out.print("Código da locação para encerrar (devolver veículo): ");
        int codigoLocacao = Integer.parseInt(this.scanner.nextLine());

        if (codigoLocacao >= 0 && codigoLocacao < this.locacoes.size()) {
            Locacao locacao = this.locacoes.get(codigoLocacao);
            locacao.encerrarLocacao();
            System.out.println("Devolução concluída com sucesso");
        } else {
            System.out.println("Código de locação inválido");
        }
    }

    public static void main(String[] argumentos) {
        Main aplicacao = new Main();
        aplicacao.menuPrincipal();
    }
}
