package assignment.android.acadgild.person_database;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import assignment.android.acadglid.DataObject.Person;

/**
 * Created by DivyaVipin on 1/10/2017.
 */

public class CustomAdapter extends BaseAdapter {
    Context c;

    public CustomAdapter(Context c, ArrayList<Person> persons) {
        this.c = c;
        this.persons = persons;

    }

    ArrayList<Person> persons;
    LayoutInflater inflater;

    @Override
    public int getCount() {
        return persons.size();
    }

    @Override
    public Object getItem(int i) {
        return persons.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(inflater==null)
        {
            inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(view==null)
        {
            view=inflater.inflate(R.layout.model,viewGroup,false);
        }
        TextView IdTxt= (TextView)view.findViewById(R.id.IdText);
        Integer a=persons.get(i).getId();
        String id=a.toString();
        IdTxt.setText(id);
        TextView firstNameTxt= (TextView)view.findViewById(R.id.FirstnameText2);
        firstNameTxt.setText(persons.get(i).getFirst_name());
        TextView lastNameTxt= (TextView)view.findViewById(R.id.LastNameText2);
        lastNameTxt.setText(persons.get(i).getLast_name());
        return view;
    }


}
