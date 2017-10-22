package sqltest.com.sqltesr;

/**
 * Created by root on 10/22/17.
 */

public class Messages {

    int _id;
    String name;
    String sms;
    String _phone_number;

    public Messages(int id, String sms, String name, String _phone_number){
        this._id = id;
        this.sms = sms;
        this._phone_number = _phone_number;
        this.name = name;
    }

    public Messages(String sms, String name, String _phone_number){
        this.sms = sms;
        this._phone_number = _phone_number;
        this.name = name;
    }

    public Messages(){

    }

    public int getId() {
        return this._id;
    }
    public void setId(int id){
        this._id = id;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getPhone_number(){
        return this._phone_number;
    }
    public void setPhone_number(String phone_number){
        this._phone_number = phone_number;
    }
    public String getSms(){
        return this.sms;
    }
    public void setSms(String sms){
        this.sms = sms;
    }
}


