package validator;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ValidatorTest extends Assert{

     @DataProvider(name = "dataProvider")
     public Object[][] provide(){
         List<String> lines = new ArrayList<>();
         lines.add("1.0 0.2 0.3 0.5");
         lines.add("-15.0 0.2 0.3 0.5");
         lines.add("15.0 0.f2 0.3 0.5");
         lines.add("15.0 0.2 0.3");
         lines.add("15.0 0.2 0.3 0.9595");
         List<Boolean> answers = new ArrayList<>();
         answers.add(true);
         answers.add(false);
         answers.add(false);
         answers.add(false);
         answers.add(true);
         return new Object[][]{
                 {lines, answers}
         };
     }

     @Test(dataProvider = "dataProvider")
    public void validateTest(List<String> lines, List<Boolean> answers){
         for (int i = 0; i<lines.size(); i++){
             boolean expected = answers.get(i);

             boolean actual = Validator.validate(lines.get(i));

             assertEquals(expected, actual);
         }
     }
}
