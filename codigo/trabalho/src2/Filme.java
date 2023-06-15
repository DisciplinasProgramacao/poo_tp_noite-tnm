import java.util.ArrayList;
import java.util.HashMap;

public class Filme {
    private String idFilme;
    private String nome;
    private String dataDeLancamento;
    private int duracao;
    private int quantidadeDeVisualizacoes;
    private ArrayList<Cliente> clientesQueAssistiram;
    private HashMap<String, Avaliacao> avaliacoes;

    public Filme(String idFilme, String nome, String dataDeLancamento, int duracao) {
        this.idFilme = idFilme;
        this.nome = nome;
        this.dataDeLancamento = dataDeLancamento;
        this.duracao = duracao;
        this.quantidadeDeVisualizacoes = 0;
        this.clientesQueAssistiram = new ArrayList<>();
        this.avaliacoes = new HashMap<>();
    }

    public Cliente obterClienteComMaisMidiasAssistidas() {
        Cliente clienteComMaisAvaliacoes = null;
        int maxAvaliacoes = 0;

        for (Avaliacao avaliacao : avaliacoes.values()) {
            Cliente cliente = avaliacao.getCliente();
            int numAvaliacoes = cliente.getNumAvaliacoes();

            if (numAvaliacoes > maxAvaliacoes) {
                maxAvaliacoes = numAvaliacoes;
                clienteComMaisAvaliacoes = cliente;
            }
        }

        return clienteComMaisAvaliacoes;
    }

    public Cliente obterClienteComMaisAvaliacoes() {
        Cliente clienteComMaisAvaliacoes = null;
        int maxAvaliacoes = 0;

        for (Avaliacao avaliacao : avaliacoes.values()) {
            Cliente cliente = avaliacao.getCliente();
            int numAvaliacoes = cliente.getNumAvaliacoes();

            if (numAvaliacoes > maxAvaliacoes) {
                maxAvaliacoes = numAvaliacoes;
                clienteComMaisAvaliacoes = cliente;
            }
        }

        return clienteComMaisAvaliacoes;
    }

    public double calcularPorcentagemClientesComMinimoAvaliacoes(int minimoAvaliacoes,
            HashMap<String, Cliente> clientes) {
        int totalClientes = clientes.size();
        int numClientesComMinimoAvaliacoes = 0;

        for (Cliente cliente : clientes.values()) {
            if (cliente.getNumAvaliacoes() >= minimoAvaliacoes) {
                numClientesComMinimoAvaliacoes++;
            }
        }

        return (double) numClientesComMinimoAvaliacoes / totalClientes * 100.0;
    }

    public String getIdFilme() {
        return null;
    }

    public String getTitulo() {
        return null;
    }

    public String getGenero() {
        return null;
    }

    public String getAvaliacaoMedia() {
        return null;
    }

}