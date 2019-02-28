import java.util.Objects;
import java.util.Arrays;

public class ShoppingList extends Item {

    private Item[] shoppingList = new Item[7];

    public boolean equals(ShoppingList shoppingListInput) {

        // self check
        if (this.getShoppingList() == shoppingListInput.getShoppingList()) {
            return true;
        }
        // check if it's null
        if (this.getShoppingList() == null) {
            return false;
        }
        // make sure it's the same type of class
        if (this.getShoppingList().getClass() != shoppingListInput.getShoppingList().getClass()) {
            return false;
        }
        // compare the fields
        boolean isEqual = true;
        int i = 0;
        int j = shoppingListInput.getShoppingList().length;
        do {
            isEqual = this.getShoppingList()[i].equals(shoppingListInput.getShoppingList()[i]);
            i++;
        }
        while (isEqual && i < j); // keep iterating while the items are equal until i has reached the end of the list
        return isEqual;
    }

    public Item[] setShoppingList(Item[] itemArray) {

        int[] priorities = new int[itemArray.length];
        Item[] sortedItems = new Item[itemArray.length];


        for (int i = 0; i < itemArray.length; i++) {
            // put item priorities into array of ints
            priorities[i] = itemArray[i].getItemPriority();
        }

        for (int i = 0; i < priorities.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < priorities.length; j++)
                if (priorities[j] < priorities[index])
                    index = j;

            int smallerNumber = priorities[index];
            priorities[index] = priorities[i];
            priorities[i] = smallerNumber;
        }

        for(int i = 0; i < itemArray.length; i++){

            for(int j = 0; j < itemArray.length; j++){
                if (priorities[j] == itemArray[i].getItemPriority()){
                    sortedItems[j] = itemArray[i];
                }

            }
        }
        shoppingList = sortedItems;
        return sortedItems;

    }

    public Item[] getShoppingList() {
        return shoppingList;
    }

    public void getPurchasedItems(ShoppingList list) {
        for (int i = 0; i < list.getShoppingList().length; i++) {

            if (list.getShoppingList()[i].getPurchased()) {
                System.out.println("Item: " + list.getShoppingList()[i].getItemName()
                        + " | Price: $" + list.getShoppingList()[i].getItemPrice());
            }
        }
    }

    public void getNotPurchasedItems(ShoppingList list) {
        for (int i = 0; i < list.getShoppingList().length; i++) {

            if (!list.getShoppingList()[i].getPurchased()) {
                System.out.println("Item: " + list.getShoppingList()[i].getItemName()
                        + " | Price: $" + list.getShoppingList()[i].getItemPrice());
            }
        }
    }

}




