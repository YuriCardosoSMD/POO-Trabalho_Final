// Subclasse de Veiculo (herança) que representa um caminhão com custo adicional de carga
public class Caminhao extends Veiculo {

    private double adicionalCarga;

    public Caminhao(String placa, String modelo, double valorDiaria, double adicionalCarga) {
        super(placa, modelo, valorDiaria);
        this.adicionalCarga = adicionalCarga;
    }

    // Polimorfismo: acrescenta o adicional de carga ao valor base da diária do caminhão
    @Override
    public double calcularValorDiaria() {
        return this.valorDiaria + this.adicionalCarga;
    }

    @Override
    public String obterDescricao() {
        return "[Caminhão] " + this.modelo + " | Placa: " + this.placa + " | Adicional de carga: R$ "
                + this.adicionalCarga;
    }

    @Override
    public void reservar() {
        this.disponivel = false;
        System.out.println("Reserva de Caminhão: " + this.modelo + " (Placa: " + this.placa
                + ") reservado após vistoria da carroceria de carga.");
    }
}
