import java.sql.*;

public class SMJDB_Application {

    public static void main(String[] args) throws Exception {
        createDatabase();
        insertValuesIntoTables();
        getQuery("select * from SMJ_TBL_CAR");
        getQuery("select * from SMJ_TBL_CLIENT");
        getQuery("select * from SMJ_TBL_PROPERTY");
        getQuery("select * from SMJ_TBL_POLICY");
    }

    /**
     * returns a connection object based on the given information
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {
        try {
            final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
            String username = "SYSTEM";
            String password = "system";

            Connection connection = DriverManager.getConnection(DB_URL, username, password);
            System.out.println("Successfully Connected!");
            return connection;

        } catch (Exception e){
            System.out.println("Error Creating the Database");
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Drops tables if they exist
     * @throws Exception
     */
    public static void dropTables() throws Exception {
        Connection connection = getConnection();
        assert connection != null;

        // Get a Statement object.
        Statement statement = connection.createStatement();
        try
        {
            //TODO:TRY & CATCH REQUIRED for each statement

            // Drop the given table.
            statement.execute("DROP TABLE SMJ_TBL_AUTO_POLICY");
            statement.execute("DROP TABLE SMJ_TBL_PROPERTY_POLICY");
            statement.execute("DROP TABLE SMJ_TBL_QUOTE");
            statement.execute("DROP TABLE SMJ_TBL_CAR");
            statement.execute("DROP TABLE SMJ_TBL_PROPERTY");
            statement.execute("DROP TABLE SMJ_TBL_POLICY");
            statement.execute("DROP TABLE SMJ_TBL_CLIENT");

            System.out.println("All tables dropped");

        } catch (SQLException ex)
        {
            // No need to report an error.
            // The table simply did not exist.
        }
    }

    /**
     * Creates the DB's tables
     * @param sqlScript
     * @throws Exception
     */
    public static void createTable(String sqlScript) throws Exception {
        try {
            Connection connection = getConnection();
            assert connection != null;
            PreparedStatement create = connection.prepareStatement(sqlScript);
            create.executeUpdate();

        } catch (Exception e){
            System.out.println("Error Creating the Table");
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Table creation completed!");
        }
    }

    /**
     * Drops the tables if exist and regenerates the DB
     * @throws Exception
     */
    public static void createDatabase() throws Exception {
        try{
            //TODO: try & catch for all statements
            dropTables();

            createTable(SMJProject_sqlStatements.tblClient);
            createTable(SMJProject_sqlStatements.tblPolicy);
            createTable(SMJProject_sqlStatements.tblProperty);
            createTable(SMJProject_sqlStatements.tblCar);
            createTable(SMJProject_sqlStatements.tblQuote);
            createTable(SMJProject_sqlStatements.tblAutoPolicy);
            createTable(SMJProject_sqlStatements.tblPropertyPolicy);

        } catch(Exception e) {
            System.out.println("Error Creating the Database");
            System.out.println(e.getMessage());
        }
    }

    /**
     * Gets an INSERT SQL statement as string and inputs the values into the proper tables
     * @param sqlScript
     * @throws Exception
     */
    public static void post(String sqlScript) throws Exception {

        try {
            Connection connection = getConnection();
            assert connection != null;

            PreparedStatement posted = connection.prepareStatement(sqlScript);
            posted.executeUpdate();

        } catch(Exception e){
            System.out.println("Error inserting values into the Table");
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Insert completed!");
        }
    }

    /**
     * Simply populates the DB's tables using given SQL statements
     * @throws Exception
     */
    public static void insertValuesIntoTables() throws Exception {
        //TODO: try catch for all statements here

        post(SMJProject_sqlStatements.insValueClient);
        post(SMJProject_sqlStatements.insValueProperty);
        post(SMJProject_sqlStatements.insValueCar);
        post(SMJProject_sqlStatements.insValuePolicy);
        post(SMJProject_sqlStatements.insValueQuote);
        post(SMJProject_sqlStatements.insValueAutoPolicy);
        post(SMJProject_sqlStatements.insValuePropertyPolicy);
    }

    /**
     * Gets a query SQL statement as String and runs it
     * @param sqlStatement
     * @throws Exception
     */
    public static void getQuery(String sqlStatement) throws Exception{
        try{
            StringBuilder queryResult = new StringBuilder();

            Connection connection = getConnection();
            assert connection != null;

            PreparedStatement statement = connection.prepareStatement(sqlStatement);
            ResultSet result = statement.executeQuery();
            ResultSetMetaData metaData = result.getMetaData();
            int numberOfColumns = metaData.getColumnCount() + 1;

            for (int i = 1; i < numberOfColumns; i++) {
                System.out.printf("%-12s\t", metaData.getColumnName(i));
            }
            System.out.println("\n----------------------------------------------------------------");
            while (result.next()) { // As long as there is another object in the table
                for (int i = 1; i < numberOfColumns ; i++) {
                    System.out.printf("%-12s\t", result.getObject(i));
                }
                System.out.println();
            }
            connection.close();

        }catch(Exception e){
            System.out.println("Error creating querry out of the Table");
            System.out.println(e.getMessage());
        }
    }
}
