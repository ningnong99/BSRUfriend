package bsru.junpukdee.sutin.bsrufriend;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

/**
 * Created by NongDay on 2/17/2017.
 */

public class FriendAdapter extends BaseAdapter{

    private Context context;
    private String[] iconStrings, nameStrings;
    private TextView textView;
    private ImageView imageView;

    public FriendAdapter(Context context,
                         String[] iconStrings,
                         String[] nameStrings) {
        this.context = context;
        this.iconStrings = iconStrings;
        this.nameStrings = nameStrings;
    }

    @Override
    public int getCount() {
        return iconStrings.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.my_listview, parent, false);

        //Bind Widget
        textView = (TextView)view.findViewById(R.id.textView3);
        imageView = (ImageView) view.findViewById(R.id.imageView11);

        //Show View
        textView.setText(nameStrings[position]);
        Picasso.with(context).load(iconStrings[position]).into(imageView);

        Log.d("17febV4", "name(" + position + ") ==> "+ nameStrings[position]);
        Log.d("17febV4", "image(" + position + ") ==> "+ iconStrings[position]);


        return view;
    }
}   //Main Class
