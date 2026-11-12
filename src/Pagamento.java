public class Pagamento {

    private double valorPago;

    public Pagamento(double valorDiaria, int dias) {
        this.valorPago = calcularValorPago(valorDiaria, dias);
    }

    public double calcularValorPago(double valorDiaria, int dias) {
        return valorDiaria * dias;
    }

    public double getValorPago() {
        return this.valorPago;
    }
}