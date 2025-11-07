import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> produits = new ArrayList<>(List.of("Eau", "Soda", "Chips", "Chocolat"));
        ArrayList<Double> prix = new ArrayList<>(List.of(5.0, 8.0, 12.0, 15.0));
        ArrayList<Integer> stock = new ArrayList<>(List.of(10, 5, 7, 3));

        Scanner scanner = new Scanner(System.in);


        System.out.print("Entrez le numéro du produit que vous voulez acheter: ");
        int numeroProduit = scanner.nextInt();



        if (numeroProduit < 1 || numeroProduit > produits.size()) {
            System.out.println("Numéro de produit invalide !");
            return;
        }

        acheterProduit(produits, prix, stock, numeroProduit - 1);
    }

    public static void acheterProduit(ArrayList<String> produits, ArrayList<Double> prix,
                                      ArrayList<Integer> stock, int index) {

        Scanner scanner = new Scanner(System.in);

        int stockDisponible = stock.get(index);

        if (stockDisponible <= 0) {
            System.out.println("Ce produit n'est pas disponible !");
            return;
        }

        double total = prix.get(index);
        String nomProduit = produits.get(index);

        System.out.print("Veuillez insérer la monnaie: ");
        double argent = scanner.nextDouble();

        if (argent < total) {
            System.out.println("Montant insuffisant.");
            return;
        }

        double change = argent - total;



        System.out.println("Achat réussi !");
        System.out.println("Produit : " + nomProduit);
        System.out.println("Argent inséré : " + argent + " DH");
        System.out.println("Monnaie rendue : " + change + " DH");
    }
}
