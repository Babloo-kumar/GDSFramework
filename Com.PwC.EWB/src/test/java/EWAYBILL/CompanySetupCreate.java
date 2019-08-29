package EWAYBILL;

import java.io.IOException;
//import java.util.concurrent.TimeUnit;

//import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class CompanySetupCreate 
{
	public static WebDriver driver;
	public static WebElement Element;
	public static Actions action;
	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	
	@Test
	public static void LunchBrowser() throws InterruptedException
	{
	   System.setProperty("webdriver.chrome.driver", "E:/PwC/Com.PwC.EWB/Driver/Chrome/chromedriver.exe");
	   driver = new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.get("http://qa-win-639340329.ap-south-1.elb.amazonaws.com/web1/");
	   Thread.sleep(1000);
	   driver.findElement(By.id("username")).sendKeys("Admin1");
	   driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("P@ss1234");
	   driver.findElement(By.xpath(".//*[@id='login']")).click();
	   Thread.sleep(2000);
	   
	   Element = driver.findElement(By.xpath(".//*[@id='Unauth_hideAdmintab']/a"));
		 
       action = new Actions(driver);
       action.moveToElement(Element).build().perform();
       Thread.sleep(100);
       
       Element = driver.findElement(By.xpath(".//*[@id='Unauth_hideAdmintab']/ul/li[1]/a"));
       Actions Company = new Actions(driver);
       Company.moveToElement(Element).build().perform();
       Thread.sleep(100);   
	}
	@Test(priority = 1)
	//@AfterTest
	public static void CreatCompany() throws InterruptedException, IOException
	{
		 System.out.println("=========Create of Companysetup Start==========");
		 driver.findElement(By.xpath(".//*[@id='lnkcompany']")).click();
	       //Thread.sleep(1000);
	       WebDriverWait wait2 = new WebDriverWait(driver,15);
		    wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div[1]/div/div/div/span")));
	     //driver.findElement(By.xpath(".//*[@id='addnew']")).click();
	     //Thread.sleep(100);
	     
	     String projectpath = System.getProperty("user.dir");
	     XSSFWorkbook workbook = new XSSFWorkbook(projectpath+"/CompanySet//CompanySet.xlsx");
	     XSSFSheet sheet = workbook.getSheet("Company");
	     
	     
	     int rowCount = sheet.getPhysicalNumberOfRows();
	     System.out.println("No of row : " +rowCount);
	     XSSFRow row =sheet.getRow(0);
	     int column =row.getLastCellNum();
	     System.out.println("No of column : " +column);
	     
	    for (int i=1;i<rowCount;i++) {
	    	
	    	driver.findElement(By.xpath(".//*[@id='addnew']")).click();
	    	WebDriverWait AddNew = new WebDriverWait(driver,15);
	    	AddNew.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Add Company')]")));
	    	
	     String companypan =sheet.getRow(i).getCell(0).getStringCellValue();
	     //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	     driver.findElement(By.xpath(".//*[@id='company_pan']")).sendKeys(companypan);
	    
	     String companyname =sheet.getRow(i).getCell(1).getStringCellValue();
	     
	     driver.findElement(By.xpath(".//*[@id='company_name']")).sendKeys(companyname);
	     
	     driver.findElement(By.xpath(".//*[@id='btn_save']")).click();
	     //Thread.sleep(10000);
	     WebDriverWait wait1 = new WebDriverWait(driver,15);
	     wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[6]/div/div")));
	     
	     driver.findElement(By.xpath("html/body/div[6]/div/div")).click();
	     
	     
	     WebDriverWait wait = new WebDriverWait(driver,15);
	     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div[1]/div/div/div/span")));
	    
	     
	     //driver.findElement(By.xpath(".//*[@id='addnew']")).click();
	     
	    //========================Extent Repot=============================
	      ExtentHtmlReporter reporter = new ExtentHtmlReporter("E:/PwC/Com.PwC.EWB/Reports/Company_setup.html");
	      
	      ExtentReports extent = new ExtentReports();
	      extent.attachReporter(reporter);
	      
	      ExtentTest logger= extent.createTest("CreatCompany");
	      
	      logger.log(Status.INFO, "Company Created Sucessfully");
	      logger.log(Status.PASS, "Company_setup created");
	      
	      extent.flush();
	      
	      
	    
	}
	    System.out.println("=========End of Company Create==========");
	     workbook.close();
	     Thread.sleep(1000);
	}
	public static WebElement Company;
	@Test(priority = 2)
	//@AfterTest(priority = 2)
	public static void CreatBu() throws InterruptedException, IOException
	{
		System.out.println("=========Create Business_Unit==========");
		 driver.findElement(By.xpath(".//*[@id='bindbudata']")).click();
	     Thread.sleep(1000);
		
		  
	     String projectpath = System.getProperty("user.dir");
	     XSSFWorkbook BusinessUnit = new XSSFWorkbook(projectpath+"/CompanySet//CompanySet.xlsx");
	     XSSFSheet Bu = BusinessUnit.getSheet("BU");
	     
	     int rowCount = Bu.getPhysicalNumberOfRows();
	     System.out.println("No of row : " +rowCount);
	     XSSFRow row =Bu.getRow(0);
	     int column =row.getLastCellNum();
	     System.out.println("No of column : " +column);
	     
	     for (int i=1;i<rowCount;i++) 
	     {
	    	 driver.findElement(By.xpath(".//*[@id='addnew']")).click();
		     //Thread.sleep(200);
	    	WebDriverWait AddNew = new WebDriverWait(driver,15);
		    AddNew.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Add Business Unit')]")));
		     
		     String Company =Bu.getRow(i).getCell(0).getStringCellValue();
		     Thread.sleep(100);
		    //Company =driver.findElement(By.xpath(".//*[@id='ddlComapnyList']"));
		    Select CompanyName = new Select(driver.findElement(By.xpath(".//*[@id='ddlComapnyList']")));
		    CompanyName.selectByVisibleText(Company);
		   

	     String BUnit =Bu.getRow(i).getCell(1).getStringCellValue();
	     Thread.sleep(100);
	     driver.findElement(By.xpath(".//*[@id='bu']")).sendKeys(BUnit);
	    
	 
	     driver.findElement(By.xpath(".//*[@id='btn_save']")).click();
	     //Thread.sleep(10000);
	     WebDriverWait wait1 = new WebDriverWait(driver,15);
		 wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[6]/div/div")));
		 
	     driver.findElement(By.xpath("html/body/div[6]/div/div")).click();
	     
	     //Thread.sleep(600);
	     WebDriverWait wait2 = new WebDriverWait(driver,15);
		 wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='black-heading'][contains(text(),'Company Setup')]")));
		 
	     ExtentHtmlReporter reporter = new ExtentHtmlReporter("E:/PwC/Com.PwC.EWB/Reports/Company_setup.html");
	      
	      ExtentReports extent = new ExtentReports();
	      extent.attachReporter(reporter);
	      
	      ExtentTest logger= extent.createTest("CreatBu");
	      
	      logger.log(Status.INFO, "BusinessUnit Created Sucessfully");
	      logger.log(Status.PASS, "BusinessUnit created");
	      
	      extent.flush();
	      
	     
	     System.out.println("=========Create Business_Unit is End==========");
	     }
	     BusinessUnit.close();
	     Thread.sleep(1000);
	}
	
	@Test(priority = 3)
	public static void Create_SBU() throws IOException, InterruptedException
	{
		System.out.println("=========Create SubBusiness_Unit==========");
		 driver.findElement(By.xpath(".//*[@id='bindsubbudata']")).click();
	       Thread.sleep(1000);
		  
	     String projectpath = System.getProperty("user.dir");
	     XSSFWorkbook SubBusinessUnit = new XSSFWorkbook(projectpath+"/CompanySet//CompanySet.xlsx");
	     XSSFSheet SBU = SubBusinessUnit.getSheet("SBU");
	     
	     int rowCount = SBU.getPhysicalNumberOfRows();
	     System.out.println("No of row : " +rowCount);
	     XSSFRow row =SBU.getRow(0);
	     int column =row.getLastCellNum();
	     System.out.println("No of column : " +column);
	     for (int i=1;i<rowCount;i++) 
	     {
	    	 driver.findElement(By.xpath(".//*[@id='addnew']")).click();
		     Thread.sleep(500);
		     
		     String Company =SBU.getRow(i).getCell(0).getStringCellValue();
		     Thread.sleep(100);
		    //Company =driver.findElement(By.xpath(".//*[@id='ddlComapnyList']"));
		    Select CompanyName = new Select(driver.findElement(By.xpath(".//*[@id='ddlComapnyList']")));
		    CompanyName.selectByVisibleText(Company);
		   

	     String BUnit =SBU.getRow(i).getCell(1).getStringCellValue();
	     Thread.sleep(100);
	     Select BU = new Select(driver.findElement(By.xpath("//*[@id='ddlBusinessUnit']")));
		 BU.selectByVisibleText(BUnit);
	     //driver.findElement(By.xpath("//*[@id='ddlBusinessUnit']")).sendKeys(BUnit);
	     
	     
	     String Sbunit=SBU.getRow(i).getCell(2).getStringCellValue();
	     Thread.sleep(100);
	     driver.findElement(By.xpath("//*[@id='sbu_name']")).sendKeys(Sbunit);
	     
	 
	     driver.findElement(By.xpath(".//*[@id='btn_save']")).click();
	     Thread.sleep(10000);
	     
	     driver.findElement(By.xpath("html/body/div[6]/div/div")).click();
	     
	     Thread.sleep(600);
	     ExtentHtmlReporter reporter = new ExtentHtmlReporter("E:/PwC/Com.PwC.EWB/Reports/Company_setup.html");
	      
	      ExtentReports extent = new ExtentReports();
	      extent.attachReporter(reporter);
	      
	      ExtentTest logger= extent.createTest("Creat_SBU");
	      
	      logger.log(Status.INFO, "SubBusinessUnit Created Sucessfully");
	      logger.log(Status.PASS, "SbuBusinessUnit created");
	      
	      extent.flush();
	      
	     
	     System.out.println("=========Create SubBusiness_Unit is End==========");
	     }
	     SubBusinessUnit.close();
	     Thread.sleep(1000);
	}	
	@Test(priority =4)
	public static void Creat_Location() throws InterruptedException, IOException 
	{
		
		System.out.println("=========Create Location Start==========");
		 driver.findElement(By.xpath("//*[@id='bindlocationdata']")).click();
	       Thread.sleep(1000);
		  
	     String projectpath = System.getProperty("user.dir");
	     XSSFWorkbook Location = new XSSFWorkbook(projectpath+"/CompanySet//CompanySet.xlsx");
	     XSSFSheet location = Location.getSheet("Location");
	     
	     int rowCount = location.getPhysicalNumberOfRows();
	     System.out.println("No of row : " +rowCount);
	     XSSFRow row =location.getRow(0);
	     int column =row.getLastCellNum();
	     System.out.println("No of column : " +column);
	     for (int i=1;i<rowCount;i++) 
	     {
	    	 driver.findElement(By.xpath(".//*[@id='addnew']")).click();
		     Thread.sleep(200);
		     
		    String Company =location.getRow(i).getCell(0).getStringCellValue();
		    Thread.sleep(100);
		    Select CompanyName = new Select(driver.findElement(By.xpath("//*[@id='ddlCompanylist']")));
		    CompanyName.selectByVisibleText(Company);
		   

	     String Location_Code =location.getRow(i).getCell(1).getStringCellValue();
	     Thread.sleep(100);
	     driver.findElement(By.xpath("//*[@id='location_code']")).sendKeys(Location_Code);
	     
	     //============Read Location_Category======================
	     
	     String Location_Category=location.getRow(i).getCell(2).getStringCellValue();
	     Thread.sleep(100);
	     Select Category = new Select(driver.findElement(By.xpath("//*[@id='DDLLocationCat']")));
	     Category.selectByVisibleText(Location_Category);

	     //===========Read Location_Name=============================
	     
	     String Location_Name =location.getRow(i).getCell(3).getStringCellValue();
	     Thread.sleep(100);
	     driver.findElement(By.xpath("//*[@id='location_name']")).sendKeys(Location_Name);
	     
	     //===================Read State===============================
	     
	     String State =location.getRow(i).getCell(4).getStringCellValue();
		 Thread.sleep(100);
		 Select LocationState = new Select(driver.findElement(By.xpath("//*[@id='ddlState']")));
		 LocationState.selectByVisibleText(State);
	     
		 //=================Read Address1=======================
		 
		 String Address1 =location.getRow(i).getCell(5).getStringCellValue();
	     Thread.sleep(100);
	     driver.findElement(By.xpath("//*[@id='address1']")).sendKeys(Address1);
	     
	     //==============Read Address2==============================
	     
	     String Address2 =location.getRow(i).getCell(6).getStringCellValue();
	     Thread.sleep(100);
	     driver.findElement(By.xpath("//*[@id='address2']")).sendKeys(Address2);
	     
	     //===============Read place================================
	     
	     String Place =location.getRow(i).getCell(7).getStringCellValue();
	     Thread.sleep(100);
	     driver.findElement(By.xpath("//*[@id='place']")).sendKeys(Place);
	     
	     //===================To Read The Pin_Code Value from Excele==============
	     //String Pin_Code =location.getRow(i).getCell(8).getStringCellValue();
	     int Pin_Code= (int)location.getRow(i).getCell(8).getNumericCellValue();
	     Thread.sleep(100);
	     driver.findElement(By.xpath("//*[@id='pin_code']")).sendKeys(String.valueOf(Pin_Code));
	     
	     
	 
	     driver.findElement(By.xpath(".//*[@id='btn_save']")).click();
	     Thread.sleep(10000);
	     
	     driver.findElement(By.xpath("html/body/div[6]/div/div")).click();
	     
	     Thread.sleep(600);
	     ExtentHtmlReporter reporter = new ExtentHtmlReporter("E:/PwC/Com.PwC.EWB/Reports/Company_setup.html");
	      
	      ExtentReports extent = new ExtentReports();
	      extent.attachReporter(reporter);
	      
	      ExtentTest logger= extent.createTest("Creat_Location");
	      
	      logger.log(Status.INFO, "Location Created Sucessfully");
	      logger.log(Status.PASS, "Location created");
	      
	      extent.flush();
	      
	     
	     System.out.println("=========Create Location is End==========");
	     }
	     Location.close();
	     Thread.sleep(1000);
	}
	
	@Test(priority = 5)
	public static void Create_gstin() throws InterruptedException, IOException 
	{
		
		System.out.println("=========Create GSTIN Start==========");
		 driver.findElement(By.xpath("//*[@id='bindgstindata']")).click();
	       Thread.sleep(1000);
		  
	     String projectpath = System.getProperty("user.dir");
	     XSSFWorkbook GSTIN = new XSSFWorkbook(projectpath+"/CompanySet//CompanySet.xlsx");
	     XSSFSheet gstin = GSTIN.getSheet("GSTIN");
	     
	     int rowCount = gstin.getPhysicalNumberOfRows();
	     System.out.println("No of row : " +rowCount);
	     XSSFRow row =gstin.getRow(0);
	     int column =row.getLastCellNum();
	     System.out.println("No of column : " +column);
	     for (int i=1;i<rowCount;i++) 
	     {
	    	 driver.findElement(By.xpath(".//*[@id='addnew']")).click();
		     Thread.sleep(200);
		     
		    String Company =gstin.getRow(i).getCell(0).getStringCellValue();
		    Thread.sleep(400);
		    Select CompanyName = new Select(driver.findElement(By.xpath("//*[@id='ddlCompanylist']")));
		    CompanyName.selectByVisibleText(Company);
		     
		    String State =gstin.getRow(i).getCell(1).getStringCellValue();
		    Thread.sleep(100);
		    Select state = new Select(driver.findElement(By.xpath("//*[@id='ddlStateList']")));
		    state.selectByVisibleText(State);

		    
	     String Create_gstin =gstin.getRow(i).getCell(2).getStringCellValue();
	     Thread.sleep(100);
	     driver.findElement(By.xpath("//*[@id='gstin']")).sendKeys(Create_gstin);
	     
	     
	     String Gstin_User_Name=gstin.getRow(i).getCell(3).getStringCellValue();
	     Thread.sleep(100);
	     driver.findElement(By.xpath("//*[@id='user_name']")).sendKeys(Gstin_User_Name);
	     
	     String Gstin_password=gstin.getRow(i).getCell(4).getStringCellValue();
	     Thread.sleep(100);
	     driver.findElement(By.xpath("//*[@id='gstinpassword']")).sendKeys(Gstin_password);
	     
	     
	     String Authorised_Signatory_Name=gstin.getRow(i).getCell(5).getStringCellValue();
	     Thread.sleep(100);
	     driver.findElement(By.xpath("//*[@id='authorised_signatory_name']")).sendKeys(Authorised_Signatory_Name);
	     
	     
	     /*String Phone_No=gstin.getRow(i).getCell(6).getStringCellValue();
	     Thread.sleep(100);
	     driver.findElement(By.xpath("//*[@id='phone_no']")).sendKeys(Phone_No);*/
	     
	     long Phone_No= (long)gstin.getRow(i).getCell(6).getNumericCellValue();
	     Thread.sleep(100);
	     driver.findElement(By.xpath("//*[@id='phone_no']")).sendKeys(String.valueOf(Phone_No));
	     
	     String Email_ID=gstin.getRow(i).getCell(7).getStringCellValue();
	     Thread.sleep(100);
	     driver.findElement(By.xpath("//*[@id='email_id']")).sendKeys(Email_ID);
	     
	     
	     /*Select Is_SEZ_Unit = new Select(driver.findElement(By.xpath("//*[@id='ddlIsSEZUnitList']")));
	     Is_SEZ_Unit.selectByIndex(1);*/
		 
	     String Is_SEZ_Unit =gstin.getRow(i).getCell(8).getStringCellValue();
		 Thread.sleep(100);
		 Select SEZ_UNIT = new Select(driver.findElement(By.xpath("//*[@id='ddlIsSEZUnitList']")));
		 SEZ_UNIT.selectByVisibleText(Is_SEZ_Unit);
	     
	 
	     driver.findElement(By.xpath(".//*[@id='btn_save']")).click();
	     Thread.sleep(10000);
	     
	     driver.findElement(By.xpath("html/body/div[6]/div/div")).click();
	     
	     Thread.sleep(600);
	     ExtentHtmlReporter reporter = new ExtentHtmlReporter("E:/PwC/Com.PwC.EWB/Reports/Company_setup.html");
	      
	      ExtentReports extent = new ExtentReports();
	      extent.attachReporter(reporter);
	      
	      ExtentTest logger= extent.createTest("Create_gstin");
	      
	      logger.log(Status.INFO, "gstin Created Sucessfully");
	      logger.log(Status.PASS, "Create_gstin created");
	      
	      extent.flush();
	      
	     
	     System.out.println("=========Create GSTIN is End==========");
	     }
	     GSTIN.close();
	     Thread.sleep(1000);
	}
	 @Test(priority = 7)
	 public static void Create_user() throws InterruptedException, IOException 
	{
		
		 System.out.println("=========Create USER Start==========");
		 driver.findElement(By.xpath("//*[@id='binduserdata']")).click();
	       Thread.sleep(1000);
		  
	     String projectpath = System.getProperty("user.dir");
	     XSSFWorkbook USER = new XSSFWorkbook(projectpath+"/CompanySet//CompanySet.xlsx");
	     XSSFSheet User = USER.getSheet("USER");
	     
	     int rowCount = User.getPhysicalNumberOfRows();
	     System.out.println("No of row : " +rowCount);
	     XSSFRow row =User.getRow(0);
	     int column =row.getLastCellNum();
	     System.out.println("No of column : " +column);
	     for (int i=1;i<rowCount;i++) 
	     {
	    	 driver.findElement(By.xpath(".//*[@id='addnew']")).click();
		     Thread.sleep(200);
		     
		     String Name_of_User =User.getRow(i).getCell(0).getStringCellValue();
		     Thread.sleep(100);
		     driver.findElement(By.xpath("//*[@id='user_name']")).sendKeys(Name_of_User);
		   

	     String Department =User.getRow(i).getCell(1).getStringCellValue();
	     Thread.sleep(100);
	     driver.findElement(By.xpath("//*[@id='department']")).sendKeys(Department);
	    
	     String Designation =User.getRow(i).getCell(2).getStringCellValue();
	     Thread.sleep(100);
	     driver.findElement(By.xpath("//*[@id='designation']")).sendKeys(Designation);
	     
	     String Email_Id =User.getRow(i).getCell(3).getStringCellValue();
	     Thread.sleep(100);
	     driver.findElement(By.xpath("//*[@id='email_id']")).sendKeys(Email_Id);
	     
	     long Mobile_No= (long)User.getRow(i).getCell(4).getNumericCellValue();
	     Thread.sleep(100);
	     driver.findElement(By.xpath("//*[@id='mobile_no']")).sendKeys(String.valueOf(Mobile_No));
	    
	     String User_Login_Id =User.getRow(i).getCell(5).getStringCellValue();
	     Thread.sleep(100);
	     driver.findElement(By.xpath("//*[@id='user_loginid']")).sendKeys(User_Login_Id);
	     
		 //=================Read Address1=======================
		 
		 String Address1 =User.getRow(i).getCell(6).getStringCellValue();
	     Thread.sleep(100);
	     driver.findElement(By.xpath("//*[@id='address1']")).sendKeys(Address1);
	     
	     //==============Read Address2==============================
	     
	     String Address2 =User.getRow(i).getCell(7).getStringCellValue();
	     Thread.sleep(100);
	     driver.findElement(By.xpath("//*[@id='address2']")).sendKeys(Address2);
	     
	     //===================To Read The Pin_Code Value from Excele==============
	     //String Pin_Code =location.getRow(i).getCell(8).getStringCellValue();
	     int Pin_Code= (int)User.getRow(i).getCell(8).getNumericCellValue();
	     Thread.sleep(100);
	     driver.findElement(By.xpath("//*[@id='pincode']")).sendKeys(String.valueOf(Pin_Code));
	     
	     /*String Escalation_User_Id =User.getRow(i).getCell(9).getStringCellValue();
	     Thread.sleep(100);
	     driver.findElement(By.xpath("//*[@id='escalation_user_id']")).sendKeys(Escalation_User_Id);
	     
	     String ERP_User_Name_ID =User.getRow(i).getCell(10).getStringCellValue();
	     Thread.sleep(100);
	     driver.findElement(By.xpath("//*[@id='erp_user_id']")).sendKeys(ERP_User_Name_ID);*/
	     
	     String Role =User.getRow(i).getCell(11).getStringCellValue();
		 Thread.sleep(100);
		 Select role = new Select(driver.findElement(By.xpath("//*[@id='ddluserrole']")));
		 role.selectByVisibleText(Role);
	     
	 
	     driver.findElement(By.xpath(".//*[@id='btn_save']")).click();
	     Thread.sleep(10000);
	     
	     driver.findElement(By.xpath("(//*[@type='button'][text()='×'][text()='×'])[2]")).click();
	     
	     Thread.sleep(600);
	     ExtentHtmlReporter reporter = new ExtentHtmlReporter("E:/PwC/Com.PwC.EWB/Reports/Company_setup.html");
	      
	      ExtentReports extent = new ExtentReports();
	      extent.attachReporter(reporter);
	      
	      ExtentTest logger= extent.createTest("Create_user");
	      
	      logger.log(Status.INFO, "Create_user Sucessfully");
	      logger.log(Status.PASS, "Create_user created");
	      
	      extent.flush();
	      
	     
	     System.out.println("=========Create_user is End==========");
	     }
	     USER.close();
	     Thread.sleep(1000);
	}
	 @Test(priority = 6)
	 public static void Assign_Role() throws Exception
	 {
		 System.out.println("=========Create Assign Role Start==========");
		 driver.findElement(By.xpath("//*[@id='bindassignroledata']")).click();
	       Thread.sleep(1000);
		  
	     String projectpath = System.getProperty("user.dir");
	     XSSFWorkbook Assignrole = new XSSFWorkbook(projectpath+"/CompanySet//CompanySet.xlsx");
	     XSSFSheet Assign = Assignrole.getSheet("Assignrole");
	     
	     int rowCount = Assign.getPhysicalNumberOfRows();
	     System.out.println("No of row : " +rowCount);
	     XSSFRow row =Assign.getRow(0);
	     int column =row.getLastCellNum();
	     System.out.println("No of column : " +column);
	     for (int i=1;i<rowCount;i++) 
	     {
	    	 driver.findElement(By.xpath(".//*[@id='addnew']")).click();
		     Thread.sleep(200);
		     
		    String User_Login_Id =Assign.getRow(i).getCell(0).getStringCellValue();
		    Thread.sleep(400);
		    Select Selct_User_id = new Select(driver.findElement(By.xpath("//*[@id='ddluserloginid']")));
		    Selct_User_id.selectByVisibleText(User_Login_Id);
	     
		    String Company =Assign.getRow(i).getCell(1).getStringCellValue();
		    Thread.sleep(400);
		    Select CompanyName = new Select(driver.findElement(By.xpath("//*[@id='ddlcompany']")));
		    CompanyName.selectByVisibleText(Company);
		    
		    String State =Assign.getRow(i).getCell(2).getStringCellValue();
		    Thread.sleep(400);
		    Select state = new Select(driver.findElement(By.xpath("//*[@id='ddlstate']")));
		    state.selectByVisibleText(State);

		    String GSTIN =Assign.getRow(i).getCell(3).getStringCellValue();
		    Thread.sleep(400);
		    Select gstin = new Select(driver.findElement(By.xpath("//*[@id='ddlgstin']")));
		    gstin.selectByVisibleText(GSTIN);
		    
		    String BU =Assign.getRow(i).getCell(4).getStringCellValue();
		    Thread.sleep(400);
		    Select Business_Unit = new Select(driver.findElement(By.xpath("//*[@id='ddlbu']")));
		    Business_Unit.selectByVisibleText(BU);
		    
		    String SBU =Assign.getRow(i).getCell(5).getStringCellValue();
		    Thread.sleep(400);
		    Select Sub_Business_Unit = new Select(driver.findElement(By.xpath("//*[@id='ddlsbu']")));
		    Sub_Business_Unit.selectByVisibleText(SBU);
		    
		    String location =Assign.getRow(i).getCell(6).getStringCellValue();
		    Thread.sleep(400);
		    Select Location = new Select(driver.findElement(By.xpath("//*[@id='ddllocation']")));
		    Location.selectByVisibleText(location);
		    
		    
		    
		     driver.findElement(By.xpath(".//*[@id='btn_save']")).click();
		     Thread.sleep(10000);
		     
		     driver.findElement(By.xpath("(//*[@type='button'][text()='×'][text()='×'])[2]")).click();
		     
		     Thread.sleep(600);
		     ExtentHtmlReporter reporter = new ExtentHtmlReporter("E:/PwC/Com.PwC.EWB/Reports/Company_setup.html");
		      
		      ExtentReports extent = new ExtentReports();
		      extent.attachReporter(reporter);
		      
		      ExtentTest logger= extent.createTest("Assign_Role");
		      
		      logger.log(Status.INFO, "Assign_Role Created Sucessfully");
		      logger.log(Status.PASS, "Assign_Role created");
		      
		      extent.flush();
		      
		     
		     System.out.println("=========Create Assign_Role is End==========");
		     }
		     Assignrole.close();
		     Thread.sleep(1000);
		    
		    
		    
		    
	     
	 }
	 
	
	
	
}

