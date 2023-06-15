import java.util.Date;
import java.util.ArrayList;

public abstract class Midia {
    public final String titulo;
    public final int Id;
    public final String[] idiomas;
    public final String[] generos;
    private ArrayList<Comentario> comentarios;
    public final Date dataDeLancamento;
    private ArrayList<Avaliacao> avaliacoes;
    private boolean lancamento;
    private ArrayList<Audiencia> Audiencia;

    public Midia(int id, String titulo, Date dataDeLancamento, String[] idiomas, String[] generos) {
        this.titulo = titulo;
        this.idiomas = idiomas;
        this.generos = generos;
        this.Id = id;
        this.dataDeLancamento = dataDeLancamento;
        this.comentarios = new ArrayList<Comentario>();
        this.avaliacoes = new ArrayList<Avaliacao>();
        this.Audiencia = new ArrayList<Audiencia>();
    }

    public void AddAudiencia(Audiencia audiencia) {
        this.Audiencia.add(audiencia);
    }

    public int getId() {
        return Id;
    }

    public void Comentar(String comentario, String userLogin) {
        this.comentarios.add(new Comentario(comentario, userLogin, Id));
    }

    public String getTitulo() {
        return null;
    }

    public String getDataDeLancamento() {
        return null;
    }
}