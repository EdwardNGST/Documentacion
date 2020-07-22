package com.example.alan_.sbgb.models.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.StringRes;
import android.util.Log;
import android.widget.Toast;
import com.example.alan_.sbgb.MainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alan_ on 01/11/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String library_itcg = "library_itcg2.db"; //Nombre de la base de datos (el archivo)

    //Estas clases guardan cada una de las caracteristicas de las tablas de la base de datos
    tableCareers career = new tableCareers();
    tableUsers users = new tableUsers();
    tableGenres genres = new tableGenres();
    tableBooks books = new tableBooks();
    tableAccounts accounts = new tableAccounts();
    tableSearch search = new tableSearch();

    //Esta clase guarda las consultas mas comunes a la BD
    QueryHelper query = new QueryHelper();

    //Este constructor es totalmente necesario al crear la base de datos
    public DatabaseHelper(Context context) {
        super(context, library_itcg, null, 1);
    }

    //Al crear la base de datos se crean las tablas tambien (El metodo oncreate sirve para ejecutar comandos en el momento en el que se crea la DB)
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(accounts.getStringQuery());
        db.execSQL(books.getStringQuery());
        db.execSQL(genres.getStringQuery());
        db.execSQL(search .getStringQuery());
        db.execSQL(users.getStringQuery());
        db.execSQL(career.getStringQuery());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+users.getTableName());
        db.execSQL("DROP TABLE IF EXISTS "+search.getTableName());
        db.execSQL("DROP TABLE IF EXISTS "+books.getTableName());
        db.execSQL("DROP TABLE IF EXISTS "+books.getTableName());
        db.execSQL("DROP TABLE IF EXISTS "+accounts.getTableName());
        db.execSQL("DROP TABLE IF EXISTS "+career.getTableName());
        onCreate(db);
    }

    //Estos comandos podrian servir para verificar la existencia de algun registro en la DB, en este caso se valida si un usuario existe
    public boolean loginUser(String userName, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT id FROM table WHERE user="+userName+" AND pass="+password+";",null);

        if (res.moveToFirst() == true){
            return true;
        }else{
            return false;
        }
    }

    //Con este metodo se eliminaron todos los datos de cada una de las tablas
    public void truncateTable(String tableName){
        SQLiteDatabase db = this.getWritableDatabase();
        String query="";
        if(tableName=="accounts"){
            query="DELETE FROM "+accounts.getTableName()+";";
        }else if(tableName=="books"){
            query="DELETE FROM "+books.getTableName()+";";
        }else if(tableName=="genres"){
            query="DELETE FROM "+genres.getTableName()+";";
        }else if(tableName=="search"){
            query="DELETE FROM "+search.getTableName()+";";
        }else if(tableName=="users"){
            query="DELETE FROM "+users.getTableName()+";";
        }else if(tableName=="career"){
            query="DELETE FROM "+career.getTableName()+";";
        }
        db.execSQL(query);
        db.execSQL("VACUUM;");
    }

    //Este metodo sirve para eliminar un registro, primero se busca para ver si en realidad existe
    public String deleteBooks(String codeBook){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT "+books.getCodeBook()+" FROM "+books.getTableName()+" WHERE "+books.getCodeBook()+"='"+codeBook+"';",null);
        if (res.moveToFirst() == false){
            return "Este libro ya no existe";
        }else{
            db.execSQL("DELETE FROM "+books.getTableName()+" WHERE "+books.getCodeBook()+"='"+codeBook+"';");
            return "Libro eliminado correctamente";
        }
    }

    //Con esto se reinician todas las tablas
    public void deleteTables(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS "+users.getTableName());
        db.execSQL("DROP TABLE IF EXISTS "+search.getTableName());
        db.execSQL("DROP TABLE IF EXISTS "+books.getTableName());
        db.execSQL("DROP TABLE IF EXISTS "+books.getTableName());
        db.execSQL("DROP TABLE IF EXISTS "+accounts.getTableName());
        db.execSQL("DROP TABLE IF EXISTS "+career.getTableName());
        onCreate(db);
    }

    //Este metodo puede servirnos para agregar un registro a la DB
    public String newUser(String username, String email, String password, String typeUser, String name, String lastName, String semester, String career){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery(query.searchUser(username),null);
        if (res.moveToFirst() == true){
            return "El usuario ya existe";
        }else{
            ContentValues contentAccount = new ContentValues();
            contentAccount.put(accounts.getUsername(), username);
            contentAccount.put(accounts.getEmail(), email);
            contentAccount.put(accounts.getPassword(), password);
            contentAccount.put(accounts.getTypeUser(), typeUser);
            long idAccount = db.insert(accounts.getTableName(),null ,contentAccount);

            ContentValues contentUser = new ContentValues();
            contentUser.put(users.getNC(), idAccount);
            contentUser.put(users.getName(), name);
            contentUser.put(users.getLastName(), lastName);
            contentUser.put(users.getSemester(), semester);
            contentUser.put(users.getCareer(), career);
            db.insert(accounts.getTableName(),null ,contentUser);

            if(idAccount<=0){
                return "El usuario no se ha podido registrar";
            }else{
                return "Usuario Registrado";
            }
        }
    }

    //Este metodo nos puede servir para crear una lista de registros para mostrarlos despues
    public List getCareers(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+career.getTableName(),null);
        List careers = new ArrayList();
        careers.add("Seleccione su carrera");
        for(res.moveToFirst(); !res.isAfterLast(); res.moveToNext()){
            careers.add(res.getString(1));
        }
        return careers;
    }

    //Esto nos devuelve un cursor(tabla) de los registros obtenidos
    public Cursor getTables(String action) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res=null;
        if(action=="genres"){
            res = db.rawQuery("SELECT * FROM " + genres.getTableName()+";", null);
        }
        return res;
    }
}
