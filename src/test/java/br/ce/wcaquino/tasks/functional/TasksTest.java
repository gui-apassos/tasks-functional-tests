package br.ce.wcaquino.tasks.functional;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;




public class TasksTest {
	
	public WebDriver acessarAplicacao() throws MalformedURLException {
	new DesiredCapabilities();
		//	WebDriver driver = new ChromeDriver();
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		WebDriver driver = new RemoteWebDriver(new URL ("http://192.168.56.1:4444/wd/hub"), cap);
		driver.navigate().to("http://192.168.56.1:8080/tasks");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	
	@Test
	public void deveSalvarTarefacomSucesso() throws MalformedURLException {
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
	public void naodeveSalvarTarefaSemDescricao() throws MalformedURLException {
        WebDriver driver = acessarAplicacao();
		try {
		//clicar em add
		
		driver.findElement(By.id("addTodo")).click();
		
		//data

		driver.findElement(By.id("dueDate")).sendKeys("10/10/2020");
		
		
		//salvar
		driver.findElement(By.id("saveButton")).click();
		
		
		//msg sucesso
		//String message = driver.findElement(By.id("message")).getText();
		//Assert.assertEquals("Fill the task description", message);
		
		//msg sucesso
		WebElement message = driver.findElement(By.id("message"));
		String text = message.getText();
		Assert.assertEquals("Fill the task description", text);
		
		}finally {
		//fechar navegador
		driver.quit();
		}
	}
		@Test
		public void naoDeveSalvarTarefasemData() throws MalformedURLException {
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
		public void naodeveSalvarTarefacomDataPassada() throws MalformedURLException {
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

		@Test
		public void deveRemoverTarefaComSucesso() throws MalformedURLException {
	        WebDriver driver = acessarAplicacao();
			try {
			//inserir uma tarefa
			driver.findElement(By.id("addTodo")).click();
			driver.findElement(By.id("task")).sendKeys("Teste Selenium");
			driver.findElement(By.id("dueDate")).sendKeys("10/10/2010");
			driver.findElement(By.id("saveButton")).click();
			String message = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Sucess!", message);
			
			//Remover a tarefa
			driver.findElement(By.xpath("//a[@class='btn btn-outline-danger btn-sm']")).click();
			message = driver.findElement(By.id("message")).getText();
			Assert.assertEquals("Sucess!", message);
			}finally {
			//fechar navegador
			driver.quit();
			}
		}
	}
	

