import java.util.HashMap;

public class Serie {
    private String idSerie;
    private String nome;
    private String dataDeLancamento;
    private int quantidadeDeVisualizacoes;
    private int numTemporadas;
    private HashMap<String, Cliente> clientesQueAssistiram;
    private HashMap<String, Avaliacao> avaliacoes;

    public Serie(String idSerie, String nome, String dataDeLancamento, int numTemporadas) {
        this.idSerie = idSerie;
        this.nome = nome;
        this.dataDeLancamento = dataDeLancamento;
        this.numTemporadas = numTemporadas;
        this.quantidadeDeVisualizacoes = 0;
        this.clientesQueAssistiram = new HashMap<>();
        this.avaliacoes = new HashMap<>();
    }

    public String getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(String idSerie) {
        this.idSerie = idSerie;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataDeLancamento() {
        return dataDeLancamento;
    }

    public void setDataDeLancamento(String dataDeLancamento) {
        this.dataDeLancamento = dataDeLancamento;
    }

    public int getQuantidadeDeVisualizacoes() {
        return quantidadeDeVisualizacoes;
    }

    public void setQuantidadeDeVisualizacoes(int quantidadeDeVisualizacoes) {
        this.quantidadeDeVisualizacoes = quantidadeDeVisualizacoes;
    }

    public HashMap<String, Cliente> getClientesQueAssistiram() {
        return clientesQueAssistiram;
    }

    public void setClientesQueAssistiram(HashMap<String, Cliente> clientesQueAssistiram) {
        this.clientesQueAssistiram = clientesQueAssistiram;
    }

    public HashMap<String, Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(HashMap<String, Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public void adicionarClienteQueAssistiu(Cliente cliente) {
        clientesQueAssistiram.put(cliente.getLogin(), cliente);
    }

    public void adicionarAvaliacao(Avaliacao avaliacao) {
        avaliacoes.put(avaliacao.getIdAvaliacao(), avaliacao);
    }

    public String getGenero() {
        return null;
    }

    public String getTitulo() {
        return null;
    }

    public int incrementarVisualizacoes(Serie idSerie) {
        return quantidadeDeVisualizacoes++;
    }
}
