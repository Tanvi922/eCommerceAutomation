package com.test.flipkart;

        import java.io.*;
        import java.util.Date;
        import java.util.concurrent.TimeUnit;
        import jxl.Sheet;
        import jxl.Workbook;
        import jxl.read.biff.BiffException;
        import jxl.write.Label;
        import jxl.write.WritableSheet;
        import jxl.write.WritableWorkbook;
        import jxl.write.WriteException;
        import org.junit.*;
        import static org.junit.Assert.*;
        import org.openqa.selenium.*;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.logging.LogEntries;
        import org.openqa.selenium.logging.LogEntry;
        import org.openqa.selenium.logging.LogType;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;

    public class flipkartTest {
    private WebDriver driver;
    private String baseUrl;

    @Before
      public void setUp() throws Exception {
            driver = new FirefoxDriver();
            baseUrl = "http://www.flipkart.com";
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }

    @Test
    public void testFilpkart() throws Exception {
        AddToCart();
        ProductsDetails();
        ReadDetails();
        analyzeLog();
    }
      public void AddToCart(){
        driver.get(baseUrl + "/");
        driver.findElement(By.id("fk-top-search-box")).click();
        driver.findElement(By.id("fk-top-search-box")).clear();
        driver.findElement(By.id("fk-top-search-box")).sendKeys("mobile");
        driver.findElement(By.xpath("//input[@value='Search']")).click();
        driver.findElement(By.linkText("Lenovo K3 Note (Black, 16 GB)")).click();
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
          WebDriverWait wait = new WebDriverWait(driver, 180);
          wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Add to Cart']")));
        driver.findElement(By.xpath("//input[@value='Add to Cart']")).click();
        assertEquals("1", driver.findElement(By.id("item_count_in_cart_top_displayed")).getText());
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Lenovo A6000 Plus")).click();
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
          wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Add to Cart']")));
        driver.findElement(By.xpath("//input[@value='Add to Cart']")).click();
        assertEquals("2", driver.findElement(By.id("item_count_in_cart_top_displayed")).getText());
        driver.findElement(By.linkText("Moto G (3rd Generation)")).click();
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
          wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Add to Cart']")));
        driver.findElement(By.xpath("//input[@value='Add to Cart']")).click();
        assertEquals("3", driver.findElement(By.id("item_count_in_cart_top_displayed")).getText());
        driver.findElement(By.linkText("Mi 4i")).click();
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
          wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Add to Cart']")));
        driver.findElement(By.xpath("//input[@value='Add to Cart']")).click();
        assertEquals("4", driver.findElement(By.id("item_count_in_cart_top_displayed")).getText());
        driver.findElement(By.linkText("Redmi 2 Prime")).click();
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
          wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Add to Cart']")));
        driver.findElement(By.xpath("//input[@value='Add to Cart']")).click();
        assertEquals("5", driver.findElement(By.id("item_count_in_cart_top_displayed")).getText());
    }
    public void ProductsDetails()throws IOException, WriteException, BiffException {
        driver.findElement(By.xpath("//div[@id='fk-mainhead-id']/div/div/div[2]/div[3]/div/a")).click();
        String item1 = driver.findElement(By.cssSelector("span.title.fk-font-14")).getText();
        String Qty1 = driver.findElement(By.linkText("1")).getText();
        String price1 = driver.findElement(By.xpath("//div[@id='cartpage-cart-tab-content']/table/tbody/tr/td[5]")).getText();
        String item2 = driver.findElement(By.xpath("//div[@id='cartpage-cart-tab-content']/table/tbody/tr[2]/td/table/tbody/tr/td[2]/span")).getText();
        String Qty2 = driver.findElement(By.xpath("(//a[contains(text(),'1')])[2]")).getText();
        String price2 = driver.findElement(By.xpath("//div[@id='cartpage-cart-tab-content']/table/tbody/tr[2]/td[5]")).getText();
        String item3 = driver.findElement(By.xpath("//div[@id='cartpage-cart-tab-content']/table/tbody/tr[3]/td/table/tbody/tr/td[2]/span")).getText();
        String Qty3 = driver.findElement(By.xpath("(//a[contains(text(),'1')])[3]")).getText();
        String price3 = driver.findElement(By.xpath("//div[@id='cartpage-cart-tab-content']/table/tbody/tr[3]/td[5]")).getText();
        String item4 = driver.findElement(By.xpath("//div[@id='cartpage-cart-tab-content']/table/tbody/tr[4]/td/table/tbody/tr/td[2]/span")).getText();
        String Qty4 = driver.findElement(By.xpath("(//a[contains(text(),'1')])[4]")).getText();
        String price4 = driver.findElement(By.xpath("//div[@id='cartpage-cart-tab-content']/table/tbody/tr[4]/td[5]")).getText();
        String item5 = driver.findElement(By.xpath("//div[@id='cartpage-cart-tab-content']/table/tbody/tr[5]/td/table/tbody/tr/td[2]/span")).getText();
        String Qty5 = driver.findElement(By.xpath("(//a[contains(text(),'1')])[5]")).getText();
        String price5 = driver.findElement(By.xpath("//div[@id='cartpage-cart-tab-content']/table/tbody/tr[5]/td[5]")).getText();
        String SubTotal = driver.findElement(By.xpath("//div[@id='cartpage-cart-tab-content']/div/div/span[2]")).getText();


        FileOutputStream FFileName= new FileOutputStream("C:\\testExcel.xls");
        WritableWorkbook exlWorkBook = Workbook.createWorkbook(FFileName);
        WritableSheet exlWorkSheet1 = exlWorkBook.createSheet("Data",0);
        Label data1 = new Label(0,0,"Item");
        exlWorkSheet1.addCell(data1);
        Label data5 = new Label(1,0,"Qty");
        exlWorkSheet1.addCell(data5);
        Label data6 = new Label(2,0,"Price");
        exlWorkSheet1.addCell(data6);
        Label data2 = new Label(0,1,item1);
        exlWorkSheet1.addCell(data2);
        Label data3 = new Label(1,1,Qty1);
        exlWorkSheet1.addCell(data3);
        Label data4 = new Label(2,1,price1);
        exlWorkSheet1.addCell(data4);
        Label data7 = new Label(0,2,item2);
        exlWorkSheet1.addCell(data7);
        Label data8 = new Label(1,2,Qty2);
        exlWorkSheet1.addCell(data8);
        Label data9 = new Label(2,2,price2);
        exlWorkSheet1.addCell(data9);
        Label data10 = new Label(0,3,item3);
        exlWorkSheet1.addCell(data10);
        Label data11 = new Label(1,3,Qty3);
        exlWorkSheet1.addCell(data11);
        Label data12 = new Label(2,3,price3);
        exlWorkSheet1.addCell(data12);
        Label data13 = new Label(0,4,item4);
        exlWorkSheet1.addCell(data13);
        Label data14 = new Label(1,4,Qty4);
        exlWorkSheet1.addCell(data14);
        Label data15 = new Label(2,4,price4);
        exlWorkSheet1.addCell(data15);
        Label data16 = new Label(0,5,item5);
        exlWorkSheet1.addCell(data16);
        Label data17 = new Label(1,5,Qty5);
        exlWorkSheet1.addCell(data17);
        Label data18 = new Label(2,5,price5);
        exlWorkSheet1.addCell(data18);
        Label data19 = new Label(1,6,"SubTotal");
        exlWorkSheet1.addCell(data19);
        Label data20 = new Label(2,6,SubTotal);
        exlWorkSheet1.addCell(data20);
        exlWorkBook.write();
        exlWorkBook.close();
    }
    public void ReadDetails() throws IOException, BiffException {
        Workbook wb = Workbook.getWorkbook(new File("C:\\testExcel.xls"));
        Sheet sh = wb.getSheet(0);
        int totalNoOfRows = sh.getRows();
        int totalNoOfCols = sh.getColumns();
        String a[][] = new String[10][10];
        for (int row = 0; row < totalNoOfRows; row++) {
            for (int col = 0; col < totalNoOfCols; col++) {
                a[row][col] = sh.getCell(col, row).getContents();
                System.out.println(row+" and "+col+" "+a[row][col]);
            }
            System.out.println();
        }
        assertEquals(a[1][0], driver.findElement(By.cssSelector("span.title.fk-font-14")).getText());
        assertEquals(a[1][2], driver.findElement(By.xpath("//div[@id='cartpage-cart-tab-content']/table/tbody/tr/td[5]")).getText());
        assertEquals(a[2][0], driver.findElement(By.xpath("//div[@id='cartpage-cart-tab-content']/table/tbody/tr[2]/td/table/tbody/tr/td[2]/span")).getText());
        assertEquals(a[2][2], driver.findElement(By.xpath("//div[@id='cartpage-cart-tab-content']/table/tbody/tr[2]/td[5]")).getText());
        assertEquals(a[3][0], driver.findElement(By.xpath("//div[@id='cartpage-cart-tab-content']/table/tbody/tr[3]/td/table/tbody/tr/td[2]/span")).getText());
        assertEquals(a[3][2], driver.findElement(By.xpath("//div[@id='cartpage-cart-tab-content']/table/tbody/tr[3]/td[5]")).getText());
        assertEquals(a[4][0], driver.findElement(By.xpath("//div[@id='cartpage-cart-tab-content']/table/tbody/tr[4]/td/table/tbody/tr/td[2]/span")).getText());
        assertEquals(a[4][2], driver.findElement(By.xpath("//div[@id='cartpage-cart-tab-content']/table/tbody/tr[4]/td[5]")).getText());
        assertEquals(a[5][0], driver.findElement(By.xpath("//div[@id='cartpage-cart-tab-content']/table/tbody/tr[5]/td/table/tbody/tr/td[2]/span")).getText());
        assertEquals(a[5][2], driver.findElement(By.xpath("//div[@id='cartpage-cart-tab-content']/table/tbody/tr[5]/td[5]")).getText());
        assertEquals(a[6][2], driver.findElement(By.xpath("//div[@id='cartpage-cart-tab-content']/div/div/span[2]")).getText());

    }
    public void analyzeLog() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}
