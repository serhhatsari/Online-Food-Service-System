package src.utility;

import src.Admin;
import src.Chef;
import src.Courier;
import src.Customer;
import src.Food;
import src.User;

class LineParsers {

  /**
   * It takes a line of text from the food.txt file, splits it into tokens, and then creates a Food
   * object with the tokens
   *
   * @param lineText The line of text that we're parsing.
   * @return A Food object
   */
  static Food parseFoodLine(String lineText) {
    String[] tokens = lineText.split(" ");
    StringBuilder foodName = new StringBuilder();
    Food food = new Food();

    food.setFoodID(Integer.parseInt(tokens[0]));

    for (int i = 1; i < tokens.length - 2; i++) {
      foodName.append(tokens[i] + " ");
    }
    food.setFoodName(foodName.toString());
    food.setFoodPrice(Integer.parseInt(tokens[tokens.length - 2]));
    food.setFoodType(tokens[tokens.length - 1]);

    return food;
  }

  /**
   * It takes a line of text, splits it into tokens, and then uses the first token to determine which
   * type of user to create
   *
   * @param lineText The line of text that we're parsing.
   * @return A User object.
   */
  static User parseAndConvertUserLine(String lineText) {
    String[] tokens = lineText.split(" ");
    String userType = tokens[0];

    if (userType.equals("admin")) {
      return new Admin(
        null,
        tokens[1],
        Integer.parseInt(tokens[2]),
        tokens[3],
        tokens[4]
      );
    } else if (userType.equals("chef")) {
      return new Chef(
        tokens[1],
        Integer.parseInt(tokens[2]),
        tokens[3],
        tokens[4],
        Integer.parseInt(tokens[5]),
        Integer.parseInt(tokens[6])
      );
    } else if (userType.equals("courier")) {
      return new Courier(
        tokens[1],
        Integer.parseInt(tokens[2]),
        tokens[3],
        tokens[4],
        tokens[5],
        Integer.parseInt(tokens[6])
      );
    } else if (userType.equals("customer")) {
      return new Customer(
        tokens[1],
        Integer.parseInt(tokens[2]),
        tokens[3],
        tokens[4],
        tokens[5],
        tokens[6],
        Double.parseDouble(tokens[7]),
        null
      );
    } else {
      return null;
    }
  }

  /**
   * It takes a line of text, splits it into tokens, and then creates a new User object based on the
   * first token
   *
   * @param lineText The line of text that we're parsing.
   * @return A User object.
   */
  static User parseUserLine(String lineText) {
    String[] tokens = lineText.split(" ");
    String userType = tokens[0];

    if (userType.equals("admin")) {
      return new User(
        tokens[1],
        Integer.parseInt(tokens[2]),
        tokens[3],
        tokens[4]
      );
    } else if (userType.equals("chef")) {
      return new User(
        tokens[1],
        Integer.parseInt(tokens[2]),
        tokens[3],
        tokens[4]
      );
    } else if (userType.equals("courier")) {
      return new User(
        tokens[1],
        Integer.parseInt(tokens[2]),
        tokens[3],
        tokens[4]
      );
    } else if (userType.equals("customer")) {
      return new User(
        tokens[1],
        Integer.parseInt(tokens[2]),
        tokens[4],
        tokens[5]
      );
    } else {
      return null;
    }
  }
}
