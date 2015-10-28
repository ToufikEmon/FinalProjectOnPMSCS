package com.example.final_project;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

@SuppressLint("NewApi")
public class HomeFragment extends Fragment implements OnClickListener {

	Button btnClikToApply, btnGetAdmitCard, btnHowToApply;

	public HomeFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_home, container, false);

		// Button initialise in a fragment
		btnClikToApply = (Button) view.findViewById(R.id.btnApply);
		btnGetAdmitCard = (Button) view.findViewById(R.id.btnGetAdmitCard);
		btnHowToApply = (Button) view.findViewById(R.id.btnHowToAply);

		// Set Action In Button
		btnClikToApply.setOnClickListener(this);
		btnGetAdmitCard.setOnClickListener(this);
		btnHowToApply.setOnClickListener(this);

		return view;
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.btnApply:

			Intent intentClickToApply = new Intent(getActivity(),
					ClcikToApply.class);
			startActivity(intentClickToApply);
			break;
		case R.id.btnGetAdmitCard:

			Intent intentGetAdmiCard = new Intent(getActivity(),
					GetAdmitCard.class);
			startActivity(intentGetAdmiCard);
			break;
		case R.id.btnHowToAply:

			Intent intent = new Intent(getActivity(), HowToApply.class);
			startActivity(intent);
			break;

		// HowToApply how = new HowToApply();
		// ft.replace(R.id.frame_container, how);
		// ft.addToBackStack(null);
		// ft.commit();
		// break;

		default:
			break;
		}

	}

}
