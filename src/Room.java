public class Room {
    private String roomType;
    private int totalRoom;
    private int cost;

    public Room(){}
    Room(String type, int cost, int totalRoom){
        this.roomType = type;
        this.cost = cost;
        this.totalRoom = totalRoom;
    }

    public int getTotalRoom(){
        return totalRoom;
    }

    public String getRoomType(){
        return roomType;
    }

    public int getCost(){
        return cost;
    }

    public String toString(){
        return "There are " + getTotalRoom() + " rooms class " + getRoomType() + " left, cost for 1 night is: $" + getCost();
    }

    public void isRent(){
        this.totalRoom --;
    }

    public void isPaid(){
        this.totalRoom ++;
    }

    public boolean isAvailable(){
        boolean isAvailable = false;
        if (this.totalRoom > 0){
            isAvailable = true;
        }
        return isAvailable;
    }


}
