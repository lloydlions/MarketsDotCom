package utilities;

import java.util.Random;

public class HelperClass {

    public static String reformatEmail(String email){
        String[] arr = email.split("@");
        Random rnd = new Random();
        String unique = String.format("%06d", rnd.nextInt(999999));
        return arr[0] + unique + "@" + arr[1];
    }

    public static void sleep(){
        try {
            long timeOut = Long.parseLong(PropertyHelper.getPropValue("TIMEOUTPAGELOAD"));
            Thread.sleep(timeOut);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
