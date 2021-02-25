package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Web {

    public static final String AUTOMATE_USERNAME = "lorranpdossantos1";
    public static final String AUTOMATE_ACCESS_KEY = "cpS6YFifUpySF18X4e1G";
    public static final String URL = "https://" + AUTOMATE_USERNAME
            + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static WebDriver createChrome(){

        // Abrindo o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Drivers\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Para que a janela do navegador já abra maximizada!!!!
        navegador.manage().window().maximize();

        // Navegando para a página do Taskit
        navegador.get("http://www.juliodelima.com.br/taskit");

        return navegador;
    }

    public static WebDriver createBrowserStack(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1024x768");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("os", "Windows");
        caps.setCapability("name", "BStack-[Java] Sample Test"); // test name
        caps.setCapability("build", "BStack Build Number 1"); // CI/CD job or build name
        WebDriver navegador = null;

        try{
            navegador = new RemoteWebDriver(new URL(URL), caps);
            navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            navegador.manage().window().maximize();
            navegador.get("http://www.juliodelima.com.br/taskit");
        } catch (MalformedURLException e){
            System.out.println("Houve problemas com a URL: " + e.getMessage());
        }

        return navegador;
    }
}