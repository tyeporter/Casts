package com.tyeporter.casts.selenium.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CategoryPageModel {

    private WebDriver driver;

    @FindBy(xpath = "//h1[@class='title margin-bottom-15']")
    private WebElement pageTitleElement;

    @FindBy(xpath = "//div[@class='buttons has-addons is-centered']//a")
    private List<WebElement> pageNavigationAnchorElements;

    @FindBy(xpath = "//h1[@class='title has-text-light margin-bottom-5']")
    private WebElement pageHeadingElement;

    @FindBy(xpath = "/html[1]/body[1]/main[1]/section[1]/div[1]/div[1]/div[1]/p")
    private List<WebElement> pageSubtitleElements;

    public CategoryPageModel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageTitleText() {
        return this.pageTitleElement.getText();
    }

    public List<String> getPageNavigationAnchorTitles() {
        List<String> navigationTitles = new ArrayList<>();

        for (WebElement pageNavigationAnchorElement : this.pageNavigationAnchorElements) {
            navigationTitles.add(pageNavigationAnchorElement.getText());
        }

        return navigationTitles;
    }

    public String getPageHeadingText() {
        return this.pageHeadingElement.getText();
    }

}
