package com.example.unext;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListuNextAdapter extends ArrayAdapter<CaruNextItem> {

    private Context context;
    private List<CaruNextItem> items;

    public ListuNextAdapter(@NonNull Context context,List<CaruNextItem> items) {
        super(context, R.layout.layout_line, items);
        this.context = context;
        this.items=items;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.layout_line, parent, false);

        ImageView imageuNext = rowView.findViewById(R.id.image_uNext_list);
        TextView textDescription = rowView.findViewById(R.id.text_description_uNext_list);
        TextView textLocal = rowView.findViewById(R.id.text_location_uNext_list);

        imageuNext.setImageResource(items.get(position).getImageId());
        textDescription.setText(items.get(position).getDescription());
        textLocal.setText(items.get(position).getValue());

        return rowView;


    }
}
