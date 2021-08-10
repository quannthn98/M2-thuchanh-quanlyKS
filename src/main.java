import java.util.Scanner;

public class main {

        public static Scanner sc = new Scanner(System.in);
        public static HotelManeger manager;

    public static void main(String[] args) {
        boolean flag = true;
         manager = new HotelManeger();
        while (flag) {
            showMainMenu();
        }
    }

    public static void showMainMenu(){
        System.out.println("------------------------------------");
        System.out.println("Welcome to Hotel Transilvania");
        System.out.println("------------------------------------");
        System.out.println("Are you a Customer or an Manager?");
        System.out.println("1. Customer");
        System.out.println("2. Manager");
        System.out.println("0. Exit");
        System.out.println("------------------------------------");

        int options = sc.nextInt();
        switch (options){
            case 1:
                toCustomerMenu();
                break;
            case 2:
                toManagerMenu();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("please input valid menu");
                showMainMenu();
                break;
        }
    }

    public static void toCustomerMenu(){
        System.out.println("------------------------------------");
        System.out.println("Welcome to Hotel Transilvania");
        System.out.println("What do you want to do?");
        System.out.println("------------------------------------");
        System.out.println("1. Get room information");
        System.out.println("2. Check in");
        System.out.println("3. Check out");
        System.out.println("0. Back to Main menu");
        System.out.println("------------------------------------");

        int options = sc.nextInt();
        processCustomerChoice(options);
    }

    public static void processCustomerChoice(int options){
        switch (options){
            case 1:
                manager.getRoomInformation();
                toCustomerMenu();
                break;
            case 2:
                manager.checkIn();
                toCustomerMenu();
                break;
            case 3:
                manager.checkOut();
                toCustomerMenu();
                break;
            case 0:
                showMainMenu();
                break;
            default:
                System.out.println("please input valid options");
                toCustomerMenu();
                break;
        }
    }

    public static void toManagerMenu(){
        System.out.println("------------------------------------");
        System.out.println("Hi Manager, What do you want to do?");
        System.out.println("------------------------------------");
        System.out.println("1. Get customers list");
        System.out.println("2. Get room information");
        System.out.println("3. Check revenue");
        System.out.println("0. back to Main menu");
        System.out.println("------------------------------------");
        int option = sc.nextInt();
        processManagerOption(option);
    }

    public static void processManagerOption(int option){
        switch (option){
            case 1:
                manager.getCustomers();
                toManagerMenu();
                break;
            case 2:
                manager.getRoomInformation();
                toManagerMenu();
                break;
            case 3:
                System.out.println("------------------------------------");
                System.out.println("Total revenue is: $" + manager.getRevenue());
                toManagerMenu();
                break;
            case 0:
                showMainMenu();
                break;
            default:
                System.out.println("------------------------------------");
                System.out.println("Please input valid options");
                toManagerMenu();
                break;
        }
    }
}
