public class Cliente {

    private String nome;
    private String documentoCpf;

    public Cliente(String nome, String documentoCpf) {
        this.nome = nome;
        this.documentoCpf = documentoCpf;
    }

    public String getNome() {
        return this.nome;
    }

    public String getDocumentoCpf() {
        return this.documentoCpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDocumentoCpf(String documentoCpf) {
        this.documentoCpf = documentoCpf;
    }
}
