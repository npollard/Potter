package com.nelson.app;

import java.util.Collections;
import java.util.Arrays;

public class Potter
{
  private final boolean DEBUG = true;

  public double getPrice(int[] books) {
    if (books.length == 0) {
      return 0;
    }

    int[] titleCount = {0, 0, 0, 0, 0};
    for (int i = 0; i < books.length; i++) {
      titleCount[books[i]]++;

    }

    int[] titleCountClone = titleCount.clone();

    if (DEBUG) System.out.println();
    if (DEBUG) printTitleCount(titleCount);
    
    Arrays.sort(titleCount);
    return getGreedyPrice(titleCount);
  
  }


  private double getGreedyPrice(int[] titleCount) {
    double totalPrice = 0;

    while (titleCount[4] > 0) {
      
      Arrays.sort(titleCount);
  
      if (DEBUG) printTitleCount(titleCount);
   
      int grouping = bestGrouping(titleCount);
      totalPrice += getDiscountRate(grouping);
      for (int i = 1; i <= grouping; i++) titleCount[titleCount.length - i]--;

      if (DEBUG) System.out.printf("GROUPING: %d\nPRICE: %f\n", grouping, totalPrice);

    }

    if (DEBUG) System.out.printf("TOTAL: %f\n\n", totalPrice);

    return totalPrice;

  }

  private int bestGrouping(int[] titleCount) {
    if (titleCount[0] == titleCount[4]) return 5;
    if (titleCount[1] > 0) return 4;
    if (titleCount[2] > 0) return 3;
    if (titleCount[3] > 0) return 2;
    if (titleCount[4] > 0) return 1;
    return 0;

  }

  private double getGreedy4Price(int[] titleCount) {
    double totalPrice = 0;

    titleCount = sortDescending(titleCount);
    if (DEBUG) printTitleCount(titleCount);

    int i = 0;
    int uniqueTitles = 0;
    int[] titleCountCopy;
    while (i < titleCount.length) {
      titleCountCopy = sortDescending(titleCount);
      if (titleCountCopy[i] > 0) {
        uniqueTitles++;
        titleCountCopy[i]--;
        i++;
      }

      if (uniqueTitles == 4) {
        totalPrice += getDiscountRate(uniqueTitles);
        
      }

    }


    if (DEBUG) System.out.printf("Greedy4: %f\n", totalPrice);
    totalPrice += getSimplePrice(titleCount);
    if (DEBUG) System.out.printf("Greedy4 + simple: %f\n", totalPrice);

    return totalPrice;
  }


  private double getSimplePrice(int[] titleCount) {
    double totalPrice = 0;
    boolean booksRemaining = true;
    while (booksRemaining) {
      booksRemaining = false;
    
      if (DEBUG) printTitleCount(titleCount);
      
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

  private int[] sortDescending(int[] a) {
    Arrays.sort(a);
    int[] b = new int[a.length];
    for (int i = 0; i < a.length; i++) {
      b[i] = a[a.length - i - 1];
    }
    return b;
  }

  private void printTitleCount(int[] titleCount) {
    System.out.printf("TITLECOUNT: %d", titleCount[0]);
    for (int i = 1; i < titleCount.length; i++) {
      System.out.printf(", %d", titleCount[i]);
    }
    System.out.println();
  }

}
