import java.util.Locale;

public class Beaytufier{
    public void beautify(String word, Decorator decorator){
        String result=decorator.decorate(word);
        System.out.println(result);

    }

}
