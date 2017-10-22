package sqltest.com.sqltesr;

/**
 * Created by root on 10/19/17.
 */

public class Contacts {

    int _id;
    String _name;
    String _phone_number;

    public Contacts(int id, String name,String _phone_number){
        this._id = id;
        this._name = name;
        this._phone_number = _phone_number;
    }

    public Contacts(String name,String _phone_number){
        this._name = name;
        this._phone_number = _phone_number;
    }

    public Contacts(){

    }

    public int getId() {
        return this._id;
    }
    public void setId(int id){
        this._id = id;
    }

    public String getName() {
        return this._name;
    }
    public void setName(String name){
        this._name = name;
    }
    public String getPhone_number(){
        return this._phone_number;
    }
    public void setPhone_number(String phone_number){
        this._phone_number = phone_number;
    }


}
