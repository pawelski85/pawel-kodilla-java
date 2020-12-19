import java.util.Locale;

public class StreaMain {
    public static void main(String[] args) {

        Beaytufier beaytufier=new Beaytufier();

        beaytufier.beautify("pawel",(n)->n.toUpperCase(Locale.ROOT));
    }
}
