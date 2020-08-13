//Declaramos la variable
Button btnMiFuncion;
//Asignamos un valor
btnMiFuncion = (Button)findViewById(R.id.buttonMiFuncion);
//Funcion que se ejecutara al presionar el botón
        btnMiFuncion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), com.example.alan_.sbgb.activities.users.new_user.class);//Aqui ponen la ruta de su layout al que quieren ir
                startActivityForResult(intent, 0);
            }
        });