package DB_Classes;

public class SQL_Methods {

    final public static String SMJ_Client =
            " CREATE TABLE SMJ_Client\n(\n" +
            "     client_id       NUMBER(8) NOT NULL,\n" +
            "     first_name      VARCHAR2(25),\n" +
            "     last_name       VARCHAR2(25),\n" +
            "     phone_number    VARCHAR2(20),\n\n" +
            " CONSTRAINT SMJ_Client_pk PRIMARY KEY (client_id)\n" +
        ")";


    final public static String SMJ_Car =
            " CREATE TABLE SMJ_Car\n(\n" +
            "     car_id      NUMBER(8) NOT NULL,\n" +
            "     client_id   NUMBER(8),\n" +
            "     make        VARCHAR2(25),\n" +
            "     model       VARCHAR2(25),\n" +
            "     year        NUMBER(4),\n" +
            "     color       VARCHAR2(15),\n\n" +
            " CONSTRAINT SMJ_Car_pk PRIMARY KEY (car_id),\n" +
            " CONSTRAINT SMJ_Car_fk1 FOREIGN KEY (client_id) REFERENCES SMJ_Client (client_id)\n" +
        ")";


    final public static String SMJ_QuoteCar =
            " CREATE TABLE SMJ_QuoteCar\n(\n" +
            "     quote_number    NUMBER(8) NOT NULL,\n" +
            "     car_id          NUMBER(8),\n" +
            "     amount          NUMBER(8, 2),\n" +
            "     date_issued     DATE,\n" +
            "     valid_until     DATE,\n\n" +
            " CONSTRAINT SMJ_QuoteCar_pk PRIMARY KEY (quote_number),\n" +
            " CONSTRAINT SMJ_QuoteCar_fk1 FOREIGN KEY (car_id) REFERENCES SMJ_Car (car_id)\n" +
        ")";

    final public static String SMJ_AutoPolicy =
            " CREATE TABLE SMJ_AutoPolicy\n(\n" +
            "     policy_number   NUMBER(8) NOT NULL,\n" +
            "     quote_number    NUMBER(8),\n" +
            "     premium         NUMBER(8, 2),\n" +
            "     effective_date  DATE,\n" +
            "     expire_date     DATE,\n" +
            "     created_date    DATE,\n\n" +
            " CONSTRAINT SMJ_AutoPolicy_pk PRIMARY KEY (policy_number),\n" +
            " CONSTRAINT SMJ_AutoPolicy_fk1 FOREIGN KEY (quote_number) REFERENCES SMJ_QuoteCar (quote_number)\n" +
        ")";

    final public static String SMJ_Property =
            " CREATE TABLE SMJ_Property\n(\n" +
            "     property_id     NUMBER(8) NOT NULL,\n" +
            "     client_id       NUMBER(8),\n" +
            "     type            VARCHAR2(25),\n" +
            "     street_number   VARCHAR2(99),\n" +
            "     city            VARCHAR2(25),\n" +
            "     state           CHAR(2),\n" +
            "     country         VARCHAR2(25),\n" +
            "     postal_code     VARCHAR2(8),\n\n" +
            " CONSTRAINT SMJ_Property_pk PRIMARY KEY (property_id),\n" +
            " CONSTRAINT SMJ_Property_fk1 FOREIGN KEY (client_id) REFERENCES SMJ_Client (client_id)\n" +
        ")";

    final public static String SMJ_QuoteProperty =
            " CREATE TABLE SMJ_QuoteProperty\n(\n\n" +
            "     quote_number    NUMBER(8) NOT NULL,\n" +
            "     property_id     NUMBER(8),\n" +
            "     amount          NUMBER(8, 2),\n" +
            "     date_issued     DATE,\n" +
            "     quote_type      VARCHAR2(40),\n" +
            "     valid_until     DATE,\n\n" +
            " CONSTRAINT SMJ_QuoteProperty_pk PRIMARY KEY (quote_number),\n" +
            " CONSTRAINT SMJ_QuoteProperty_fk1 FOREIGN KEY (property_id) REFERENCES SMJ_Property (property_id)\n" +
        ")";

