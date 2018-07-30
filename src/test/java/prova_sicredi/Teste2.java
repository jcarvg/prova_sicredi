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
    WebDriverWait wait;
    WebElement voltar;
    WebElement lupa;
    WebElement lupaPesquisa;
    WebElement loading;
    WebElement checkbox1;
    WebElement botaoDelete;
    String mensagemValidacao1="Are you sure that you want to delete this 1 item?";
	WebElement mensagemSucessoDelete1;
	WebElement botaoDeletePopUp;
	String mensagemValidacao2 = "Your data has been successfully deleted from the database.";            
	WebElement mensagemSucessoDelete2;
	
    @BeforeClass
    public static void preCondicao() throws InterruptedException {
        teste1 = new Teste1();
        teste1.preCondicao();
        teste1.passo2();
        teste1.passo3();
        teste1.passo4();
        teste1.passo5();
        teste1.passo6();
    }
    
    
    @Test
    public void passo1() {
         String botaovoltar = "Go back to list"; 
         voltar =  teste1.driver.findElement(By.linkText(botaovoltar));
         voltar.click();
    }
    
         
    @Test
    public void passo2(){        
        lupa = teste1.driver.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[1]/div[2]/a[3]"));
        lupaPesquisa = lupa.findElement(By.tagName("input"));
        loading = teste1.driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[1]"));
        wait = new WebDriverWait(teste1.driver, 10);
        wait.until(ExpectedConditions.visibilityOf(lupa));
        lupa.click();
     //   lupaPesquisa.sendKeys(teste1.nome);
        lupaPesquisa.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.invisibilityOf(loading));
    }

 
    
    @Test
    public void passo3() { 
    	checkbox1 =  teste1.driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/form/div[2]/table/thead/tr[2]/td[1]/div/input"));    	
    	checkbox1.sendKeys(Keys.SPACE);                             
    } 	 
    


   // 4 Clicar no botão Delete
    @Test
    public void passo4(){
        botaoDelete = teste1.driver.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[2]/table/thead/tr[2]/td[2]/div[1]/a"));
        botaoDelete.click();
        wait = new WebDriverWait(teste1.driver, 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("modal-dialog")));
    }
    
//5. Validar o texto "Are you sure that you want to delete this 1 item?" através de uma asserção para a popup que será apresentada    
    @Test
    public void passo5(){
    	mensagemSucessoDelete1 = teste1.driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div[2]/p[2]"));
        String mensagem = mensagemSucessoDelete1.getText();
        Assert.assertEquals(mensagem, mensagemValidacao1); 
    }
    
//    6. Clicar no botão Delete da popup
    @Test
    public void passo6(){
    	botaoDeletePopUp = teste1.driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div[3]/button[2]"));
        botaoDeletePopUp.click();
    }
    
   
    @Test
    public void passo7(){
    	mensagemSucessoDelete2 = teste1.driver.findElement(By.xpath("/html/body/div[3]/span/p"));
        wait.until(ExpectedConditions.visibilityOf(mensagemSucessoDelete2));
    	String mensagem = mensagemSucessoDelete2.getText(); 
        Assert.assertEquals(mensagem, mensagemValidacao2); 
        teste1.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    
     
    @AfterClass
    public static void posCondicao(){
        teste1.driver.quit();
        
    }
    
}