package com.example.myapplication.InvertebrataOrders.Coleoptera;

import com.example.myapplication.InvertebrataOrders.Coleoptera.Coleoptera;

import java.util.List;

public interface ColeopteraCallback {
    void onDataReceived(List<Coleoptera> data);
}
