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

    
    String[] userinfo = new String[]{""};
    
    String[] guest_general_options = new String[]{
        "Login", "SignUp", "Search", "Exit"
    };





    String[] login_options = new String[]{"Username", "Password", "Enter Credentials", "Return"};
    String[] user_option = new String[]{"Delete Account", "Update Info", "Add to Order", "View Cart", "Logout", "Checkout", "Search"};
    String[] staff_option = new String[]{"Create", "Update", "Delete"};
    boolean app_running = true;
    String username = "Guest";
    String password = "Guest";
    


        public static void main(String[] args)
        {

            RetailStore retailStore = new RetailStore();
            //retailStore.options = retailStore.guest_general_options;
           // while ( retailStore.app_running )
            //{
                    retailStore.menuContent(retailStore.guest_general_options);
            //}          
        }


        public void menuContent(String[] menuOptions)
        {

            while ( app_running ){
            String menu = "";
            int size = menuOptions.length;
            for (int i = 0; i < size; i++){
                menu += "( " + i + " ) " + menuOptions[i] + "\n";
            }

            System.out.print(menu);
            //Scanner input = new Scanner( System.in );
            Scanner input = new Scanner( System.in );
            int menuOption = input.nextInt(); 
            //System.out.println(options[menuOption]);
            navigate(menuOptions[menuOption]);
            }
        }



        public void navigate(String menuOption){
            
            switch (menuOption){


            case "Exit":
                menu_exit();
                break;
            case "Login":
                menu_login();
                //menuContent(login_options);
                //System.out.println("menuOption");
            case "Return":
                return;
            case "Username":
                //set_Username();
            default:
                //menu_exit();
                System.out.println(menuOption);
            }

        }

        /* EXIT APP */
        public void menu_exit()
        {
            app_running = false;
        }

        public void menu_login()
        {

            Scanner input = new Scanner( System.in );
            System.out.print( "Please Enter Username:" );
            username = input.nextLine(); //Defines number1 
            System.out.print( "Please Enter Password:" );
            password = input.nextLine(); //Defines number1 
            

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
                        while (rs.next()) {
                                String id = rs.getString("user_id");
                                String firstName = rs.getString("user_name");
                                String lastName = rs.getString("user_password");
                                System.out.println("ID: " + id + ", User Name: " + firstName
                                                + ", Password: " + lastName);
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