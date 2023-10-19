package testdata;

import org.testng.annotations.DataProvider;

public class testdata_one {

    @DataProvider(name = "data-provider")
    public Object[][] getData(){
        return new Object[][]{ {"test@test.com", "Test123!"}};
    }

}
