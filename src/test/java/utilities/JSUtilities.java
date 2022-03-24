package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JSUtilities {

    public static void scrollIntoViewJS(WebElement element) {
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) Driver.getDriver());
        jsexecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }}