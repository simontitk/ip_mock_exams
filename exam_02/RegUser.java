import java.util.Set;

public class RegUser extends User {

    private int region;

    
    public RegUser(int level, int region) {
        super(level);
        this.region = region;
    }
    

    private boolean checkIPValidity(String ip) {
        return !Set.of(ip.split("\\.")).contains("111");
    }


    @Override
    public void setIP(String ip) {
        if (this.checkIPValidity(ip)) {
            super.setIP(ip);
        }
    }
}
