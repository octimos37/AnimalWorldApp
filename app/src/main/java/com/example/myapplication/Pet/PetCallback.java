package com.example.myapplication.Pet;


import java.util.List;

public interface PetCallback {
    void onDataReceived(List<Pet> data);
}
