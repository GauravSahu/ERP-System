
public class ReverseStringwtmethod 
{
  public static void main(String args[])
  {
	  String str = "vani";
	  int len = str.length();
	  System.out.println(len/2);
	  for(int i =0;i<len/2;i++)
	  {
		  if(str.charAt(i) != str.charAt(len-i-1))
		  {
			  System.out.println("not a palindrome");
		  }
		  else
		  {
			  System.out.println("palindrome");
		  }
	  }
  }
}
