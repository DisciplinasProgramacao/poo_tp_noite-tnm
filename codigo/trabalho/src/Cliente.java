import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cliente {
    // #region Properties
    private static final int QUANTIDADE_DE_MEDIA_PROFSSIONAL = 5;
    private int quantidadeDeMediasAssitidas;
    private boolean especialista;
    private Map<Integer, Midia> midiasAssistidas;
    private Map<Integer, Midia> midiasFuturas;
    private Map<Integer, Avaliacao> midiasAvaliadas;
    private Map<Integer, Comentario> midiasComentadas;

    private String nome;
    private String login;
    private String senha;

    // #endregion Properties
    // #region Public
    /**
     * Construtor da classe
     * 
     * @param nome
     * @param login
     * @param senha
     */
    public Cliente(String nome, String login, String senha) {
        this.login = login;
        this.nome = nome;
        this.senha = senha;

        quantidadeDeMediasAssitidas = 0;
        this.especialista = false;
        midiasAssistidas = new HashMap<>();
        midiasFuturas = new HashMap<>();
        this.midiasAvaliadas = new HashMap<>();
        this.midiasComentadas = new HashMap<>();
    }

    public String getLogin() {
        return login;
    }

    public boolean VerificarUsuario(String senha) {
        if (this.senha.equals(senha)) {
            return true;
        } else {
            return false;
        }
    }

    public void AdicionarMidiaAssistida(Midia midia) {
        for (Map.Entry<Integer, Midia> midiaMap : midiasAssistidas.entrySet()) {
            Midia midiaVerificar = midiaMap.getValue();
            if (midiaVerificar.Id == midia.Id) {
                System.out.println("Só é possível marcar como assistida uma vez");
                System.out.println();
                return;
            }
        }
        this.midiasAssistidas.put(midia.Id, midia);
        quantidadeDeMediasAssitidas++;
        String mensagem = midia.titulo + " marcado como assistido com sucesso!";
        System.out.println();
        System.out.println(mensagem);
        if (quantidadeDeMediasAssitidas >= QUANTIDADE_DE_MEDIA_PROFSSIONAL) {
            especialista = true;
        }
    }

    public boolean EhEspecialista() {
        return especialista;
    }

    public void AdicionarMidiaFutura(Midia midia) {
        for (Map.Entry<Integer, Midia> midiaMap : midiasAssistidas.entrySet()) {
            Midia midiaVerificar = midiaMap.getValue();
            if (midiaVerificar.Id == midia.Id) {
                System.out.println("Só é possível marcar para assistir futuramente uma vez");
                return;
            }
        }
        this.midiasFuturas.put(midia.Id, midia);
        String mensagem = midia.titulo + " marcado para assistir futuramente com sucesso!";
        System.out.println();
        System.out.println(mensagem);
    }

    public void RemoverMidiaFutura(Midia midia) {
        for (Map.Entry<Integer, Midia> midiaMap : midiasAssistidas.entrySet()) {
            Midia midiaVerificar = midiaMap.getValue();
            if (midiaVerificar.Id == midia.Id) {
                System.out.println(midia.titulo + " desmarcado para assistir futuramente");
                System.out.println();
                midiasFuturas.remove(midia.Id, midia);
                return;
            }
        }
        String mensagem = midia.titulo + " não está marcado para assistir futuramente";
        System.out.println();
        System.out.println(mensagem);
    }
}
