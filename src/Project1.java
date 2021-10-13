import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.util.Random;

public class Project1 {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver","C:\\Users\\tetya\\OneDrive\\Documents\\SELENIUM\\DRIVERS\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

////        1. Navigate to http://duotifyapp.us-east-2.elasticbeanstalk.com/register.php

        driver.get("http://duotifyapp.us-east-2.elasticbeanstalk.com/register.php");

////        2. Verify the the title is "Welcome to Duotify!"

        Assert.assertEquals(driver.getTitle(),"Welcome to Duotify!");


////        3. Click on Signup here

        driver.findElement(By.id("hideLogin")).click();

//
////        4. Fill out the form with the required info
        String randomUserName = generateRandomUserName();
        String randomEmail    = generateRandomEmail();

        driver.findElement(By.name("username")).sendKeys(randomUserName);
        driver.findElement(By.id("firstName")).sendKeys("Mira");
        driver.findElement(By.id("lastName")).sendKeys("Mar");
        driver.findElement(By.id("email")).sendKeys(randomEmail);
        driver.findElement(By.id("email2")).sendKeys(randomEmail);
        driver.findElement(By.id("password")).sendKeys("Marmira2020");
        driver.findElement(By.id("password2")).sendKeys("Marmira2020");

////        5. Click on Sign up
        driver.findElement(By.name("registerButton")).click();


//        6. Once logged in to the application, verify that the URL is:http://duotifyapp.us-east-2.elasticbeanstalk.com/browse.php?

        Assert.assertEquals(driver.getCurrentUrl(),"http://duotifyapp.us-east-2.elasticbeanstalk.com/browse.php?");
        Thread.sleep(1000);


//        7. In the left navigation bar, verify that your first and last name matches
//        the first and last name that you used when signing up.

        String firstAndLastName = "Mira Mar";
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains(firstAndLastName));
        Thread.sleep(1000);



//  ?????  8. Click on the username on the left navigation bar and verify the username
//        on the main window is correct and then click logout.

        driver.findElement(By.id("nameFirstAndLast")).click();
        Thread.sleep(1000);



       //?????
//         Assert.assertEquals(driver.findElement(By.className("userInfo")), "Mira Mar");
//        Thread.sleep(1000);


        driver.findElement(By.id("rafael")).click();
        Thread.sleep(1000);



  //    9. Verify that you are logged out by verifying the URL is:
//       http://duotifyapp.us-east-2.elasticbeanstalk.com/register.php


     Assert.assertEquals(driver.getCurrentUrl(),"http://duotifyapp.us-east-2.elasticbeanstalk.com/register.php");
        Thread.sleep(1000);



//        10. Login using the same username and password when you signed up.
        driver.findElement(By.id("loginUsername")).sendKeys(randomUserName);
        driver.findElement(By.id("loginPassword")).sendKeys("Marmira2020");
        driver.findElement(By.name("loginButton")).click();

//   ?????   11. Verify successful login by verifying that the home page contains the text "You Might Also Like".

        String expectedText = "You Might Also Like";
        String pageSource1=driver.getPageSource();
        //Assert.assertTrue(pageSource1.contains(expectedText));
        Thread.sleep(1000);



        driver.findElement(By.id("nameFirstAndLast")).click();
        Thread.sleep(1000);


//        12. Log out once again and verify that you are logged out.

        driver.findElement(By.id("rafael")).click();
        Thread.sleep(1000);


       //Assert.assertEquals( driver.getCurrentUrl()," http://duotifyapp.us-east-2.elasticbeanstalk.com/register.php");
      // Thread.sleep(1000);

driver.quit();

//












    }

    public static String generateRandomUserName() {
        String chars = "1234567890abcdefghijklmnopqrstuvwxyz";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 5; i<=25; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }




        public  static String generateRandomEmail(){

        String chars = "abcdefghijklmnopqrstuvwxyz1234567890";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<=10; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));

        return sb.toString()+"@gmail.com";

       // String email=randomestring()+
    }
}
