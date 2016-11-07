package com.quanlt.vietcomicclean.presentation.view.fragment;

import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.quanlt.vietcomicclean.presentation.di.HasComponent;


public class BaseFragment extends Fragment {

    protected <T> T getComponent(Class<T> componentType) {
        return componentType.cast(((HasComponent<T>) getActivity()).getComponent());
    }
}
