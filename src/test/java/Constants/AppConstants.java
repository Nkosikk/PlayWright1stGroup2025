package Constants;

import com.github.javafaker.Faker;

public class AppConstants {

    public static final String EXPECTED_LOGIN_PAGE_TITLE = "Swag Labs";
    public static final String UserName1 = "standard_user";
    public static final String UserName2 = "locked_out_user";
    public static final String UserName3 = "problem_user";
    public static final String UserName4 = "problem_user";
    public static final String UserName5 = "performance_glitch_user";
    public static final String UserName6 = "visual_user";
    public static final String UserPassword = "secret_sauce";
    public static final String EXPECTED_PRODUCTS_PAGE_TITLE = "Products";

    public  static String FirstName = Faker.instance().name().firstName();
    public  static String LastName = Faker.instance().name().lastName();
    public  static String PostalCode = Faker.instance().address().zipCode();

}
