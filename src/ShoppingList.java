import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Arrays;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class ShoppingList {

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

    public Item[] setShoppingList(ArrayList<Item> itemArray) { // this sets the shopping list based on the item priorities input by user

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
        shoppingList = sortedItems;
        return sortedItems;

    }

    public Item[] getShoppingList() {
        return shoppingList;
    }

    public void getPurchasedItems(ShoppingList list) { // used for presentation of purchased items at end of main
        for (int i = 0; i < list.getShoppingList().length; i++) {

            if (list.getShoppingList()[i].getPurchased()) {
                System.out.println("Item: " + list.getShoppingList()[i].getItemName()
                        + " | Price: $" + list.getShoppingList()[i].getItemPrice());
            }
        }
    }

    public void getNotPurchasedItems(ShoppingList list) { // used for presentation of not purchased items at end of main
        for (int i = 0; i < list.getShoppingList().length; i++) {

            if (!list.getShoppingList()[i].getPurchased()) {
                System.out.println("Item: " + list.getShoppingList()[i].getItemName()
                        + " | Price: $" + list.getShoppingList()[i].getItemPrice());
            }
        }
    }

    public void writeItems(ShoppingList list, boolean purchased, boolean ignorePurchased) { //

        String fileName = null;

        if (ignorePurchased) {
            fileName = "shoppingList.txt"; // set the name of the output file
        } else if (!ignorePurchased) {
            if (purchased) {
                fileName = "purchased.txt"; // set the name of the output file
            } else if (!purchased) {
                fileName = "notPurchased.txt"; // set the name of the output file
            }
        }
        PrintWriter outputStream = null;

        try {
            outputStream = new PrintWriter(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("Error opening the file " +
                    fileName);
            System.exit(0);
        }

        if (ignorePurchased) {
            for (int i = 0; i < list.getShoppingList().length; i++) {
                outputStream.println("Item: " + list.getShoppingList()[i].getItemName()
                        + " | Price: $" + list.getShoppingList()[i].getItemPrice());
            }
            outputStream.close();
        } else if (!ignorePurchased) {
            for (int i = 0; i < list.getShoppingList().length; i++)
                if (purchased == (list.getShoppingList()[i].getPurchased())) {
                    outputStream.println("Item: " + list.getShoppingList()[i].getItemName()
                            + " | Price: $" + list.getShoppingList()[i].getItemPrice());
                }
            outputStream.close();


        }
    }

    public void readItems(ShoppingList list, boolean purchased, boolean ignorePurchased) { //

        String fileName = null;
        Scanner inputStream = null;

        if (ignorePurchased) {
            fileName = "shoppingList.txt"; // set the name of the output file
        } else if (!ignorePurchased) {
            if (purchased) {
                fileName = "purchased.txt"; // set the name of the output file
            } else if (!purchased) {
                fileName = "notPurchased.txt"; // set the name of the output file
            }
        }


        try {
            inputStream = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("Error opening the file " +
                    fileName);
            System.exit(0);
        }
        while (inputStream.hasNextLine()) {
            String line = inputStream.nextLine();
            System.out.println(line);
        }
    }
}




