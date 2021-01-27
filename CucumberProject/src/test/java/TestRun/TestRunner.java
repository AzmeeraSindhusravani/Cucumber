package TestRun;
import org.testng.ITest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.api.testng.*;

@CucumberOptions(
	     //features ="Features",
		 //features=".//Features/A_Sales_Projections.feature",
		  features=".//Features/login.feature",
         //tags= {"@PeriodSales,@SalesActualComps,@SalesActualBudget,@Projections,@SalesBudget"},
	 	 //tags= {"@Projections,@salesBudget,@purchaseActuals,@purchaseOrders,@purchasePlan"},
		 glue= {"StepDefinition"},

		
		plugin={"com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"},		
		monochrome = true, dryRun = false)
	    
public class TestRunner extends AbstractTestNGCucumberTests implements ITest {
private TestNGCucumberRunner tcr; 
private String featureName;

@BeforeClass(alwaysRun = false)
public void beforeClass() throws Exception {
tcr = new TestNGCucumberRunner(this.getClass());
}
@BeforeMethod
public void beforeMethod(Object[] params) {
CucumberFeatureWrapper cucumberFeature = (CucumberFeatureWrapper) params[0];
featureName = cucumberFeature.getCucumberFeature().getGherkinFeature().getName();
}

@Test(groups = "cucumber", description = "Runs CucumberFeature", dataProvider = "features")
public void feature(CucumberFeatureWrapper cucumberFeature) {
tcr.runCucumber(cucumberFeature.getCucumberFeature());
}

@Override
public String getTestName() {
return featureName;
}

@DataProvider
public Object[][] features() {
return tcr.provideFeatures();
} 

@AfterClass(alwaysRun = true)
public void afterClass() {
tcr.finish();
}
}