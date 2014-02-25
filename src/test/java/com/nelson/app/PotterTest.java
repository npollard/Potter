package com.nelson.app;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;


public class PotterTest {
  Potter p = new Potter();
  int[][] books = {
    {},
    {0},
    {1},
    {2},
    {3},
    {4},
  };


	@Test
	public void testBasic() {
		assertEquals(0, p.getPrice(books[0]), .0001);
	  assertEquals(8, p.getPrice(books[1]), .0001);
    assertEquals(8, p.getPrice(books[2]), .0001);
    assertEquals(8, p.getPrice(books[3]), .0001);
    assertEquals(8, p.getPrice(books[4]), .0001);
    assertEquals(8, p.getPrice(books[5]), .0001);
  //  assertEquals(8, p.getPrice(books[6]), .0001);


  
  }


 
}
