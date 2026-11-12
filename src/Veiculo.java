public abstract class Veiculo implements Alugavel {

    private static int contadorVeiculos = 0;

    private int id;

    protected String placa;
    protected String modelo;
    protected double valorDiaria;
    protected boolean disponivel;

    public Veiculo(String placa, String modelo, double valorDiaria) {
        this.id = gerarProximoId();
        this.placa = placa;
        this.modelo = modelo;
        this.valorDiaria = valorDiaria;
        this.disponivel = true;
    }

    public static int gerarProximoId() {
        contadorVeiculos = contadorVeiculos + 1;
        return contadorVeiculos;
    }

    public abstract double calcularValorDiaria();

    public abstract String obterDescricao();

    @Override
    public void reservar() {
        this.disponivel = false;
        System.out.println("Veículo " + this.modelo + " (Placa: " + this.placa + ") foi reservado.");
    }

    @Override
    public void devolver() {
        this.disponivel = true;
        System.out.println("Veículo " + this.modelo + " (Placa: " + this.placa + ") foi devolvido.");
    }

    public int getId() {
        return this.id;
    }

    public String getPlaca() {
        return this.placa;
    }

    public String getModelo() {
        return this.modelo;
    }

    public double getValorDiaria() {
        return this.valorDiaria;
    }

    public boolean isDisponivel() {
        return this.disponivel;
    }
}