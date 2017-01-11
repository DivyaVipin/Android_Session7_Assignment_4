package assignment.android.acadgild.person_database;

import android.app.Dialog;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import assignment.android.acadglid.DataObject.Person;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    Button btnSave;
    CustomAdapter adapter;
    ArrayList<Person> persons=new ArrayList<>();
    EditText firstName;
    EditText lastName;
    Dialog d;
    DBAdapter db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.listViewNames);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.btnAdd);
        db=new DBAdapter(MainActivity.this);
        db.openDB();
        adapter=new CustomAdapter(this,persons);
        getPersons();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 d=new Dialog(MainActivity.this);
                d.setTitle("Insert Data");
                d.setContentView(R.layout.dialog_layout);
                firstName= (EditText) d.findViewById(R.id.editTextFst);
                lastName=(EditText) d.findViewById(R.id.editTextLastname);
                btnSave=(Button)d.findViewById(R.id.saveBtn);
                d.show();
                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        db.add(firstName.getText().toString(),lastName.getText().toString()) ;

                        d.dismiss();
                        getPersons();
                    }
                });
            }
        });



    }
    private void getPersons()
    {
        persons.clear();
        Person p=null;
        Cursor c=db.retrieve();
        while (c.moveToNext())
        {
            int id=c.getInt(0);
            String firstname=c.getString(1);
            String lastname=c.getString(2);
            p=new Person();
            p.setId(id);
            p.setFirst_name(firstname);
            p.setLast_name(lastname);

            persons.add(p);
        }
        lv.setAdapter(adapter);

    }



}