    final public static String SMJ_PropertyPolicy =
            " CREATE TABLE SMJ_PropertyPolicy\n(\n" +
            "     policy_number   NUMBER(8) NOT NULL,\n" +
            "     quote_number    NUMBER(8),\n" +
            "     premium         NUMBER(8, 2),\n" +
            "     effective_date  DATE,\n" +
            "     expire_date     DATE,\n" +
            "     created_date    DATE,\n\n" +
            " CONSTRAINT SMJ_PropertyPolicy_pk PRIMARY KEY (policy_number),\n" +
            " CONSTRAINT SMJ_PropertyPolicy_fk1 FOREIGN KEY (quote_number) REFERENCES SMJ_QuoteProperty (quote_number)\n" +
        ")";

    final public static String insValClient =
            " INSERT ALL\n" +
            "     INTO SMJ_Client VALUES (10001, 'Mohammad' , 'Fakhari Rad', '(709)666-6666 ')\n" +
            "     INTO SMJ_Client VALUES (10002, 'Alex' , 'Power', '(709)111-2222 ')\n" +
            "     INTO SMJ_Client VALUES (10003, 'Josh' , 'Taylor', '(709)555-0044 ')\n" +
            "     INTO SMJ_Client VALUES (10004, 'Mark' , 'White', '(709)677-3355 ')\n\n" +
            " SELECT * FROM dual";

    final public static String insValCar =
            " INSERT ALL\n" +
            "     INTO SMJ_Car VALUES (33300, 10001 , 'Ford', 'F-150', 2018, 'Black')\n" +
            "     INTO SMJ_Car VALUES (33301, 10003 , 'BMW', 'X5', 2020, 'Grey')\n" +
            "     INTO SMJ_Car VALUES (33302, 10003 , 'Honda', 'Civic', 2021, 'Red')\n" +
            "     INTO SMJ_Car VALUES (33303, 10004 , 'Toyota', 'Camry', 2016, 'White')\n\n" +
            " SELECT * FROM dual";


    final public static String insValQuoteCar =
            " INSERT ALL\n" +
            "     INTO SMJ_quotecar VALUES (40011, 33300 , 4870.49, TO_DATE('24-July-2020', 'DD-MONTH-YYYY'), TO_DATE('24-August-2020', 'DD-MONTH-YYYY') )\n" +
            "     INTO SMJ_quotecar VALUES (40012, 33303 , 2550.99, TO_DATE('02-April-2020', 'DD-MONTH-YYYY'), TO_DATE('02-May-2020', 'DD-MONTH-YYYY') )\n" +
            "     INTO SMJ_quotecar VALUES (40013, 33303 , 2600.00, TO_DATE('18-September-2020', 'DD-MONTH-YYYY'), TO_DATE('30-September-2020', 'DD-MONTH-YYYY') )\n" +
            "     INTO SMJ_quotecar VALUES (40014, 33301 , 6200.49, TO_DATE('01-July-2019', 'DD-MONTH-YYYY'), TO_DATE('25-July-2019', 'DD-MONTH-YYYY') )\n\n" +
            " SELECT * FROM dual";

    final public static String insValAutoPolicy =
            " INSERT ALL\n" +
            "     INTO SMJ_autopolicy VALUES (5001, 40011 , 5000,\n" +
            "         TO_DATE('01-July-2020', 'DD-MONTH-YYYY'),\n" +
            "         TO_DATE('01-August-2021', 'DD-MONTH-YYYY'),\n" +
            "         TO_DATE('01-July-2020', 'DD-MONTH-YYYY'))\n" +
            "     INTO SMJ_autopolicy VALUES (5002, 40013 , 3500.99,\n" +
            "         TO_DATE('01-December-2020', 'DD-MONTH-YYYY'),\n" +
            "         TO_DATE('01-February-2021', 'DD-MONTH-YYYY'),\n" +
            "         TO_DATE('01-January-2020', 'DD-MONTH-YYYY'))\n" +
            "     INTO SMJ_autopolicy VALUES (5003, 40012 , 2650.99,\n" +
            "         TO_DATE('01-December-2020', 'DD-MONTH-YYYY'),\n" +
            "         TO_DATE('01-February-2021', 'DD-MONTH-YYYY'),\n" +
            "         TO_DATE('01-January-2020', 'DD-MONTH-YYYY'))\n\n" +
            " SELECT * FROM dual";

