import java.util.Scanner;
import java.sql.*;

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
                System.out.print( "Enter Second integer: " );
                number2 = input.nextInt(); //Defines number2
                sum = number1 + number2;
                System.out.printf( "Sum equals %d\n", sum); */
	}


        public void defaultMenu()
        {
                
        }

        public static void menuContent()	// The first menu to appear on the app.
        {

            if ( menuOption == "" )
            {
                System.out.println( "***********************************" );
                System.out.println( "* ( 1 ) Login                     *" );
                System.out.println( "* ( 2 ) Sign Up                   *" );
                System.out.println( "* ( 3 ) Search                    *" );
                System.out.println( "* ( 4 ) Exit                      *" );
                System.out.println( "***********************************" );
            }
            else if( menuOption =="1" )
            {
            
            }
            else if( menuOption =="2" )
            {
            	
            }
            else if( menuOption =="3" )
            {
            	
            }
            else if( menuOption =="4" )
            {

            }
            else
            {
            	
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
               Connection sqlcon  = null;
           Statement sqlStatement  = null;
     ResultSet myResultSet  = null;

     try {
       DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

       // Connect to the database
       sqlcon= DriverManager.getConnection ("jdbc:my:thin:hr/hr@oracle.cise.ufl.edu:1521:orcl", "username", "password");

       // Create a Statement
       sqlStatement = sqlcon.createStatement ();

       // call sqlStatement.executeQuery ()
       String q = "select Student.ID, name, GPA from Student, Apply where UnivName = \'UF\' and Student.ID = Apply.ID";

       System.out.println(q);      
       myResultSet = sqlStatement.executeQuery(q);


       // Move to next row and & its contents to the html output
       while(myResultSet.next())
       {
         String id = myResultSet.getObject(1).toString();
         String name = myResultSet.getObject(2).toString();
         String GPA = myResultSet.getObject(3).toString();
         System.out.println("  " + id + "    " + name + "     " + GPA);
       }

       sqlStatement.close();

       sqlcon.close();
     }

     catch (SQLException ex)
     {
       System.out.println("SQLException:" + ex.getMessage() + "<BR>");
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
