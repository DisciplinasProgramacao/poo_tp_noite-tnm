import java.util.HashMap;

public class Cliente {
    private String nome;
    private String login;
    private String senha;
    private HashMap<String, Serie> seriesVistas;
    private HashMap<String, Filme> filmesVistos;
    private HashMap<String, Avaliacao> avaliacoes;

    public Cliente(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.seriesVistas = new HashMap<>();
        this.filmesVistos = new HashMap<>();
        this.avaliacoes = new HashMap<>();
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public void adicionarSerieVista(Serie serie) {
        seriesVistas.put(serie.getIdSerie(), serie);
    }

    public void adicionarFilmeVisto(Filme filme) {
        filmesVistos.put(filme.getIdFilme(), filme);
    }

    public void adicionarAvaliacao(Avaliacao avaliacao) {
        avaliacoes.put(avaliacao.getIdMidia(), avaliacao);
    }

    public int getMidiasAssistidas() {
        return 0;
    }

    public int getNumAvaliacoes() {
        return 0;
    }

}
