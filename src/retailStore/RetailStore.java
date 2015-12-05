//package test;
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
//String userLevel = "Guest";
                //boolean logged_in = false;
    //String username = "Guest";
    //String password = "Guest";
import java.util.Scanner;
import java.sql.*;

public class RetailStore
{

    Scanner input = new Scanner( System.in );
    String[] userinfo = new String[]{""};
    String[] general_options = new String[]{""};
    String[] guest_general_options = new String[]{"Login", "SignUp", "Search", "Exit"};
    String[] login_options = new String[]{"Enter Username", "Enter Password", "Enter Credentials", "Return"};
    String[] signup_options = new String[]{"Enter Username", "Enter Password", "Create Account", "Return"};
    String[] search_options = new String[]{"Enter Keywords", "Return"};
    String[] user_options = new String[]{"View Profile", "View Cart", "Search", "View Past Orders", "Logout", /*"Exit"*/};
    String[] profile_options = new String[]{"Update Account", "Delete Account", "Return", /*"Exit"*/};
    String[] staff_options = new String[]{"Create", "Update", "Delete"};
    String[] user_update_options = new String[]{"Update Password", "Update Address","Update Name", "Exit"};
    boolean app_running = true;
    boolean submenu_running = false;
    boolean subsubmenu_running = false;
    String query = "";
    String username = ""; String password = ""; String userLevel = "";  String user_id=""; String address="";
    String name=""; 
    int inte = 0;


        public static void main(String[] args)
        {

            RetailStore retailStore = new RetailStore();
            //while ( retailStore.app_running ){
            retailStore.general_options = retailStore.guest_general_options;
            retailStore.menuContent(retailStore.general_options); 
            //}
        }

        //public boolean menuContent(String[] menuOptions)
        public void menuContent(String[] menuOptions)
        {

            while ( app_running ){

                String menu = "";
                int size = menuOptions.length;
                for ( int i = 0; i < size; i++ ){
                    menu += "( " + i + " ) " + menuOptions[i] + "\n";
                }

                System.out.print(menu);

                
                int menuOption = input.nextInt();
                navigate(menuOptions[menuOption]);
            }

        }

        public void submenuContent(String[] menuOptions)
        {

            while ( submenu_running ){

                String menu = "";
                int size = menuOptions.length;
                for ( int i = 0; i < size; i++ ){
                    menu += "( " + i + " ) " + menuOptions[i] + "\n";
                }

                System.out.print(menu);

                
                int menuOption = input.nextInt();
                navigate(menuOptions[menuOption]);
            }

        }

        public void subsubmenuContent(String[] menuOptions)
        {

            while ( subsubmenu_running ){

                String menu = "";
                int size = menuOptions.length;
                for ( int i = 0; i < size; i++ ){
                    menu += "( " + i + " ) " + menuOptions[i] + "\n";
                }

                System.out.print(menu);

                
                int menuOption = input.nextInt();
                navigate(menuOptions[menuOption]);
            }

        }

        public void navigate(String menuOption)
        {
            inte++;
            System.out.println(inte);
            
            switch (menuOption)
            {


            case "Create Account": /*EITHER AUTO LOGIN OR NOT*/
                //loggin Value
                query = "INSERT INTO User(user_email, user_password) VALUES('" + username + "', '" + password + "')";
                 String query2 =  "SELECT * FROM User WHERE user_email ='" + username + "'";
                if ( signUp( query, query2 ) != 0 ){
                    menuContent(user_options);
                }
                break;
            case "Delete Account":
                query = "DELETE FROM User WHERE user_email = '" + username + "'";
                if ( deletAccount( query ) != 0 ){
                    menuContent(guest_general_options);
                }
                break;
            case "Enter Credentials":
                query = "SELECT * FROM User WHERE user_email ='"+ username + "' AND user_password='" + password + "'";
                if ( login( query )  ){
                    menuContent(user_options);
                }
                break;
            case "Enter Password":
                set_Password();
                break;
            case "Enter Username":
                set_Username();
                break;
            case "Exit":
                subsubmenu_exit();
                //return false;//break;return
                break;
            case "Login"://menu_login();
                menuContent(login_options);
                app_running = true;
                break;
            case "Return":
                menu_exit();
                break;
            case "Search":
                menuContent(search_options);
                app_running = true;
                break;
            case "SignUp": 
                menuContent(signup_options);
                app_running = true;
                break;
            case "Update Account":
                subsubmenu_running = true;
                subsubmenuContent(user_update_options);
                break;
            case "Update Address":
                update_usr("user_address");
                break;
            case "Update Name":
                update_usr("user_name");
                break;
            case "Update Password":
                update_usr("user_password");
                break;
            case "View Profile"://menu_login();
                System.out.println("Name:\t\t" + name);
                System.out.println("Address:\t" + address);
                System.out.println("Email:\t\t" + username);
                menuContent(profile_options);
                app_running = true;
                break;
            default:
                //menu_exit();
                System.out.println(menuOption);
            }

            //return true;

        }

        /* EXIT APP */

        public void subsubmenu_exit()
        {

            subsubmenu_running = false;     
        }

        public void menu_exit()
        {

            app_running = false;     
        }

