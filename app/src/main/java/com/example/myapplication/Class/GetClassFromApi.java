package com.example.myapplication.Class;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GetClassFromApi extends AsyncTask<Void, Void, List<Class>> {
    private ClassCallback callback;

    public GetClassFromApi(ClassCallback callback) {
        this.callback = callback;
    }

    @Override
    protected List<Class> doInBackground(Void... voids) {
        List<Class> result = new ArrayList<>();

        try {
            URL url = new URL("http://192.168.1.4/GetData/get_class.php");
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
                    String id = data.getString("idclas");
                    //String textData = data.getString("FamilyNameTV");
                    String image_path = data.getString("ImageClass");
                    String des = data.getString("descriptionClass");
                    Class entity = new Class(id, image_path, des);
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
    protected void onPostExecute(List<Class> myDataEntities) {
        super.onPostExecute(myDataEntities);
        if (callback != null) {
            callback.onDataReceived(myDataEntities);
        }
    }
}
