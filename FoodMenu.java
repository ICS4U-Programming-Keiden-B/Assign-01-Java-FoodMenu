
import java.util.Scanner;

/**
* Assignment #1; a food menu.
*
* @author  Keiden B
* @version 1.0
* @since   2023-03-02
**/

public final class FoodMenu {
    /**
    * Scanner object. Accessible to all functions!
    **/
    private static Scanner receive = new Scanner(System.in);

    /**
    * Necessary to prevent HideUtilityClass Error.
    *
    * @exception IllegalStateException Utility class
    * @see IllegalStateException
    */
    private FoodMenu() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * Get what type of food the user wants.
    *
    * @return The type of food chosen.
    **/
    public static String getOrder() {
        // Declaring variable for what food the user orders.
        String foodType = "";

        do {
            System.out.println("What would you like to order?\n"
                    + "(Platter, Wrap, Burger, or Poutine)");
            foodType = receive.nextLine().toUpperCase();
        // Only stops repeating when the user types a valid order.
        } while (!("PLATTER".equals(foodType) || "WRAP".equals(foodType)
            || "BURGER".equals(foodType) || "POUTINE".equals(foodType)));

        // Returns what the customer orders.
        return foodType;
    }

    /**
    * Does the user want meat on their platter/wrap.
    *
    * @param pricingMeat Cost to add for meat.
    * @return Total cost of meat.
    **/
    public static double haveMeat(final double pricingMeat) {
        // Declaring variables for the price of meat and if the user wants it.
        String wantMeat = "";
        double meatPricing = pricingMeat;

        do {
            System.out.println("Would you like meat, or only vegetarian?\n"
                    + "(Y or N)");
            wantMeat = receive.nextLine().toUpperCase();
        // Repeats until the user answers if they want meat or not.
        } while (!("Y".equals(wantMeat) || "N".equals(wantMeat)));

        // If the user doesn't want meat, no cost is added to the order.
        if ("N".equals(wantMeat)) {
            meatPricing = 0;
        }
        // Returns either the cost of meat or $0, depending on the user
        return meatPricing;
    }

    /**
    * Does the user want a large-size item.
    *
    * @param pricingLarge cost to add for large size.
    * @return The extra cost for a large item.
    **/
    public static double haveLarge(final double pricingLarge) {
        // Declaring variables for the price of a
        // large size and if the user wants it.
        String wantLarge = "";
        double largePricing = pricingLarge;

        do {
            System.out.println("Would you like a large size?\n"
                + "(Y or N)");
            wantLarge = receive.nextLine().toUpperCase();
        // Repeats until the user answers if they want large or not.
        } while (!("Y".equals(wantLarge) || "N".equals(wantLarge)));

        // If the user doesn't want a large, no cost is added to the order.
        if ("N".equals(wantLarge)) {
            largePricing = 0;
        }
        // Returns either the cost of a large or $0
        return largePricing;

    }

    /**
    * Does the user want pita bread with their platter.
    *
    * @param pricingPita Cost to add for pitas.
    * @return The cost of pitas.
    **/
    public static double havePita(final double pricingPita) {
        // Declaring variables for the price of pita bread
        // and if the user wants it.
        String wantPita = "";
        double pitaPricing = pricingPita;

        do {
            System.out.println("Would you like some pita bread on the side?\n"
                    + "(Y or N)");
            wantPita = receive.nextLine().toUpperCase();
        // Repeats until the user answers if they want pita or not.
        } while (!("Y".equals(wantPita) || "N".equals(wantPita)));

        // If the user doesn't want pita, no cost is added to the order.
        if ("N".equals(wantPita)) {
            pitaPricing = 0;
        }
        // Returns either the cost of pita or $0
        return pitaPricing;
    }

    /**
    * Does the user want a drink(s).
    *
    * @param pricingDrink The price for a drink
    * @return the total cost of all drinks ordered.
    **/
    public static double haveDrink(final double pricingDrink) {
        // Declaring variables for if the user wants drinks, and how many.
        String wantDrink = "";
        int drinkInt = 0;

        do {
            System.out.println("Would you like a drink on the side?\n"
                + "(Y or N)");
            wantDrink = receive.nextLine().toUpperCase();
            // Repeats until the user says they want a drink or not.
        } while (!("Y".equals(wantDrink) || "N".equals(wantDrink)));
        // Asking the user how many drinks they want.
        if ("Y".equals(wantDrink)) {
            do {
                System.out.println("How many drinks would you like?");
                final String drinkAmount = receive.nextLine();
                // Catches non-number amounts of drinks.
                try {
                    drinkInt = Integer.parseInt(drinkAmount);
                    // Displays "error" for negative amounts of drinks.
                    if (drinkInt < 1) {
                        System.out.println("Invalid input. Can't"
                                + " purchase less than 1 drink!");
                    }
                } catch (NumberFormatException error) {
                    System.out.println("Not a number of drinks. "
                            + error.getMessage());
                }
            // Repeats until the user orders at least 1 drink.
            } while (drinkInt < 1);
        }

        // The price for a drink times the amount of drinks ordered.
        // If the user doesn't want a drink, times by 0.
        final double drinkTotal = pricingDrink * drinkInt;
        // Return the cost of drinks, or else 0.
        return drinkTotal;
    }

