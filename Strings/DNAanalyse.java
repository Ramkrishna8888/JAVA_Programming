import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of DNA sequences: ");
        int N = sc.nextInt();
        sc.nextLine();  
        
        if (N <= 0) {
            System.out.println("The number of sequences must be greater than zero");
            return;
        }

        String[] sequences = new String[N];
        int seqLength = -1;
        
        for (int i = 0; i < N; i++) {
            String seq = sc.nextLine();
            sequences[i] = seq;
            
            if (seqLength == -1) {
                seqLength = seq.length();
            } else if (seq.length() != seqLength) {
                System.out.println("All sequences are not of the same length");
                return;
            }
        }

        for (int i = 0; i < N; i++) {  
            String seq = sequences[i];
            int purineCount = 0;
            int pyrimidineCount = 0;

            for (int j = 0; j < seq.length(); j++) {  
                char nucleotide = seq.charAt(j);

                if (nucleotide == 'A' || nucleotide == 'G') {
                    purineCount++;
                }
                if (nucleotide == 'C' || nucleotide == 'T') {
                    pyrimidineCount++;
                }
            }

            System.out.println(purineCount + " " + pyrimidineCount);
        }
    }
}
