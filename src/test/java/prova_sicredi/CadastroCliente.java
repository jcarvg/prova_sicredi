package prova_sicredi;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CadastroCliente {

	WebDriver driver;
	
	
	public CadastroCliente(WebDriver driver){
		this.driver =driver;
	}
	
	public CadastroCliente preencheName(String name) {
		driver.findElement(By.id("field-customerName")).sendKeys(name);
		return this;
	}
	
	
	public CadastroCliente preencheLastName(String lastName) {
		driver.findElement(By.id("field-contactLastName")).sendKeys(lastName);
		return this;
	}
	
	public CadastroCliente preencheContactFirstName(String contactFirstName) {
		driver.findElement(By.id("field-contactFirstName")).sendKeys(contactFirstName);
		return this;
	}
	
 	
	public CadastroCliente preenchePhone(String phone) {
		driver.findElement(By.id("field-phone")).sendKeys(phone);
		return this;
	}
	
	public CadastroCliente preencheAddressLine1(String addressLine1) {
		driver.findElement(By.id("field-addressLine1")).sendKeys(addressLine1);
		return this;
	}
	
	
	public CadastroCliente preencheAddressLine2(String addressLine2) {
		driver.findElement(By.id("field-addressLine2")).sendKeys(addressLine2);
		return this;
	}
	
	
	public CadastroCliente preencheCity(String city) {
		driver.findElement(By.id("field-city")).sendKeys(city);
		return this;
	}
	
	
	public CadastroCliente preencheState(String state) {
		driver.findElement(By.id("field-state")).sendKeys(state);
		return this;
	}
	
	
	public CadastroCliente preenchePostalCode(String postalCode) {
		driver.findElement(By.id("field-postalCode")).sendKeys(postalCode);
		return this;
	}
	
	
	public CadastroCliente preencheCountry(String country) {
		driver.findElement(By.id("field-country")).sendKeys(country);
		return this;
	}
	

     public CadastroCliente preencheCreditLimit(String creditLimit) {
 		driver.findElement(By.id("field-creditLimit")).sendKeys(creditLimit);
 		return this;
 	}
	
     public CadastroCliente preencheFromEmployeer(String fromEmployeer1){
         List<WebElement> fromEmployeer = driver.findElements(By.id("field_salesRepEmployeeNumber_chosen"));         
         for(WebElement employeer : fromEmployeer){
             if (employeer.isSelected())
                 System.out.println("Existe elemento selecionado");
             else
                 employeer.click();//se n existe elemento selecionado clica na lista de elementos
                 WebElement valor = driver.findElement(By.xpath("//*[@id='field_salesRepEmployeeNumber_chosen']/div/div/input"));
                 valor.sendKeys(fromEmployeer1); 
                 valor.sendKeys(Keys.TAB);
         }
     	return this;
     }
     
     public  void  clicaBotaoSave(){
    	   WebElement botaoSave = driver.findElement(By.id("form-button-save"));
           botaoSave.click();
     }
     
     public CadastroCliente selecionaVersao(String valorSeletor){
    	 WebElement selectVersion  = driver.findElement(By.id("switch-version-select"));         
         Select version = new Select(selectVersion);
         version.selectByValue(valorSeletor);
         return this;
     }
     
     
     public CadastroCliente validarAssert(String mensagemValidacao){
    	 WebElement mensagemSucesso = driver.findElement(By.xpath("//*[@id='report-success']/p")); 
    	 String mensagem = mensagemSucesso.getText();
    	 System.out.println(mensagem);
    	 String[] msg= mensagem.split("\\.");
    	 String   mensagemeditada= msg[0]; //Your data has been successfully stored into the database
    	 System.out.println(mensagemeditada);
    	 Assert.assertEquals(mensagemeditada, mensagemValidacao);
    	 return this;    	 
     }
 
     
     public  void clicarAddCustomer(){
    	 WebElement add_customer = driver.findElement(By.partialLinkText("Add Customer"));//linkText("https://www.grocerycrud.com/demo/bootstrap_theme_v4/add"));
         add_customer.click();
     }
     
}
