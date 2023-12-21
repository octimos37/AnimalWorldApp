package com.example.myapplication.CrocodyliaFamilies.Crocodylidae;

import android.os.AsyncTask;

import com.example.myapplication.CrocodyliaFamilies.Crocodylidae.Crocodylidae;
import com.example.myapplication.CrocodyliaFamilies.Crocodylidae.CrocodylidaeCallback;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GetCrocodylidaeFromApi extends AsyncTask<Void, Void, List<Crocodylidae>> {
    private CrocodylidaeCallback callback;

    public GetCrocodylidaeFromApi(CrocodylidaeCallback callback) {
        this.callback = callback;
    }

    @Override
    protected List<Crocodylidae> doInBackground(Void... voids) {
        List<Crocodylidae> result = new ArrayList<>();

        try {
            URL url = new URL("http://192.168.1.6/GetData/get_crocodylidae.php");
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
                    Crocodylidae entity = new Crocodylidae(id, textData,image_path, description, AnimalVideo, iFact, info);
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
    protected void onPostExecute(List<Crocodylidae> myDataEntities) {
        super.onPostExecute(myDataEntities);
        if (callback != null) {
            callback.onDataReceived(myDataEntities);
        }
    }
}
