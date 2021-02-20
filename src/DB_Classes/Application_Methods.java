package DB_Classes;

import java.sql.*;
import static java.lang.System.out;

public class Application_Methods {

    public static SQL_Methods sql = new SQL_Methods();
    //public Connection connection;

    Application_Methods() {
        try {
            main();
        } catch (Exception e) {
            out.println("Application_Methods failed.");
        }
    }

    public void main() throws Exception {
        //connection = getConnection();

        dropTables();
        createDatabase();
        insertValuesIntoTables();

        getQuery("select * from SMJ_Car");
        getQuery("select * from SMJ_Client");
        getQuery("select * from SMJ_Property");
        getQuery("select * from SMJ_QuoteCar");
        getQuery("select * from SMJ_AutoPolicy");
    }

    /**
     * returns a connection object based on the given information
     * @return
     * @throws Exception
     */
    public Connection getConnection() throws Exception {
        try {
            final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
            String username = "SYSTEM";
            String password = "system";

            Connection connection = DriverManager.getConnection(DB_URL, username, password);
            out.println("Successfully Connected!");
            return connection;

        } catch (Exception e){
            out.println("Error Creating the Database");
            out.println(e.getMessage());
            return null;
        }

    }

    /**
     * Drops tables if they exist
     * @throws Exception
     */
    public void dropTables() throws Exception {
        Connection connection = getConnection();
        assert connection != null;

        Statement statement = connection.createStatement(); // Get a Statement object.
        try {
            //TODO:TRY & CATCH REQUIRED for each statement

            // Drop the given table.
            statement.execute("DROP TABLE SMJ_AutoPolicy");
            statement.execute("DROP TABLE SMJ_PropertyPolicy");
            statement.execute("DROP TABLE SMJ_QuoteCar");
            statement.execute("DROP TABLE SMJ_QuoteProperty");
            statement.execute("DROP TABLE SMJ_Property");
            statement.execute("DROP TABLE SMJ_Car");
            statement.execute("DROP TABLE SMJ_Client");

            out.println("All tables dropped");

        } catch (SQLException ex) {
            out.println("dropTables() failed"); // A table did not exist.
        }
    }

    /**
     * Creates the DB's tables
     * @param sqlScript
     * @throws Exception
     */
    public void createTable(String sqlScript) throws Exception {
        try {
            Connection connection = getConnection();
            assert connection != null;
            PreparedStatement create = connection.prepareStatement(sqlScript);
            create.executeUpdate();

        } catch (Exception e) {
            out.println("Error Creating the Table");
            out.println(e.getMessage());
        }
        finally {
            out.println("Table creation completed!");
        }
    }

    /**
     * Drops the tables if exist and regenerates the DB
     * @throws Exception
     */
    public void createDatabase() throws Exception {
        try {
            //TODO: try & catch for all statements
            //dropTables();

            createTable(sql.SMJ_Client);
            createTable(sql.SMJ_Car);
            createTable(sql.SMJ_QuoteCar);
            createTable(sql.SMJ_AutoPolicy);
            createTable(sql.SMJ_Property);
            createTable(sql.SMJ_QuoteProperty);
            createTable(sql.SMJ_PropertyPolicy);

        } catch(Exception e) {
            out.println("Error Creating the Database");
            out.println(e.getMessage());
        }
    }

    /**
     * Gets an INSERT SQL statement as string and inputs the values into the proper tables
     * @param sqlScript
     * @throws Exception
     */
    public void post(String sqlScript) throws Exception {

        try {
            Connection connection = getConnection();
            assert connection != null;

            PreparedStatement posted = connection.prepareStatement(sqlScript);
            posted.executeUpdate();

        } catch(Exception e) {
            out.println("Error inserting values into the Table");
            out.println(e.getMessage());
        }
        finally {
            out.println("Insert completed!");
        }
    }

    /**
     * Simply populates the DB's tables using given SQL statements
     * @throws Exception
     */
    public void insertValuesIntoTables() throws Exception {
        //TODO: try catch for all statements here

        post(sql.insValClient);
        post(sql.insValCar);
        post(sql.insValProperty);
        post(sql.insValQuoteCar);
        post(sql.insValQuoteProperty);
        post(sql.insValAutoPolicy);
        post(sql.insValPropertyPolicy);
    }

    /**
     * Gets a query SQL statement as String and runs it
     * @param sqlStatement
     * @throws Exception
     */
    public void getQuery(String sqlStatement) throws Exception {
        try {
            StringBuilder queryResult = new StringBuilder();

            Connection connection = getConnection();
            assert connection != null;

            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            ResultSet result = statement.executeQuery();
            ResultSetMetaData metaData = result.getMetaData();
            int numberOfColumns = metaData.getColumnCount() + 1;

            for (int i = 1; i < numberOfColumns; i++) {
                out.printf("%-12s\t", metaData.getColumnName(i));
            }
            out.println("\n------------------------------------------------------------------------------------------");
            while (result.next()) { // As long as there is another object in the table
                for (int i = 1; i < numberOfColumns ; i++) {
                    out.printf("%-12s\t", result.getObject(i));
                }
                out.println();
            }
            connection.close();

        } catch(Exception e) {
            out.println("Error creating query out of the Table");
            out.println(e.getMessage());
        }
    }

}
