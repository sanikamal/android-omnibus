package com.ruatech.sanikamal.welcomemessage;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class WishListActivity extends AppCompatActivity {
    EditText wishEditText;
    Button addWishButton;
    ListView wishListView;
    ArrayList<ItemList> arrayList;
    BaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_list);
        initializeAll();
    }
    private void initializeAll(){
        wishEditText=findViewById(R.id.wishListEditText);
        addWishButton=findViewById(R.id.addWishButton);
        wishListView=findViewById(R.id.wishListView);
        arrayList= new ArrayList<ItemList>();
        adapter=new BaseAdapter() {
            LayoutInflater inflater= (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            @Override
            public int getCount() {
                return arrayList.size();
            }

            @Override
            public Object getItem(int position) {
                return arrayList.get(position);
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View view, ViewGroup viewGroup) {
                if(view==null){
                    view=inflater.inflate(R.layout.wish_list_item,null);
                }
                TextView wishTextView=view.findViewById(R.id.wishListItemTextView);
                TextView dateTextView=view.findViewById(R.id.wishListDateTextView);
                wishTextView.setText(arrayList.get(position).getWish());
                Date date=arrayList.get(position).getDate();
//                dateTextView.setText(DateFormat.format("dd/MM/yy HH:mm:ss a",date));
                // TODO need some modification on DateFormat.format
                return view;
            }
        };
        wishListView.setAdapter(adapter);
        addWishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string=wishEditText.getText().toString();
                Date date=new Date();
                ItemList itemList=new ItemList(string,date);
                arrayList.add(itemList);
                adapter.notifyDataSetChanged();
                wishEditText.setText("");
                InputMethodManager inputMethodManager= (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(wishEditText.getWindowToken(),0);
                Toast.makeText(getBaseContext(),"New Wish Added To List",Toast.LENGTH_SHORT).show();
            }
        });

        wishListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                arrayList.remove(position);
                adapter.notifyDataSetChanged();
                Toast.makeText(getBaseContext(),"One Item Removed",Toast.LENGTH_SHORT).show();
                return false;
            }
        });



    }
}
