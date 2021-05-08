package basicTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//import org.junit.Test;

public class JunitBasic {

    @Before
    public void before(){
        System.out.println("BEFORE Test");
    }

    @After
    public void after(){
        System.out.println("AFTER Test");
    }


    @Test
    public void verifyTheJunitIsWorking(){
        System.out.println("It is a TEST!");
    }

    @Test
    public void verifyTheJunitIsWorking2(){
        System.out.println("It is a TEST2!");
    }

}