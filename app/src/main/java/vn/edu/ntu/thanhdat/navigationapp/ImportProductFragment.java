package vn.edu.ntu.thanhdat.navigationapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import vn.edu.ntu.thanhdat.controller.ICartController;
import vn.edu.ntu.thanhdat.model.Product;


/**
 * A simple {@link Fragment} subclass.
 */
public class ImportProductFragment extends Fragment implements View.OnClickListener {

    NavController controller;
    EditText edtNameP,edtPriceP,edtDecsP;
    Button btnLuu;
    ICartController cartController;

    public ImportProductFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        controller = NavHostFragment.findNavController(this);
        ((MainActivity) getActivity()).controller = controller;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_import_product, container, false);
        edtNameP=view.findViewById(R.id.edtNameP);
        edtPriceP=view.findViewById(R.id.edtPriceP);
        edtDecsP=view.findViewById(R.id.edtDecsP);
        btnLuu=view.findViewById(R.id.btnLuu);
        btnLuu.setOnClickListener(this);
        cartController =((MainActivity)getActivity()).cartController;
        addevent();
        return view;

    }
    private void addevent()
    {

    }


    @Override
    public void onClick(View v) {
        cartController.addProduct(new Product(edtNameP.getText().toString(),edtDecsP.getText().toString(),Integer.parseInt(edtPriceP.getText().toString())));

    }
}
