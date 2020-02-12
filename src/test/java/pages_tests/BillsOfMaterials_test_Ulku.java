package pages_tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MainPageKenje.MainPageKenje;

public class BillsOfMaterials_test_Ulku {

    @BeforeClass
            public void login() {
        LoginTest login1 = new LoginTest();
        login1.loginManager();
    }

    @Test
    public void click(){
        MainPageKenje main=new MainPageKenje();
        main.billsOfMaterials.click();
    }
}
