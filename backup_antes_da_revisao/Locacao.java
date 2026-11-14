// Classe que representa o contrato de locação de um veículo por um cliente
public class Locacao {

    // Associação simples: Locacao referencia um Cliente já existente no sistema
    private Cliente cliente;

    // Associação simples: Locacao referencia um Veiculo disponível da frota
    private Veiculo veiculo;

    private int dias;

    // Composição: Pagamento é criado dentro da Locacao e não existe sem ela
    private Pagamento pagamento;

    public Locacao(Cliente cliente, Veiculo veiculo, int dias) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dias = dias;

        this.realizarReserva(this.veiculo);

        // Polimorfismo: calcula a diária conforme o tipo real do veículo (Carro, Moto ou Caminhao)
        double diariaCalculada = this.veiculo.calcularValorDiaria();
        this.pagamento = new Pagamento(diariaCalculada, dias);
    }

    // Polimorfismo via interface Alugavel para reservar o veículo
    public void realizarReserva(Alugavel itemAlugavel) {
        itemAlugavel.reservar();
    }

    // Dependência: instancia CalculadoraDeMulta apenas durante a execução do cálculo
    public double calcularMultaAtraso(int diasAtraso) {
        CalculadoraDeMulta calculadora = new CalculadoraDeMulta();
        return calculadora.calcularMulta(diasAtraso);
    }

    // Polimorfismo via interface Alugavel para devolver o veículo e liberá-lo na frota
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
