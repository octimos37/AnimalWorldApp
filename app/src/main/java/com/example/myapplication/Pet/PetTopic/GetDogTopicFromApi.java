package com.example.myapplication.Pet.PetTopic;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GetDogTopicFromApi extends AsyncTask<Void, Void, List<DogTopic>> {
    private DogTopicCallback callback;

    public GetDogTopicFromApi(DogTopicCallback callback) {
        this.callback = callback;
    }

    @Override
    protected List<DogTopic> doInBackground(Void... voids) {
        List<DogTopic> result = new ArrayList<>();

        try {
            URL url = new URL("http://192.168.1.6/GetData/get_dogtopic.php");
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
                    String id = data.getString("IdPetDetail");
                    String title = data.getString("NamePetDetailTV");
                    String image = data.getString("ImagePetDetail");
                    String des = data.getString("PetDetailDes");
                    String petId = data.getString("IdPet");
                    DogTopic entity = new DogTopic(id, title, image, des, petId);
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
    protected void onPostExecute(List<DogTopic> myDataEntities) {
        super.onPostExecute(myDataEntities);
        if (callback != null) {
            callback.onDataReceived(myDataEntities);
        }
    }
}
