import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Création d'un blog avec une capacité de 5 billets
        Blog monBlog = new Blog("Mon Super Blog", 5);

        // Création de messages
        Message message1 = new Message(LocalDate.of(2024, 12, 1), "Auteur1", "Ceci est le contenu du premier message");
        Message message2 = new Message(LocalDate.of(2024, 12, 2), "Auteur2", "Ceci est le contenu du deuxième message");

        // Création de vidéos
        Video video1 = new Video(LocalDate.of(2024, 12, 3), "Auteur3", 10, "https://video1.com");
        Video video2 = new Video(LocalDate.of(2024, 12, 4), "Auteur1", 15, "https://video2.com");

        try {
            // Publication des billets sur le blog
            monBlog.post(message1);
            monBlog.post(message2);
            monBlog.post(video1);
            monBlog.post(video2);
        } catch (InvalidURLException e) {
            System.out.println("Erreur lors de la publication d'une vidéo : " + e.getMessage());
        }

        // Affichage du blog
        System.out.println(monBlog);

        // Nombre de billets taggables
        System.out.println("Nombre de billets taggables : " + monBlog.getNombreBilletsTaggables());

        // Recherche de billets taggables par auteur
        Publiable[] billetsAuteur1 = monBlog.RechercheBilletsTaggablesParAuteur("Auteur1");
        System.out.println("Billets de Auteur1 : ");
        for (Publiable billet : billetsAuteur1) {
            System.out.println(billet);
        }

        // Recherche du billet le plus récent
        Publiable plusRecent = monBlog.getPlusRecentBillet();
        System.out.println("Billet le plus récent : " + plusRecent);

        // Recherche de billets par contenu
        String[] mots = {"contenu", "premier"};
        Publiable[] billetsParContenu = monBlog.RechercheBilletsParContenu(mots);
        System.out.println("Billets contenant tous les mots : ");
        for (Publiable billet : billetsParContenu) {
            System.out.println(billet);
        }
    }
}
