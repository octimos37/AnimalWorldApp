package com.example.myapplication.TestudinesFamilies.Testudinidae;

import android.os.AsyncTask;

import com.example.myapplication.TestudinesFamilies.Testudinidae.Testudinidae;
import com.example.myapplication.TestudinesFamilies.Testudinidae.TestudinidaeCallback;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GetTestudinidaeFromApi extends AsyncTask<Void, Void, List<Testudinidae>> {
    private TestudinidaeCallback callback;

    public GetTestudinidaeFromApi(TestudinidaeCallback callback) {
        this.callback = callback;
    }

    @Override
    protected List<Testudinidae> doInBackground(Void... voids) {
        List<Testudinidae> result = new ArrayList<>();

        try {
            URL url = new URL("http://192.168.1.6/GetData/get_testudinidae.php");
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
                    String textData = data.getString("title");
                    String image_path = data.getString("Speciesimage");
                    String description = data.getString("description");
                    String AnimalVideo = data.getString("AnimalVideo");
                    String iFact = data.getString("iFact");
                    String info = data.getString("ReferenceLink");
                    Testudinidae entity = new Testudinidae(id, textData,image_path, description, AnimalVideo, iFact, info);
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
    protected void onPostExecute(List<Testudinidae> myDataEntities) {
        super.onPostExecute(myDataEntities);
        if (callback != null) {
            callback.onDataReceived(myDataEntities);
        }
    }
}
