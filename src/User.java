import java.util.Objects;

public class User {
    private String userId;
    private double budget;

    public User(){
        this.userId = "notAssigned";
        this.budget = 0;
    }

    public double getBudget(){
        return budget;
    }

    public String getUserId(){
        return userId;
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
                Objects.equals(budget, user.budget);
    }

    public void setUserId(String string){
        userId = string;
    }

    public void setBudget(double money){
        budget = money;
    }

    public void goShopping(ShoppingList list) {
        for (int i = 0; i < list.getShoppingList().length; i++) {

            if (list.getShoppingList()[i].getItemPrice() <= budget) {
                budget = (budget - list.getShoppingList()[i].getItemPrice());
                list.getShoppingList()[i].setPurchased(true);
            }

        }
    }




}




