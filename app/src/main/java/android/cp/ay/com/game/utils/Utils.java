package android.cp.ay.com.game.utils;

import java.util.Calendar;
import java.util.Random;

/**
 * Created by ayesh on 9/11/15.
 */
public class Utils {


    public static int getRandomNumber() throws Exception {
        try {

//            long value = System.currentTimeMillis();
//            Random random = new Random(value);
//
//
//            return  random.nextInt();

            Random generator = new Random();
            int i = generator.nextInt(10000) + 1;
            int j = generator.nextInt(1000) + 1;
            int k = generator.nextInt(100) + 1;

            return (i+j+k);
//            return safeLongToInt(value);


        } catch (Exception e) {
            throw e;
        }
    }


    public static int safeLongToInt(long l) {
        if (l < Integer.MIN_VALUE || l > Integer.MAX_VALUE) {

            return 1;
        }
        return (int) l;
    }
}
