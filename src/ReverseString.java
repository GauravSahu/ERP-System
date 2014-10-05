
public class ReverseString
{
	public static void main(String args[])
	{
	String str = "vani";
	  StringBuilder strbuild = new StringBuilder(str);
	  System.out.println(strbuild.reverse());
	  if(strbuild.toString().equals(str))
	  {
		  System.out.println("it is a palindrome ");
	  }
	  else
	  {
		  System.out.println("it is not a palindrome");
	  }
	 
	}
  
}
