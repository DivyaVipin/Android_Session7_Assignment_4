package assignment.android.acadgild.person_database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by DivyaVipin on 1/10/2017.
 */

public class DBAdapter {
    Context c;
    SQLiteDatabase db;
    DBHelper helper;
    public DBAdapter(Context c) {
        this.c = c;
        helper=new DBHelper(c);
    }

    //OPEN DB
    public void openDB()
    {
        try
        {
            db=helper.getWritableDatabase();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //CLOSE
    public void closeDB()
    {
        try
        {
            helper.close();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    //INSERT DATA
    public boolean add(String firstname,String lastname)
    {
        try
        {
            ContentValues cv=new ContentValues();
            cv.put(Constants.FIRSTNAME,firstname);
            cv.put(Constants.LASTNAME,lastname);
            db.insert(Constants.TB_NAME,null, cv);//If inserted return long value

            return true;

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }
    //RETRIEVE DATA AND FILTER
    public Cursor retrieve()
    {
        String[] columns={Constants.ROW_ID,Constants.FIRSTNAME,Constants.LASTNAME};
        Cursor c=null;
        c=db.query(Constants.TB_NAME,columns,null,null,null,null,null);
        return c;
    }


}
