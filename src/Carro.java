public class Carro extends Veiculo {

    private double taxaLimpeza;

    public Carro(String placa, String modelo, double valorDiaria, double taxaLimpeza) {
        super(placa, modelo, valorDiaria);
        this.taxaLimpeza = taxaLimpeza;
    }

    @Override
    public double calcularValorDiaria() {
        return this.valorDiaria + this.taxaLimpeza;
    }

    @Override
    public String obterDescricao() {
        return "[Carro] " + this.modelo + " | Placa: " + this.placa + " | Taxa de limpeza: R$ " + this.taxaLimpeza;
    }

    @Override
    public void reservar() {
        this.disponivel = false;
        System.out.println("Reserva de Carro: " + this.modelo + " (Placa: " + this.placa
                + ") reservado com higienização interna agendada.");
    }

    public double getTaxaLimpeza() {
        return this.taxaLimpeza;
    }
}