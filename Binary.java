//skeleton file for class Binary
//Owen Zeng
//APCS1 pd9
//HW43 -- This or That
//2015-12-8

public class Binary {

    private int _decNum;
    private String _binNum;
    
    
    /*=====================================
      default constructor
      pre:  n/a
      post: initializes _decNum to 0, _binNum to "0"
      =====================================*/
    public Binary() { 
	int _decNum = 0;
	String _binNum = "0";
    }
    
    
    /*=====================================
      overloaded constructor
      pre:  n >= 0
      post: sets _decNum to n, _binNum to equiv string of bits
      =====================================*/
    public Binary( int n ) {
	_decNum = n;
	_binNum = decToBin(n); //convert the inputted integer into a binary String
    }
    
    
    /*=====================================
      overloaded constructor
      pre:  s is String representing non-negative binary number
      post: sets _binNum to input, _decNum to decimal equiv
      =====================================*/
    public Binary( String s ) {
	_decNum = binToDec(s);//convert the inputted String into a decimal integer
	_binNum = s;
    }
    
    
    /*=====================================
      String toString() -- returns String representation of this Object
      pre:  n/a
      post: returns String of 1's and 0's representing value of this Object
      =====================================*/
    public String toString() { 
	return _binNum;  
    }
    
    
    /*=====================================
      String decToBin(int) -- converts base-10 input to binary
      pre:  n >= 0
      post: returns String of bits
      eg  decToBin(0) -> "0"
      decToBin(1) -> "1"
      decToBin(2) -> "10"
      decToBin(3) -> "11"
      decToBin(14) -> "1110"
      =====================================*/
    public static String decToBin( int n ) {
        String binary = "";
	//while loop used to create the String
	while (n > 0){
	    binary = (n % 2) + binary;
	    n /= 2;
	}
	return binary;
    }
    
    
    /*=====================================
      String decToBinR(int) -- converts base-10 input to binary, recursively
      pre:  n >= 0
      post: returns String of bits
      eg  decToBinR(0) -> "0"
      decToBinR(1) -> "1"
      decToBinR(2) -> "10"
      decToBinR(3) -> "11"
      decToBinR(14) -> "1110"
      =====================================*/
    public static String decToBinR( int n ) {
	//building from right to left
        return decToBinR(n / 2) + (n % 2) + "";
    }
    
    
    /*=====================================
      String binToDec(String) -- converts base-10 input to binary
      pre:  s represents non-negative binary number
      post: returns String of bits
      eg  
      binToDec("0") -> 0
      binToDec("1") -> 1
      binToDec("10") -> 2
      binToDec("11") -> 3
      binToDec("1110") -> 14
      =====================================*/
    public static int binToDec( String s ) {
	int decimal = 0;
	int place = 0;
	for (int x = 0; s.length() > x; x++){
	    if (s.substring(s.length() - 1).equals("1")){;//if the rightmost index is 1
		decimal += Math.pow(2,place);//increase by 2 to the power of place 
	    }
	    place++; //add 1 to place
	    s = s.substring(0, s.length());//cut the String down
	}
	return decimal;
    }
    
    
    /*=====================================
      String binToDecR(String) -- converts base-10 input to binary, recursively
      pre:  s represents non-negative binary number
      post: returns String of bits
      eg  
      binToDecR("0") -> 0
      binToDecR("1") -> 1
      binToDecR("10") -> 2
      binToDecR("11") -> 3
      binToDecR("1110") -> 14
      =====================================*/
    public static int binToDecR( String s ) {
        return binToDecR(s.susbtring(0 , s.length())) + (Integer.parseInt(s.substring(s.length() - 1)) * Math.pow (2,1) // don't know how to increment    
    }
    
    
    /*=============================================
      boolean equals(Object) -- tells whether 2 Objs are equivalent
      pre:  other is an instance of class Binary
      post: Returns true if this and other are aliases (pointers to same 
      Object), or if this and other represent equal binary values
      =============================================*/
    public boolean equals( Object other ) {
        //int a = Integer.parseInt(this._binNum);
	//int b = Integer.parseInt(((Binary)other)._binNum);
	//return a == b;

	//no modifications just straight comparison with what you have
	return this._binNum.equals(((Binary)other)._binNum);
    }
    
    
    /*=============================================
      int compareTo(Object) -- tells which of two Binary objects is greater
      pre:  other is instance of class Binary
      post: Returns 0 if this Object is equal to the input Object,
      negative integer if this<input, positive integer otherwise
      =============================================*/
    public int compareTo( Object other ) {
	//turns the String of binary into decimal integers. I could have used parseInt but didn't want to have big numbers return
        int thisBin = binToDec(this._binNum);
	int thatBin = binToDec(((Binary)other)._binNum);

	//for comparison 
	return thisBin - thatBin;
    }
    
    
    //main method for testing
    public static void main( String[] args ) {
	
	
	  System.out.println();
	  System.out.println( "Testing ..." );
	  
	  Binary b1 = new Binary(5);
	  Binary b2 = new Binary(5);
	  Binary b3 = b1;
	  Binary b4 = new Binary(35);
	  
	  System.out.println( b1 );
	  System.out.println( b2 );
	  System.out.println( b3 );       
	  System.out.println( b4 );       
	  
	  System.out.println( "\n==..." );
	  System.out.println( b1 == b2 ); //should be false
	  System.out.println( b1 == b3 ); //should be true
	  
	  System.out.println( "\n.equals()..." );
	  System.out.println( b1.equals(b2) ); //should be true
	  System.out.println( b1.equals(b3) ); //should be true
	  System.out.println( b3.equals(b1) ); //should be true
	  System.out.println( b4.equals(b2) ); //should be false
	  System.out.println( b1.equals(b4) ); //should be false
	  
	  System.out.println( "\n.compareTo..." );
	  System.out.println( b1.compareTo(b2) ); //should be 0
	  System.out.println( b1.compareTo(b3) ); //should be 0
	  System.out.println( b1.compareTo(b4) ); //should be neg
	  System.out.println( b4.compareTo(b1) ); //should be pos
    }//end main()
    
} //end class
