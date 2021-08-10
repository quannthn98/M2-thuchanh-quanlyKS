import java.util.Scanner;

public class HotelManeger {
    public static Scanner sc = new Scanner(System.in);

    private Customer[] customerList = new Customer[0];

    private int revenue = 0;
    private Room roomClassA;
    private Room roomClassB;

    public HotelManeger(){
        createRoomType();
    }

    public void createRoomType(){
        roomClassA = new Room("A", 500, 0);
        roomClassB = new Room("B", 250, 1);
    }

    public void checkIn(){

        checkRoom();
        System.out.println("Please choose type of Room you want to ");
        int roomType = sc.nextInt();

        System.out.println("please input your name");
        String cusTomerName = sc.next();

        System.out.println("please input your date of Birth (dd/mm/yyyy)");
        String dOfB = sc.next();

        System.out.println("please input your NationalID");
        String nationalId =sc.next();

        System.out.println("How many day you want to stay?");
        int dayRent = sc.nextInt();

        customerList = recordNewCustomer(cusTomerName, dOfB, nationalId, roomType, dayRent);

        System.out.println("------------------------------------");
        System.out.println("You have checked in successfully, please enjoy our services");
    }

    public void checkOut(){
        System.out.println("------------------------------------");
        System.out.println("Please provide your National Id number");
        String nationalId = sc.next();
        int customerIndex = getCustomerIndex(nationalId);
        if (customerIndex != -1){

            customerList[customerIndex].getRentRoom().isPaid();//Trả về phòng đã thuê
            receivePayment(customerList[customerIndex].getPendingPayment());//Tăng doanh thu
            customerList[customerIndex].checkOut();//Khách hàng thanh toán
            customerList = removeCustomer(customerIndex);//Xóa khách hàng khỏi danh sách

            System.out.println("------------------------------------");
            System.out.println("Thank you for trusting our services, hope we will see you again. Goodbye!");
        } else {
            System.out.println("------------------------------------");
            System.out.println("We can not find this national ID in our system. Please check again");
        }
    }

    public Customer[] recordNewCustomer(String name, String dOfB, String nationalId, int roomType, int dayRent){
        Customer[] temp = new Customer[customerList.length + 1];
        System.arraycopy(customerList, 0, temp, 0, customerList.length);

        Room pickedRoom = new Room();

        switch (roomType){
            case 1:
                pickedRoom = roomClassA;
                break;
            case 2:
                pickedRoom = roomClassB;
                break;
        }
        pickedRoom.isRent();

        temp[temp.length - 1] = new Customer(name, dOfB, nationalId, dayRent, pickedRoom);
        return temp;
    }

    public Customer[] removeCustomer(int index){
        Customer[] temp = new Customer[customerList.length - 1];
        for (int i = 0; i < customerList.length-1; i++) {
            if (i < index){
                temp[i] = customerList[i];
            } else {
                temp[i] = customerList[i+1];
            }
        }
        return temp;
    }

    public int getCustomerIndex(String nationalId){
        int index = -1;
        for (int i = 0; i < customerList.length; i++) {
            if (customerList[i].getNationalID().equals(nationalId)){
                index = i;
                break;
            }
        }
        return index;
    }

    public int getRevenue(){
        return revenue;
    }

    public void getCustomers(){
        System.out.println("------------------------------------");
        System.out.println("Here are customers list");
        for (int i = 0; i < customerList.length; i++) {
            System.out.println((i + 1) + ". " + customerList[i].toString());
        }
        System.out.println("------------------------------------");
    }

    public void getRoomInformation(){
        System.out.println("------------------------------------");
        System.out.println("We have 2 type of Room: A class and B class");
        System.out.println(roomClassA.toString());
        System.out.println(roomClassB.toString());
        System.out.println("------------------------------------");
    }

    public void receivePayment(int payment){
        this.revenue += payment;
    }

    public void checkRoom(){
        boolean isAvailable = false;
//        switch (type){
//            case 1:
//                if (roomClassA.isAvailable()){
//                    isAvailable = true;
//                } else {
//                    System.out.println("Room type A is over please choose room type B, sorry for this sir/madam!");
//                }
//                break;
//            case 2:
//                if (roomClassB.isAvailable()){
//                    isAvailable = true;
//                } else {
//                    System.out.println("Room type B is over, please choose room type B, sorry for this sir/madam!");
//                }
//                break;
//        }
        if (roomClassA.isAvailable() && roomClassB.isAvailable()){
            getRoomInformation();
        } else if (roomClassA.isAvailable() && !roomClassB.isAvailable()){
            System.out.println(roomClassA.toString());
            System.out.println("Room class B is out of order, please pick room A");
        } else if (!roomClassA.isAvailable() && roomClassB.isAvailable()){
            System.out.println("Room class A is out of order, please pick room B");
            System.out.println(roomClassB.toString());
        } else {
            System.out.println("All room are out of order, we are sorry for that, hope you will comeback next time!");
            main.toCustomerMenu();
        }

    }
}
