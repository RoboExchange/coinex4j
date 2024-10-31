package ir.moke.sdk.api;

import java.io.InputStream;
import java.util.Properties;

public class Configuration {
    public static String ACCESS_ID;
    public static String SECRET_KEY;

    static {
        try (InputStream is = PerpetualTest.class.getClassLoader().getResourceAsStream("test.properties")) {
            Properties properties = new Properties();
            properties.load(is);
            ACCESS_ID = properties.getProperty("ACCESS_ID");
            SECRET_KEY = properties.getProperty("SECRET_KEY");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}