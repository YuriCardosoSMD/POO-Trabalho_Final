public class CalculadoraDeMulta {

    private double valorPorDiaAtraso;

    public CalculadoraDeMulta() {
        this.valorPorDiaAtraso = 50.0;
    }

    public double calcularMulta(int diasAtraso) {
        return diasAtraso * this.valorPorDiaAtraso;
    }
}