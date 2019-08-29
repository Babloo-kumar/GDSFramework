package EWAYBILL;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AddNew extends Login
{
	@Test
	public static void Addnewform() throws InterruptedException
	{
          
		
        //filling all field of Filtercolumn
    	Select Source= new Select(driver.findElement(By.xpath(".//*[@id='ddlsource']")));
        Source.selectByIndex(1);
        
        Select Company = new Select(driver.findElement(By.xpath(".//*[@id='ddlcompany']")));
        Company.selectByIndex(1);
        Select State = new Select(driver.findElement(By.xpath(".//*[@id='ddlstate']")));
        State.selectByIndex(1);
        Select Location = new Select(driver.findElement(By.xpath(".//*[@id='location']")));
        Location.selectByIndex(1);
        Select BU = new Select(driver.findElement(By.xpath(".//*[@id='bu']")));
        BU.selectByIndex(1);
        Select SBU = new Select(driver.findElement(By.xpath(".//*[@id='sbu']")));
        SBU.selectByIndex(1);
        Select GSTIN = new Select(driver.findElement(By.xpath(".//*[@id='ddlGSITN']")));
        GSTIN.selectByIndex(1);
        
 //Transaction Details Column field
        
        Select Supplytype = new Select(driver.findElement(By.xpath(".//*[@id='supplyType']")));
        Supplytype.selectByIndex(0);
        Select SubType = new Select(driver.findElement(By.xpath(".//*[@id='supplyType']")));
        SubType.selectByIndex(0);
        driver.findElement(By.xpath(".//*[@id='fu1']")).sendKeys("Sub_type");
        Select DocumentType = new Select(driver.findElement(By.xpath(".//*[@id='supplyType']")));
        DocumentType.selectByIndex(0);
        driver.findElement(By.xpath(".//*[@id='docNo']")).sendKeys("Auto-3D");
       
        
        //driver.findElement(By.xpath(".//*[@id='docDate']")).clear();
       // driver.findElement(By.xpath(".//*[@id='docDate']")).sendKeys("05/12/2018");
        driver.findElement(By.xpath(".//*[@id='docDate']")).click();
        Thread.sleep(100);
        driver.findElement(By.xpath("html/body/div[6]/div[1]/table/tbody/tr[2]/td[5]")).click();
        Thread.sleep(200);
       /* driver.findElement(By.xpath(".//*[@id='docDate']")).click();
        Thread.sleep(200);
        driver.findElement(By.xpath("html/body/div[6]/div[1]/table/tbody/tr[2]/td[4]")).click();*/
        
        Select Transactiontype = new Select(driver.findElement(By.xpath(".//*[@id='fu6']")));
        Transactiontype.selectByIndex(0);
        		
        //Bill From column
        
        /*driver.findElement(By.xpath(".//*[@id='fromGstin']")).clear();
        driver.findElement(By.xpath(".//*[@id='fromGstin']")).sendKeys("29AEKPV7203E1Z9");*/
        
      
       driver.findElement(By.xpath(".//*[@id='fromTrdName']")).clear();
       driver.findElement(By.xpath(".//*[@id='fromTrdName']")).sendKeys("Test1");
      
       /*String actual = driver.findElement(By.xpath(".//*[@id='fromTrdName']")).getText();
       String expected="MITSUBISHI ELECTRIC INDIA PVT LTD";
       Assert.assertEquals(actual, "MITSUBISHI ELECTRIC INDIA PVT LTD");*/
      
     
      Select BillFromState = new Select(driver.findElement(By.xpath(".//*[@id='billFromSateCode']")));
      BillFromState.selectByVisibleText("KARNATAKA");
      
      driver.findElement(By.xpath(".//*[@id='fromAddr1']")).clear();
      driver.findElement(By.xpath(".//*[@id='fromAddr1']")).sendKeys("South City-1,N-65,");
      
      driver.findElement(By.xpath(".//*[@id='fromAddr2']")).clear();
      driver.findElement(By.xpath(".//*[@id='fromAddr2']")).sendKeys("Mobifly");
      
      driver.findElement(By.xpath(".//*[@id='fromPlace']")).clear();;
      driver.findElement(By.xpath(".//*[@id='fromPlace']")).sendKeys("Gurugram");
      
      driver.findElement(By.xpath(".//*[@id='fromPincode']")).clear();
      driver.findElement(By.xpath(".//*[@id='fromPincode']")).sendKeys("560090");
      
      Select DispatchFromState = new Select(driver.findElement(By.xpath(".//*[@id='fromStateCode']")));
      DispatchFromState .selectByVisibleText("KARNATAKA");
      
      
      
      //Bill To Column
      
    
      //driver.findElement(By.xpath(".//*[@id='toGstin']")).clear();
      driver.findElement(By.xpath(".//*[@id='toGstin']")).sendKeys("29AAACW4202F1ZM");
    		 
      
      
      driver.findElement(By.xpath(".//*[@id='toTrdName']")).clear();
      driver.findElement(By.xpath(".//*[@id='toTrdName']")).sendKeys("SRM");
      
      
      Select BillToState = new Select(driver.findElement(By.xpath(".//*[@id='billToStateCode']")));
      BillToState .selectByVisibleText("KARNATAKA");
      
      
      driver.findElement(By.xpath(".//*[@id='toAddr1']")).clear();
      driver.findElement(By.xpath(".//*[@id='toAddr1']")).sendKeys("House No-Z/99");
      
      
      driver.findElement(By.xpath(".//*[@id='toAddr2']")).clear();
      driver.findElement(By.xpath(".//*[@id='toAddr2']")).sendKeys("commercial enclave");
      
      
      driver.findElement(By.xpath(".//*[@id='toPlace']")).clear();
      driver.findElement(By.xpath(".//*[@id='toPlace']")).sendKeys("Delhi");
      
      
      driver.findElement(By.xpath(".//*[@id='toPincode']")).clear();
      driver.findElement(By.xpath(".//*[@id='toPincode']")).sendKeys("560037");
      
      
      Select ShipToState = new Select(driver.findElement(By.xpath(".//*[@id='toStateCode']")));
      ShipToState .selectByVisibleText("KARNATAKA");
      
      //Item Details Column
      driver.findElement(By.xpath(".//*[@id='add_rows_span']")).click();
      Thread.sleep(1000);
      driver.findElement(By.xpath(".//*[@id='productName_3']")).sendKeys("ELECTRONICE PRODUCT");
      
      driver.findElement(By.xpath(".//*[@id='productDesc_3']")).sendKeys("long life");
      
      driver.findElement(By.xpath(".//*[@id='hsnCode_3']")).sendKeys("2618");
      
      driver.findElement(By.xpath(".//*[@id='quantity_3']")).sendKeys("101");
      
      Select Unit = new Select(driver.findElement(By.xpath(".//*[@id='qtyUnit']")));
      Unit.selectByVisibleText("NUMBERS");
      
      driver.findElement(By.xpath(".//*[@id='taxableAmount_3']")).sendKeys("52000");
      
 
      Select CGSTSGSTRate = new Select(driver.findElement(By.xpath(".//*[@id='cgstRate']")));
      CGSTSGSTRate.selectByVisibleText("9+9");
      
      Select IGSTRate = new Select(driver.findElement(By.xpath(".//*[@id='igstRate']")));
      IGSTRate.selectByValue("12");
      
      Select CESSAdvolRate = new Select(driver.findElement(By.xpath(".//*[@id='cessRate']")));
      CESSAdvolRate.selectByValue("36");
      
      Select CESSNonAdvolRate = new Select(driver.findElement(By.xpath(".//*[@id='fu8']")));
      CESSNonAdvolRate.selectByValue("400");
      Thread.sleep(1000);
      
      //Transportation Details Column Field
      
      Select TransporterID = new Select(driver.findElement(By.xpath(".//*[@id='transporterId']")));
      TransporterID.selectByVisibleText("29AAACW6288M1ZH");
      
      driver.findElement(By.xpath(".//*[@id='transporterName']")).clear();
      driver.findElement(By.xpath(".//*[@id='transporterName']")).sendKeys("ABC");
      
      //driver.findElement(By.xpath(".//*[@id='transDistance']")).sendKeys("499");
      
      //PartB Column Field
      Select Mode = new Select(driver.findElement(By.xpath(".//*[@id='transMode']")));
      Mode.selectByIndex(1);
      
      driver.findElement(By.xpath(".//*[@id='vehicleNo']")).sendKeys("DL44VU7576");
      
      Select VehicleType = new Select(driver.findElement(By.xpath(".//*[@id='vehicleType']")));
      VehicleType.selectByIndex(0);
      
      driver.findElement(By.xpath(".//*[@id='transDocNo']")).sendKeys("3DAuto544");
      

      driver.findElement(By.xpath(".//*[@id='transDocDate']")).click();
      Thread.sleep(200);
      driver.findElement(By.xpath("html/body/div[6]/div[1]/table/tbody/tr[2]/td[5]")).click();
      Thread.sleep(200);
      /*driver.findElement(By.xpath(".//*[@id='transDocDate']")).click();
      Thread.sleep(200);
      driver.findElement(By.xpath("html/body/div[6]/div[1]/table/tbody/tr[2]/td[4]")).click();*/
      
      
	/*List<WebElement> dates = driver.findElement(By.xpath(".//*[@id='transDocDate']"));
      int total_node = dates.size();
       for (int i=0;i<total_node;i++) {
    	   String date = dates.get(i).getText();
    	   
    	   if (date.equals("25")) {
    		   dates.get(i).click();
    		   break;*/
    	   
 
	
      
      driver.findElement(By.xpath(".//*[@id='submit']")).click();
      
      //driver.findElement(By.xpath(".//*[@id='addNew']/div[9]/div/div[3]/div/div/div/div/a/button")).click();
      
	}

}
