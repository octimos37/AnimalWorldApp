package com.example.myapplication.Pet.PetTopic;


import java.util.List;

public interface DogTopicCallback {
    void onDataReceived(List<DogTopic> data);
}
