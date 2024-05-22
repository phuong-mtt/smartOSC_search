import org.junit.*;

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
