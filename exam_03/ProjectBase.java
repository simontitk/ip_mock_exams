import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProjectBase {

    private List<String> projectTitles;

    
    public ProjectBase(List<String> projectTitles) {
        this.projectTitles = projectTitles;
    }


    public void addTitle(String t) {
        this.projectTitles.add(t);
    }


    public Set<String> search(String query) {
        return this.projectTitles.stream()
            .filter(title -> title.contains(query))
            .collect(Collectors.toSet());
    }
}
