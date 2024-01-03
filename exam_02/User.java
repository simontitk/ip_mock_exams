import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {

    private String userIP;
    private int level;

    public User(int level) {
        this.level = level;
    }


    private boolean checkIPValidity(String ip) {
        Pattern p = Pattern.compile("99\\d*\\.\\d+\\.\\d+\\.\\d+");
        Matcher m = p.matcher(ip);
        return m.matches();
    } 

    
    public void setIP(String ip) {
        if (this.checkIPValidity(ip)) {
            this.userIP = ip;
        }
    }    
    
}
