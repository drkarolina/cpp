package conteiners;

import java.util.ArrayList;
import java.util.Arrays;

public class RandomNameGenerator {
    private static final ArrayList<String> names = new ArrayList<>(Arrays.asList(
        "Neive", "Ruiz",
        "Colton", "Pace",
        "Jim", "Hensley",
        "Hakim", "Choi",
        "Farhan", "Melton",
        "Bianka", "Beach",
        "Nichola", "Kearns",
        "Katelyn", "Estrada",
        "Alivia", "Knapp",
        "Danyl", "Corona",
        "Juno", "Aldred",
        "Dave", "Dejesus",
        "Tonya", "Albert",
        "Emma-Louise", "Keller",
        "Hina", "Heath"));

    public static String GetRandomName(){
        int index = (int)(Math.random() * names.size());
        return names.get(index);
    }
}
