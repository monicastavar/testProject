package base;

import java.util.ArrayList;
import java.util.List;

public class TestDataVariables {

    static FileReader fileReader = new FileReader();
    private static List<String> ids = new ArrayList<String>();
    public static String DELETE_RESOURCE = fileReader.getProperty("DeleteEmployeeResource");
    public static String CREATE_RESOURCE = fileReader.getProperty("CreateEmployeeResource");
    public static String GET_ALL_RESOURCE = fileReader.getProperty("GETAllEmployeesResource");
    public static String GET_ID_RESOURCE = fileReader.getProperty("GETEmployeeResource");
    public static String UPDATE_RESOURCE = fileReader.getProperty("UpdateEmployeeResource");
    public static String ENDPOINT = fileReader.getProperty("endpoint");




    String endpoint = fileReader.getProperty("endpoint");


    public static void saveId(String id){
        ids.add(id);
    }

    public static List<String> getIds(){
        return ids;
    }

    public static String getId(int position){
        return ids.get(position);
    }
}
