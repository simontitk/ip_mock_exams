import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AdvancedProjectBase extends ProjectBase {

    
    public AdvancedProjectBase(List<String> projectTitles) {
        super(projectTitles);
    }


    @Override
    public Set<String> search(String query) {
        String[] queryTerms = query.split(",");
        Set<String> result = new HashSet<>();
        for (String t : queryTerms) {
            result.addAll(super.search(t));
        }
        return result;
    }

}
