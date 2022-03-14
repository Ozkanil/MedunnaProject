package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {



    //1-Properties objesi olusturacagiz
    static Properties properties;

    //2-Bu classin amaci configration.propertiesdosyasini okumak
    // ve aradaki key ikililerini kullanarak istegimiz key e ait value bize getirmek

    static {
        String dosyaYolu="configuration.properties";

        try {
            FileInputStream fileInputStream=new FileInputStream(dosyaYolu);
            properties=new Properties();
            properties.load(fileInputStream);
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }




    //3-test classlarindan configReader classina
    // ulasip yukaridaki islemleri yapmamizi saglayacak bir method

    public static String getProperty(String key){

        String value=properties.getProperty(key);
        return value;
    }
}
