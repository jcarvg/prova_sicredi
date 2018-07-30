package prova_sicredi;

import static org.junit.Assert.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import    org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Teste2 {

    static Teste1 teste1;
    private static CadastroCliente cadastro;
    WebDriverWait wait;
    String mensagemValidacao1="Are you sure that you want to delete this 1 item?";
	String mensagemValidacao2 = "Your data has been successfully deleted from the database.";            
	
    @BeforeClass
    public static void preCondicao() throws InterruptedException {
        teste1 = new Teste1();
        teste1.preCondicao();
        teste1.passo2();
        teste1.passo3();
        teste1.passo4();
        teste1.passo5();
        teste1.passo6();
        cadastro = new CadastroCliente(teste1.driver);
    }
    
    
    @Test
    public void passo1() {
    	cadastro.botaoVoltar();    	
    }
    
         
    @Test
    public void passo2(){        
    	cadastro.clicaLupa("Teste Sicredi");
    }

    
    @Test
    public void passo3() { 
    	cadastro.clicarCheckbox();                            
    } 	 
    

   // 4 Clicar no botão Delete
    @Test
    public void passo4(){
        cadastro.clicarBotaoDelete();
        wait = new WebDriverWait(teste1.driver, 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("modal-dialog")));
    }
    
//5. Validar o texto "Are you sure that you want to delete this 1 item?" através de uma asserção para a popup que será apresentada    
    @Test
    public void passo5(){
    	cadastro.ValidarDeleteItens(mensagemValidacao1);
    }
    
//    6. Clicar no botão Delete da popup
    @Test
    public void passo6(){
    	cadastro.clicarBotaoDeletePopUp();
    }
    
   
    @Test
    public void passo7(){
    	cadastro.ConfirmaDeleteItens(mensagemValidacao2);
        teste1.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    
     
    @AfterClass
    public static void posCondicao(){
        teste1.driver.quit();
        
    }
    
}