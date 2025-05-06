package com.example.testjava.domain;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.testjava.data.model.Customer;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class CustomerRepository {

    private final MutableLiveData<List<Customer>> customersLiveData = new MutableLiveData<>();

    @Inject
    public CustomerRepository() {}

    public LiveData<List<Customer>> getCustomers() {
        loadingCustomers();
        return customersLiveData;
    }

    private void loadingCustomers() {
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            List<Customer> clienteList = new ArrayList<>();
            clienteList.add(new Customer("001", "Juan Pérez", "5551234567", "juan@mail.com", true));
            clienteList.add(new Customer("002", "Ana Gómez", "5559876543", "ana@mail.com", false));
            clienteList.add(new Customer("003", "Carlos López", "5550001234", "carlos@mail.com", true));
            clienteList.add(new Customer("004", "Juan Pérez", "5551234567", "juan@mail.com", true));
            clienteList.add(new Customer("005", "Ana Gómez", "5559876543", "ana@mail.com", false));
            clienteList.add(new Customer("006", "Carlos López", "5550001234", "carlos@mail.com", true));
            customersLiveData.setValue(clienteList);
        }, 2000);
    }
}