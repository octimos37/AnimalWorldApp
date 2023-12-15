package com.example.myapplication.MammalsOrders.Carnivora;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GetCarnivoraFromApi extends AsyncTask<Void, Void, List<Carnivora>> {
    private CarnivoraCallback callback;

    public GetCarnivoraFromApi(CarnivoraCallback callback) {
        this.callback = callback;
    }

    @Override
    protected List<Carnivora> doInBackground(Void... voids) {
        List<Carnivora> result = new ArrayList<>();

        try {
            URL url = new URL("http://192.168.1.119/GetData/get_carnivora.php");
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
                    String id = data.getString("FamilyID");
                    String textData = data.getString("FamilyNameE");
                    String nameTV = data.getString("FamilyNameTV");
                    String image_path = data.getString("imagesFamyli");
                    String class_id = data.getString("DescriptionFamily");
                    String ordo_id = data.getString("OrdoID");
                    Carnivora entity = new Carnivora(id, textData, nameTV, image_path, class_id, ordo_id);
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
    protected void onPostExecute(List<Carnivora> myDataEntities) {
        super.onPostExecute(myDataEntities);
        if (callback != null) {
            callback.onDataReceived(myDataEntities);
        }
    }
}
