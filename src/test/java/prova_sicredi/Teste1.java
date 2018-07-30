package prova_sicredi;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.eclipse.jetty.http.PreEncodedHttpField;
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
     private static CadastroCliente cadastro;
     static String url="https://www.grocerycrud.com/demo/bootstrap_theme";
     String mensagemValidacao = "Your data has been successfully stored into the database";
    
     
    @BeforeClass
    public static void preCondicao() {
    	System.setProperty("webdriver.chrome.driver", "C:\\JavaLibs\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver(); 
        cadastro = new CadastroCliente(driver);
        driver.get(url);
        driver.manage().window().maximize();      
    }
    
    
    @Test
    public void passo2(){
    	cadastro.selecionaVersao("bootstrap_theme_v4");
    }
    
     
    
    @Test
    public void passo3(){        
       cadastro.clicarAddCustomer();
    }
    
    
    @Test
    public void passo4() {
    	cadastro.preencheName("Teste Sicredi");
    	cadastro.preencheLastName("Teste");
    	cadastro.preencheContactFirstName("juliano");
    	cadastro.preenchePhone("51 9999-9999");
    	cadastro.preencheAddressLine1("Av Assis Brasil, 3970");
    	cadastro.preencheAddressLine2("Torre D");
    	cadastro.preencheCity("Porto Alegre");
    	cadastro.preencheState("RS");
    	cadastro.preenchePostalCode("91000-000");
    	cadastro.preencheCountry("Brasil");
        cadastro.preencheFromEmployeer("Fixter");
    	cadastro.preencheCreditLimit("200");
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    
    
    
    @Test
    public void passo5(){
    	cadastro.clicaBotaoSave();
    }
    
    @Test
    public void passo6(){
    	cadastro.validarAssert(mensagemValidacao);
    }
    
    
    
   @AfterClass
    public static void posCondicao(){
        driver.close();
        
    }
    
}

