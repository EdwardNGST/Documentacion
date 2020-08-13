//Rextester.Program.Main is the entry point for your code. Don't change it.
//Compiler version 4.0.30319.17929 for Microsoft (R) .NET Framework 4.5

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;
using System.Globalization;

namespace Rextester
{
    public class Program
    {
        public static void Main(string[] args)
        {
            DateTime date = new DateTime(2017, 9, 6, 0, 0, 0);
            
            CultureInfo.CurrentCulture = CultureInfo.CreateSpecificCulture("de-DE");
            Console.WriteLine("Current Culture: " + CultureInfo.CurrentCulture);
            string deDateString = date.ToString("MMM d, yyyy h:mm tt");
            Console.WriteLine("deDateString: " + deDateString);
            DateTime deDateParse = DateTime.Parse(deDateString);
            DateTime deDateParseWithCulture = DateTime.Parse(deDateString, CultureInfo.CurrentCulture);
            
            Console.WriteLine();
            
            CultureInfo.CurrentCulture = CultureInfo.CreateSpecificCulture("en-US");
            Console.WriteLine("Current Culture: " + CultureInfo.CurrentCulture);
            string enDateString = date.ToString("MMM d, yyyy h:mm tt");
            Console.WriteLine("enDateString: " + enDateString);
            DateTime enDateParse = DateTime.Parse(enDateString);
            DateTime enDateParseWithCulture = DateTime.Parse(enDateString, CultureInfo.CurrentCulture);
            
            Console.WriteLine();
            
            Console.WriteLine("deDateParse: " + deDateParse.ToString("MMM d, yyyy hh:mm:ss tt"));          
            Console.WriteLine("enDateParse: " + enDateParse.ToString("MMM d, yyyy hh:mm:ss tt"));
            Console.WriteLine("deDateParseWithCulture: " + deDateParseWithCulture.ToString("MMM d, yyyy hh:mm:ss tt"));          
            Console.WriteLine("enDateParseWithCulture: " + enDateParseWithCulture.ToString("MMM d, yyyy hh:mm:ss tt"));
        }
    }
}