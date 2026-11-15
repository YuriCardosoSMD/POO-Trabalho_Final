public class CalculadoraDeMulta {

    private double valorPorDiaAtraso;

    public CalculadoraDeMulta() {
        this.valorPorDiaAtraso = 50.0;
    }

    public double calcularMulta(int diasAtraso) {
        return diasAtraso * this.valorPorDiaAtraso;
    }

    public double getValorPorDiaAtraso() {
        return this.valorPorDiaAtraso;
    }

    public void setValorPorDiaAtraso(double valorPorDiaAtraso) {
        this.valorPorDiaAtraso = valorPorDiaAtraso;
    }
}
