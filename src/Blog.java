import java.time.LocalDate;

public class Blog {
    private String titre;
    private Publiable[] LBillets;  // Tableau pour stocker les billets publiés
    private int nbBillets;  // Nombre de billets actuellement dans le blog
    private int capacite;

    // Constructeur Blog
    public Blog(String titre, int capacite) {
        this.titre = titre;
        this.capacite = capacite;
        this.LBillets = new Publiable[capacite];
        this.nbBillets = 0;
    }

    public void post(Publiable billet) throws InvalidURLException {

        if (billet instanceof Video) {
            Video videoBillet = (Video) billet;
            if (!videoBillet.getUrl().startsWith("https://")) {
                throw new InvalidURLException("L'URL de la vidéo n'est pas sécurisée (elle doit commencer par HTTPS).");
            }
        }

        if (nbBillets < capacite) {
            LBillets[nbBillets] = billet;
            nbBillets++;
        } else {
            System.out.println("Le blog est plein, impossible d'ajouter plus de billets.");
        }
    }

    public int getNombreBilletsTaggables() {
        int count = 0;
        for (int i = 0; i < nbBillets; i++) {
            if (LBillets[i] instanceof Taggable) {
                count++;
            }
        }
        return count;
    }

    public Publiable[] RechercheBilletsTaggablesParAuteur(String auteur) {
        Publiable[] result = new Publiable[nbBillets];
        int j = 0;
        for (int i = 0; i < nbBillets; i++) {
            if (LBillets[i] instanceof Taggable && LBillets[i].getAuteur().equals(auteur)) {
                result[j] = LBillets[i];
                j++;
            }
        }

        Publiable[] finalResult = new Publiable[j];
        for (int k = 0; k < j; k++) {
            finalResult[k] = result[k];
        }
        return finalResult;
    }

    public Publiable getPlusRecentBillet() {
        if (nbBillets == 0) {
            return null;  // Si le blog est vide, retourner null
        }

        Publiable plusRecent = LBillets[0];
        for (int i = 1; i < nbBillets; i++) {
            // Vérification si la date de publication n'est pas nulle avant de comparer
            if (LBillets[i].getDatePublication() != null &&
                    plusRecent.getDatePublication() != null &&
                    LBillets[i].getDatePublication().isAfter(plusRecent.getDatePublication())) {
                plusRecent = LBillets[i];
            }
        }
        return plusRecent;
    }

    public Publiable[] RechercheBilletsParContenu(String[] mots) {
        Publiable[] result = new Publiable[nbBillets];
        int j = 0;
        for (int i = 0; i < nbBillets; i++) {
            if (LBillets[i] instanceof Message) {
                Message messageBillet = (Message) LBillets[i];
                boolean containsAllWords = true;
                for (String mot : mots) {
                    if (messageBillet.getContenu().indexOf(mot) == -1) {
                        containsAllWords = false;
                        break;  // Si un mot n'est pas trouvé, sortir de la boucle
                    }
                }
                if (containsAllWords) {
                    result[j] = LBillets[i];
                    j++;
                }
            }
        }

        Publiable[] finalResult = new Publiable[j];
        for (int k = 0; k < j; k++) {
            finalResult[k] = result[k];
        }
        return finalResult;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Blog: ").append(titre).append("\n");
        sb.append("Billets publiés : ").append(nbBillets).append("\n");
        for (int i = 0; i < nbBillets; i++) {
            sb.append(LBillets[i].toString()).append("\n");
        }
        return sb.toString();
    }
}
