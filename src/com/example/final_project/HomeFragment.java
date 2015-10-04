package com.example.final_project;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
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
		btnClikToApply = (Button) view.findViewById(R.id.btnClickToApply);
		btnGetAdmitCard = (Button) view.findViewById(R.id.btnAdmitCardPrint);
		btnHowToApply = (Button) view.findViewById(R.id.btnHowToApply);

		// Set Action In Button
		btnClikToApply.setOnClickListener(this);
		btnGetAdmitCard.setOnClickListener(this);
		btnHowToApply.setOnClickListener(this);

		return view;
	}

	@Override
	public void onClick(View v) {
		FragmentManager fm = getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();

		switch (v.getId()) {
		case R.id.btnClickToApply:

			ClcikToApply app = new ClcikToApply();
			ft.replace(R.id.frame_container, app);
			ft.addToBackStack(null);
			ft.commit();
			break;
		case R.id.btnAdmitCardPrint:

			GetAdmitCard get = new GetAdmitCard();
			ft.replace(R.id.frame_container, get);
			ft.addToBackStack(null);
			ft.commit();
			break;
		case R.id.btnHowToApply:

			HowToApply how = new HowToApply();
			ft.replace(R.id.frame_container, how);
			ft.addToBackStack(null);
			ft.commit();
			break;

		default:
			break;
		}

	}

}
