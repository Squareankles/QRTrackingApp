package com.squareankles.qracker.fragments;


import com.example.qrtracking.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class OpeningFragment extends Fragment {
	@Override
	  public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			super.onCreateView(inflater,container,savedInstanceState);
			View view =inflater.inflate(R.layout.fragment_opening, container, false);
			
			return view;
		}
}
