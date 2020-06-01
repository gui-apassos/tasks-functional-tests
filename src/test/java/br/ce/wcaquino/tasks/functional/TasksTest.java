package br.ce.wcaquino.tasks.functional;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class TasksTest {
	
	public WebDriver acessarAplicacao() {
		System.setProperty("webdriver.chrome.driver", "C:\\Dev\\java\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://localhost:8080/tasks");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	
	@Test
	public void deveSalvarTarefacomSucesso() {
        WebDriver driver = acessarAplicacao();
		try {
		//clicar em add
		
		driver.findElement(By.id("addTodo")).click();
		
		//descrição
		
		driver.findElement(By.id("task")).sendKeys("Teste Selenium");
		
		//data

		driver.findElement(By.id("dueDate")).sendKeys("10/10/2020");
		
		
		//salvar
		driver.findElement(By.id("saveButton")).click();
		
		
		//msg sucesso
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Success!", message);
		
		}finally {
		//fechar navegador
		driver.quit();
		}
	}
	
	@Test
	public void naodeveSalvarTarefaSemDescricao() {
        WebDriver driver = acessarAplicacao();
		try {
		//clicar em add
		
		driver.findElement(By.id("addTodo")).click();
		
		//data

		driver.findElement(By.id("dueDate")).sendKeys("10/10/2020");
		
		
		//salvar
		driver.findElement(By.id("saveButton")).click();
		
		
		//msg sucesso
		String message = driver.findElement(By.id("message")).getText();
		Assert.assertEquals("Fill the task description", message);
		
		}finally {
		//fechar navegador
		driver.quit();
		}
	}
		@Test
		public void naoDeveSalvarTarefasemData() {
	        WebDriver driver = acessarAplicacao();
			try {
			//clicar em add
			
			driver.findElement(By.id("addTodo")).click();
			
			//descrição
			
			driver.findElement(By.id("task")).sendKeys("Teste Selenium");
			
			//salvar
			driver.findElement(By.id("saveButton")).click();
			
			
			//msg sucesso
			String message = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Fill the due date", message);
			
			}finally {
			//fechar navegador
			driver.quit();
			}
		}

		@Test
		public void naodeveSalvarTarefacomDataPassada() {
	        WebDriver driver = acessarAplicacao();
			try {
			//clicar em add
			
			driver.findElement(By.id("addTodo")).click();
			
			//descrição
			
			driver.findElement(By.id("task")).sendKeys("Teste Selenium");
			
			//data

			driver.findElement(By.id("dueDate")).sendKeys("10/10/2010");
			
			
			//salvar
			driver.findElement(By.id("saveButton")).click();
			
			
			//msg sucesso
			String message = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Due date must not be in past", message);
			
			}finally {
			//fechar navegador
			driver.quit();
			}
		}
}
	