    final public static String insValProperty =
            " INSERT ALL\n" +
            "     INTO SMJ_property VALUES (1111, 10002 , 'Flat', '111 Water St.', 'St. John''s', 'NL', 'Canada', 'A1E 4G6')\n" +
            "     INTO SMJ_property VALUES (1112, 10001 , 'House', '92 Empire Ave.', 'St. John''s', 'NL', 'Canada', 'A1C 2F9')\n" +
            "     INTO SMJ_property VALUES (1113, 10004 , 'Cabin', '61 White St.', 'CBS', 'NL', 'Canada', 'A1D C5T')\n" +
            "     INTO SMJ_property VALUES (1114, 10004 , 'Downtown flat', '209 Water St.', 'St. John''s', 'NL', 'Canada', 'A2B P7X')\n\n" +
            " SELECT * FROM dual";

    final public static String insValQuoteProperty =
            " INSERT ALL\n" +
            "     INTO SMJ_quoteproperty VALUES (90001, 1111 , 5000.00,\n" +
            "         TO_DATE('24-July-2020', 'DD-MONTH-YYYY'), 'Regular', TO_DATE('24-August-2020', 'DD-MONTH-YYYY'))\n" +
            "     INTO SMJ_quoteproperty VALUES (90002, 1112 , 4850.00,\n" +
            "         TO_DATE('01-July-2020', 'DD-MONTH-YYYY'), 'Regular', TO_DATE('02-August-2020', 'DD-MONTH-YYYY'))\n" +
            "     INTO SMJ_quoteproperty VALUES (90003, 1113 , 6200.00,\n" +
            "         TO_DATE('02-July-2020', 'DD-MONTH-YYYY'), 'Regular', TO_DATE('03-August-2020', 'DD-MONTH-YYYY'))\n" +
            "     INTO SMJ_quoteproperty VALUES (90004, 1113 , 5990.00,\n" +
            "         TO_DATE('03-July-2020', 'DD-MONTH-YYYY'), 'Regular', TO_DATE('04-August-2020', 'DD-MONTH-YYYY'))\n\n" +
            " SELECT * FROM dual";

    final public static String insValPropertyPolicy =
            " INSERT ALL\n" +
            "     INTO SMJ_propertypolicy VALUES (7100, 90001 , 5000,\n" +
            "         TO_DATE('01-July-2020', 'DD-MONTH-YYYY'),\n" +
            "         TO_DATE('01-August-2021', 'DD-MONTH-YYYY'),\n" +
            "         TO_DATE('01-July-2020', 'DD-MONTH-YYYY'))\n" +
            "     INTO SMJ_propertypolicy VALUES (7101, 90004 , 7000,\n" +
            "         TO_DATE('01-July-2020', 'DD-MONTH-YYYY'),\n" +
            "         TO_DATE('01-August-2021', 'DD-MONTH-YYYY'),\n" +
            "         TO_DATE('01-July-2020', 'DD-MONTH-YYYY'))\n" +
            "     INTO SMJ_propertypolicy VALUES (7102, 90002 , 4800,\n" +
            "         TO_DATE('01-July-2020', 'DD-MONTH-YYYY'),\n" +
            "         TO_DATE('01-August-2021', 'DD-MONTH-YYYY'),\n" +
            "         TO_DATE('01-July-2020', 'DD-MONTH-YYYY'))\n" +
            "     INTO SMJ_propertypolicy VALUES (7103, 90001 , 5550,\n" +
            "         TO_DATE('01-July-2020', 'DD-MONTH-YYYY'),\n" +
            "         TO_DATE('01-August-2021', 'DD-MONTH-YYYY'),\n" +
            "         TO_DATE('01-July-2020', 'DD-MONTH-YYYY'))\n\n" +
            " SELECT * FROM dual";
}