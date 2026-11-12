public class Moto extends Veiculo {

    private double descontoEconomico;

    public Moto(String placa, String modelo, double valorDiaria, double descontoEconomico) {
        super(placa, modelo, valorDiaria);
        this.descontoEconomico = descontoEconomico;
    }

    @Override
    public double calcularValorDiaria() {
        return this.valorDiaria - this.descontoEconomico;
    }

    @Override
    public String obterDescricao() {
        return "[Moto] " + this.modelo + " | Placa: " + this.placa + " | Desconto econômico: R$ "
                + this.descontoEconomico;
    }

    @Override
    public void reservar() {
        this.disponivel = false;
        System.out.println("Reserva de Moto: " + this.modelo + " (Placa: " + this.placa
                + ") reservada com capacete extra incluído.");
    }

    public double getDescontoEconomico() {
        return this.descontoEconomico;
    }
}