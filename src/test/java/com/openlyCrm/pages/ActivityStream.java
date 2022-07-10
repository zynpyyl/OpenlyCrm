package com.openlyCrm.pages;

import com.openlyCrm.utilities.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActivityStream {
    public ActivityStream(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@id='microoPostFormLHE_blogPostForm_inner']")
    public WebElement messageBox;

    @FindBy(xpath = "(//iframe)[1]")
    public WebElement iframe;

    @FindBy(xpath = "//body[@contenteditable='true']")
    public WebElement iframeMessageBox;

    @FindBy(xpath = "//button[@id='blog-submit-button-save']")
    public WebElement sendButton;

    @FindBy(xpath = "//span[@class='feed-add-info-text']")
    public WebElement errorMessage;

    @FindBy(xpath = "//span[@class='feed-add-post-del-but']")
    public WebElement allEmployeesClose;

    @FindBy(xpath = "//span[@class='feed-add-post-destination-text']")
    public WebElement defaultRecipient;

    @FindBy(xpath = "(//div[@class='feed-post-text-block-inner-inner'])[1]")
    public WebElement messageBody;

    @FindBy(linkText = "Add more")
    public WebElement addMore;

    @FindBy(xpath = "//a[@class='bx-finder-box-tab bx-lm-tab-last bx-finder-box-tab-selected']")
    public WebElement recent;

    @FindBy(xpath = "(//div[@class='bx-finder-box-item-t7-name'])[3]")
    public WebElement recentRecipient;

    @FindBy(xpath = "//a[contains(@id,'destDepartmentTab_destination')]")
    public WebElement employeesAndDepartments;

    @FindBy(linkText = "HR")
    public WebElement department;

    @FindBy(xpath = "(//div[@class='bx-finder-company-department-check-text'])[1]")
    public WebElement subDepartment;

    @FindBy(xpath = "(//span[@class='feed-add-post-destination-text'])[2]")
    public WebElement selectedRecipient1;

    @FindBy(xpath = "(//span[@class='feed-add-post-destination-text'])[3]")
    public WebElement getSelectedRecipient2;

    @FindBy(xpath = "(//span[@class='feed-add-post-del-but'])[1]")
    public WebElement allEmployeesDeleteButton;

    @FindBy(xpath = "//button[@id='blog-submit-button-cancel']")
    public WebElement cancelButton;



}
