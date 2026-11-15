public abstract class Veiculo implements Alugavel {

    private static int contadorVeiculos = 0;

    private int identificador;
    protected String placa;
    protected String modelo;
    protected double valorDiaria;
    protected boolean disponivel;

    public Veiculo(String placa, String modelo, double valorDiaria) {
        this.identificador = gerarProximoId();
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

    public int getIdentificador() {
        return this.identificador;
    }

    public String getModelo() {
        return this.modelo;
    }

    public boolean isDisponivel() {
        return this.disponivel;
    }
}
