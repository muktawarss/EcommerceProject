package listeners;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class MyListeners extends TestListenerAdapter {

    public void  onFinish(ITestContext context){
        for (int i = 0; i < context.getAllTestMethods().length; i++) {
            if (context.getAllTestMethods()[i].getCurrentInvocationCount() == 2) {
                if (context.getFailedTests().getResults(context.getAllTestMethods()[i]).size() == 2 || context.getPassedTests().getResults(context.getAllTestMethods()[i]).size() == 1) {
                    context.getFailedTests().removeResult(context.getAllTestMethods()[i]);
                }
            }
        }
    }

  /*  @Override
    public void onTestSkipped(ITestResult result) {
        String rs = getMethodContext(result);
        System.out.println(rs + " | SKIPPED");
        Reporter.log(rs + " | SKIPPED");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String rs = getMethodContext(result);
        System.out.println(rs + " | PASSED");
        Reporter.log(rs + " | PASSED");
    }*/

    @SuppressWarnings("unused")
	private String getMethodContext(ITestResult result) {
        //String browser = result.getTestContext().getCurrentXmlTest()
        //.getParameter("browser");
        String testClasss = result.getTestClass().getName();
        String name = result.getName();
        String rs = testClasss + " | " + name;
        return rs;
    }
}
