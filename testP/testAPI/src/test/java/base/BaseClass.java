package base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;

public class BaseClass {

    PrerequisteMethods helperMethod = new PrerequisteMethods();
    private static final Logger logger = LoggerFactory.getLogger(BaseClass.class);


    @BeforeMethod
    public void createEntry() {
      String id = helperMethod.createEntry();
      TestDataVariables.saveId(id);
    }

    @AfterMethod
    public void deleteEntry() {
        List<String> idsToBeDeleted = TestDataVariables.getIds();
        for (String id : idsToBeDeleted){
            try{
                helperMethod.deleteEntry(id);
            }catch(Exception e){
                logger.error("Id " + id + " was not found or could not have been deleted.");
            }
        }
    }
}