        public void set_Username()
        {
            Scanner user = new Scanner( System.in );
            System.out.print( "Please Enter Username: " );
            username = user.nextLine();
        }

        public void set_Password()
        {
            Scanner pass = new Scanner( System.in );
            System.out.print( "Please Enter Password: " );
            password = pass.nextLine();
        }

         public void update_usr(String menuOption)
        {
            String update_info;

            Scanner usr_acc = new Scanner( System.in );
            if (menuOption == "user_address")
                System.out.print( "Please Enter Address: " );
            else if (menuOption == "user_name")
                System.out.print( "Please Enter Name: " );
            else if (menuOption == "user_password")
                System.out.print( "Please Enter Password: " );

            update_info = usr_acc.nextLine();
            String query = "Update User SET " + menuOption + "='" + update_info + "' WHERE user_email='" + username + "'"; 
            update_usr_acc(query); 

        }

        public void menu_login()
        {
            System.out.print( "Please Enter Username:" );
            username = input.nextLine(); 
            System.out.print( "Please Enter Password:" );
            password = input.nextLine();
           // update_usr_acc(); 
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

        private boolean login(String query){
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            boolean result = false;
            
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();

                String connectionUrl = "jdbc:mysql://localhost/cis_project";
                String connectionUser = "root";
                String connectionPassword = "JPN.96954899";
                conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
                stmt = conn.createStatement();
                rs = stmt.executeQuery( query );
                if (!rs.isBeforeFirst()){
                    System.out.println("Incorrect Username and Password. Please try again!");
                }
                else
                {
                    while (rs.next()){
                        user_id = rs.getString("user_id");
                        name = rs.getString("user_name");
                        address = rs.getString("user_address");
                                if ( rs.getString("user_is_Staff") == "Y" ) {
                                    userLevel = "Staff";

                                }else{
                                    userLevel = "Customer";
                                }
                    result = true;
                }
            } 
                
            }catch (Exception e) {
                        e.printStackTrace();
                } finally {
                        try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
                        try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
                        try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
                }

                return result;
            }

        private  int deletAccount(String query)
        {
             Connection conn = null;
             PreparedStatement stmt = null;
             ResultSet rs = null;
             int count =  0;
            
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();

                String connectionUrl = "jdbc:mysql://localhost/cis_project";
                String connectionUser = "root";
                String connectionPassword = "JPN.96954899";

                conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
                stmt = conn.prepareStatement( query );
                count = stmt.executeUpdate();
                System.out.println("the count is " + count );
                if ( count < 0 ){
                    System.out.println("Unable to delete account");
                }
                
            }catch (Exception e) {
                        e.printStackTrace();
                } finally {
                        try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
                        try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
                        try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
                }

                return count;
        }
        private int update_usr_acc(String query){
             Connection conn = null;
             PreparedStatement stmt = null;
             ResultSet rs = null;
             int count =  0;
            
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();

                String connectionUrl = "jdbc:mysql://localhost/cis_project";
                String connectionUser = "root";
                String connectionPassword = "JPN.96954899";

                conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
                stmt = conn.prepareStatement( query );
                count = stmt.executeUpdate();
               /* if (menuOption == "Update Address")
                    System.out.println("the count is " + count );
                elseif (menuOption == "Update Name")
                    System.out.println("the count is " + count );
                elseif (menuOption == "Update Password")
                     System.out.println("the count is " + count );*/
                
            }catch (Exception e) {
                        e.printStackTrace();
                } finally {
                        try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
                        try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
                        try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
                }

                return count;
        }
        private int signUp(String query, String query2){
            Connection conn = null;
            PreparedStatement stmt = null;
            Statement stmt2 = null;
            ResultSet rs = null;
           int count = 0;
            
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();

                String connectionUrl = "jdbc:mysql://localhost/cis_project";
                String connectionUser = "root";
                String connectionPassword = "JPN.96954899";

                conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
                stmt2 = conn.createStatement();
                rs = stmt2.executeQuery( query2 );
                if (rs.isBeforeFirst()){
                    System.out.println("This username is not available. Please try again!");
                }
                else
                {
                    stmt = conn.prepareStatement( query );
                    count = stmt.executeUpdate();
                    
                }   
                
            }catch (Exception e) {
                        e.printStackTrace();
                } finally {
                        try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
                        try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
                        try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
                }

                return count;

        }

        private void create(){
                Connection conn = null;
                Statement stmt = null;
                ResultSet rs = null;
                try {
                        //                      new com.mysql.jdbc.Driver();
                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        // conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdatabase?user=testuser&password=testpassword");
                        String connectionUrl = "jdbc:mysql://localhost/cis_project";
                        String connectionUser = "root";
                        String connectionPassword = "JPN.96954899";
                        conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
                        stmt = conn.createStatement();
                        rs = stmt.executeQuery("SELECT * FROM User");

                        /*while (rs.next()) {
                                String id = rs.getString("user_id");
                                String firstName = rs.getString("user_name");
                                String lastName = rs.getString("user_password");
                                System.out.println("ID: " + id + ", User Name: " + firstName
                                                + ", Password: " + lastName);
                        }*/
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