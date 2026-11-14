// Classe que representa o funcionário responsável por registrar o atendimento de locação
public class Funcionario {

    private String nome;

    public Funcionario(String nome) {
        this.nome = nome;
    }

    // Dependência: recebe Locacao como parâmetro para exibir o comprovante sem armazená-la
    public void registrarLocacao(Locacao locacao) {
        Veiculo veiculo = locacao.getVeiculo();
        System.out.println("Funcionário " + this.nome + " registrou a locação:");
        System.out.println("  Cliente: " + locacao.getCliente().getNome());
        // Polimorfismo: chama obterDescricao() que executa a versão específica da subclasse
        System.out.println("  Veículo: " + veiculo.obterDescricao());
        System.out.println("  Dias: " + locacao.getDias());
        System.out.println("  Valor Total Pago: R$ " + locacao.getPagamento().getValorPago());
    }

    public String getNome() {
        return this.nome;
    }
}
