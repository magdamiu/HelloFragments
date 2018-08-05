package com.example.magdamiu.hellofragments.company_details;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.magdamiu.hellofragments.R;
import com.example.magdamiu.hellofragments.base.BaseFragment;
import com.example.magdamiu.hellofragments.company_location.CompanyLocationFragment;


public class CompanyDetailsFragment extends BaseFragment implements View.OnClickListener {

    private Button mBtnLocation;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_company_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    @Override
    public void onResume() {
        super.onResume();
        setToolbarTitle(getString(R.string.title_menu_nav_company_details));
    }

    @Override
    public void onClick(View view) {
        Fragment currentFragment = getActivity().getSupportFragmentManager()
                .findFragmentById(R.id.content_main);
        switch (view.getId()) {
            case R.id.btn_details_location:
                if (!(currentFragment instanceof CompanyLocationFragment)) {
                    BaseFragment.addFragment(getActivity(),
                            R.id.content_main,
                            new CompanyLocationFragment());
                }
                break;
        }
    }

    private void initView(View view) {
        mBtnLocation = view.findViewById(R.id.btn_details_location);
        mBtnLocation.setOnClickListener(this);
    }
}
