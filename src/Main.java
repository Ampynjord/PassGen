/**
 * PassGen
 * Génère un mot de passe selon les catégories de caractères séléctionnées
 * @author Gwenvaël Caouissin
 */

import java.util.Random;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

            //Longueur du mot de passe
            int longMdp = SimpleInput.getInt("Longueur du mot de passe : ");

            //Caractères disponibles
            String minLetters = "abcdefghijklmnopqrstuvwxyz";
            String majLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String numbers = "123456789";
            String specialChar = "²&é'(-è_çà)=~#{[|`^@]}'^¨$£¤%ùµ*!:;,§/.?*-+.";

            //Var
            boolean minLettersChoice;
            boolean majLettersChoice;
            boolean numbersChoice;
            boolean specialCharsChoice;

            //Entrées des catégories de caractères du mot de passe
            do {
                minLettersChoice = SimpleInput.getBoolean("Voulez vous des lettres minuscules ? : ");
                majLettersChoice = SimpleInput.getBoolean("Voulez vous des lettres majuscules ? : ");
                numbersChoice = SimpleInput.getBoolean("Voulez vous des nombres ? : ");
                specialCharsChoice = SimpleInput.getBoolean("Voulez vous des caractères spéciaux ? : ");
            } while (minLettersChoice == false && majLettersChoice == false && numbersChoice == false && specialCharsChoice == false);

            //Var
            String carDispo = "";

            //Conditions selon les entrées ci-dessus
            if (minLettersChoice && majLettersChoice && numbersChoice && specialCharsChoice) {
                carDispo = minLetters + majLetters + numbersChoice + specialChar;
            } else if (minLettersChoice && majLettersChoice == false && numbersChoice && specialCharsChoice == false) {
                carDispo = minLetters + numbersChoice;
            } else if (minLettersChoice == false && majLettersChoice && numbersChoice == false && specialCharsChoice) {
                carDispo = majLetters + specialChar;
            } else if (minLettersChoice && majLettersChoice == false && numbersChoice == false && specialCharsChoice == false) {
                carDispo = minLetters;
            } else if (minLettersChoice == false && majLettersChoice && numbersChoice == false && specialCharsChoice == false) {
                carDispo = majLetters;
            } else if (minLettersChoice == false && majLettersChoice == false && numbersChoice && specialCharsChoice == false) {
                carDispo = numbers;
            } else if (minLettersChoice == false && majLettersChoice == false && numbersChoice == false && specialCharsChoice) {
                carDispo = specialChar;
            } else if (minLettersChoice && majLettersChoice && numbersChoice && specialCharsChoice == false) {
                carDispo = minLetters + majLetters + numbers;
            } else if (minLettersChoice && majLettersChoice && numbersChoice == false && specialCharsChoice == false) {
                carDispo = minLetters + majLetters;
            } else if (minLettersChoice == false && majLettersChoice == false && numbersChoice && specialCharsChoice) {
                carDispo = numbers + specialChar;
            } else if (minLettersChoice == false && majLettersChoice && numbersChoice && specialCharsChoice) {
                carDispo = majLetters + numbers + specialChar;
            } else if (minLettersChoice && majLettersChoice == false && numbersChoice && specialCharsChoice) {
                carDispo = minLetters + numbers + specialChar;
            } else if (minLettersChoice && majLettersChoice && numbersChoice == false && specialCharsChoice) {
                carDispo = minLetters + majLetters + specialChar;
            } else if (minLettersChoice && majLettersChoice == false && numbersChoice == false && specialCharsChoice) {
                carDispo = minLetters + specialChar;
            } else if (minLettersChoice == false && majLettersChoice && numbersChoice && specialCharsChoice == false) {
                carDispo = majLetters + numbers;
            }

            //Var
            Random random = new Random();
            char randomChar = '0';
            int i;
            ArrayList<Character> mdpList = new ArrayList();

            //Choisis un nombre de caractère aléatoire égal à la longueur du mot de passe et les ajoute à uen liste
            for (i = 0; i < longMdp; i++) {
                int j = (i * 100) / longMdp;
                int randomInt = random.nextInt(carDispo.length());
                randomChar = carDispo.charAt(randomInt);
                System.out.print("Processing---------" + j + "%" + "\r");
                mdpList.add(randomChar);
            }

            //Converti la liste de caractères en une chaîne de caractère (String)
            StringBuilder sb = new StringBuilder();

            for (Character ch : mdpList) {
                sb.append(ch);
            }
            String mdp = sb.toString();

            System.out.println("Mot de passe généré : " + mdp);
    }
}