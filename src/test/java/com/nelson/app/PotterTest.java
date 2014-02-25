package com.nelson.app;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;


public class PotterTest {
  Potter p = new Potter();
  int[][] books = {
    {}, //0
    {0}, //1
    {1}, //2
    {2}, //3
    {3}, //4
    {4}, //5
    {0, 0}, //6
    {1, 1, 1}, //7
    {0, 1}, //8
    {0, 2, 4}, //9
    {0, 1, 2, 4}, //10
    {0, 1, 2, 3, 4}, //11
    {0, 0, 1}, //12
    {0, 0, 1, 1} 

  };


	@Test
	public void testBasic() {
		assertEquals(0, p.getPrice(books[0]), .0001);
	  assertEquals(8, p.getPrice(books[1]), .0001);
    assertEquals(8, p.getPrice(books[2]), .0001);
    assertEquals(8, p.getPrice(books[3]), .0001);
    assertEquals(8, p.getPrice(books[4]), .0001);
    assertEquals(8, p.getPrice(books[5]), .0001);
    assertEquals(2 * 8, p.getPrice(books[6]), .0001);
    assertEquals(3 * 8, p.getPrice(books[7]), .0001);
  
  }

  @Test
  public void testSimpleDiscounts() {
    assertEquals(8 * 2 * .95, p.getPrice(books[8]), .0001);
    assertEquals(8 * 3 * .9, p.getPrice(books[9]), .0001);
    assertEquals(8 * 4 * .8, p.getPrice(books[10]), .0001);
    assertEquals(8 * 5 * .75, p.getPrice(books[11]), .0001);

  }

  @Test
  public void testMultipleDiscounts() {
    assertEquals(8 + (8 * 2 * .95), p.getPrice(books[12]), .0001);
    assertEquals(2 * (8 * 2 * .95), p.getPrice(books[13]), .0001);

  }


 
}
