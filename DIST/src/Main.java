import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> produits = new ArrayList<>(List.of("Eau", "Soda", "Chips", "Chocolat"));
        ArrayList<Double> prix = new ArrayList<>(List.of(5.0, 8.0, 12.0, 15.0));
        ArrayList<Integer> stock = new ArrayList<>(List.of(10, 5, 7, 3));
        Scanner sc = new Scanner(System.in);
        System.out.println("Produits disponibles :");
        for (int i = 0; i < produits.size(); i++) {
            System.out.println((i + 1) + ". " + produits.get(i) + " (" + prix.get(i) + " MAD) - Stock : " + stock.get(i));
        }

        System.out.print("\nEntrez le numéro du produit à acheter : ");
        int choix = sc.nextInt() - 1;

        if (choix < 0 || choix >= produits.size()) {
            System.out.println("Produit invalide !");
            return;
        }

        System.out.print("Entrez le montant inséré (en MAD) : ");
        double montant = sc.nextDouble();

        if (montant < prix.get(choix)) {
            System.out.println("Montant insuffisant !");
        } else {
            // Mettre à jour le stock
            stock.set(choix, stock.get(choix) - 1);
            double monnaie = montant - prix.get(choix);

            System.out.println("Vous avez acheté : " + produits.get(choix));
            System.out.println("Monnaie rendue : " + monnaie + " MAD");

            // Afficher le stock mis à jour
            System.out.println("\nStock après achat :");
            for (int i = 0; i < produits.size(); i++) {
                System.out.println(produits.get(i) + " - Stock : " + stock.get(i));
            }
        }


    }
}
