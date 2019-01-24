package strings.coursera.week2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReconstructStringFromBWT {

    public String reconstruct(String text) {
        List<String> reconstructed = new ArrayList<>();
        List<String> original = new ArrayList<>();
        for(int i=0;i<text.length();i++) {
            reconstructed.add(text.substring(i, i+1));
        }
        original.addAll(reconstructed);
        for(int i=0;i<text.length()-1;i++) {
            Collections.sort(reconstructed);
            for(int j=0;j<text.length();j++) {
                reconstructed.set(j, original.get(j)+reconstructed.get(j));
            }
        }
        Collections.sort(reconstructed);
        System.out.println(reconstructed);
        return reconstructed.get(0).substring(1, text.length()) + "$";
    }

    public static void main(String[] args) {
        ReconstructStringFromBWT recon = new ReconstructStringFromBWT();
        System.out.println(recon.reconstruct("annb$aa"));
    }

}
