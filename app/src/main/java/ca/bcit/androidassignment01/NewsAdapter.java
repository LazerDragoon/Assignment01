package ca.bcit.androidassignment01;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class NewsAdapter extends ArrayAdapter<News> {
    Context _context;
    public NewsAdapter(Context context, ArrayList<News> news) {
        super(context, 0, news);
        _context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Activity activity = (Activity) _context;
        // Get the data item for this position
        News news = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_row_layout, parent, false);
        }

        // Lookup view for data population
        TextView tvFullName = convertView.findViewById(R.id.fullName);
        TextView tvOccupation = convertView.findViewById(R.id.occupation);
        TextView tvGender = convertView.findViewById(R.id.gender);

        // Populate the data into the template view using the data object
        tvFullName.setText(String.format("%s %s", news.getFirstName(), news.getLastName()));
        tvOccupation.setText(news.getOccupation());
        tvGender.setText(news.getGender());

        ImageView imgOnePhoto = convertView.findViewById(R.id.thumbImage);
        if (news.getPictureUrl() != null) {
            new ImageDownloaderTask(imgOnePhoto).execute(news.getPictureUrl());
        }

        // Return the completed view to render on screen
        return convertView;
    }
}
