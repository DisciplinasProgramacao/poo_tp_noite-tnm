public class Avaliacao {
    private String idAvaliacao;
    private Cliente cliente;
    private int nota;

    public Avaliacao(Cliente cliente, int nota) {
        this.cliente = cliente;
        this.nota = nota;
    }

    public String getIdAvaliacao() {
        return idAvaliacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getNota() {
        return nota;
    }

    public String getIdMidia() {
        return null;
    }
}