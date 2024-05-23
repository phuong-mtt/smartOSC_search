package stepDefs;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import utils.DriverInitializer;

public class hooks {
    @Before
    public void beforeScenario(){
        DriverInitializer.initializeDriver();
    }

    @After
    public void afterScenario(){
        DriverInitializer.closeDriver();
    }
}
