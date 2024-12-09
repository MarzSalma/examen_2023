import java.time.LocalDate;

public class BilletsTaggables extends Billet implements Taggable{
    String LTags[];
    protected int nbTags;
    protected int capacite;

    public BilletsTaggables(LocalDate datePub, String auteur, int c){
        super(datePub, auteur);
        this.nbTags=c;
        LTags=new String[c];
    }

    public String ListerTable() {
        String result = "";
        for (int i = 0; i < nbTags; i++) {
            result += LTags[i] + " ";
        }
        return result;
    }

    public String toString() {
        return this.ListerTable();
    }

    @Override
    public LocalDate getDatePublication() {
        return null;
    }

    @Override
    public String getAuteur() {
        return "";
    }

    @Override
    public void ajoutTag(String tag) {
        for(int i =0;i<nbTags;i++){
            if(nbTags<=capacite){
                LTags[nbTags]=tag;
                nbTags++;
            }else{
                System.out.println("Le Tableau est saturree");
            }
        }
    }

    @Override
    public void supprimeTag(String tag) {

    }

    @Override
    public int nombreTags() {
        return 0;
    }

    @Override
    public int rechercheTag(String tag) {
        return 0;
    }
}
