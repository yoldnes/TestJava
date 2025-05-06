package com.example.testjava.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.testjava.data.model.Customer;
import com.example.testjava.domain.CustomerRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class CustomerViewModel extends ViewModel {

    private final MutableLiveData<List<Customer>> customers = new MutableLiveData<>(new ArrayList<>());
    private List<Customer> clienteList = new ArrayList<>();

    @Inject
    public CustomerViewModel(CustomerRepository repository) {
        repository.getCustomers().observeForever(lista -> {
            clienteList = lista;
            customers.setValue(new ArrayList<>(clienteList));
        });
    }

    public LiveData<List<Customer>> getCustomers() {
        return customers;
    }

    public void allUser() {
        customers.setValue(clienteList);
    }

    public void filterVisited(boolean visited) {
        List<Customer> filter = new ArrayList<>();
        for (Customer c : clienteList) {
            if (c.isVisited() == visited) {
                filter.add(c);
            }
        }
        customers.setValue(filter);
    }

    public void orderByCode() {
        List<Customer> sortedList = new ArrayList<>(customers.getValue());
        Collections.sort(sortedList, Comparator.comparing(Customer::getId));
        customers.setValue(sortedList);
    }

    public void orderByName() {
        List<Customer> sortedList = new ArrayList<>(customers.getValue());
        Collections.sort(sortedList, Comparator.comparing(Customer::getName));
        customers.setValue(sortedList);
    }
}
