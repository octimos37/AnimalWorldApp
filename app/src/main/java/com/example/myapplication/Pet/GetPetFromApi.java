package com.example.myapplication.Pet;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GetPetFromApi extends AsyncTask<Void, Void, List<Pet>> {
    private PetCallback callback;

    public GetPetFromApi(PetCallback callback) {
        this.callback = callback;
    }

    @Override
    protected List<Pet> doInBackground(Void... voids) {
        List<Pet> result = new ArrayList<>();

        try {
            URL url = new URL("http://192.168.1.6/GetData/get_pet.php");
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
                    String id = data.getString("IdPet");
                    String name = data.getString("NamePetTV");
                    String nameE = data.getString("NamePetE");
                    String image = data.getString("ImagePet");
                    Pet entity = new Pet(id, name, nameE, image);
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
    protected void onPostExecute(List<Pet> myDataEntities) {
        super.onPostExecute(myDataEntities);
        if (callback != null) {
            callback.onDataReceived(myDataEntities);
        }
    }
}
