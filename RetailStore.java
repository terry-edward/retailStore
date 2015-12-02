import java.util.Scanner;
import java.sql.*;
/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
*/

public class RetailStore
{

        String userLevel = "Guest";
        String[] userinfo = new String[]{""};
        String menu = "";//defaultMenu();
        static String menuOption = "";
        static boolean app_running = true;



	public static void main(String[] args)
	{
                //System.out.println("");

                while ( app_running ){

                        menuContent();
                        app_running = false;
                }

               /* Scanner input = new Scanner( System.in );

                int number1;
                int number2;
                int sum;

                System.out.print( "Enter First integer: " );
                number1 = input.nextInt(); //Defines number1
                System.out.print( "Enter Second interger: " );
                number2 = input.nextInt(); //Defines number2

                sum = number1 + number2;
                System.out.printf( "Sum equals %d\n", sum); */
	}


        public void defaultMenu(){
                
        }

        public static void menuContent()
        {

             if ( menuOption == "" ){
                System.out.println( "***********************************" );
                System.out.println( "* ( 1 ) Login                     *" );
                System.out.println( "* ( 2 ) Sign Up                   *" );
                System.out.println( "* ( 3 ) Search                    *" );
                System.out.println( "* ( 4 ) Exit                      *" );
                System.out.println( "***********************************" );
            }else{

            }



        }

        public void get_user_level()
        {

        }

        public void menu_logout()
        {

        }

        public void menu_login()
        {

        }

        public void menu_search()
        {

        }

        public void menu_sign_up()
        {

        }

        public void menu_delete_account()
        {

        }

        public void menu_update_user_info()
        {

        }

        public void add_to_order()
        {

        }

        public void menu_checkout(){

        }

        public void create() throws SQLException{
                Connection conn = null;
                Statement stmt = null;
                ResultSet rs = null;
                try {
                        //                      new com.mysql.jdbc.Driver();
                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        // conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdatabase?user=testuser&password=testpassword");
                        String connectionUrl = "jdbc:mysql://localhost:3306/testdatabase";
                        String connectionUser = "testuser";
                        String connectionPassword = "testpassword";
                        conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
                        stmt = conn.createStatement();
                        rs = stmt.executeQuery("SELECT * FROM employees");
                        while (rs.next()) {
                                String id = rs.getString("id");
                                String firstName = rs.getString("first_name");
                                String lastName = rs.getString("last_name");
                                System.out.println("ID: " + id + ", First Name: " + firstName
                                                + ", Last Name: " + lastName);
                        }
                } catch (Exception e) {
                        e.printStackTrace();
                } finally {
                        try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
                        try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
                        try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
                }


        }

        public boolean read() throws SQLException{


                return false;
        }

        public void update() throws SQLException{

        }

        public void delete() throws SQLException{

        }


}