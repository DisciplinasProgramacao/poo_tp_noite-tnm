import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner ent = new Scanner(System.in);
        PlataformaStreaming streaming = new PlataformaStreaming();
        int opt;

        while (true) {
            if (streaming.UsuarioLogado() == null) {
                System.out.println("1- Logar");
                System.out.println("2- Registrar");
                System.out.println();
                System.out.print("Digite sua opção: ");
                opt = ent.nextInt();
                ent.nextLine();
                if (opt == 1) {
                    System.out.print("Digite seu login: ");
                    String login = ent.nextLine();

                    System.out.print("Digite sua senha: ");
                    String senha = ent.nextLine();
                    streaming.loginCliente(login, senha);
                    continue;
                } else if (opt == 2) {
                    System.out.print("Digite seu nome: ");
                    String nome = ent.nextLine();

                    System.out.print("Digite seu login: ");
                    String user = ent.nextLine();

                    System.out.print("Digite sua senha: ");
                    String senha = ent.nextLine();

                    streaming.registroCliente(nome, user, senha);
                    continue;
                }
            } else {

                System.out.println("1 - Ver Catálogo");
                System.out.println("2 - Ver mídia futuras");
                System.out.println("3 - Ver mídia assistidas");
                System.out.println();
                System.out.println("4 - Adicionar mídia como assistida");
                System.out.println("5 - Adicionar mídia para assistir futuramente");
                System.out.println();
                System.out.println("6 - Desmarcar mídia como assistida");
                System.out.println("7 - Desmarcar mídia para assistir futuramente");
                System.out.println();
                System.out.println("8 - Deslogar");
                System.out.println("9 - Apagar conta");

                opt = ent.nextInt();
                ent.nextLine();
                System.out.println("1 - Catalogo de Filmes ");
                System.out.println("2 - Catalogo de Series ");
                if (opt == 1) {

                }
                ArrayList<Serie> lista = opt == 1 ? catalogo
                        : opt == 2 ? streaming.UsuarioLogado().SeriesFuturas
                                : opt == 3 ? streaming.UsuarioLogado().SeriesAssistidas : null;
                if (lista != null) {
                    System.out.println("1 - Ver todos");
                    System.out.println("2 - Pesquisar por nome");
                    System.out.println("3 - Pesquisar por genero");
                    System.out.println("4 - Pesquisar por idioma");
                    System.out.println("5 - Cancelar");

                    System.out.println();
                    System.out.print("Digite sua opção: ");
                    int tipoBusca = ent.nextInt();
                    ent.nextLine();

                    if (tipoBusca == 1) {
                        streaming.VerSeries(opt);
                    } else if (tipoBusca == 2) {
                        System.out.print("Digite o nome da série que deseja buscar: ");
                        String titulo = ent.nextLine();
                        Serie serie = streaming.PesquisarSerie(titulo, lista);
                        if (serie == null) {
                            System.out.println("Série não encontrada");
                            System.out.println();
                            continue;
                        }
                        streaming.PrintSerie(serie);

                    } else if (tipoBusca == 3) {
                        for (int i = 0; i < streaming.Generos.length; i++) {
                            System.out.println(i + " - " + streaming.Generos[i]);
                        }
                        System.out.print("Sua opção: ");
                        int genero = ent.nextInt();
                        ent.nextLine();
                        if (genero <= streaming.Generos.length) {
                            streaming.PesquisarSerie(1, genero, lista);
                        } else {
                            System.out.println("Opção inválida");
                        }
                    } else if (tipoBusca == 4) {
                        for (int i = 0; i < streaming.Idiomas.length; i++) {
                            System.out.println(i + " - " + streaming.Idiomas[i]);
                        }
                        int idiomas = ent.nextInt();
                        ent.nextLine();
                        if (idiomas <= streaming.Idiomas.length) {
                            streaming.PesquisarSerie(2, idiomas, lista);
                        } else {
                            System.out.println("Opção inválida");
                        }
                    }
                    if (tipoBusca == 5) {
                        continue;
                    }

                } else {
                    if (opt == 4) {

                        System.out.print("Digite o nome do Filme/Série que deseja adicionar como assistido: ");
                        String titulo = ent.nextLine();
                        streaming.adicionarFA(true, titulo);

                    } else if (opt == 5) {
                        System.out.print("Digite o filme/série que deseja adicionar como assitir futuramente: ");
                        String titulo = ent.nextLine();
                        streaming.adicionarFA(false, titulo);
                    } else if (opt == 6) {
                        if (usuarioLogado.SeriesAssistidas.size() > 0) {
                            System.out
                                    .print("Digite o nome do filme/série que deseja remover da lista de assistidas: ");
                            String titulo = ent.nextLine();
                            streaming.removerFA(true, titulo);
                        } else {
                            System.out.println("Você não possui séries assistidas.");
                        }

                    } else if (opt == 7) {
                        if (usuarioLogado.SeriesFuturas.size() > 0) {
                            System.out.print(
                                    "Digite o nome do filme/série que deseja remover da lista de assistir futuramente: ");
                            String titulo = ent.nextLine();
                            streaming.removerFA(false, titulo);
                        } else {
                            System.out.println("Você não possui séries marcadas para assistir futuramente.");
                        }

                    } else if (opt == 8) {
                        streaming.Deslogar();
                    } else if (opt == 9) {
                        System.out.print("Digite seu login: ");
                        String login = ent.nextLine();

                        System.out.print("Digite sua senha: ");
                        String senha = ent.nextLine();
                        streaming.removerCliente(login, senha);
                    }
                }
            }
        }

    }
}
