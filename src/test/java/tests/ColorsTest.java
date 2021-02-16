package tests;

import adapters.BaseAdapter;
import consntants.TestConstants;
import org.testng.annotations.Test;


public class ColorsTest implements TestConstants {

    @Test
    public void colorsListTest(){
        new BaseAdapter().get(LIST_COLORS_URL);
    }
}
