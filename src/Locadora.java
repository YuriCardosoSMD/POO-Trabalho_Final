import java.util.ArrayList;

public class Locadora {

    private String nome;
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
            Veiculo v = this.veiculos.get(i);
            if (v.getId() == id) {
                return v;
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
