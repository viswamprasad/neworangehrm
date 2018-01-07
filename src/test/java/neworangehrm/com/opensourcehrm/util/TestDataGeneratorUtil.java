package neworangehrm.com.opensourcehrm.util;

import java.util.Random;

public class TestDataGeneratorUtil {

    static String[] someLetters = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u",
            "v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V",
            "W","X","Y","Z","0","1","2","3","4","5","6","7","8","9","$","_"};

    public static String getRandomWord(int length) {
        String randomWord = "";
        Random random = new Random();
        while(--length >= 0)
            randomWord += someLetters[random.nextInt(someLetters.length)];

        return randomWord;
    }
}