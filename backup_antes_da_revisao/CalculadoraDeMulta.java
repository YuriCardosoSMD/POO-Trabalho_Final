// Classe utilitária que calcula a multa por dias de atraso na devolução do veículo
public class CalculadoraDeMulta {

    private double valorPorDiaAtraso;

    public CalculadoraDeMulta() {
        // Regra de negócio: taxa fixa de R$ 50,00 por cada dia de atraso
        this.valorPorDiaAtraso = 50.0;
    }

    public double calcularMulta(int diasAtraso) {
        return diasAtraso * this.valorPorDiaAtraso;
    }
}
