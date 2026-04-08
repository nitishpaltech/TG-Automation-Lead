
package components;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import constants.BrandCTAType;

public class BrandPageComponent {

    WebDriver driver;

    public BrandPageComponent(WebDriver driver) {

        this.driver = driver;

    }

    public void clickFirstCardCTA(BrandCTAType type) {

        switch(type) {

            case CHECK_TRACTOR_PRICE:

                driver.findElement(
                    By.xpath("(//button[contains(text(),'Check Tractor Price')])[1]")
                ).click();

                break;


            case CHECK_EMI:

                driver.findElement(
                    By.xpath("(//span[contains(text(),'Click Here')])[1]")
                ).click();

                break;


            case TALK_TO_DEALER:

                driver.findElement(
                    By.xpath("(//span[@data-leadbuttonname='Talk To Dealer'])[1]")
                ).click();

                break;


            case APPLY_FOR_LOAN:

                driver.findElement(
                    By.xpath("(//button[contains(text(),'Apply For Loan')])[1]")
                ).click();

                break;


//            case GET_BEST_PRICE:
//
//                driver.findElement(
//                    By.xpath("(//button[contains(text(),'Check Price')])[1]")
//                ).click();
//
//                break;


            case GET_SELLER_DETAILS:

                driver.findElement(
                    By.xpath("(//button[contains(text(),'Get Seller Details')])[1]")
                ).click();

                break;
                
            case GET_BEST_PRICE:

                try {

                    WebElement readMore = driver.findElement(
                        By.xpath("(//span[contains(@class,'ckeditor-btn1')])[1]")
                    );

                    // Scroll element to center (avoid sticky header overlap)

                    ((JavascriptExecutor) driver).executeScript(
                        "arguments[0].scrollIntoView({block:'center'});",
                        readMore
                    );

                    Thread.sleep(500);

                    // JS click instead of normal click

                    ((JavascriptExecutor) driver).executeScript(
                        "arguments[0].click();",
                        readMore
                    );

                }

                catch(Exception e) {

                    System.out.println("Read More already expanded");

                }


                // Now click Click Here button

                WebElement clickHereBtn = driver.findElement(
                    By.xpath("(//button[contains(@class,'click_here')])[1]")
                );

                ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();",
                    clickHereBtn
                );

                break;

              

        }}

}