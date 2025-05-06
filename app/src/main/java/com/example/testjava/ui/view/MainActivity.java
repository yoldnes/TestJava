package com.example.testjava.ui.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.testjava.databinding.ActivityMainBinding;
import com.example.testjava.ui.adapter.CustomerAdapter;
import com.example.testjava.ui.viewmodel.CustomerViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private CustomerAdapter adapter;
    private CustomerViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(CustomerViewModel.class);
        adapter = new CustomerAdapter(this);
        setRecyclerView();

        viewModel.getCustomers().observe(this, clientes -> {
            adapter.setCustomerList(clientes);
        });
        initView();
    }

    private void setRecyclerView() {
        binding.recyclerViewClientes.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerViewClientes.setAdapter(adapter);
    }

    private void initView() {
        binding.btnFiltrarVisitados.setOnClickListener(v -> viewModel.filterVisited(true));
        binding.btnFiltrarNoVisitados.setOnClickListener(v -> viewModel.filterVisited(false));
        binding.btnOrdenarCodigo.setOnClickListener(v -> viewModel.orderByCode());
        binding.btnOrdenarNombre.setOnClickListener(v -> viewModel.orderByName());
        binding.btnAllUser.setOnClickListener(v -> viewModel.allUser());
    }
}