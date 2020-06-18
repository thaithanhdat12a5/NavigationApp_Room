package vn.edu.ntu.thanhdat.navigationapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import vn.edu.ntu.thanhdat.controller.ICartController;
import vn.edu.ntu.thanhdat.model.Product;


/**
 * A simple {@link Fragment} subclass.
 */
public class ConfirmFragment extends Fragment {
    TextView txtThongBao,txtSanPham;
    ICartController cartController;
    public ConfirmFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_confirm, container, false);
        txtThongBao= view.findViewById(R.id.txtThongBao);
        txtSanPham= view.findViewById(R.id.txtSanPham);
        cartController = ((MainActivity)getActivity()).cartController;
        addEvent();


        return view;

    }
    private void addEvent()
    {
        cartController = ((MainActivity)getActivity()).cartController;
        List<Product> listProduct = cartController.getCart();
        StringBuilder builder = new StringBuilder();
        for(Product product: listProduct) {
            builder.append(product.getName()+" "+product.getPrice()+"vnd\n");
        }
        if(builder.toString().length() > 0) {
            txtThongBao.setText("Ban da dat hang thanh cong");
            txtSanPham.setText(builder.toString());
        }
        else {
            txtThongBao.setText("Không có sản phẩm trong giỏ.");
            txtSanPham.setText("");
        }
    }
}
