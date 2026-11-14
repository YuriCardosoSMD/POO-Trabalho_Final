import java.util.ArrayList;

// Classe que gerencia a frota de veículos disponíveis na empresa
public class Locadora {

    private String nome;

    // Agregação: Locadora mantém uma lista de objetos Veiculo criados externamente
    private ArrayList<Veiculo> veiculos;

    public Locadora(String nome) {
        this.nome = nome;
        this.veiculos = new ArrayList<Veiculo>();
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }

    public Veiculo buscarVeiculoPorId(int id) {
        for (int i = 0; i < this.veiculos.size(); i++) {
            Veiculo veiculo = this.veiculos.get(i);
            if (veiculo.getId() == id) {
                return veiculo;
            }
        }
        return null;
    }

    public ArrayList<Veiculo> getVeiculos() {
        return this.veiculos;
    }

    public String getNome() {
        return this.nome;
    }
}
