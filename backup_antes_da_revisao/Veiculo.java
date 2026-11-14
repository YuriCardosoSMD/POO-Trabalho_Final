// Classe abstrata que representa a base de qualquer veículo da frota e implementa Alugavel
public abstract class Veiculo implements Alugavel {

    // Atributo estático compartilhado para gerar IDs únicos para cada veículo
    private static int contadorVeiculos = 0;

    private int id;

    // Atributos protected para acesso direto nas subclasses Carro, Moto e Caminhao
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

    // Método estático que incrementa e retorna o próximo ID sequencial de veículo
    public static int gerarProximoId() {
        contadorVeiculos = contadorVeiculos + 1;
        return contadorVeiculos;
    }

    // Métodos abstratos que obrigam as subclasses a aplicar polimorfismo no cálculo e na descrição
    public abstract double calcularValorDiaria();

    public abstract String obterDescricao();

    @Override
    public void devolver() {
        this.disponivel = true;
        System.out.println("Veículo " + this.modelo + " (Placa: " + this.placa + ") foi devolvido.");
    }

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
