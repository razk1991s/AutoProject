package extentions;

import io.qameta.allure.Step;
import utilities.CommonOps;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBActions extends CommonOps {

    @Step("get credentials from DB")
    public static List<String> getCredentials(String query){
        List<String> credentials = new ArrayList<String>();
        try {
            rs = stmt.executeQuery(query);
            rs.next();
            credentials.add(rs.getString(1));
            credentials.add(rs.getString(2));
        } catch (Exception e) {
            System.out.println("ERROR Occurred while printing table DATA, see details: "+e);
        }
        return credentials;
    }
}
