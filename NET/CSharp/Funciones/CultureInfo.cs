//Asignar la cultura
CultureInfo cultureinfo = new CultureInfo("en-US");
//Obtener un datetime con cultura
DateTime dt = DateTime.Parse("MMM", cultureinfo);
//Obtener mes y año con cultura
string CurrentDate = cultureinfo.DateTimeFormat.GetMonthName(currentDate.Month) + " " + currentDate.Year.ToString();
//Obtener mes actual con cultura
string date = cultureinfo.DateTimeFormat.GetMonthName(currentDate.Month).ToString();
//Convertir de String a Datetime
DateTime dt = DateTime.ParseExact(result, "MMM", cultureInfo);
//