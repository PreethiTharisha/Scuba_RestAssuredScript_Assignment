package com;

import com.maveric.core.cucumber.CucumberBaseTest;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"./src/test/resources/features"},
        glue ={ "com.api.stepDefs","com.api"}
)
public class CucumberRunner extends CucumberBaseTest {


}
