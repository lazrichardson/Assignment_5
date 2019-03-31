import java.util.ArrayList;
import java.util.Objects;

public class User implements Information {
    private String userId;
    private double bankAccount;
    private String nameOfUser;

    public User(){
        this.userId = "notAssigned";
        this.bankAccount = 0;
        this.nameOfUser = "notAssigned";
    }

    public double getBankAccount() {
        return bankAccount;
    }

    public String getUserId(){
        return userId;
    }

    public String getNameOfUser() {
        return nameOfUser;
    }

    public String getName() {
        return nameOfUser;
    }

    public boolean equals(User user){

        // self check
        if (this == user){
            return true;}
        // check if it's null
        if (this == null){
            return false;}
        // make sure it's the same type of class
        if(getClass() != user.getClass()){
            return false;}

        // compare the fields
        return Objects.equals(userId, user.userId) &&
                Objects.equals(bankAccount, user.bankAccount);
    }

    public void setUserId(String string){
        userId = string;
    }

    public void setBankAccount(double money) {
        bankAccount = money;
    }

    public void setNameOfUser(String name) {
        nameOfUser = name;
    }

    public void goShopping(ArrayList<Item> list) { // used to purchase items
        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).getItemPrice() <= bankAccount) {
                Item item = list.get(i);
                bankAccount = (bankAccount - item.getItemPrice());
                item.setPurchased(true);
                item.setNumItemsPurchased(item.getNumItemsPurchased() + 1);
            }
        }
    }

    public void prioritizeShoppingList(ArrayList<Item> itemArray) { // this sets the shopping list based on the item priorities input by user

        int[] priorities = new int[itemArray.size()];  // stores priorities as int
        int[] sortedPriorities = new int[itemArray.size()]; // stores sorted priorities
        Item[] sortedItems = new Item[itemArray.size()];


        for (int i = 0; i < itemArray.size(); i++) {
            // put item priorities into array of ints
            priorities[i] = itemArray.get(i).getItemPriority();
        }

        sortedPriorities = Sorting.bubbleSort(priorities);

        for (int i = 0; i < itemArray.size(); i++) {

            for (int j = 0; j < itemArray.size(); j++) {
                if (sortedPriorities[j] == itemArray.get(i).getItemPriority()) {
                    sortedItems[j] = itemArray.get(i);
                }

            }
        }

        // copy to an array list
        for (int i = 0; i < itemArray.size(); i++) {
            itemArray.set(i, sortedItems[i]);
        }

    }

    public void printString(String s) {
        System.out.print(s);

    }

    public void printDouble(Double d) {
        System.out.print(d);

    }


}




