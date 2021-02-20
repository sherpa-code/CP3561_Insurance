//package Objects;
//
//import DB_Classes.Application;
//
//import java.util.Date;
//
//public class TestApplication {
//    public static void main(String[] args) throws Exception {
//        Date date1 = new Date();
//        Client clientObject = new Client("Mohammad", "Fakhari Rad", "(709) 6916121");
//
//        Car myCar = new Car(clientObject, "2012FDS87YTX");
//        //Car myCar = new Car(new Client("Mohammad", "Fakhari Rad", "(709) 6916121"), "2012FDS87YTX");
//        QuoteCar newQuote = new QuoteCar(2500.49, date1, date1, date1, myCar);
//        AutoPolicy policy1 = new AutoPolicy(newQuote);
//
//        System.out.println(clientObject.getClient_ID());
//        System.out.println(policy1.getQuoteCar().getQuotedCar().getClient().getFirstName());
//        System.out.println(policy1.getQuoteCar().getQuotedCar().getCar_ID());
//        Application.getQuery("select  * from tblclient");
//
//        String clientId = String.valueOf(clientObject.getClient_ID());
//        String clientsFirstName = clientObject.getFirstName();
//        String clientsLastName = clientObject.getLastName();
//        String clientsPhoneNumber = clientObject.getPhoneNumber();
//        String newInsStatement = "INSERT INTO TBLCLIENT VALUES ("
//                + clientId + ", '"+ clientsFirstName + "', '"
//                + clientsLastName + "', '" + clientsPhoneNumber + "')";
//        Application.post(newInsStatement);
//        Application.getQuery("select  * from tblclient");
//
//
//
//    }
//}
