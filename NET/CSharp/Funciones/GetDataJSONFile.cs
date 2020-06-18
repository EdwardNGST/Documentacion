//Obtener el texto de un archivo JSON en C#

#region metodo 1
//Metodo para obtener el texto
public void LoadJson()
{
    using (StreamReader r = new StreamReader("file.json"))
    {
        string json = r.ReadToEnd();
        List<Item> items = JsonConvert.DeserializeObject<List<Item>>(json);
    }
}

//Datos dentro del json
public class Item
{
    public int millis;
    public string stamp;
    public DateTime datetime;
    public string light;
    public float temp;
    public float vcc;
}


//Contenido dentro del JSON
//[
//    { "millis": "1000",
//      "stamp": "1273010254",
//      "datetime": "2010/5/4 21:57:34",
//      "light": "333",
//      "temp": "78.32",
//      "vcc": "3.54" }, 
//]

#endregion

#region metodo 2
//Obtener datos dinamicamente
//You can even get the values dynamically without declaring Item class.

dynamic array = JsonConvert.DeserializeObject(json);
foreach(var item in array)
{
    Console.WriteLine("{0} {1}", item.temp, item.vcc);
}
#endregion