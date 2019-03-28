import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class AssignmentFour {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        String input;
        int intInput;

        Item[] itemArray = new Item[7];
        ShoppingList cart = new ShoppingList();
        User user = new User();

// request + set the user's budget
        System.out.println("Please input your budget");
        user.setBankAccount(59.00);

// create the items + set prices
        for (int i = 0; i < itemArray.length; i++) {

            itemArray[i] = new Item();
            int itemNum = (i + 1);
            itemArray[0].setItemNumber(itemNum);
            itemArray[i].setItemPrice(5.25 + (i * 4)); // set prices for each item
        }

// input item names
        for (int i = 0; i < itemArray.length; i++) {

            boolean isNew = true;
            do{
                System.out.println("Input an item name "+(i+1)+" of "+itemArray.length+ "...\n");
                input = keyboard.next();

                if (!Item.itemInList(itemArray,input)){
                    System.out.println("That's already on the list.\nOnly one entry per item.\nTry again.\n");
                }
                else {
                    itemArray[i].setItemName(input);
                    isNew = true;
                    break;
                }
            } while(isNew);
        }

// print items input
        System.out.println("Here's the list of items you input... \n");

        for (int i = 0; i < itemArray.length; i++) {
            System.out.println((i + 1) + ": " + itemArray[i].getName());
        }

// user input for item priorities
        for (int i = 0; i < itemArray.length; i++) {

            boolean isNew = true;
            do { // user input for purchase priorities + rejections of dupes / too high or low
                System.out.println("\nInput an purchase priority for: " + itemArray[i].getName() +
                        "\nThis number should be between 1 and " + itemArray.length);

                intInput = keyboard.nextInt();

                if (!Item.priorityInList(itemArray,intInput)){
                    System.out.println("That's already on the list.\nOnly one entry per item.\nTry again.\n");
                }
                else if (intInput > itemArray.length){
                    System.out.println("That's too high!\nNumbers 1 to " + itemArray.length
                            + " only.\nTry again.\n");
                }
                else if (intInput <= 0){
                    System.out.println("That's too low!\nNumbers 1 to " + itemArray.length
                            + " only.\nTry again.\n");
                }
                else {
                    itemArray[i].setItemPriority(intInput);
                    isNew = true;
                    break;
                }
            } while(isNew);
        }

// assign the input to a shopping list
        cart.setShoppingList(itemArray);

// going shopping
        String fileName = "out.txt"; // set the name of the output file

        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("Error opening the file " +
                    fileName);
            System.exit(0);
        }

        user.goShopping(cart); // go shopping

        for (int i = 0; i < cart.getShoppingList().length; i++) {
            outputStream.println(
                    "Price: " + cart.getShoppingList()[i].getItemPrice() + "\n" +
                            "Priority: " + cart.getShoppingList()[i].getItemPriority() + "\n" +
                            "Item Number: " + cart.getShoppingList()[i].getItemNumber() + "\n" +
                            "Item Name: " + cart.getShoppingList()[i].getItemName() + "\n" +
                            "Purchased: " + cart.getShoppingList()[i].getPurchased()
            );
        }
        outputStream.close();


// show purchases
        System.out.println("\nYou purchased....\n");
        cart.getPurchasedItems(cart);

// show not purchased
        System.out.println("\nYou didn't have enough money to purchase...\n");
        cart.getNotPurchasedItems(cart);

    }
}

