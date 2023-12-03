package com.example.myapplication.Quiz;


import java.util.List;

public interface QuizCallback {
    void onDataReceived(List<Quiz> data);
}
