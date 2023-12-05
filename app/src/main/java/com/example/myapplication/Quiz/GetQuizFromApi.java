package com.example.myapplication.Quiz;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GetQuizFromApi extends AsyncTask<Void, Void, List<Quiz>> {
    private QuizCallback callback;

    public GetQuizFromApi(QuizCallback callback) {
        this.callback = callback;
    }

    @Override
    protected List<Quiz> doInBackground(Void... voids) {
        List<Quiz> result = new ArrayList<>();

        try {
            URL url = new URL("http://192.168.1.108/GetData/get_quiz.php");
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
                    String id = data.getString("IdQuiz");
                    String image = data.getString("imageQuiz");
                    String qa = data.getString("AskA");
                    String qb = data.getString("AskB");
                    String qc = data.getString("AskC");
                    String qd = data.getString("AskD");
                    String ans = data.getString("Ans");
                    Quiz entity = new Quiz(id, image, qa, qb, qc, qd, ans);
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
    protected void onPostExecute(List<Quiz> myDataEntities) {
        super.onPostExecute(myDataEntities);
        if (callback != null) {
            callback.onDataReceived(myDataEntities);
        }
    }
}
