import java.time.LocalDate;

public class Message extends Billet {
    private String contenu;

    public Message(LocalDate datePub, String auteur, String contenu){
        super(datePub,auteur);
        this.contenu=contenu;

    }
    public String getContenu() {
        return contenu;
    }
}
