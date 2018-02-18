package hk.ust.cse.comp107x.greetfriend;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ListActivity {

    //Button greetButton;
    String[] names;
    protected static final String TAG="MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        names=getResources().getStringArray(R.array.friends);
        setListAdapter (new ArrayAdapter<String>(this,R.layout.friend_item,names));

//        setContentView(R.layout.activity_main);
//        greetButton = (Button) findViewById(R.id.greetButton);
//        greetButton.setOnClickListener(this);


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"onStart()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"onRestart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"onPause()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"onStop()");
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent in=new Intent(this,showMessage.class);
        in.putExtra("message","Good Day " + names[(int)id] + "!");
        //textMessage.setText("Good Day " + friendName + "!");
        startActivity(in);
    }

//    @Override
//    public void onClick(View v) {
//       // TextView textMessage = (TextView) findViewById(R.id.textMessage);
//        EditText editFriendName = (EditText) findViewById(R.id.editFriendName);
//        String friendName = editFriendName.getText().toString();
//        switch (v.getId()) {
//            case R.id.greetButton:
//                Intent in=new Intent(this,showMessage.class);
//                in.putExtra("message","Good Day " + friendName + "!");
//                //textMessage.setText("Good Day " + friendName + "!");
//                startActivity(in);
//                break;
//            default:
//                break;
//
//        }
//
//
//    }
}
