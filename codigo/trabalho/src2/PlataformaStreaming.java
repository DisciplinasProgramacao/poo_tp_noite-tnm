import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class PlataformaStreaming {
    private HashMap<String, Cliente> listaCliente;
    private HashMap<String, Serie> series;
    private HashMap<String, Filme> filmes;
    private String basePathArquivos = " C:\\Users\\breno\\OneDrive\\u00C1rea de Trabalho\\trabalho_POO\\lib\\";

    public PlataformaStreaming() {
        listaCliente = new HashMap<>();
        this.series = new HashMap<>();
        this.filmes = new HashMap<>();
        lerArquivo("Audiencia.csv");
        lerArquivo("Espectadores.csv");
        lerArquivo("Series.csv");
    }

    public void lerArquivo(String nomeArquivo) {
        try {

            if (nomeArquivo.contains("Espectadores")) {

                File file = new File(basePathArquivos + nomeArquivo);
                Scanner arq = new Scanner(file);
                String linha;
                while ((linha = arq.nextLine()) != null) {
                    String[] dados = linha.split(";");
                    String nome = dados[0];
                    String login = dados[1];
                    String senha = dados[2];
                    listaCliente.put(login, new Cliente(nome, login, senha));
                }

            } else if (nomeArquivo.contains("Series")) {
                File file = new File(basePathArquivos + nomeArquivo);
                BufferedReader leitor = new BufferedReader(new FileReader(file));
                String linha;
                while ((linha = leitor.readLine()) != null) {
                    String[] dados = linha.split(",");
                    int id = Integer.parseInt(dados[0]);
                    String titulo = dados[1];
                    String dataNaoFormatada = dados[2];

                }
            } else if (nomeArquivo.contains("Filmes")) {
                File file = new File(basePathArquivos + nomeArquivo);
                BufferedReader leitor = new BufferedReader(new FileReader(file));
                String linha;
                while ((linha = leitor.readLine()) != null) {
                    String[] dados = linha.split(",");
                    int id = Integer.parseInt(dados[0]);
                    String titulo = dados[1];
                    String dataNaoFormatada = dados[2];
                    String duracao = dados[3];

                }
            } else if (nomeArquivo.contains("Audiencia")) {
                File file = new File(basePathArquivos + nomeArquivo);
                Scanner arq = new Scanner(file);
                String linha;

                while ((linha = arq.nextLine()) != null) {
                    String[] dados = linha.split(";");
                    String login = dados[0];
                    String tipoListaSerie = dados[1];
                    String idSerie = dados[2];
                }
            }
        } catch (

        Exception e) {
        }
    }

    public void assistirSerie(String loginCliente, Serie idSerie) {
        Cliente cliente = getCliente(loginCliente);
        Serie serie = getSerie(idSerie);

        cliente.adicionarSerieVista(idSerie);
        serie.incrementarVisualizacoes(serie);
    }

    public List<Filme> getFilmesAssistidos() {
        return null;
    }

    public List<Filme> getFilmesParaAssistir() {
        return null;
    }

    public List<Serie> getSeriesAssistidas() {
        return null;
    }

    public Serie getSerie(String idSerie) {
        return null;
    }

    public void adicionarCliente(Cliente cliente) {
        listaCliente.put(cliente.getLogin(), cliente);
    }

    public void adicionarSerie(Serie serie) {
        series.put(serie.getIdSerie(), serie);
    }

    public void adicionarFilme(Filme filme) {
        filmes.put(filme.getIdFilme(), filme);
    }

    public Cliente getCliente(String login) {
        return listaCliente.get(login);
    }

    public Serie getSerie(Serie idSerie) {
        return series.get(idSerie);
    }

    public Filme getFilme(String idFilme) {
        return filmes.get(idFilme);
    }
}
