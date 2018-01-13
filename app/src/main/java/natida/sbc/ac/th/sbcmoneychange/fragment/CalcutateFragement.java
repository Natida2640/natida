package natida.sbc.ac.th.sbcmoneychange.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import natida.sbc.ac.th.sbcmoneychange.MainActivity;
import natida.sbc.ac.th.sbcmoneychange.R;

/**
 * Created by LAB3201_00 on 13/1/2561.
 */

public class CalcutateFragement extends Fragment{

    private double aDouble;

    public static CalcutateFragement calculateInstance(double factorDouble){
        CalcutateFragement calcutateFragement = new CalcutateFragement();
        Bundle bundle = new Bundle();
        bundle.putDouble("Factor",factorDouble);
        calcutateFragement.setArguments(bundle);

        return calcutateFragement;
    }





    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //        Toolbar Controller
        toolbarController();

//        Get Value From Argument
        aDouble = getArguments().getDouble("Factor");
        Log.d("13Jan", "Factor ==>" + aDouble);



    }   // Main Method

    private void toolbarController() {
        Toolbar toolbar = getView().findViewById(R.id.toolbarCalculate);
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);

        ((MainActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.th_exchange));
        ((MainActivity) getActivity()).getSupportActionBar().setSubtitle(getString(R.string.th_sub_exchange));

        ((MainActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragement_calculate,container,false);
        return view;

    }
}   //Main Class
