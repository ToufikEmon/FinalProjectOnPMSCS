package com.example.final_project;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ViewFlipper;

public class BeautifulPlaces extends Fragment {

	int mFlipping = 0; // Initially flipping is off
	Button mButton; // Reference to button available in the layout to start and
					// stop the flipper

	public BeautifulPlaces() {
		// TODO Auto-generated constructor stub
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		final View view = inflater.inflate(R.layout.beautiful_ju, container,
				false);

		/** Click event handler for button */
		OnClickListener listener = new OnClickListener() {

			@Override
			public void onClick(View v) {
				ViewFlipper flipper = (ViewFlipper) view
						.findViewById(R.id.flipper1);

				if (mFlipping == 0) {
					/** Start Flipping */
					flipper.startFlipping();
					mFlipping = 1;
					mButton.setText(R.string.str_btn_stop);
				} else {
					/** Stop Flipping */
					flipper.stopFlipping();
					mFlipping = 0;
					mButton.setText(R.string.str_btn_start);
				}
			}
		};
		/** Getting a reference to the button available in the resource */
		mButton = (Button) view.findViewById(R.id.btn);

		/** Setting click event listner for the button */
		mButton.setOnClickListener(listener);
		return view;

	}

}