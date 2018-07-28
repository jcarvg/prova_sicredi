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
         WebElement voltar =  teste1.driver.findElement(By.linkText(botaovoltar));
         voltar.click();
    
        //fazer uma espera pela nova pagina
            
    }
    
         
    @Test
    public void passo2(){        
        WebElement lupa = teste1.driver.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[1]/div[2]/a[3]"));
        WebElement lupaPesquisa = lupa.findElement(By.tagName("input"));
        WebElement loading = teste1.driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[1]"));
        lupa.click();
        lupaPesquisa.sendKeys(teste1.nome);
       //wait.until(ExpectedConditions.invisibilityOf(loading));
        lupaPesquisa.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(teste1.driver, 5);
        wait.until(ExpectedConditions.textToBePresentInElement(lupaPesquisa,"Teste Sicredi"));//(lupa));
        //WebDriverWait wait = new WebDriverWait(teste1.driver, 5);
      //  wait.until(ExpectedConditions.invisibilityOf(loading));
    }

 
    
    @Test
    public void passo3() { 
        
    	WebElement checkbox1 =  teste1.driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/form/div[2]/table/thead/tr[2]/td[1]/div/input"));    	
    	checkbox1.sendKeys(Keys.SPACE);                             
       // teste1.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    //	checkbox1.sendKeys(Keys.SPACE);
    	/*WebDriverWait wait = new WebDriverWait(teste1.driver, 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"gcrud-search-form\"]/div[2]/table/thead/tr[2]/td[2]/div[1]/a")));
    	*/
    } 	 
    


   // 4 Clicar no botão Delete
    @Test
    public void passo4(){
        WebElement botaoDelete = teste1.driver.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[2]/table/thead/tr[2]/td[2]/div[1]/a"));
        botaoDelete.click();
        WebDriverWait wait = new WebDriverWait(teste1.driver, 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("modal-dialog")));
    }
    
//5. Validar o texto "Are you sure that you want to delete this 1 item?" através de uma asserção para a popup que será apresentada    
    @Test
    public void passo5(){
    	String mensagemValidacao="Are you sure that you want to delete this 1 item?";
    	WebElement mensagemSucessoDelete = teste1.driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div[2]/p[2]"));
        String mensagem = mensagemSucessoDelete.getText();
        Assert.assertEquals(mensagem, mensagemValidacao); 
    }
    
//    6. Clicar no botão Delete da popup
    @Test
    public void passo6(){
    	WebElement botaoDeletePopUp = teste1.driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div[3]/button[2]"));
            	botaoDeletePopUp.click();
    }
    
   
    @Test
    public void passo7(){
    	String mensagemValidacao = "Your data has been successfully deleted from the database.";            
    	
    	WebElement mensagemSucessoDelete = teste1.driver.findElement(By.xpath("/html/body/div[3]/span/p"));
    	WebDriverWait wait = new WebDriverWait(teste1.driver, 5);
        wait.until(ExpectedConditions.visibilityOf(mensagemSucessoDelete));
    	String mensagem = mensagemSucessoDelete.getText(); 
        Assert.assertEquals(mensagem, mensagemValidacao); 
        teste1.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    
     
    @AfterClass
    public static void posCondicao(){
        teste1.driver.quit();
        
    }
    
}