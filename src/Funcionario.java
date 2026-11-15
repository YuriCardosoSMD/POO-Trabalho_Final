public class Funcionario {

    private String nome;

    public Funcionario(String nome) {
        this.nome = nome;
    }

    public void registrarLocacao(Locacao locacao) {
        Veiculo veiculo = locacao.getVeiculo();
        System.out.println("Funcionário " + this.nome + " registrou a locação:");
        System.out.println("  Cliente: " + locacao.getCliente().getNome());
        System.out.println("  Veículo: " + veiculo.obterDescricao());
        System.out.println("  Dias: " + locacao.getDias());
        System.out.println("  Valor Total Pago: R$ " + locacao.getPagamento().getValorPago());
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
