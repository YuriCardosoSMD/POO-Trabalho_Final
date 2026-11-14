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

    public int getId() {
        return this.id;
    }

    public String getModelo() {
        return this.modelo;
    }

    public boolean isDisponivel() {
        return this.disponivel;
    }
}
