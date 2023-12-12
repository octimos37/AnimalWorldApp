package com.example.myapplication.MammalsOrders.Chiroptera;

import android.os.AsyncTask;

import com.example.myapplication.MammalsOrders.Carnivora.Carnivora;
import com.example.myapplication.MammalsOrders.Carnivora.CarnivoraCallback;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GetChiropteraFromApi extends AsyncTask<Void, Void, List<Chiroptera>> {
    private ChiropteraCallback callback;

    public GetChiropteraFromApi(ChiropteraCallback callback) {
        this.callback = callback;
    }

    @Override
    protected List<Chiroptera> doInBackground(Void... voids) {
        List<Chiroptera> result = new ArrayList<>();

        try {
            URL url = new URL("http://192.168.1.131/GetData/get_carnivora.php");
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
                    Chiroptera entity = new Chiroptera(id, textData, nameTV, image_path, class_id, ordo_id);
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
    protected void onPostExecute(List<Chiroptera> myDataEntities) {
        super.onPostExecute(myDataEntities);
        if (callback != null) {
            callback.onDataReceived(myDataEntities);
        }
    }
}
