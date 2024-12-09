import java.time.LocalDate;

public class Billet implements Publiable{
    protected LocalDate datePub;
    protected String auteur;

    public Billet(LocalDate datePub, String auteur){
        this.auteur=auteur;
        this.datePub=datePub;
    }

    @Override
    public String toString() {
        return "La date de publicite est : "+datePub+" l'auteur est : "+auteur;
    }

    @Override
    public LocalDate getDatePublication() {
        return null;
    }

    @Override
    public String getAuteur() {
        return "";
    }
}
