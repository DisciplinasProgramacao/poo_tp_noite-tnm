import java.util.Date;

public class Filme extends Midia {
    private String duracao;

    public Filme(int id, String titulo, Date dataDeLancamento, String duracao, String[] generosAleatorios,
            String[] idiomasAleatorios) {
        super(id, titulo, dataDeLancamento, idiomasAleatorios, idiomasAleatorios);
        this.duracao = duracao;
    }

    // Implemente os métodos abstratos da classe Midia, se houver algum
}
