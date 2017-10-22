package sqltest.com.sqltesr;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;
import static java.lang.Integer.parseInt;

/**
 * Created by root on 10/19/17.
 */

public class DBhandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "contactManager";

    private static final String TABLE_CONTACTS = "contacts";
    private static final String TABLE_MESSAGES = "messages";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PH_N0 = "phone_number";

    private static final String KEY_SMS = "sms";

    private static final String CREATE_TABLE_CONTACTS = "CREATE TABLE "
            + TABLE_CONTACTS + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME
            + " TEXT," + KEY_PH_N0 + " TEXT" + ")";


    private static final String CREATE_TABLE_MESSAGES = "CREATE TABLE "
            + TABLE_MESSAGES + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME
            + " TEXT," + KEY_PH_N0 + " TEXT," + KEY_SMS
            + " TEXT" + ")";

    public DBhandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(CREATE_TABLE_CONTACTS);
        sqLiteDatabase.execSQL(CREATE_TABLE_MESSAGES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_MESSAGES);
        onCreate(sqLiteDatabase);
    }

    public void addContact(Contacts contacts) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contacts.getName());
        values.put(KEY_PH_N0, contacts.getPhone_number());

        sqLiteDatabase.insert(TABLE_CONTACTS, null, values);
        sqLiteDatabase.close();
    }

    public void addMessage(Messages messages) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, messages.getName());
        values.put(KEY_PH_N0, messages.getPhone_number());
        values.put(KEY_SMS, messages.getSms());

        sqLiteDatabase.insert(TABLE_MESSAGES, null, values);
        sqLiteDatabase.close();
    }

    public Contacts getContact(int id) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS, new String[]{KEY_ID, KEY_NAME, KEY_PH_N0}, KEY_ID + "+?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();


        Contacts contacts = new Contacts(parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));

        return contacts;
    }
    public Messages getMessage(int id) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_MESSAGES, new String[]{KEY_ID, KEY_NAME, KEY_PH_N0, KEY_SMS}, KEY_ID + "+?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();


        Messages messages = new Messages(parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3));

        return messages;
    }

    public List<Contacts> getAllContacts() {
        List<Contacts> contactsList = new ArrayList<Contacts>();

        String selectQuery = "SELECT * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Contacts contacts = new Contacts();
                contacts.setId(Integer.parseInt(cursor.getString(0)));
                contacts.setName(cursor.getString(1));
                contacts.setPhone_number(cursor.getString(2));

                contactsList.add(contacts);
            } while (cursor.moveToNext());
        }
        return contactsList;
    }

    public List<Messages> getAllMessages() {
        List<Messages> messagesList = new ArrayList<Messages>();

        String selectQuery = "SELECT * FROM " + TABLE_MESSAGES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Messages messages = new Messages();
                messages.setId(Integer.parseInt(cursor.getString(0)));
                messages.setName(cursor.getString(1));
                messages.setPhone_number(cursor.getString(2));
                messages.setSms(cursor.getString(3));

                messagesList.add(messages);
            } while (cursor.moveToNext());
        }
        return messagesList;
    }

    public int getContactsCount() {
        String countQuery = "SELECT * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }

    public int getMessagesCount() {
        String countQuery = "SELECT * FROM " + TABLE_MESSAGES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }
    public int updateContact(Contacts contacts) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contacts.getName());
        values.put(KEY_PH_N0, contacts.getPhone_number());

        return db.update(TABLE_CONTACTS, values, KEY_ID + "-?", new String[]{String.valueOf(contacts.getId())});
    }

    public int updateMessages(Messages messages) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, messages.getName());
        values.put(KEY_PH_N0, messages.getPhone_number());
        values.put(KEY_SMS, messages.getSms());

        return db.update(TABLE_MESSAGES, values, KEY_ID + "-?", new String[]{String.valueOf(messages.getId())});
    }

    public void deleteContact(Contacts contacts) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID + "= ?", new String[]{String.valueOf(contacts.getId())});

        db.close();
    }

    public void deleteMessages(Messages messages) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_MESSAGES, KEY_ID + "= ?", new String[]{String.valueOf(messages.getId())});

        db.close();
    }
}


