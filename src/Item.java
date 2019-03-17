import java.util.Objects;

public class Item extends StandardItem implements Information {
    private int  itemNumber;
    private String itemName;
    private int itemPriority;
    private double itemPrice;
    private boolean purchased = false;

    public Item(String itemName) { // inherited from standardItem
        super(itemName);
    }

    public Item (){
        this.itemNumber = -100;
        this.itemName = "no input";
        this.itemPriority = -1;
        this.itemPrice = -1;
        this.purchased = false;
    }

    public Item(int itemNumber, String itemName, int itemPriority){
        super(itemName);
        this.itemNumber = itemNumber;
        this.itemPriority = itemPriority;
    }

    public Item(int itemNumber, String itemName, int itemPriority, boolean purchased){
        super(itemName);
        this.itemNumber = itemNumber;
        this.itemName = itemName;
        this.itemPriority = itemPriority;
        this.purchased = purchased;
    }

    public boolean equals(Item itemInput){
        // self check
        if (this == itemInput){
            return true;}
        // check if it's null
        if (this == null){
            return false;}
        // make sure it's the same type of class
        if(getClass() != itemInput.getClass()){
            return false;}

        // compare the fields
        return Objects.equals(itemNumber, itemInput.itemNumber) &&
                Objects.equals(itemName, itemInput.itemName) &&
                Objects.equals(itemPriority, itemInput.itemPriority) &&
                Objects.equals(itemPrice, itemInput.itemPrice) &&
                Objects.equals(purchased, itemInput.purchased);
    }

    // Setters
    public void setItemNumber(int itemNumberInput) {
        itemNumber = itemNumberInput;
    }

    public void setItemName(String itemNameInput) {
        itemName = itemNameInput;
    }

    public void setItemPriority(int itemPriorityInput) {
        itemPriority = itemPriorityInput;
    }

    public void setItemPrice(double itemPriceInput) {
        itemPrice = itemPriceInput;
    }

    public void setPurchased(boolean itemWasPurchased){
        purchased = itemWasPurchased;
    }


    // Getters
    public int getItemNumber()
    {
        return itemNumber;
    }

    public String getItemName()
    {
        return itemName;
    }

    public String getName() {
        return itemName;
    }

    public int getItemPriority()
    {
        return itemPriority;
    }

    public Double getItemPrice()
    {
        return itemPrice;
    }

    public boolean getPurchased(){
        return purchased;
    }


    // put item names into a list of strings
    public static String[] itemNamesToString(Item[] list) {

        String[] newList = new String[list.length];

        for (int i = 0; i < list.length; i++) {
            newList[i] = list[i].getItemName();
        }
        return newList;
    }

    // put item priorities into a list of strings
    public static int[] itemPriorityToString(Item[] list) {

        int[] newList = new int[list.length];

        for (int i = 0; i < list.length; i++) {
            newList[i] = list[i].getItemPriority();
        }
        return newList;
    }

    // check if item name is already in a given list
    public static boolean itemInList(Item[] list, String item) {
        int matchCounter = 0;
        boolean isNew = true;
        for (int i = 0; i < list.length; i++){
            if (Item.itemNamesToString(list)[i].equals(item))
                matchCounter++;
        }
        if (matchCounter > 0){ isNew = false;
        }
        return isNew;
    }

    // checks the priority of an item in a given list
    public static boolean priorityInList(Item[] list, int item) {
        int matchCounter = 0;
        boolean isNew = true;
        for (int i = 0; i < list.length; i++){
            if (Item.itemPriorityToString(list)[i] == item)
                matchCounter++;
        }
        if (matchCounter > 0){ isNew = false;
        }
        return isNew;
    }




}
