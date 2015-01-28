package stepDefinitions;

import org.javalite.activejdbc.Base;

import java.sql.SQLException;
import java.util.List;

public class SimpleTest {
    public static void main(String args[]) throws SQLException {
        Base.open("org.sqlite.JDBC", "jdbc:sqlite:" + System.getProperty("user.dir") + "\\src\\test\\resources\\practiceselenium.sqlite", "", "");
//       List<Map> products = Base.findAll("select * from products");
//        for(Map m:products)
//        {
//            System.out.println(m.get("id"));
//            System.out.println(m.get("category_id"));
//            System.out.println(m.get("description"));
//        }

        System.out.println("count--"+Fan.count());

        List<Fan> fans = Fan.findAll();
        Fan fan1 = fans.get(0);
        System.out.println(fan1.get("name"));


    }
}
