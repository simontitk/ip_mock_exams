import java.util.List;
import java.util.Map;

public class ReaderWithFilter extends TextReader {

    private List<String> filteredWords;

    
    public ReaderWithFilter(String text, List<String> filteredWords) {
        super(text);
        this.filteredWords = filteredWords;
    }


    public void filter() {
        this.filteredWords.forEach(w -> this.replace(w, "***"));
    }


    @Override
    public Map<String,Integer> counts() {
        Map<String,Integer> countMap = super.counts();
        this.filteredWords.forEach(w -> countMap.remove(w));
        return countMap;
    }

}
