//Algorithm

// Initialization: Start from the innermost circle with initial power "P".

// Traversal through Circles: For each circle, Abhimanyu has three options:

//1. Skip fighting the enemy (he can do this a times).
//2. Recharge his power (he can do this b times).
//3. Fight the enemy if his power is greater than or equal to the enemy's power.

// Special Enemies: Handle the special cases for enemies at k3 and k7 who can regenerate and attack from behind.

// Victory Condition: Abhimanyu must have positive power after crossing the 11th circle.


public class Chakravyuha {
    
  public static boolean canAbhimanyuCross(int[] enemies, int p, int a, int b) {
      int rechargeCount = b;
      
      for (int i = 0; i < enemies.length; i++) {
          int enemyPower = enemies[i];

          // Skip enemy if possible
          if (a > 0) {
              a--;
              continue;
          }
          
          // Check if Abhimanyu can fight the enemy
          if (p >= enemyPower) {
              p -= enemyPower;
          } else if (rechargeCount > 0) {
              rechargeCount--;
              p += enemyPower;        // Recharge to match the enemy's power
          } else {
              return false;
          }

          // Handle special cases for k3 and k7 enemies
          if ((i == 2 || i == 6) && i + 1 < enemies.length) {
              int regeneratedPower = enemyPower / 2;
              if (p < regeneratedPower) {
                  return false;
              } else {
                  p -= regeneratedPower;
              }
          }
      }
      
      return p > 0;
  }
  
  public static void main(String[] args) {
      int[] enemies1 = {3, 2, 5, 6, 3, 2, 7, 4, 5, 6, 7};
      int p1 = 15;
      int a1 = 2;
      int b1 = 1;
      
      boolean result1 = canAbhimanyuCross(enemies1, p1, a1, b1);
      System.out.println("Test case 1: " + (result1 ? "Abhimanyu can cross the Chakravyuha" : "Abhimanyu cannot cross the Chakravyuha"));
      
      int[] enemies2 = {5, 4, 8, 7, 3, 2, 6, 5, 4, 3, 8};
      int p2 = 20;
      int a2 = 1;
      int b2 = 2;
      
      boolean result2 = canAbhimanyuCross(enemies2, p2, a2, b2);
      System.out.println("Test case 2: " + (result2 ? "Abhimanyu can cross the Chakravyuha" : "Abhimanyu cannot cross the Chakravyuha"));
  }
}

