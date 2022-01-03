//Metodo 1
using System;
using System.Linq;

public class IdentifyString
{
    public static void Main()
    {
      string number = "123456";
      if(number.All(char.IsDigit))
      {
          Console.WriteLine("The Given String is a Number.");
      }
      else
      {
          Console.WriteLine("The Given String is Not a Number.");
      }
    }
}
//Metodo 2
using System;
using System.Text.RegularExpressions;

public class IdentifyString
{
    public static void Main()
    {
      string number = "123456";
      if(Regex.IsMatch(number, @"^[0-9]+$"))
      {
          Console.WriteLine("The Given String is a Number.");
      }
      else
      {
          Console.WriteLine("The Given String is Not a Number.");
      }
    }
}

//REF: https://www.delftstack.com/es/howto/csharp/how-to-identify-if-a-string-is-a-number-in-csharp/