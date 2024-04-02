import java.util.Scanner;
public class Main {
    public static void main(String[] Args){
        
        
        mainMenu();
    }

    public static void mainMenu(){
        Scanner sc = new Scanner(System.in);
        String scelta;

        System.out.println("Scrivi 'cifra' per cifrare una stringa");
        System.out.println("Scrivi 'decifra' per decifrare una stringa");
        System.out.println("Scrivi 'esci' per terminare il programma");
        
        switch (scelta = sc.nextLine()) {
            case "cifra":
                cifra(sc);
                break;
            case "decifra":
                decifra(sc);
                break;
            case "esci":
                System.exit(0);
            default:
                System.out.println("Il valore inserito non è valido, il programma terminerà.");
                System.exit(1);
        }
    }
    
    public static void cifra(Scanner sc){
        System.out.println("Inserisci la frase che vuoi cifrare:");
        
        String frase = sc.nextLine();     
        frase = frase.toLowerCase();
        
        int lunghezza = frase.length();     
        char[] arrayFrase = frase.toCharArray();
        
        System.out.println("Che chiave di cifratura vuoi usare?");
 
        int chiave = sc.nextInt();
        
        for(int i = 0; i < arrayFrase.length; i++){
            if(arrayFrase[i] != ' ' && arrayFrase[i] != ',' && arrayFrase[i] != '.' && arrayFrase[i] != '!' && arrayFrase[i] != '?' && arrayFrase[i] != '\'' && arrayFrase[i] != 'à' && arrayFrase[i] != 'è' && arrayFrase[i] != 'ì' && arrayFrase[i] != 'ò' && arrayFrase[i] != 'ù'){
                int asciiZ = (int) 'z';
                int asciiA = (int) 'a';
                int ascii = (int) arrayFrase[i];
                ascii += chiave;
                char next = (char) ascii;
                if(next > asciiZ){
                    int diff = next -= asciiZ;
                    char nextAfter = (char) (asciiA + diff - 1);
                    arrayFrase[i] = nextAfter;
                }
                else{
                    arrayFrase[i] = next;
                }
            }
            
        }

        System.out.println("La frase cifrata è:");
        
        for(int i = 0; i < arrayFrase.length; i++){
            System.out.print(arrayFrase[i]);
        }

        System.out.print('\n');

        mainMenu();
    }
    
    public static void decifra(Scanner sc){
        System.out.println("Inserisci la frase che vuoi decifrare:");
        
        String frase = sc.nextLine();     
        frase = frase.toLowerCase();
        
        int lunghezza = frase.length();     
        char[] arrayFrase = frase.toCharArray();
        
        System.out.println("Che chiave di cifratura vuoi usare?");
   
        int chiave = sc.nextInt();       
        
        for(int i = 0; i < arrayFrase.length; i++){
            if(arrayFrase[i] != ' ' && arrayFrase[i] != ',' && arrayFrase[i] != '.' && arrayFrase[i] != '!' && arrayFrase[i] != '?' && arrayFrase[i] != '\'' && arrayFrase[i] != 'à' && arrayFrase[i] != 'è' && arrayFrase[i] != 'ì' && arrayFrase[i] != 'ò' && arrayFrase[i] != 'ù'){
                int asciiZ = (int) 'z';
                int asciiA = (int) 'a';
                int ascii = (int) arrayFrase[i];
                ascii -= chiave;
                char next = (char) ascii;
                if(next < asciiA){
                    int diff = asciiA -= next;
                    char nextAfter = (char) (asciiZ - diff - 1);
                    arrayFrase[i] = nextAfter;
                }
                else{
                    arrayFrase[i] = next;
                }
            }
            
        }
        System.out.println("La frase decifrata è:");
        
        for(int i = 0; i < arrayFrase.length; i++){
            System.out.print(arrayFrase[i]);
        }

        System.out.print('\n');

        mainMenu();
    }
    
}
