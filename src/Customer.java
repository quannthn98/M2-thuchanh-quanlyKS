public class Customer {
    final private String name, dateOfBirth, nationalID;
    final private Room rentRoom;
    private int pendingPayment;
    final private int dayRent;
    public static void main(String[] args) {
    }

    public Customer(String name, String dateOfBirth, String nationalID,int dayRent, Room roomType){
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.nationalID = nationalID;
        this.dayRent = dayRent;
        this.rentRoom = roomType;
        this.pendingPayment = roomType.getCost()*dayRent;
    }

    public Room getRentRoom(){
        return this.rentRoom;
    }

    public String getName(){
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public int getDayRent(){
        return this.dayRent;
    }

    public String getNationalID(){
        return nationalID;
    }

    public void checkOut(){
        this.pendingPayment = 0;
    }

    public int getPendingPayment(){
        return this.pendingPayment;
    }

    public String toString(){
        return "Customer name: " + getName() +
                ", Date of Birth: " + getDateOfBirth() +
                ", NationalID: " + getNationalID() +
                ", pending Payment: " + getPendingPayment() +
                "$, is renting room class " + getRentRoom().getRoomType() +
                " for " + getDayRent() + " day(s)";
    }


}
