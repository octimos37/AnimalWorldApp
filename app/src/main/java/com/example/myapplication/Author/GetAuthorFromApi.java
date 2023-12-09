package com.example.myapplication.Author;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GetAuthorFromApi extends AsyncTask<Void, Void, List<Author>> {
    private AuthorCallback callback;

    public GetAuthorFromApi(AuthorCallback callback) {
        this.callback = callback;
    }

    @Override
    protected List<Author> doInBackground(Void... voids) {
        List<Author> result = new ArrayList<>();

        try {
            URL url = new URL("http://192.168.1.4/GetData/get_author.php");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");

            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                JSONArray jsonArray = new JSONArray(response.toString());
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject data = jsonArray.getJSONObject(i);
                    String id = data.getString("id");
                    String fullName = data.getString("full_name");
                    String email = data.getString("email");
                    String phone = data.getString("Phone");
                    String image = data.getString("image");
                    Author entity = new Author(id, fullName, email, phone, image);
                    result.add(entity);
                }
            }
            httpURLConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    protected void onPostExecute(List<Author> myDataEntities) {
        super.onPostExecute(myDataEntities);
        if (callback != null) {
            callback.onDataReceived(myDataEntities);
        }
    }
}
