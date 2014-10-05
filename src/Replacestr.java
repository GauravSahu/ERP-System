
public class Replacestr
{
  public static String main(String args[])
  {
	  String temp="";
	  String str1 = "vani";
	  String str2 = "rags";
      int len = str2.length();
      for(int i=0;i<len;i++)
      {
          for(int j=0;j<str1.length();j++)
          {
              if(str1.charAt(j)==str2.charAt(i))
                 continue;
              else
                 temp = temp + str1.charAt(j);
          }
          str1=temp;
          temp="";
      }
      return str1;
  }
}
