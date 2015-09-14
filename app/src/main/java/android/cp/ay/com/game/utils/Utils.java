package android.cp.ay.com.game.utils;

import java.util.Random;

/**
 * Created by ayesh on 9/11/15.
 */
public class Utils {


    /**
     * Random number generator
     * @return
     * @throws Exception
     */
    public static int getRandomNumber() throws Exception {
        try {



            Random generator = new Random();

            int i = generator.nextInt(10000) + 1;
            int j = generator.nextInt(1000) + 1;
            int k = generator.nextInt(100) + 1;

            return (i+j+k);


        } catch (Exception e) {
            throw e;
        }
    }

}
