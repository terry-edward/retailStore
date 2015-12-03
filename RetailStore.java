import java.util.Scanner;
import java.sql.*;
import java.io.* ;

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
                Scanner keyboard = new Scanner(System.in);
                menuOption = keyboard.nextInt();
            }
            else if( menuOption =="1" )
            {
            	menu_login();
            }
            else if( menuOption =="2" )
            {
            	menuSignUp();
            	menu_login();
            }
            else if( menuOption =="3" )
            {
            	menu_search();
            }
            else if( menuOption =="4" )
            {

            }
            else
            {
            		System.out.println("Not a menu option please try again")
            		menuOption = "";
            		menuContent();
            }
	}
	//////////////////////////////////////////////////////////////////////////////////////// End of menucontent;

	public void menu_login()
        {
		boolean tracker = false;
            	
                While(tracker != true)				// Use a for loop to return just incase we get a bad password/username combo
                {
            		Scanner sc = new Scanner(System.in);	// Put in a menu
            		System.out.println("Enter user ID: ")
            		String user_id = sc.nextLine();
            		System.out.println("Enter password: ")
            		String password = sc.nextLine();
            	
            		PreparedStatement password_Query = myCon.createStatement(	// the query for getting user_password based on user_name
            			"SELECT user_password, user_is_staff FROM User" + "WHERE user_name =" + user_id);
            			ResultSet passwords = password_Query.executeQuery();	
            	
            		while(passwords.next(){		//go through the password table to get passwords.
            			if(password.compareTo(passwords.getString(1)) == 0)	//if the passwords are the same
            			{
            				tracker = true;					// since passwords are the same quit out of loop
            				if(passwords.getChar(2) == 't')			// check if the user is a staff or not
            				{
            					userLevel = "staff";
            				}		
            				else
            				{
            					userLevel = "user";
            				}
            			}
            			else
            				System.out.println("Incorrect user/password combination, plealse try again.");
        		}
            	}
        }
        //////////////////////////////////////////////////////////////////////////////////////// End of menuLogin;
        public void menuSignUp()
        {
		Scanner sc = new Scanner(System.in);	// Put in a menu
		//Put in menu here
		Statement stat1 = myCon createStatement();
		stat1.executeUpdate("INSERT INTO User" + "VALUES("/*user_id(auto increments),user_address,user_name,user_password,user_email,user_is_staff*/ ")"
		System.out.println("Sucess your user ID is please relog") //*Note remember to put in the userID variable.
        }
        //////////////////////////////////////////////////////////////////////////////////////// End of menuSignUp;
        public String getUserLevel()
        {
		return userLevel;
        }

        public void menu_logout()
        {

        }

        public void menu_search()
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
