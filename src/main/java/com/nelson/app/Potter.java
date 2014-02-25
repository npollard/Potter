package com.nelson.app;


public class Potter
{
  public double getPrice(int[] books) {
    if (books.length == 0) {
      return 0;
    }

    if (books.length == 1) {
      return 8;
    }

    int uniqueTitles = 1;
    int prevTitle = books[0];

    System.out.printf("books[0]: %d\n", books[0]); //DEBUG
    
    for (int i = 1; i < books.length; i++) {
      if (books[i] != prevTitle) uniqueTitles++;

      System.out.printf("books[%d]: %d\n", i, books[i]); //DEBUG
    }
    
    System.out.printf("UNIQUE TITLES = %d\n", uniqueTitles); //DEBUG

    double price = getDiscountRate(uniqueTitles) + (books.length - uniqueTitles) * 8;
    
    return price;
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

}
