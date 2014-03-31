package ru.smolgu.Profkom_Diskont;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class OProgramFragment extends Fragment {
public OProgramFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.oprogram_fragment, container, false);
         
        return rootView;
    }
}
