package ca.bcit.androidassignment01;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();
    private ListView lv;
    // URL to get contacts JSON
    private static String API_KEY = "3d9e72c25bd8445882533b8d5bdcae45";
    private static String SERVICE_URL; //= "https://newsapi.org/v2/everything?q=" + searchWord +"&from=2019-12-28&sortBy=publishedAt&apiKey=3d9e72c25bd8445882533b8d5bdcae45";
    private ArrayList<News> newsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newsList = new ArrayList<News>();
        lv = findViewById(R.id.newsList);
        new GetContacts().execute();
        String key = "Bitcoin";
        String date = "2020-02-06";
        SERVICE_URL = String.format("https://newsapi.org/v2/everything?q=%s&from=%s&sortBy=publishedAt&apiKey=%s ",
                key, date, API_KEY);
    }

    /**
     * Async task class to get json by making HTTP call
     */
    private class GetContacts extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            String jsonStr = null;

            // Making a request to url and getting response
            jsonStr = sh.makeServiceCall(SERVICE_URL);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                Log.d(TAG, "Json: " + jsonStr);
                // this step is needed to wrap the JSON array inside
                // a JSON object that looks like this { "toons": . . . . }
                // this is not needed any  louis said so!! jsonStr = "{\"toons\":" + jsonStr + "}";
                Gson gson = new Gson();
                BaseNews baseToon = gson.fromJson(jsonStr, BaseNews.class);
                newsList = baseToon.getNews();
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            NewsAdapter adapter = new NewsAdapter(MainActivity.this, newsList);

            // Attach the adapter to a ListView
            lv.setAdapter(adapter);
        }
    }

}
