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
        user.printString("Please input your budget" + "\n");
        user.setBankAccount(keyboard.nextDouble());
        user.printString("You have $");
        user.printDouble(user.getBankAccount());
        user.printString(" in your bank account \n");

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
        user.goShopping(cart); // go shopping

// show shopping list
        user.printString("Here is the shopping list before shopping....\n");
        cart.writeItems(cart, true, true);
        cart.readItems(cart, true, true);

// show purchases
        System.out.println("\nYou purchased....\n");
        // cart.getPurchasedItems(cart);
        cart.writeItems(cart, true, false);
        cart.readItems(cart, true, false);


// show not purchased
        System.out.println("\nHere's the shopping list after shopping \na.k.a you didn't have enough money to purchase...\n");
        //  cart.getNotPurchasedItems(cart);
        cart.writeItems(cart, false, false);
        cart.readItems(cart, false, false);

// show remainder of bank account
        user.printString("\nHere is your remaining bank balance: $");
        System.out.format("%.2f%n", user.getBankAccount());
    }


}

