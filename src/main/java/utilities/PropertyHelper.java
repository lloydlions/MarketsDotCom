package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyHelper {

    private static final String PROPERTY_FILE = System.getProperty("user");
    private static Properties prop = new Properties();

    //load property config
    public static String getPropValue(String key) throws Exception {
        try{
            FileInputStream fi = new FileInputStream(System.getProperty("user.dir")
                    + File.separator + "src"
                    + File.separator + "test"
                    + File.separator + "resources"
                    + File.separator + "config.properties");
            prop = new Properties();
            prop.load(fi);

        }catch (Exception e){

        }
        return prop.getProperty(key);
    }


}