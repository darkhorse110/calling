import org.testng.TestNG;
import org.testng.collections.Lists;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

//@Listeners(ReportListener.class)
public class TestRunner {
    static TestNG testNG;

    public static void main(String[] args) throws IOException {
        testNG = new TestNG();
        List suites = Lists.newArrayList();
        suites.add("src/test/resources/RunTestCase.xml");
        testNG.setTestSuites(suites);
        testNG.run();
        // send command curl to Rocket chat
            // Curl for OS unix
            Process p = Runtime.getRuntime().exec(new String[]{"sh", "-c", "curl -X POST -H 'Content-Type: application/json' --data '{\"text\":\"Run Test Scrip done\"}' https://neolab.wc.calling.fun/hooks/JLZBssrGJTsNa4PHu/Pgrt2XssvtvioNvZEKsoi4fTfe9Kvmd4eSPyjibWNHWycatX"});
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = null;
            System.out.println(line = in.readLine());
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
    }
}
