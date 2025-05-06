package com.example.testjava.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testjava.data.model.Customer;
import com.example.testjava.databinding.LayoutItemBinding;
import java.util.ArrayList;
import java.util.List;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder> {

    private final Context context;
    private List<Customer> customerList = new ArrayList<>();

    public CustomerAdapter(Context context) {
        this.context = context;
    }

    public void setCustomerList(List<Customer> customers) {
        this.customerList = customers;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        LayoutItemBinding binding = LayoutItemBinding.inflate(inflater, parent, false);
        return new CustomerViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerViewHolder holder, int position) {
        Customer customer = customerList.get(position);
        holder.bind(customer);
    }

    @Override
    public int getItemCount() {
        return customerList.size();
    }

    class CustomerViewHolder extends RecyclerView.ViewHolder {
        private final LayoutItemBinding binding;

        public CustomerViewHolder(LayoutItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Customer customer) {
            binding.codigoTextView.setText(customer.getId());
            binding.nombreTextView.setText(customer.getName());
            binding.telefonoTextView.setText(customer.getPhone());
            binding.emailTextView.setText(customer.getEmail());
            binding.visitadoTextView.setText(customer.isVisited() ? "Visitado" : "No Visitado");

            binding.telefonoTextView.setOnClickListener(v -> {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + customer.getPhone()));
                context.startActivity(intent);
            });
        }
    }
}