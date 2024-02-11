package Class01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Annotations {

    @BeforeMethod
    public  void BeforeMethod(){
        System.out.println("I am before method");
    }

    @Test
    public void ATestCase(){
        System.out.println("This is the test case no 1");

    }
    @Test
    public void BTestCase(){
        System.out.println("This is the test case no 2");
    }

    @AfterMethod
    public  void AfterMethod(){
        System.out.println("I am After method");
    }
}
