package sqltest.com.sqltesr;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by root on 10/22/17.
 */

public class Adapter extends BaseAdapter {
    private Context myContext;
    private List<Messages> myLists;

    public Adapter(Context myContext, List<Messages> myLists){
        this.myContext = myContext;
        this.myLists = myLists;
    }

    @Override
    public int getCount() {
        return myLists.size();
    }

    @Override
    public Object getItem(int position) {
        return myLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return myLists.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View v = View.inflate(myContext,R.layout.items,null);
        TextView Name = v.findViewById(R.id.jina);
        TextView Phone = v.findViewById(R.id.simu);
        TextView Sms = v.findViewById(R.id.meso);

        Name.setText(myLists.get(position).getName());
        Phone.setText(myLists.get(position).getPhone_number());
        Sms.setText(myLists.get(position).getSms());
        return v;
    }

}


