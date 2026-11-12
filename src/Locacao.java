public class Locacao {

    private Cliente cliente;

    private Veiculo veiculo;

    private int dias;

    private Pagamento pagamento;

    public Locacao(Cliente cliente, Veiculo veiculo, int dias) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dias = dias;

        this.realizarReserva(this.veiculo);

        double diariaCalculada = this.veiculo.calcularValorDiaria();
        this.pagamento = new Pagamento(diariaCalculada, dias);
    }

    public void realizarReserva(Alugavel itemAlugavel) {
        itemAlugavel.reservar();
    }

    public double calcularMultaAtraso(int diasAtraso) {
        CalculadoraDeMulta calculadora = new CalculadoraDeMulta();
        return calculadora.calcularMulta(diasAtraso);
    }

    public void encerrarLocacao() {
        Alugavel itemAlugavel = this.veiculo;
        itemAlugavel.devolver();
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public Veiculo getVeiculo() {
        return this.veiculo;
    }

    public int getDias() {
        return this.dias;
    }

    public Pagamento getPagamento() {
        return this.pagamento;
    }
}