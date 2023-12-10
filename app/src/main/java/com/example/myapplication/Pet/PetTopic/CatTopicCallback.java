package com.example.myapplication.Pet.PetTopic;

import java.util.List;

public interface CatTopicCallback {
    void onDataReceived(List<CatTopic> data);
}
