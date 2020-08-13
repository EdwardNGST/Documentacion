//Para recorrer un ArrayList lo primero será crear un ArrayList.

ArrayList<String> al = new ArrayList<String>();

//Insertar elementos

al.add("Victor");
al.add("Luis");
al.add("Elena");

//Ahora vamos a recorrer un ArrayList como si fuese un array. Para ello tenemos que obtener el tamaño de un ArrayList mediante el método .size().

int size=al.size();

//Y ahora utilizaremos un bucle for para recorrer un ArrayList.

for(int x=0;x<al.size();x++) {
  System.out.println(al.get(x));
}