//Obtener la fecha
DateTime currentDate = DateTime.Now;
//Recortar DateTime a 3 (ENE-JAN)
string result = date.Substring(0, 3);
//Restar un mes al mes del Datetime actual
var lastmonth = DateTime.Today.AddMonths(-1);
//Cambiar de mes a 12 en caso de que sea el primero
if (date.Month == 1)
{
    lastDate = cultureinfo.DateTimeFormat.GetMonthName(12).ToString();
}
else
{
    lastDate = cultureinfo.DateTimeFormat.GetMonthName(date.Month - 1).ToString();
}
//Obtener un datetime con cultura
DateTime dt = DateTime.Parse("MMM", cultureinfo);
//Obtener mes y año con cultura
string CurrentDate = cultureinfo.DateTimeFormat.GetMonthName(currentDate.Month) + " " + currentDate.Year.ToString();
//Obtener mes actual con cultura
string date = cultureinfo.DateTimeFormat.GetMonthName(currentDate.Month).ToString();
//Convertir de String a Datetime
DateTime dt = DateTime.ParseExact(result, "MMM", cultureInfo);
//Obtener DateTime con cultura incluida
System.Globalization.CultureInfo cultureinfo =
        new System.Globalization.CultureInfo("nl-NL");
DateTime dt = DateTime.Parse(date, cultureinfo);