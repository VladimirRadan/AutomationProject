package utils;

import io.github.cdimascio.dotenv.Dotenv;
import org.testng.annotations.DataProvider;

public class Utils {

    public static Dotenv dotEnv() {
        return Dotenv.configure()
                .ignoreIfMalformed()
                .ignoreIfMissing()
                .load();
    }


    public static void waitForSeconds(double seconds) {
        try {
            Thread.sleep((long) (seconds * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @DataProvider(name = "dpTest")
    public static Object[][] dpTest() {
        return new Object[][]{
                {"username 1", ""},
                {"username 2", "password 2"},
                {"username 3", "password 3"}
        };
    }




}
