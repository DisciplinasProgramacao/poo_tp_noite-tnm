import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PlataformaStreaming {
    private HashMap<Integer, Midia> catalogo;
    private ArrayList<Cliente> listaCliente;
    private Cliente usuarioLogado;
    private String basePathArquivos = "C:\\Users\\breno\\OneDrive\\Área de Trabalho\\trabalho\\lib\\POO_";

    public PlataformaStreaming() {
        this.usuarioLogado = null;
        listaCliente = new ArrayList<Cliente>();
        lerArquivo("Audiencia.csv");
        lerArquivo("Espectadores.csv");
        lerArquivo("Series.csv");
    }

    public Cliente UsuarioLogado() {
        return usuarioLogado;
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
                    listaCliente.add(new Cliente(nome, login, senha));
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
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
                    Date dataDeLancamento = formatter.parse(dataNaoFormatada);
                    Serie series = new Serie(id, titulo, dataDeLancamento, GenerosEnum.GenerosAleatorios(),
                            IdiomasEnum.IdiomasAleatorios());
                    catalogo.put(id, series);
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
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
                    Date dataDeLancamento = formatter.parse(dataNaoFormatada);
                    Filme filme = new Filme(id, titulo, dataDeLancamento, duracao, GenerosEnum.GenerosAleatorios(),
                            IdiomasEnum.IdiomasAleatorios());
                    catalogo.put(id, filme);
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

                    listaCliente.forEach(cliente -> {
                        if (cliente.getLogin().equals(login)) {
                            catalogo.forEach((id, serie) -> {
                                if (serie.getId() == Integer.parseInt(idSerie)) {
                                    if (tipoListaSerie.equals("F"))
                                        cliente.AdicionarMidiaFutura((Serie) serie);
                                    else
                                        cliente.AdicionarMidiaAssistida((Serie) serie);

                                }
                            });
                        }
                    });
                }
            }
        } catch (

        Exception e) {
        }
    }

    public void registroCliente(String nome, String login, String senha) {
        for (Cliente cliente : listaCliente) {
            if (cliente.getLogin().equals(login)) {
                System.out.println("Usuário existente");
                return;
            }
        }
        Cliente cliente = new Cliente(nome, login, senha);
        listaCliente.add(cliente);
    }

    public boolean loginCliente(String login, String senha) {
        boolean loggedIn = false;
        String mensagem = "";
        for (Cliente cliente : listaCliente) {
            if (cliente.getLogin().equals(login)) {
                loggedIn = cliente.VerificarUsuario(senha);
                if (loggedIn) {
                    this.usuarioLogado = cliente;
                }
            }
        }
        mensagem = loggedIn ? "Usuário logado com sucesso!" : "Login ou senha inválidos!";
        System.out.println(mensagem);
        System.out.println();
        return loggedIn;

    }

    public void Deslogar() {
        this.usuarioLogado = null;
        System.out.println("Usuário deslogado com sucesso!");
    }

    public void removerCliente(String login, String senha) {
        for (Cliente cliente : listaCliente) {
            if (cliente.getLogin().equals(login)) {
                boolean loggedIn = cliente.VerificarUsuario(senha);
                if (loggedIn) {
                    listaCliente.remove(cliente);
                    System.out.println("Cliente removido com sucesso!");
                    return;
                }
            }
        }
        System.out.println("Impossivel retirar usario. Usuario ou senha incorretos!");
    }

    public void pesquisarPorTitulo(String titulo, HashMap<Integer, Midia> catalogo) {
        System.out.println();
        boolean encontrou = false;

        for (Midia midia : catalogo.values()) {
            if (midia.getTitulo().equalsIgnoreCase(titulo)) {
                PrintMidia(midia);
                System.out.println("-----------------------------------------------");
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Não foi encontrada nenhuma mídia com esse título.");
        }
    }

    public void PesquisarSerie(int tipoPesquisa, int index, HashMap<Integer, Midia> catalogo) {

        if (tipoPesquisa == 1) {
            GenerosEnum genero = GenerosEnum.values()[index];
            System.out.println();
            boolean possuiGenero = false;
            for (Midia midia : catalogo.values()) {
                if (GenerosEnum.getGeneros().contains(genero)) {
                    possuiGenero = true;
                    PrintMidia(midia);
                    System.out.println("-----------------------------------------------");
                }
            }
            if (!possuiGenero) {
                System.out.println("Não existe nenhuma série com esse gênero.");
            }
        } else if (tipoPesquisa == 2) {
            IdiomasEnum idioma = IdiomasEnum.values()[index];
            System.out.println();
            boolean possuiIdioma = false;
            for (Midia midia : catalogo.values()) {
                if (IdiomasEnum.getIdiomas().contains(idioma)) {
                    possuiIdioma = true;
                    PrintMidia(midia);
                    System.out.println("-----------------------------------------------");
                }
            }
            if (!possuiIdioma) {
                System.out.println("Não existe nenhuma série com esse idioma.");
            }
        }
    }

    public void mostrarCatalogo(HashMap<Integer, Midia> catalogo) {
        System.out.println("Catálogo de Mídias:");
        System.out.println("-----------------------------------------------");

        for (Midia midia : catalogo.values()) {
            PrintMidia(midia);
            System.out.println("-----------------------------------------------");
        }

        if (catalogo.isEmpty()) {
            System.out.println("O catálogo está vazio.");
        }
    }

    public void AdicionarAssistida(Midia midia) {

        usuarioLogado.AdicionarMidiaAssistida(midia);
    }

    public void AdicionarMidiaFutura(Midia midia) {
        usuarioLogado.AdicionarMidiaFutura(midia);
    }

    public void PrintMidia(Midia midia) {
        System.out.println("Título: " + midia.getTitulo());
        System.out.println("Data de lançamento: " + midia.getDataDeLancamento());
        System.out.print("Idiomas: ");

        Random random = new Random();
        IdiomasEnum[] idiomas = IdiomasEnum.values();
        for (int i = 0; i < 2; i++) { // Exibir até 3 idiomas de forma randômica
            int index = random.nextInt(idiomas.length);
            System.out.print(idiomas[index] + " ");
        }
        System.out.println();

        System.out.print("Gêneros: ");
        GenerosEnum[] generos = GenerosEnum.values();
        for (int i = 0; i < 2; i++) { // Exibir 2 gêneros de forma randômica
            int index = random.nextInt(generos.length);
            System.out.print(generos[index] + " ");
        }
        System.out.println();
    }

}
