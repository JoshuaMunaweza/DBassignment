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
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listData;
    private Adapter displayData;
    private List<Messages> grubData;
    private DBhandler dumpDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        listData = (ListView)findViewById(R.id.data);
        dumpDB = new DBhandler(this);

        grubData = dumpDB.getAllMessages();
        displayData = new Adapter(this, grubData);
        listData.setAdapter(displayData);

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

    }
}


