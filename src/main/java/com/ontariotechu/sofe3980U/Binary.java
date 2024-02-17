package com.ontariotechu.sofe3980U;

/**
 * Unsigned integer Binary variable
 *
 */
public class Binary
{
	private String number="0";  // string containing the binary value '0' or '1'
	/**
	* A constructor that generates a binary object.
	*
	* @param number a String of the binary values. It should conatins only zeros or ones with any length and order. otherwise, the value of "0" will be stored.   Trailing zeros will be excluded and empty string will be considered as zero.
	*/
    public Binary(String number) {
		for (int i = 0; i < number.length(); i++) {
			// check each character if it's not 0 or 1
			char ch=number.charAt(i);
			if(ch!='0' && ch!='1') {
				number="0"; // if not store "0" and end the function
				return;
			}
		}
		// remove any trailing zeros
		int beg;
		for (beg = 0; beg < number.length(); beg++) {
			if (number.charAt(beg)!='0')
				break;
		}
		//beg has the index of the first non zero digit in the number
		this.number=number.substring(beg); // exclude the trailing zeros if any

		if(this.number=="") { // replace empty strings with a single zero
			this.number="0";
		}
    }
	/**
	* Return the binary value of the variable
	*
	* @return the binary value in a string format.
	*/
	public String getValue()
	{
		return this.number;
	}
	/**
	* Adding two binary variables. For more information, visit <a href="https://www.wikihow.com/Add-Binary-Numbers"> Add-Binary-Numbers </a>.
	*
	* @param num1 The first addend object
	* @param num2 The second addend object
	* @return A binary variable with a value of <i>num1+num2</i>.
	*/
	public static Binary add(Binary num1,Binary num2)
	{
		// the index of the first digit of each number
		int ind1=num1.number.length()-1;
		int ind2=num2.number.length()-1;
		//initial variable
		int carry=0;
		String num3="";  // the binary value of the sum
		while(ind1>=0 ||  ind2>=0 || carry!=0) // loop until all digits are processed
		{
			int sum=carry; // previous carry
			if(ind1>=0){ // if num1 has a digit to add
				sum += (num1.number.charAt(ind1)=='1')? 1:0; // convert the digit to int and add it to sum
				ind1--; // update ind1
			}
			if(ind2>=0){ // if num2 has a digit to add
				sum += (num2.number.charAt(ind2)=='1')? 1:0; // convert the digit to int and add it to sum
				ind2--; //update ind2
			}
			carry=sum/2; // the new carry
			sum=sum%2;  // the resultant digit
			num3 =( (sum==0)? "0":"1")+num3; //convert sum to string and append it to num3
		}
		Binary result=new Binary(num3);  // create a binary object with the calculated value.
		return result;
		
	}
	
	/**
	 * Bitwise OR two binary variables.
	 * 
	 * @param num1 The first input binary number.
	 * @param num2 The second input binary number.
	 * @return A binary variable with a value of <i>num1 OR num2</i>.
	 */
	public static Binary or(Binary num1, Binary num2) {
		// gather the larger of the two index
		int ind = num1.number.length() > num2.number.length() ? num1.number.length() : num2.number.length();
		// string to hold output
		StringBuilder num3 = new StringBuilder("");
		// loop over all available digits
		for (int i = 1; i <= ind; i++) {
			// check for unequal length strings
			if (num1.number.length() < i) { // first num is shorter, use second
				num3.append(num2.number.charAt(num2.number.length() - i));
			} else if (num2.number.length() < i) { // second num is shorter, use first
				num3.append(num1.number.charAt(num1.number.length() - i));
			} else { // both have a valid digit, compare
				num3.append((num1.number.charAt(num1.number.length() - i) == '1' || num2.number.charAt(num2.number.length() - i) == '1') ? "1" : "0");
			}
		}
		// reverse string builder since we appended instead of prepended
		num3.reverse();
		return new Binary(num3.toString());
	}
	
	/**
	 * Bitwise AND two binary variables.
	 * 
	 * @param num1 The first input binary number.
	 * @param num2 The second input binary number.
	 * @return A binary variable with a value of <i>num1 AND num2</i>
	 */
	public static Binary and(Binary num1, Binary num2) {
		// gather the larger of the two index
		int ind = num1.number.length() > num2.number.length() ? num1.number.length() : num2.number.length();
		// string to hold output
		StringBuilder num3 = new StringBuilder("");
		// loop over all available digits
		for (int i = 1; i <= ind; i++) {
			// check for unequal length strings
			if (num1.number.length() < i || num2.number.length() < i) { // if either num is too shorter
				num3.append("0");
			} else { // both have a valid digit, compare
				num3.append((num1.number.charAt(num1.number.length() - i) == '1' && num2.number.charAt(num2.number.length() - i) == '1') ? "1" : "0");
			}
		}
		// reverse string builder since we appended instead of prepended
		num3.reverse();
		return new Binary(num3.toString());
	}
	
	/**
	 * Multiply two binary numbers.
	 * 
	 * @param num1 The first binary multiplicand.
	 * @param num2 The second binary multiplicand.
	 * @return A binary variable with a value of <i>num1 * num2</i>
	 */
	public static Binary multiply(Binary num1, Binary num2) {
		// approaching using shifting methodology
		// assign shorter and longer of the multiplicands to new pointers to reduce loop cycles
		Binary longer = num1.number.length() > num2.number.length() ? num1 : num2;
		Binary shorter = num1.number.length() <= num2.number.length() ? num1 : num2;
		// new empty binary object to collect result
		Binary result = new Binary("0");
		// loop over shorter
		for (int i = shorter.number.length() - 1; i >= 0; i--) {
			// check the appropriate character at index in shorter
			if (shorter.number.charAt(i) == '1') { // 1 so add
				result = Binary.add(result, longer);
			}
			// append 0 to longer to effectively bit shift
			longer = new Binary(longer.number + "0");
		}
		return result;
	}
}	
