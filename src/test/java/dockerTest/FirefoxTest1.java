package dockerTest;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FirefoxTest1 {
    @Test
    public void test1() throws MalformedURLException {
        DesiredCapabilities dc = DesiredCapabilities.firefox();
        URL url = new URL("http://localhost:4444/wd/hub");
        RemoteWebDriver driver = new RemoteWebDriver(url, dc);
        driver.get("https://verizon.com");
        System.out.println("driver.getTitle() = " + driver.getTitle());
        driver.quit();

    }

}
