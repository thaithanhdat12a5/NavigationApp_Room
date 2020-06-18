package vn.edu.ntu.thanhdat.navigationapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import vn.edu.ntu.thanhdat.controller.CartControllerBD;
import vn.edu.ntu.thanhdat.controller.ICartController;
import vn.edu.ntu.thanhdat.model.Product;

public class ListProductFragment extends Fragment implements View.OnClickListener{

    FloatingActionButton fab;
    RecyclerView rvListProduct;
    NavController controller;
    ICartController cartController;
    List<Product> listProduct;
    ProductAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull final Menu menu, @NonNull final MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.mnu_cart, menu);
        MenuItem mnuCart = menu.findItem(R.id.mnuCart);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnuCart: controller.navigate(R.id.action_listProductFragment_to_cartFragment);
                                return true;
            default: return super.onOptionsItemSelected(item);
        }
    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cartController = ((MainActivity)getActivity()).cartController;
        controller = NavHostFragment.findNavController(ListProductFragment.this);
        ((MainActivity) getActivity()).controller = controller;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.navigate(R.id.action_listProductFragment_to_importProductFragment);
            }
        });
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.list_product, container, false);
        rvListProduct = view.findViewById(R.id.rvListProduct);
        fab = view.findViewById(R.id.fab);
        rvListProduct.setLayoutManager(new LinearLayoutManager(getActivity()));
        cartController = ((MainActivity)getActivity()).cartController;
        listProduct = cartController.getListProduct();
        adapter = new ProductAdapter(listProduct);
        rvListProduct.setAdapter(adapter);
        return view;
    }



    private class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView txtName, txtPrice, txtDescription;
        ImageButton imgAddCart;
        Product product;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = this.itemView.findViewById(R.id.txtName);
            txtPrice = this.itemView.findViewById(R.id.txtPrice);
            txtDescription = this.itemView.findViewById(R.id.txtDesc);
            imgAddCart = this.itemView.findViewById(R.id.imageBtn);
            imgAddCart.setOnClickListener(this);
        }

        public void bind(Product product) {
            txtName.setText(product.getName());
            txtPrice.setText(new Integer(product.getPrice()).toString());
            txtDescription.setText(product.getDescription());
            imgAddCart.setImageResource(R.drawable.ic_action_name);
            this.product = product;
        }

        @Override
        public void onClick(View v) {
            if (!cartController.addToCart(product)) {
                Toast.makeText(getActivity(), "product " + product.getName() + " is added", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(getActivity(), "product "+product.getName()+" is added in the past", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {

        List<Product> listProduct;

        public ProductAdapter(List<Product> listProduct) {
            this.listProduct = listProduct;
        }

        @NonNull
        @Override
        public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = getLayoutInflater();
            View view = layoutInflater.inflate(R.layout.product_item, parent, false);
            return new ProductViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
            holder.bind(listProduct.get(position));
        }

        @Override
        public int getItemCount() {
            return listProduct.size();
        }
    }

    @Override
    public void onClick(View v) {

    }
}
