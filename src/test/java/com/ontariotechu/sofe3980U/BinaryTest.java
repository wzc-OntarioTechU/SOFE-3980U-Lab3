package com.ontariotechu.sofe3980U;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for Binary class.
 */
public class BinaryTest 
{
    /**
     * Test The constructor with a valid binary vallue
     */
    @Test
    public void normalConstructor()
    {
		Binary binary=new Binary("1001001");
        assertTrue( binary.getValue().equals("1001001"));
    }
    /**
     * Test The constructor with an invalid binary value of out-of-range digits
     */
    @Test
    public void constructorWithInvalidDigits()
    {
		Binary binary=new Binary("1001001211");
        assertTrue( binary.getValue().equals("0"));
    }
    /**
     * Test The constructor with an invalid binary value of alphabetic characters
     */
    @Test
    public void constructorWithInvalidChars()
    {
		Binary binary=new Binary("1001001A");
        assertTrue( binary.getValue().equals("0"));
    }
    /**
     * Test The constructor with an invalid binary value that has a sign
     */
    @Test
    public void constructorWithNegativeSign()
    {
		Binary binary=new Binary("-1001001");
        assertTrue( binary.getValue().equals("0"));
    }
    /**
     * T	est The constructor with a zero tailing valid binary value
     */
    @Test
    public void constructorWithZeroTailing()
    {
		Binary binary=new Binary("00001001");
        assertTrue( binary.getValue().equals("1001"));
    }
    /**
     * Test The constructor with an empty string
     */
    @Test
    public void constructorEmptyString()
    {
		Binary binary=new Binary("");
        assertTrue( binary.getValue().equals("0"));
    }
	/**
     * Test The add functions with two binary numbers of the same length
     */
    @Test
    public void add()
    {
		Binary binary1=new Binary("1000");
		Binary binary2=new Binary("1111");
		Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("10111"));
    }
	/**
     * Test The add functions with two binary numbers, the length of the first argument is less than the second
     */
    @Test
    public void add2()
    {
		Binary binary1=new Binary("1010");
		Binary binary2=new Binary("11");
		Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("1101"));
    }
	/**
     * Test The add functions with two binary numbers, the length of the first argument is greater than the second
     */
    @Test
    public void add3()
    {
		Binary binary1=new Binary("11");
		Binary binary2=new Binary("1010");
		Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("1101"));
    }
	/**
     * Test The add functions with a binary numbers with zero
     */
    @Test
    public void add4()
    {
		Binary binary1=new Binary("0");
		Binary binary2=new Binary("1010");
		Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("1010"));
    }
	/**
     * Test The add functions with two zeros
     */
    @Test
    public void add5()
    {
		Binary binary1=new Binary("0");
		Binary binary2=new Binary("0");
		Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("0"));
    }
    
    /**
     * Test the or function with two zeros
     */
    @Test
    public void or1() {
    	Binary bin1 = new Binary("0");
    	Binary bin2 = new Binary("0");
    	Binary bin3 = Binary.or(bin1, bin2);
    	assertTrue(bin3.getValue().equals("0"));
    }
    /**
     * Test the or function with two ones
     */
    @Test
    public void or2() {
    	Binary bin1 = new Binary("1");
    	Binary bin2 = new Binary("1");
    	Binary bin3 = Binary.or(bin1, bin2);
    	assertTrue(bin3.getValue().equals("1"));
    }
    /**
     * Test the or function with a one and a zero
     */
    @Test
    public void or3() {
    	Binary bin1 = new Binary("0");
    	Binary bin2 = new Binary("1");
    	Binary bin3 = Binary.or(bin1, bin2);
    	assertTrue(bin3.getValue().equals("1"));
    }
    /**
     * Test the or function with a longer string of ones and zeros
     */
    @Test
    public void or4() {
    	Binary bin1 = new Binary("0100101");
    	Binary bin2 = new Binary("0110010");
    	Binary bin3 = Binary.or(bin1, bin2);
    	assertTrue(bin3.getValue().equals("110111"));
    }
    /**
     * Test the or function with two strings of ones and zeros of varying length
     */
    @Test
    public void or5() {
    	Binary bin1 = new Binary("0100101");
    	Binary bin2 = new Binary("110");
    	Binary bin3 = Binary.or(bin1, bin2);
    	assertTrue(bin3.getValue().equals("100111"));
    }
    /**
     * Test the and function with two zeros
     */
    @Test
    public void and1() {
    	Binary bin1 = new Binary("0");
    	Binary bin2 = new Binary("0");
    	Binary bin3 = Binary.and(bin1, bin2);
    	assertTrue(bin3.getValue().equals("0"));
    }
    /**
     * Test the and function with two ones
     */
    @Test
    public void and2() {
    	Binary bin1 = new Binary("1");
    	Binary bin2 = new Binary("1");
    	Binary bin3 = Binary.and(bin1, bin2);
    	assertTrue(bin3.getValue().equals("1"));
    }
    /**
     * Test the and function with a one and a zero
     */
    @Test
    public void and3() {
    	Binary bin1 = new Binary("0");
    	Binary bin2 = new Binary("1");
    	Binary bin3 = Binary.and(bin1, bin2);
    	assertTrue(bin3.getValue().equals("0"));
    }
    /**
     * Test the and function with a longer string of ones and zeros
     */
    @Test
    public void and4() {
    	Binary bin1 = new Binary("0100101");
    	Binary bin2 = new Binary("0110010");
    	Binary bin3 = Binary.and(bin1, bin2);
    	assertTrue(bin3.getValue().equals("100000"));
    }
    /**
     * Test the and function with two strings of ones and zeros of varying length
     */
    @Test
    public void and5() {
    	Binary bin1 = new Binary("0100101");
    	Binary bin2 = new Binary("110");
    	Binary bin3 = Binary.and(bin1, bin2);
    	assertTrue(bin3.getValue().equals("100"));
    }
    /**
     * Test the multiply function with two zeros
     */
    @Test
    public void multiply1() {
    	Binary bin1 = new Binary("0");
    	Binary bin2 = new Binary("0");
    	Binary bin3 = Binary.multiply(bin1, bin2);
    	assertTrue(bin3.getValue().equals("0"));
    }
    /**
     * Test the multiply function with two ones
     */
    @Test
    public void multiply2() {
    	Binary bin1 = new Binary("1");
    	Binary bin2 = new Binary("1");
    	Binary bin3 = Binary.multiply(bin1, bin2);
    	assertTrue(bin3.getValue().equals("1"));
    }
    /**
     * Test the multiply function with a one and a zero
     */
    @Test
    public void multiply3() {
    	Binary bin1 = new Binary("0");
    	Binary bin2 = new Binary("1");
    	Binary bin3 = Binary.multiply(bin1, bin2);
    	assertTrue(bin3.getValue().equals("0"));
    }
    /**
     * Test the multiply function with a longer string of ones and zeros
     */
    @Test
    public void multiply4() {
    	Binary bin1 = new Binary("0100101");
    	Binary bin2 = new Binary("0110010");
    	Binary bin3 = Binary.multiply(bin1, bin2);
    	assertTrue(bin3.getValue().equals("11100111010"));
    }
    /**
     * Test the multiply function with two strings of ones and zeros of varying length
     */
    @Test
    public void multiply5() {
    	Binary bin1 = new Binary("0100101");
    	Binary bin2 = new Binary("110");
    	Binary bin3 = Binary.multiply(bin1, bin2);
    	assertTrue(bin3.getValue().equals("11011110"));
    }
}
