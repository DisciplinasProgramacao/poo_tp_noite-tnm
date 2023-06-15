import java.util.List;
import java.util.Scanner;

public class Main {

    private static PlataformaStreaming plataforma = new PlataformaStreaming();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n----------------------------------");
            System.out.println("Bem-vindo à Plataforma de Streaming!");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Cadastrar Série");
            System.out.println("3 - Cadastrar Filme");
            System.out.println("4 - Listar Séries Para Assistir");
            System.out.println("5 - Listar Séries Assistidas");
            System.out.println("6 - Listar Filmes Para Assistir");
            System.out.println("7 - Listar Filmes Assistidos");
            System.out.println("8 - Sair");
            System.out.println("9 - Avaliar Série");
            System.out.println("10 - Avaliar Filme");
            System.out.println("----------------------------------\n");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    cadastrarSerie();
                    break;
                case 3:
                    cadastrarFilme();
                    break;
                case 4:
                    listarSeriesParaAssistir();
                    break;
                case 5:
                    listarSeriesAssistidas();
                    break;
                case 6:
                    listarFilmesParaAssistir();
                    break;
                case 7:
                    listarFilmesAssistidos();
                    break;
                case 8:
                    exit = true;
                    break;
                case 9:
                    avaliarSerie();
                    break;
                case 10:
                    avaliarFilme();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.\n");
                    break;
            }
        }
    }

    private static void avaliarSerie() {
        // Implementar método para avaliar uma série
        System.out.println("Digite o seu login:");
        String login = scanner.next();
        Cliente cliente = plataforma.getCliente(login);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }
        System.out.println("Digite o ID da série:");
        String idSerie = scanner.next();

        Serie serie = plataforma.getSerie(idSerie);
        if (serie == null) {
            System.out.println("Série não encontrada.");
            return;
        }
        System.out.println("Digite a nota (1-5):");
        int nota = scanner.nextInt();
        Avaliacao avaliacao = new Avaliacao(cliente, nota);
        serie.adicionarAvaliacao(avaliacao);
    }

    private static void avaliarFilme() {
        // Implementar método para avaliar um filme
        System.out.println("Digite o seu login:");
        String login = scanner.next();
        Cliente cliente = plataforma.getCliente(login);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }
        System.out.println("Digite o ID do filme:");
        String idFilme = scanner.next();
        Filme filme = plataforma.getFilme(idFilme);
        if (filme == null) {
            System.out.println("Filme não encontrado.");
            return;
        }
        System.out.println("Digite a nota (1-5):");
        int nota = scanner.nextInt();
        Avaliacao avaliacao = new Avaliacao(cliente, nota);
        cliente.adicionarAvaliacao(avaliacao);
    }

    private static void cadastrarCliente() {
        System.out.println("Digite o login do cliente:");
        String login = scanner.next();

        // Verificar se o cliente já existe
        if (plataforma.getCliente(login) != null) {
            System.out.println("Cliente já cadastrado.");
            return;
        }
        System.out.println("Digite o nome do cliente:");
        String nome = scanner.next();

        System.out.println("Digite a sua senha: ");
        String senha = scanner.next();
        // Criar o objeto Cliente
        Cliente cliente = new Cliente(login, nome, senha);

        // Adicionar o cliente à plataforma
        plataforma.adicionarCliente(cliente);

        System.out.println("Cliente cadastrado com sucesso.");
    }

    private static void cadastrarSerie() {
        System.out.println("Digite o ID da série:");
        String idSerie = scanner.next();

        // Verificar se a série já existe
        if (plataforma.getSerie(idSerie) != null) {
            System.out.println("Série já cadastrada.");
            return;
        }

        System.out.println("Digite o nome da série:");
        String nomeSerie = scanner.next();

        System.out.println("Digite o número de temporadas da série:");
        int numTemporadas = scanner.nextInt();

        // Criar o objeto Série
        Serie serie = new Serie(idSerie, nomeSerie, nomeSerie, numTemporadas);

        // Adicionar a série à plataforma
        plataforma.adicionarSerie(serie);

        System.out.println("Série cadastrada com sucesso.");
    }

    private static void cadastrarFilme() {
        System.out.println("Digite o ID do filme:");
        String idFilme = scanner.next();

        // Verificar se o filme já existe
        if (plataforma.getFilme(idFilme) != null) {
            System.out.println("Filme já cadastrado.");
            return;
        }

        System.out.println("Digite o título do filme:");
        String tituloFilme = scanner.next();

        System.out.println("Digite o gênero do filme:");
        String generoFilme = scanner.next();

        // Criar o objeto Filme
        Filme filme = new Filme(idFilme, tituloFilme, generoFilme, 0);

        // Adicionar o filme à plataforma
        plataforma.adicionarFilme(filme);

        System.out.println("Filme cadastrado com sucesso.");
    }

    private static void listarSeriesParaAssistir() {
        System.out.println("Séries disponíveis para assistir:");
        List<Serie> seriesParaAssistir = plataforma.getSeriesAssistidas();

        if (seriesParaAssistir.isEmpty()) {
            System.out.println("Não há séries disponíveis para assistir.");
        } else {
            for (Serie serie : seriesParaAssistir) {
                System.out.println("ID: " + serie.getIdSerie());
                System.out.println("Título: " + serie.getTitulo());
                System.out.println("Gênero: " + serie.getGenero());
                System.out.println("--------------------");
            }
        }
    }

    private static void listarSeriesAssistidas() {
        System.out.println("Séries assistidas:");
        List<Serie> seriesAssistidas = plataforma.getSeriesAssistidas();

        if (seriesAssistidas.isEmpty()) {
            System.out.println("Não há séries assistidas.");
        } else {
            for (Serie serie : seriesAssistidas) {
                System.out.println("ID: " + serie.getIdSerie());
                System.out.println("Título: " + serie.getTitulo());
                System.out.println("Gênero: " + serie.getGenero());
                System.out.println("Avaliação média: " + serie.getAvaliacoes());
                System.out.println("--------------------");
            }
        }
    }

    private static void listarFilmesParaAssistir() {
        System.out.println("Filmes para assistir:");
        List<Filme> filmesParaAssistir = plataforma.getFilmesParaAssistir();

        if (filmesParaAssistir.isEmpty()) {
            System.out.println("Não há filmes para assistir.");
        } else {
            for (Filme filme : filmesParaAssistir) {
                System.out.println("ID: " + filme.getIdFilme());
                System.out.println("Título: " + filme.getTitulo());
                System.out.println("Gênero: " + filme.getGenero());
                System.out.println("Avaliação média: " + filme.getAvaliacaoMedia());
                System.out.println("--------------------");
            }
        }
    }

    private static void listarFilmesAssistidos() {
        System.out.println("Filmes assistidos:");
        List<Filme> filmesAssistidos = plataforma.getFilmesAssistidos();

        if (filmesAssistidos.isEmpty()) {
            System.out.println("Não há filmes assistidos.");
        } else {
            for (Filme filme : filmesAssistidos) {
                System.out.println("ID: " + filme.getIdFilme());
                System.out.println("Título: " + filme.getTitulo());
                System.out.println("Gênero: " + filme.getGenero());
                System.out.println("Avaliação média: " + filme.getAvaliacaoMedia());
                System.out.println("--------------------");
            }
        }
    }

}