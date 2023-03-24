package steps;

import static utils.Utils.*;

import java.util.ArrayList;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	@Before
	public void setUp(Scenario scenario) throws Exception {
		Selenide.open("https://app.cocobambu.com/delivery");
		
	}

	@After
	public void tearDown(Scenario scenario) throws Exception {
//		capturarScreenshot(scenario);
//		Selenide.closeWindow();

	}

}
