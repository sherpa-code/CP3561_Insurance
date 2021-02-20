public class SMJProject_sqlStatements {

    final public static String tblClient = "CREATE TABLE SMJ_TBL_CLIENT \n" +
            "(\n" +
            "  CLIENT_ID NUMBER(8, 0) NOT NULL \n" +
            ", FIRST_NAME VARCHAR2(25 BYTE) \n" +
            ", LAST_NAME VARCHAR2(25 BYTE) \n" +
            ", PHONE_NUMBER VARCHAR2(15 BYTE) \n" +
            ", EMAIL VARCHAR2(50 BYTE) \n" +
            ", DOB DATE \n" +
            ", CONSTRAINT SMJ_TBL_CLIENT_PK PRIMARY KEY (CLIENT_ID)\n" +
            ")";

    final public static String tblPolicy = "CREATE TABLE SMJ_TBL_POLICY \n" +
            "(\n" +
            "  POLICY_NUMBER NUMBER(8, 0) NOT NULL \n" +
            ", CLIENT_ID NUMBER(8, 0) NOT NULL \n" +
            ", POLICY_EFFECTIVE_DATE DATE \n" +
            ", POLICY_EXPIRE_DATE DATE \n" +
            ", PREMIUM NUMBER(8, 2) \n" +
            ", PAYMENT_OPTION VARCHAR2(20 BYTE) \n" +
            ", CREATED_DATE DATE \n" +
            ", CONSTRAINT SMJ_TBL_POLICY_PK111 PRIMARY KEY (POLICY_NUMBER)\n" +
            ", CONSTRAINT SMJ_TBL_POLICY_FK111 FOREIGN KEY (CLIENT_ID)\n" +
            "  REFERENCES SMJ_TBL_CLIENT (CLIENT_ID) \n" +
            ")";

    final public static String tblProperty = "CREATE TABLE SMJ_TBL_PROPERTY \n" +
            "(\n" +
            "  PROPERTY_ID NUMBER(8, 0) NOT NULL \n" +
            ", PROPERTY_OWNER_ID NUMBER(8, 0) NOT NULL \n" +
            ", COST NUMBER(8, 2) \n" +
            ", TYPE VARCHAR2(30 BYTE) \n" +
            ", DESCRIPTION VARCHAR2(99 BYTE) \n" +
            ", STREET_ADDRESS VARCHAR2(100 BYTE) \n" +
            ", CITY VARCHAR2(20 BYTE) \n" +
            ", STATE CHAR(2 BYTE) \n" +
            ", COUNTRY VARCHAR2(20 BYTE) \n" +
            ", POSTAL_CODE VARCHAR2(6 BYTE) \n" +
            ", CONSTRAINT SMJ_TBL_PROPERTY_PK PRIMARY KEY (PROPERTY_ID) \n" +
            ", CONSTRAINT SMJ_TBL_PROPERTY_FK1 FOREIGN KEY (PROPERTY_OWNER_ID)\n" +
            "  REFERENCES SMJ_TBL_CLIENT (CLIENT_ID) \n" +
            ")";

    final public static String tblCar = "CREATE TABLE SMJ_TBL_CAR \n" +
            "(\n" +
            "  CAR_ID NUMBER(8, 0) NOT NULL \n" +
            ", MAKE VARCHAR2(20) \n" +
            ", MODEL VARCHAR2(20) \n" +
            ", YEAR NUMBER(4) \n" +
            ", COLOR VARCHAR2(20) \n" +
            ", PLATE_NUMBER VARCHAR2(8) \n" +
            ", VIN VARCHAR2(20) \n" +
            ", DRIVERS_LICENSE_NUMBER VARCHAR2(8) \n" +
            ", CAR_OWNER_ID NUMBER(8, 0) NOT NULL \n" +
            ", CONSTRAINT SMJ_TBL_CAR_PK PRIMARY KEY (CAR_ID)\n" +
            ", CONSTRAINT SMJ_TBL_CAR_FK1 FOREIGN KEY (CAR_OWNER_ID)\n" +
            "  REFERENCES SMJ_TBL_CLIENT (CLIENT_ID) \n" +
            ")";

    final public static String tblQuote = "CREATE TABLE SMJ_TBL_QUOTE \n" +
            "(\n" +
            "  QUOTE_NUMBER NUMBER(8, 0) NOT NULL \n" +
            ", INSURED_ITEM_ID NUMBER(8, 0) \n" +
            ", CLIENT_ID NUMBER(8, 0) NOT NULL \n" +
            ", AMOUNT NUMBER(8, 2) \n"+
            ", DATE_ISSUED DATE \n"+
            ", VALID_UNTIL DATE \n"+
            ", QUOTE_TYPE VARCHAR2(25)\n" +
            ", CONSTRAINT SMJ_TBL_QUOTE_PK PRIMARY KEY (QUOTE_NUMBER)\n" +
            ", CONSTRAINT SMJ_TBL_QUOTE_FK1 FOREIGN KEY (CLIENT_ID)\n" +
            "  REFERENCES SMJ_TBL_CLIENT (CLIENT_ID)\n" +
            ")";

    final public static String tblPropertyPolicy = "CREATE TABLE SMJ_TBL_PROPERTY_POLICY \n" +
            "(\n" +
            "  POLICY_NUMBER NUMBER(8, 0) NOT NULL \n" +
            ", PROPERTY_ID NUMBER(8, 0) NOT NULL \n" +
            ", CONSTRAINT SMJ_TBL_PROPERTY_POLICY_PK PRIMARY KEY (POLICY_NUMBER, PROPERTY_ID)\n" +
            ", CONSTRAINT SMJ_TBL_PROPERTY_POLICY_FK1 FOREIGN KEY (POLICY_NUMBER)\n" +
            "  REFERENCES SMJ_TBL_POLICY (POLICY_NUMBER)\n" +
            ", CONSTRAINT SMJ_TBL_PROPERTY_POLICY_FK2 FOREIGN KEY (PROPERTY_ID)\n" +
            "  REFERENCES SMJ_TBL_PROPERTY (PROPERTY_ID) \n" +
            ")";

    final public static String tblAutoPolicy = "CREATE TABLE SMJ_TBL_AUTO_POLICY \n" +
            "(\n" +
            "  POLICY_NUMBER NUMBER(8, 0) NOT NULL \n" +
            ", CAR_ID NUMBER(8, 0) NOT NULL \n" +
            ", CONSTRAINT SMJ_TBL_AUTO_POLICY_PK PRIMARY KEY (POLICY_NUMBER, CAR_ID)\n" +
            ", CONSTRAINT SMJ_TBL_AUTO_POLICY_FK1 FOREIGN KEY (POLICY_NUMBER)\n" +
            "  REFERENCES SMJ_TBL_POLICY (POLICY_NUMBER)\n" +
            ", CONSTRAINT SMJ_TBL_AUTO_POLICY_FK2 FOREIGN KEY (CAR_ID)\n" +
            "  REFERENCES SMJ_TBL_CAR (CAR_ID) \n" +
            ")";

//-------------------------------------------------------------------


    public static String insValueClient = "INSERT ALL\n" +
            "  INTO SMJ_TBL_CLIENT VALUES" +
            " (1001, 'Simin', 'Bekhsat', '(709)666-5555)', 'siminbekhsat@info.com', TO_DATE('12-Dec-1995', 'DD-Mon-YYYY'))\n" +
            "  INTO SMJ_TBL_CLIENT VALUES" +
            " (1002, 'Josh', 'Taylor', '(709)111-2222)', 'joshtaylor@info.com', TO_DATE('16-May-1982', 'DD-Mon-YYYY'))\n" +
            "  INTO SMJ_TBL_CLIENT VALUES" +
            " (1003, 'Mark', 'Greene', '(709)777-4444)', 'markgreene@info.com', TO_DATE('02-Jan-1999', 'DD-Mon-YYYY'))\n" +
            "SELECT * FROM dual";

    public static String insValueProperty = "INSERT ALL\n" +
            "  INTO SMJ_TBL_PROPERTY VALUES" +
            " (1001, 1001, 240000, 'House', 'Very Old triple downtown house', '25 Water St.', 'St.John''s', 'NL', 'Canada', 'A1A2A2')\n" +
            "  INTO SMJ_TBL_Property VALUES" +
            " (1002, 1001, 325000, 'Apartment', 'Recently renovated', '125 White St.', 'St.John''s', 'NL', 'Canada', 'A1C2F6')\n" +
            "  INTO SMJ_TBL_PROPERTY VALUES" +
            " (1003, 1002, 560000, 'Big House', 'Luxury Cabin', '96 Waterford Bridge Rd.', 'St.John''s', 'NL', 'Canada', 'A4B6D5')\n" +
            "SELECT * FROM dual";

    public static String insValueCar = "INSERT ALL\n" +
            "  INTO SMJ_TBL_CAR VALUES" +
            " (1001, 'Honda', 'Civic', 2012, 'Red', 'HZZ 288', 'GF158YX26HM1264', 'B1001111', 1001)\n" +
            "  INTO SMJ_TBL_CAR VALUES" +
            " (1002, 'Toyota', 'Camry', 2016, 'Grey', 'JBE 344', 'RF159HQC19KL127', 'C1234567', 1003)\n" +
            "  INTO SMJ_TBL_CAR VALUES" +
            " (1003, 'Ford', 'Fusion', 2019, 'Green', 'JMD 118', 'NXR458YJA2K36PQ', 'N9876542', 1003)\n" +
            "SELECT * FROM dual";

    public static String insValuePolicy = "INSERT ALL\n" +
            "  INTO SMJ_TBL_POLICY VALUES" +
            " (1111, 1001, TO_DATE('12-May-2021', 'DD-Mon-YYYY'), TO_DATE('28-May-2021', 'DD-Mon-YYYY')," +
            " 5200, 'Cash', TO_DATE('02-May-2021', 'DD-Mon-YYYY'))\n" +
            "  INTO SMJ_TBL_POLICY VALUES" +
            " (1112, 1003, TO_DATE('16-Jun-2021', 'DD-Mon-YYYY'), TO_DATE('24-Jul-2021', 'DD-Mon-YYYY')," +
            " 2700, 'Cheque', TO_DATE('28-May-2021', 'DD-Mon-YYYY'))\n" +
            "  INTO SMJ_TBL_POLICY VALUES" +
            " (1113, 1002, TO_DATE('09-Dec-2020', 'DD-Mon-YYYY'), TO_DATE('05-Dec-2021', 'DD-Mon-YYYY')," +
            " 2900, 'Cash', TO_DATE('01-Dec-2020', 'DD-Mon-YYYY'))\n" +
            "SELECT * FROM dual";

    public static String insValueQuote = "INSERT ALL\n" +
            "  INTO SMJ_TBL_QUOTE VALUES" +
            " (4011, 7777, 1001, 3700, TO_DATE('01-Feb-2021', 'DD-Mon-YYYY')," +
            " TO_DATE('28-Feb-2021', 'DD-Mon-YYYY'), 'Regular')\n" +
            "  INTO SMJ_TBL_QUOTE VALUES" +
            " (4012, 6666, 1003, 338000, TO_DATE('11-Feb-2021', 'DD-Mon-YYYY')," +
            " TO_DATE('28-Feb-2021', 'DD-Mon-YYYY'), 'Discount included')\n" +
            "  INTO SMJ_TBL_QUOTE VALUES" +
            " (4013, 8888, 1003, 425000, TO_DATE('19-May-2021', 'DD-Mon-YYYY')," +
            " TO_DATE('25-May-2021', 'DD-Mon-YYYY'), 'Regular')\n" +
            "SELECT * FROM dual";

    public static String insValueAutoPolicy = "INSERT ALL\n" +
            "  INTO SMJ_TBL_AUTO_POLICY VALUES (1112, 1001)" +
            "  INTO SMJ_TBL_AUTO_POLICY VALUES (1111, 1002)" +
            "  INTO SMJ_TBL_AUTO_POLICY VALUES (1113, 1003)" +

            " SELECT * FROM dual";

    public static String insValuePropertyPolicy = "INSERT ALL\n" +
            "  INTO SMJ_TBL_PROPERTY_POLICY VALUES (1112, 1003)" +
            "  INTO SMJ_TBL_PROPERTY_POLICY VALUES (1111, 1002)" +
            "  INTO SMJ_TBL_PROPERTY_POLICY VALUES (1111, 1003)" +

            " SELECT * FROM dual";



}
