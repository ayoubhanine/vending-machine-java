import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class VendingMachine {
    static ArrayList<String> produits = new ArrayList<>(List.of("Eau", "Soda", "Chips", "Chocolat"));
    static ArrayList<Double> prix = new ArrayList<>(List.of(5.0, 8.0, 12.0, 15.0));
    static ArrayList<Integer> stock = new ArrayList<>(List.of(10, 5, 7, 3));

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            afficherMenuPrincipal();
            System.out.print("Entrez votre choix : ");
            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    afficherProduits();
                    break;
                case 2:
                    acheterProduit();
                    break;
                case 3:
                    System.out.println("Fin de programme !");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println(" Choix invalide. Veuillez entrer 1, 2 ou 3.\n");
            }
        }
    }
    public static void afficherMenuPrincipal() {
        System.out.println("\n DISTRIBUTEUR AUTOMATIQUE");
        System.out.println("1. Afficher les produits");
        System.out.println("2. Acheter un produit");
        System.out.println("3. Quitter");
    }
    public static void afficherProduits() {
        System.out.println("\n PRODUITS DISPONIBLES");
        for (int i = 0; i < produits.size(); i++) {
            System.out.println((i + 1) + ". " + produits.get(i)
                    + " -" + prix.get(i) + " MAD - Stock : " + stock.get(i));
        }
    }
    public static void acheterProduit() {
        Scanner sc = new Scanner(System.in);
        afficherProduits();
        System.out.print("\n Entrez le numéro du produit à acheter : ");
        int numeroProduit = sc.nextInt();

        if (numeroProduit < 1 || numeroProduit > produits.size()) {
            System.out.println(" Numéro de produit invalide ");
            return;
        }

        int index = numeroProduit - 1;

        if (stock.get(index) <= 0) {
            System.out.println(" Ce produit est indisponible dans le stock ");
            return;
        }

        System.out.print("Insérez le montant  : ");
        double montant = sc.nextDouble();

        if (montant < prix.get(index)) {
            System.out.println(" Montant insuffisant ");
            return;
        }

        double monnaie = montant - prix.get(index);
        stock.set(index, stock.get(index) - 1);

        System.out.println("\n Achat réussi ");
        System.out.println("Produit : " + produits.get(index));
        System.out.println("Prix : " + prix.get(index) + " MAD");
        System.out.println("Monnaie rendue : " + monnaie + " MAD");
        System.out.println("Stock restant : " + stock.get(index));
        System.out.println("\n");
    }
}
