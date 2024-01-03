import java.util.HashMap;
import java.util.Map;

public class TextReader {

    private String text;

    public TextReader(String text) {
        this.text = text;
    }

    // this replaces all occurences of s, even in substrings. the expected behaviour might be different
    public void replace(String s, String t) {
        this.text = this.text.replaceAll(s, t);
    }

    public Map<String,Integer> counts() {
        Map<String,Integer> countMap = new HashMap<>();
        for (String word : this.text.split(" ")) {
            countMap.merge(word, 1, Integer::sum);
        }
        return countMap;
        
    }
    
}
