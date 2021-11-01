import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static void takeScreenShot(WebDriver driver,String fileNameSuffix, String path) throws IOException {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd-HHmmssSSS");
        String fileName =   format.format(new Date())+ "_" + fileNameSuffix + ".png";
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(path+fileName);
        FileHandler.copy(src,destFile);
    }
}
