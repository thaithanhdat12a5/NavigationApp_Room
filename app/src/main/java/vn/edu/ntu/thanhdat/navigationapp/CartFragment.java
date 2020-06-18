package vn.edu.ntu.thanhdat.navigationapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import java.util.List;

import vn.edu.ntu.thanhdat.controller.ICartController;
import vn.edu.ntu.thanhdat.model.Product;

public class CartFragment extends Fragment {

    TextView txtCartInfo;
    Button btnOrder, btnDeleteCart;
    NavController controller;

    ICartController cartController;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        cartController =((MainActivity)getActivity()).cartController;
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.cart_product, container, false);
        txtCartInfo = view.findViewById(R.id.txtCartInfo);
        btnOrder = view.findViewById(R.id.btnOrder);
        btnDeleteCart = view.findViewById(R.id.btnDeleteCart);
        viewCartInfo();
        return view;

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /*view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(CartFragment.this)
                        .navigate(R.id.action_listProductFragment_to_cartFragment);
            }
        });*/
        btnOrder = view.findViewById(R.id.btnOrder);
        controller = NavHostFragment.findNavController(CartFragment.this);
        ((MainActivity) getActivity()).controller = controller;
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.navigate(R.id.action_cartFragment_to_confirmFragment);
            }
        });
        btnDeleteCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartController.clearCart();
                txtCartInfo.setText("Bạn đã xóa sảm phẩm");
            }
        });
    }

    private void viewCartInfo() {

        List<Product> listProduct = cartController.getCart();
        StringBuilder builder = new StringBuilder();
        for(Product product: listProduct) {
            builder.append(product.getName()+" "+product.getPrice()+"vnd\n");
        }
        if(builder.toString().length() > 0) {
            txtCartInfo.setText(builder.toString());
        }
        else {
            txtCartInfo.setText("Không có sản phẩm trong giỏ.");
        }
    }
}
