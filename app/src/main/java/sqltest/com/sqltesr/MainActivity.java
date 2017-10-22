package sqltest.com.sqltesr;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBhandler db = new DBhandler(this);

        Log.d("Insert: ", "Inserting....");
        db.addContact(new Contacts("Joshua", "9100000000"));
        db.addContact(new Contacts("John", "9200000000"));
        db.addContact(new Contacts("Kelvo", "9200000000"));
        db.addContact(new Contacts("Kieth", "9400000000"));

        db.addMessage(new Messages("Nisignie class ya Mobile App", "9100000000", "Joshua"));
        db.addMessage(new Messages("Sawa brathe!", "9200000000", "Kelvo"));
        db.addMessage(new Messages("Yo niko online on FIFA", "9400000000", "Kieth"));
        db.addMessage(new Messages("Cheki msee achana na huyo dem", "9200000000", "John"));

        List<Contacts> contacts = db.getAllContacts();
        Log.d("Reading: ", "Reading all contacts...");

        List<Messages> messages = db.getAllMessages();
        Log.d("Reading: ", "Reading all messages...");

        for (Contacts cn : contacts) {
            String log = "id: " + cn.getId() + ",Name: " + cn.getName() + " ,Phone: " + cn.getPhone_number();

            Log.d("contacts ", log);
        }

        for (Messages cn : messages) {
            String log = "id: " + cn.getId() + ",Phone: " + cn.getName() + " ,From: " + cn.getPhone_number() + " ,Message: " + cn.getSms();

            Log.d("messages ", log);
        }


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
