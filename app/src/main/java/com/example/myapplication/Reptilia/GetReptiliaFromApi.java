package com.example.myapplication.Reptilia;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GetReptiliaFromApi extends AsyncTask<Void, Void, List<Reptilia>> {
    private ReptiliaCallback callback;

    public GetReptiliaFromApi(ReptiliaCallback callback) {
        this.callback = callback;
    }

    @Override
    protected List<Reptilia> doInBackground(Void... voids) {
        List<Reptilia> result = new ArrayList<>();

        try {
            URL url = new URL("http://192.168.1.4/GetData/get_reptilia.php");
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
                    String id = data.getString("OrdoID");
                    String textData = data.getString("OrdoNameE");
                    String image_path = data.getString("ImageOrdo");
                    String class_id = data.getString("ClassID");
                    Reptilia entity = new Reptilia(id, textData, image_path, class_id);
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
    protected void onPostExecute(List<Reptilia> myDataEntities) {
        super.onPostExecute(myDataEntities);
        if (callback != null) {
            callback.onDataReceived(myDataEntities);
        }
    }
}
