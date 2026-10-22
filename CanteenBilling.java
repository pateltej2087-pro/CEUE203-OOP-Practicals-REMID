import java.util.Scanner;
class Item{
    private final String name;
    private final int price;

    Item(String name,int price){
        this.name=name;
        this.price=price;
    }
    String getName(){
        return name;
    }
    int getPrice(){
        return price;
    }
    static Item findItem(char code){
        return switch(Character.toUpperCase(code)){
            case 'T' -> new Item("Tea",10);
            case 'C' -> new Item("Coffee",15);
            case 'S' -> new Item("Samosa",12);
            case 'P' -> new Item("Puff",20);
            default -> null;
        };
    }
}
class Order{
    private int tokenNo;
    private Item item;
    private int quantity;
    static int nextToken=101;
    static int totalOrders=0;
    static int totalSales=0;
    Order(Item item,int quantity){
        this.item=item;
        this.quantity=quantity;
        this.tokenNo=nextToken++;
        totalOrders++;
        totalSales+=getAmount();
    }
    int getAmount(){
        return item.getPrice()*quantity;
    }
    static int getTotalOrders(){
        return totalOrders;
    }
    static int getTotalSales(){
        return totalSales;
    }
    public String toString(){
        return "Token " + tokenNo + ": " + item.getName()+ " x " + quantity + " = " + getAmount();
    }
}

public class CanteenBilling{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("=======================");
        System.out.println("   WELCOME TO CANTEEN  ");
        System.out.println("=======================");
        System.out.println("[T] Tea    - Rs. 10");
        System.out.println("[C] Coffee - Rs. 15");
        System.out.println("[S] Samosa - Rs. 12");
        System.out.println("[P] Puff   - Rs. 20");
        System.out.println("=======================");
        System.out.print("Enter number of orders: ");
        int n=sc.nextInt();
        for (int i=0;i<n;i++) {
            System.out.println("--- Order "+(i+1)+ " ---");
            System.out.print("Enter item code (T/C/S/P): ");
            char code=sc.next().charAt(0);
            System.out.print("Enter quantity: ");
            int quantity=sc.nextInt();
            Item item=Item.findItem(code);
            if(item==null || quantity<=0){
                System.out.println("Invalid order: " + code + " " + quantity);
            } 
            else{
                Order order = new Order(item,quantity);
                System.out.println(order);
            }
        }
        System.out.println("=======================");
        System.out.println("Total orders: " + Order.getTotalOrders()+ ", Total sales: Rs. " + Order.getTotalSales());
        System.out.println("=======================");
        sc.close();
    }
}