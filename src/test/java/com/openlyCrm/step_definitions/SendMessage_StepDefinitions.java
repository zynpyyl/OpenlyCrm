package com.openlyCrm.step_definitions;

import com.openlyCrm.pages.ActivityStream;
import com.openlyCrm.pages.Login;
import com.openlyCrm.utilities.utilities.ConfigurationReader;
import com.openlyCrm.utilities.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendMessage_StepDefinitions {
    ActivityStream activityStream=new ActivityStream();

    @Given("user is on the activity stream menu")
    public void userIsOnTheActivityStreamMenu() {
        Login login=new Login();
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        login.usernameInput.sendKeys(ConfigurationReader.getProperty("username"));
        login.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        login.loginButton.click();

    }

    @And("user clicks the message box")
    public void userClicksTheMessageBox() {
        activityStream.messageBox.click();
    }

    @When("user writes {string} to the message tab")
    public void userWritesToTheMessageTab(String arg0) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(activityStream.iframe));
        Driver.getDriver().switchTo().frame(activityStream.iframe);
        activityStream.iframeMessageBox.sendKeys(arg0);
    }

    @And("user able to press send key")
    public void userAbleToPressSendKey() throws InterruptedException {
        Driver.getDriver().switchTo().parentFrame();
        activityStream.sendButton.click();

    }


    @Then("user should be able to send the message {string}")
    public void userShouldBeAbleToSendTheMessage(String arg0) {
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='feed-post-text-block-inner-inner'])[1]")));
        String messageSent=activityStream.messageBody.getText();
        Assert.assertEquals(arg0,messageSent);
    }


    @When("user leaves the message text empty and clicks the send button")
    public void userLeavesTheMessageTextEmptyAndClicksTheSendButton(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(activityStream.sendButton));
        activityStream.sendButton.click();
    }

    @Then("error message {string} is displayed")
    public void errorMessageIsDisplayed(String arg0) {
        String actualErrorMessage=activityStream.errorMessage.getText();
        Assert.assertEquals(arg0,actualErrorMessage);
    }


    @And("user deletes the default recipient and click the send button")
    public void userDeletesTheDefaultRecipientAndClickTheSendButton() {
        Driver.getDriver().switchTo().parentFrame();
        activityStream.allEmployeesClose.click();
        activityStream.sendButton.click();
    }



    @Then("user should verify that default recipient is {string}")
    public void userShouldVerifyThatDefaultRecipientIs(String arg0) {
        String actualDefaultRecipient=activityStream.defaultRecipient.getText();
        Assert.assertEquals(arg0,actualDefaultRecipient);
    }


    @When("user clicks to add more")
    public void userClicksToAddMore() {
        activityStream.addMore.click();
    }

    @Then("user should be able to add recipients from Recent, My Groups and Employees and departments tabs")
    public void userShouldBeAbleToAddRecipientsFromRecentMyGroupsAndEmployeesAndDepartmentsTabs()  {
        activityStream.recent.click();
        activityStream.recentRecipient.click();
        activityStream.employeesAndDepartments.click();
        activityStream.department.click();
        activityStream.subDepartment.click();
        Assert.assertTrue(activityStream.selectedRecipient1.isDisplayed());
        Assert.assertTrue(activityStream.getSelectedRecipient2.isDisplayed());

    }

    @Then("user can delete a recipient")
    public void userCanDeleteARecipient() {
        activityStream.allEmployeesDeleteButton.click();
        Assert.assertNotNull(activityStream.selectedRecipient1);
    }

    @And("user clicks cancel button")
    public void userClicksCancelButton() {
        Driver.getDriver().switchTo().parentFrame();
        activityStream.cancelButton.click();
    }

    @Then("the message should be deleted and main screen should be monitored")
    public void theMessageShouldBeDeletedAndMainScreenShouldBeMonitored() {
        activityStream.messageBox.click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(activityStream.iframe));
        Driver.getDriver().switchTo().frame(activityStream.iframe);

        String actual=activityStream.iframeMessageBox.getText();
        Assert.assertTrue(actual.isBlank());

    }
}
