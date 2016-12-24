package silentmodetoggle.android.dummies.com.funfacts;

import java.util.Random;

/**
 * Created by ADMINN on 10-09-2016.
 */

public class Funfacts {
    public String[] facts = {"Around a 100 million years ago, India was an island",
            " India’s name is derived from the “Indus” river.",
            "Indus Valley Civilisation is the world’s oldest civilisation",
            " India has the world’s third largest active army, after China and USA.",
            "Varanasi is the oldest, continuously inhabited city in the world today.",
            "Kangaroos use their tails for balance, so if you lift a kangaroo’s tail off the ground, it can’t hop",
            "On average, there are 50,000 spiders per acre in green areas. Bet you’ll think twice before going outside now – unless you’re this guy.",
            "You cant fold a peice of paper more than seven times.",
            "Ostriches run faster than horses.",
            "Lamborgini was founded by a Tractor company",
            "Sweating help in growing beard faster",
    };
    public String getfact() {

        String fact1 = "";
        Random randomgenerator = new Random();
        int randomnumber = randomgenerator.nextInt(facts.length);
        fact1 = facts[randomnumber];
        return fact1;
    }
}
