package com.nelson.app;


public class Potter
{
  private final boolean DEBUG = true;

  public double getPrice(int[] books) {
    if (books.length == 0) {
      return 0;
    }

    if (books.length == 1) {
      return 8;
    }

    int[] titleCount = {0, 0, 0, 0, 0};
    for (int i = 0; i < books.length; i++) {
      titleCount[books[i]]++;

    }
    
  
    double totalPrice = 0;
    boolean booksRemaining = true;
    while (booksRemaining) {
      booksRemaining = false;
    
      printTitleCount(titleCount);
      
      int uniqueTitles = 0;
      for (int i = 0; i < titleCount.length; i++) {
        if (titleCount[i] > 0) {
          booksRemaining = true;
          uniqueTitles++;
          titleCount[i]--;
        }
      }

      totalPrice += getDiscountRate(uniqueTitles);
      if (DEBUG) System.out.printf("CURRENT PRICE = %f\n", totalPrice);

    }

    if (DEBUG) System.out.printf("TOTAL PRICE = %f\n", totalPrice);
    System.out.println();
    return totalPrice;
  }


  private double getDiscountRate(int uniqueTitles) {
    double discountRate = 1;
    switch (uniqueTitles) {
      case 1: discountRate = 1;
              break;
      case 2: discountRate = .95;
              break;
      case 3: discountRate = .9;
              break;
      case 4: discountRate = .8;
              break;
      case 5: discountRate = .75;
              break;
      default: break;

    }

    return discountRate * uniqueTitles * 8;
        
  }

  private void printTitleCount(int[] titleCount) {
    if (DEBUG) {
      System.out.printf("TITLECOUNT: %d", titleCount[0]);
      for (int i = 1; i < titleCount.length; i++) {
        System.out.printf(", %d", titleCount[i]);
      }
      System.out.println();
    }
  }

}
