package com.openlyCrm.step_definitions;


import com.openlyCrm.utilities.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {


    @After  // every scenario
    public void tearDownScenario(Scenario scenario) {

        if (scenario.isFailed()) {

            byte[] screenShot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "image/png", scenario.getName());
        }

        Driver.closeDriver();

    }


}

