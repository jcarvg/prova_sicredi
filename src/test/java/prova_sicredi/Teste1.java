package prova_sicredi;

import static org.junit.Assert.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import    org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class Teste1 {


     static WebDriver driver;
     static String url="https://www.grocerycrud.com/demo/bootstrap_theme";
     String valorSeletor="bootstrap_theme_v4";
     String mensagemValidacao = "Your data has been successfully stored into the database";
     String nome = "Teste Sicredi";
    
    
    @BeforeClass
    public static void preCondicao() {
        System.setProperty("webdriver.chrome.driver", "C:\\JavaLibs\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver(); 
        driver.get(url);
        driver.manage().window().maximize();
    }
    
    
    @Test
    public void passo2(){
         WebElement selectVersion  = driver.findElement(By.id("switch-version-select"));         
        Select version = new Select(selectVersion);
        version.selectByValue(valorSeletor);
    }
    
     
    
    @Test
    public void passo3(){        
        WebElement add_customer = driver.findElement(By.partialLinkText("Add Customer"));//linkText("https://www.grocerycrud.com/demo/bootstrap_theme_v4/add"));
        add_customer.click();
    }
        
    @Test
    public void passo4() throws InterruptedException{
         driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
         WebElement name = driver.findElement(By.id("field-customerName"));
         WebElement lastName = driver.findElement(By.id("field-contactLastName"));
         WebElement contactFirstName = driver.findElement(By.id("field-contactFirstName"));
         WebElement phone = driver.findElement(By.id("field-phone"));
         WebElement addressLine1 = driver.findElement(By.id("field-addressLine1"));
         WebElement addressLine2 = driver.findElement(By.id("field-addressLine2"));
         WebElement city = driver.findElement(By.id("field-city"));
         WebElement state = driver.findElement(By.id("field-state"));
         WebElement postalCode = driver.findElement(By.id("field-postalCode"));
         WebElement country = driver.findElement(By.id("field-country"));
         List<WebElement> fromEmployeer = driver.findElements(By.id("field_salesRepEmployeeNumber_chosen"));         
         WebElement CreditLimit = driver.findElement(By.id("field-creditLimit"));
         name.sendKeys(nome);
         lastName.sendKeys("Teste");
         contactFirstName.sendKeys("juliano");
         phone.sendKeys("51 9999-9999");
         addressLine1.sendKeys("Av Assis Brasil, 3970");
         addressLine2.sendKeys("Torre D");
         city.sendKeys("Porto Alegre");
         state.sendKeys("RS");
         postalCode.sendKeys("91000-000");
         country.sendKeys("Brasil");
         for(WebElement employeer : fromEmployeer){
             if (employeer.isSelected())
                 System.out.println("Existe elemento selecionado");
             else
                 employeer.click();//se n existe elemento selecionado clica na lista de elementos
                  WebElement valor = driver.findElement(By.xpath("//*[@id='field_salesRepEmployeeNumber_chosen']/div/div/input"));
                  valor.sendKeys("Fixter"); 
                  valor.sendKeys(Keys.TAB);
         } 
         CreditLimit.sendKeys("200");
         Thread.sleep(1000);
    }
    
    @Test
    public void passo5(){
        WebElement botaoSave = driver.findElement(By.id("form-button-save"));
        botaoSave.click();
        //verificacao para ver se o item foi clicado

    }
    
    @Test
    public void passo6(){
    	WebElement mensagemSucesso = driver.findElement(By.xpath("//*[@id=\"report-success\"]/p"));
        String mensagem = mensagemSucesso.getText();
    	String[] msg= mensagem.split("\\.");
    	String   mensagemeditada= msg[0]; //Your data has been successfully stored into the database
        Assert.assertEquals(mensagemeditada, mensagemValidacao);
    }
    
    
    
   @AfterClass
    public static void posCondicao(){
        driver.close();
        
    }
    
}

