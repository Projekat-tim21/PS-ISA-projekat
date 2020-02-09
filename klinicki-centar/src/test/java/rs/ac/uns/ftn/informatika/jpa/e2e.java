package rs.ac.uns.ftn.informatika.jpa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class e2e {

	private WebDriver driver;

	@Before
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "src/test/java/rs/ac/uns/ftn/informatika/jpa/chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();

	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void testZakazivnjePregled() {
		driver.get("http://localhost:8081/");
		driver.findElement(By.linkText("Logovanje")).click();
		driver.get("http://localhost:8081/login");
		driver.manage().window().fullscreen();
		driver.findElement(By.id("username")).click();
		driver.findElement(By.id("username")).sendKeys("miki");
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).sendKeys("miki");
		driver.findElement(By.id("login")).click();
		driver.get("http://localhost:8081/AdminPraviPreglede");
		driver.get("http://localhost:8081/kreirajPregledZaLekara?id=1");
		driver.findElement(By.id("inputText")).click();
		driver.findElement(By.id("inputText")).sendKeys("2020-10-04T15:42");
		driver.findElement(By.id("sala")).click();
		driver.findElement(By.id("sala")).sendKeys("2B");
		driver.findElement(By.id("cena")).click();
		driver.findElement(By.id("cena")).sendKeys("1000");
		driver.findElement(By.id("popust")).click();
		driver.findElement(By.id("popust")).sendKeys("5");
		driver.findElement(By.id("potvrda")).click();
		driver.switchTo().alert().accept();
		driver.get("http://localhost:8081/sacuvajTermine2");
		
	}

	@Test
	public void TestPacijetnZakazujePregled() {

		driver.get("http://localhost:8081/");
		driver.findElement(By.linkText("Logovanje")).click();
		driver.get("http://localhost:8081/login");
		driver.manage().window().fullscreen();
		driver.findElement(By.id("username")).click();
		driver.findElement(By.id("username")).sendKeys("marko22");
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("password")).sendKeys("markomarkovic");
		driver.findElement(By.id("login")).click();
		driver.get("http://localhost:8081/zakaziPregledKojiJeDef?id=12");
		driver.get("http://localhost:8081/uspesnoZakazanPregled2?id=1&idpac=12");
		driver.findElement(By.id("clickMe")).click();
		driver.switchTo().alert().accept();
		
		
	}

}