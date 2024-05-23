import org.junit.*;
import org.testng.annotations.*;

import static utils.SetUpDriver.*;

public class hooks {

    @Before
    public void beforeScenario(){
        initializeDriver();
    }
    @After
    public void afterScenario(){
        closeDriver();
    }
}
