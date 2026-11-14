import java.util.ArrayList;
import java.util.Scanner;

// Classe principal que controla os menus interativos e inicia o sistema da locadora
public class Main {

    private Scanner scanner;
    // Associação simples: Main gerencia a instância principal de Locadora e as listas do sistema
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

        this.carregarDadosIniciais();
    }

    private void carregarDadosIniciais() {
        this.locadora.adicionarVeiculo(new Carro("ABC-1111", "Fiat Pulse", 120.0, 30.0));
        this.locadora.adicionarVeiculo(new Moto("XYZ-2222", "Honda CG 160", 80.0, 10.0));
        this.locadora.adicionarVeiculo(new Caminhao("TRK-3333", "Volvo FH", 300.0, 150.0));

        this.clientes.add(new Cliente("Carlos Silva", "123.456.789-00"));
        this.funcionarios.add(new Funcionario("Ana Souza"));
    }

    private String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return this.scanner.nextLine();
    }

    private int lerInteiro(String mensagem) {
        System.out.print(mensagem);
        return Integer.parseInt(this.scanner.nextLine());
    }

    private double lerDecimal(String mensagem) {
        System.out.print(mensagem);
        return Double.parseDouble(this.scanner.nextLine());
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
            String opcao = this.lerTexto("Digite uma opção: ");

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
            String opcao = this.lerTexto("Digite uma opção: ");

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
            // Polimorfismo: obterDescricao() e calcularValorDiaria() variam conforme a subclasse
            System.out.println(
                    "ID = " + veiculo.getId() +
                            " | " + veiculo.obterDescricao() +
                            " | Diária Final = R$ " + veiculo.calcularValorDiaria() +
                            " | Status = " + status);
        }
    }

    public void buscarVeiculo() {
        int idBusca = this.lerInteiro("Digite o ID do veículo: ");
        Veiculo veiculo = this.locadora.buscarVeiculoPorId(idBusca);

        if (veiculo != null) {
            System.out.println(
                    "ID = " + veiculo.getId() +
                            " | " + veiculo.obterDescricao() +
                            " | Diária Final = R$ " + veiculo.calcularValorDiaria());
        } else {
            System.out.println("Veículo não encontrado");
        }
    }

    public void testarInterfaceAlugavel() {
        ArrayList<Veiculo> frota = this.locadora.getVeiculos();
        System.out.println("\n--- Demonstração da Interface Alugavel e Polimorfismo em reservar() ---");
        for (int i = 0; i < frota.size(); i++) {
            // Polimorfismo via interface: cada tipo de veículo executa sua própria reserva
            Alugavel item = frota.get(i);
            item.reservar();
            item.devolver();
        }
    }

    public void inserirCarro() {
        String placa = this.lerTexto("Placa: ");
        String modelo = this.lerTexto("Modelo: ");
        double diaria = this.lerDecimal("Valor da diária base: ");
        double taxaLimpeza = this.lerDecimal("Taxa de limpeza: ");

        Carro novoCarro = new Carro(placa, modelo, diaria, taxaLimpeza);
        this.locadora.adicionarVeiculo(novoCarro);
        System.out.println("Carro inserido com sucesso (ID = " + novoCarro.getId() + ")");
    }

    public void inserirMoto() {
        String placa = this.lerTexto("Placa: ");
        String modelo = this.lerTexto("Modelo: ");
        double diaria = this.lerDecimal("Valor da diária base: ");
        double desconto = this.lerDecimal("Desconto econômico: ");

        Moto novaMoto = new Moto(placa, modelo, diaria, desconto);
        this.locadora.adicionarVeiculo(novaMoto);
        System.out.println("Moto inserida com sucesso (ID = " + novaMoto.getId() + ")");
    }

    public void inserirCaminhao() {
        String placa = this.lerTexto("Placa: ");
        String modelo = this.lerTexto("Modelo: ");
        double diaria = this.lerDecimal("Valor da diária base: ");
        double adicional = this.lerDecimal("Adicional de carga: ");

        Caminhao novoCaminhao = new Caminhao(placa, modelo, diaria, adicional);
        this.locadora.adicionarVeiculo(novoCaminhao);
        System.out.println("Caminhão inserido com sucesso (ID = " + novoCaminhao.getId() + ")");
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
            String opcao = this.lerTexto("Digite uma opção: ");

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
            System.out.println("Código = " + i + " | Nome = " + cliente.getNome() + " | CPF = " + cliente.getCpf());
        }
    }

    public void buscarCliente() {
        int codigo = this.lerInteiro("Digite o código do cliente: ");

        if (codigo >= 0 && codigo < this.clientes.size()) {
            Cliente cliente = this.clientes.get(codigo);
            System.out.println("Código = " + codigo + " | Nome = " + cliente.getNome() + " | CPF = " + cliente.getCpf());
        } else {
            System.out.println("Cliente não encontrado");
        }
    }

    public void inserirCliente() {
        String nome = this.lerTexto("Nome: ");
        String cpf = this.lerTexto("CPF: ");

        Cliente novoCliente = new Cliente(nome, cpf);
        this.clientes.add(novoCliente);
        System.out.println("Registro inserido com sucesso");
    }

    public void removerCliente() {
        int codigo = this.lerInteiro("Código do cliente para remover: ");

        if (codigo >= 0 && codigo < this.clientes.size()) {
            this.clientes.remove(codigo);
            System.out.println("Registro removido com sucesso");
        } else {
            System.out.println("Falha ao remover registro: código inválido");
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
            String opcao = this.lerTexto("Digite uma opção: ");

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
        String nome = this.lerTexto("Nome do funcionário: ");

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
            String opcao = this.lerTexto("Digite uma opção: ");

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
            System.out.println(
                    "Código = " + i +
                            " | Cliente = " + locacao.getCliente().getNome() +
                            " | Veículo = " + locacao.getVeiculo().getModelo() +
                            " | Dias = " + locacao.getDias() +
                            " | Total Pago = R$ " + locacao.getPagamento().getValorPago());
        }
    }

    private Cliente selecionarCliente() {
        this.listarClientes();
        int codigoCliente = this.lerInteiro("Código do cliente: ");
        if (codigoCliente < 0 || codigoCliente >= this.clientes.size()) {
            System.out.println("Cliente inválido");
            return null;
        }
        return this.clientes.get(codigoCliente);
    }

    private Funcionario selecionarFuncionario() {
        this.listarFuncionarios();
        int codigoFuncionario = this.lerInteiro("Código do funcionário responsável: ");
        if (codigoFuncionario < 0 || codigoFuncionario >= this.funcionarios.size()) {
            System.out.println("Funcionário inválido");
            return null;
        }
        return this.funcionarios.get(codigoFuncionario);
    }

    private Veiculo selecionarVeiculoDisponivel() {
        this.listarVeiculos();
        int idVeiculo = this.lerInteiro("ID do veículo: ");
        Veiculo veiculoEscolhido = this.locadora.buscarVeiculoPorId(idVeiculo);

        if (veiculoEscolhido == null) {
            System.out.println("Veículo não encontrado");
            return null;
        }
        if (!veiculoEscolhido.isDisponivel()) {
            System.out.println("Este veículo já está alugado no momento");
            return null;
        }
        return veiculoEscolhido;
    }

    public void inserirLocacao() {
        if (this.clientes.size() == 0 || this.funcionarios.size() == 0) {
            System.out.println("Cadastre pelo menos um cliente e um funcionário antes de locar.");
            return;
        }

        Cliente clienteEscolhido = this.selecionarCliente();
        if (clienteEscolhido == null) {
            return;
        }

        Funcionario funcionarioEscolhido = this.selecionarFuncionario();
        if (funcionarioEscolhido == null) {
            return;
        }

        Veiculo veiculoEscolhido = this.selecionarVeiculoDisponivel();
        if (veiculoEscolhido == null) {
            return;
        }

        int dias = this.lerInteiro("Quantidade de dias da locação: ");

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
        int codigoLocacao = this.lerInteiro("Código da locação: ");

        if (codigoLocacao >= 0 && codigoLocacao < this.locacoes.size()) {
            Locacao locacao = this.locacoes.get(codigoLocacao);
            int diasAtraso = this.lerInteiro("Quantidade de dias de atraso: ");

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
        int codigoLocacao = this.lerInteiro("Código da locação para encerrar (devolver veículo): ");

        if (codigoLocacao >= 0 && codigoLocacao < this.locacoes.size()) {
            Locacao locacao = this.locacoes.get(codigoLocacao);
            locacao.encerrarLocacao();
            System.out.println("Devolução concluída com sucesso");
        } else {
            System.out.println("Código de locação inválido");
        }
    }

    public static void main(String[] args) {
        Main sistema = new Main();
        sistema.menuPrincipal();
    }
}