    /**
    * Does the user want fries.
    *
    * @param pricingFries The price for fries.
    * @return The cost of all the fries.
    **/
    public static double haveFries(final double pricingFries) {
        // Declaring variables for if the user wants fries, and how many.
        String wantFries = "";
        int friesInt = 0;

        do {
            System.out.println("Would you like Fries on the side?\n"
                + "(Y or N)");
            wantFries = receive.nextLine().toUpperCase();
            // Repeats until the user says they want fries or not.
        } while (!("Y".equals(wantFries) || "N".equals(wantFries)));
        // Asking the user how many orders of fries they want.
        if ("Y".equals(wantFries)) {
            do {
                System.out.println("How many Fries would you like?");
                final String friesAmount = receive.nextLine();
                // Catches non-number amounts of fries.
                try {
                    friesInt = Integer.parseInt(friesAmount);
                    // Displays "error" for negative amounts of fries.
                    if (friesInt < 1) {
                        System.out.println("Invalid input. Can't purchase"
                                + " less than 1 Fries!");
                    }
                } catch (NumberFormatException error) {
                    System.out.println("Not a number of fries. "
                            + error.getMessage());
                }
            // Repeats until the user orders at least 1 order of fries.
            } while (friesInt < 1);
        }

        // The price for fries times the amount of fries ordered.
        // If the user doesn't want fries, times by 0.
        final double friesTotal = pricingFries * friesInt;
        // Return the cost of fries, or else 0.
        return friesTotal;
    }

    /**
    * Does the user want to order another item.
    *
    * @return Returns true if the user wants to order another item.
    **/
    public static boolean orderAgain() {
        String decision = "";
        do {
            System.out.println("Would you like to order another item?\n"
                    + "(Y or N)");
            decision = receive.nextLine().toUpperCase();
        // Repeats until the user decides if they want to order another item.
        } while (!("Y".equals(decision) || "N".equals(decision)));
        // ".equals()" returns a boolean true or false
        // Returns true or false to main based on that and user decision.
        return "Y".equals(decision);
    }

    /**
    * Adding tax to the cost of the order.
    *
    * @param itemsPrice The subtotal of all the items.
    * @param taxRate How much is tax in the area.
    * @return The final price.
    **/
    public static double addTax(final double itemsPrice,
        final double taxRate) {
        // Calculations for tax and creating a final cost.
        final double finalTax = itemsPrice * taxRate;
        final double finalPrice = itemsPrice + finalTax;

        // Returning the total cost.
        return finalPrice;
    }

    /**
    * Main lines of code.
    *
    * @param args a placeholder value when making the main function
    **/
    public static void main(String[] args) {
        // Money-related variables and constants
        final double platterPrice = 13.99;
        final double wrapPrice = 3.99;
        final double burgerPrice = 6.99;
        final double poutinePrice = 5.99;
        final double drinkPrice = 2.30;
        final double friesPrice = 4.70;
        final double meatPrice = 2;
        final double pitaPrice = 2;
        final double largeSize = 3;
        final double hstTax = 0.13;
        double subPrice = 0;
        double totalPrice = 0;

        System.out.println("Welcome to our new and improved menu system!");
        // Looping so user can order multiple items.
        do {
            // Call function to get the user's order.
            // Repeats until there is a valid order.
            final String food = getOrder();

            // Checks if the user ordered a platter.
            if ("PLATTER".equals(food)) {
                // Adds the general item cost.
                subPrice += platterPrice;
                // Does the user want meat or vegetarian?
                // Adds the cost of meat to the order total.
                subPrice += haveMeat(meatPrice);
                // Does the user want pita with their platter?
                // Adds the cost of pita bread to the order total.
                subPrice += havePita(pitaPrice);

            // Checks if the user ordered a wrap.
            } else if ("WRAP".equals(food)) {
                // Adds the general item cost.
                subPrice += wrapPrice;
                // Does the user want meat or vegetarian?
                // Adds the cost of meat to the order total
                subPrice += haveMeat(meatPrice);
                // Does the user want a large or regular wrap?
                // Adds the cost of a large size to the order total
                subPrice += haveLarge(largeSize);

            // Checks if the user ordered a burger.
            } else if ("BURGER".equals(food)) {
                // Adds the general item cost.
                subPrice += burgerPrice;
                // Does the user want a large or regular burger?
                // Adds the cost of a large size to the order total
                subPrice += haveLarge(largeSize);

            // Checks if the user ordered a poutine.
            } else if ("POUTINE".equals(food)) {
                // Adds the general item cost.
                subPrice += poutinePrice;
                // Does the user want a large or regular poutine?
                // Adds the cost of a large size to the order total
                subPrice += haveLarge(largeSize);
            }

            // Does the user want any drinks?
            // User can order multiple.
            // Adds the cost of them to the order total.
            subPrice += haveDrink(drinkPrice);

            // Does the user want any fries?
            // User can order multiple.
            // Adds the cost of them to the order total.
            subPrice += haveFries(friesPrice);

            // Calls a function to ask if the user wants to order another item.
            // Returns either true or false to activate the repeat.
        } while (orderAgain());

        // Runs a function to calculate the final
        // cost from the subtotal and tax.
        totalPrice = addTax(subPrice, hstTax);
        // Prints the final cost.
        System.out.printf("The total price of your order"
            + " is $%.2f. Thank you!\n", totalPrice);
    }
}
