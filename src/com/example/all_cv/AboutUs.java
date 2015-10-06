package com.example.all_cv;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.final_project.R;
import com.example.friendsbookcse2nt.RoundImage;

public class AboutUs extends Fragment {

	Button btnPhone;

	ImageView imgChyon, imgEmon, imgAnup;
	RoundImage roundImage1, roundImage2, roundImage3;

	public AboutUs() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.about_us, container, false);

		imgChyon = (ImageView) view.findViewById(R.id.imgChyon);
		imgEmon = (ImageView) view.findViewById(R.id.imgEmon);
		imgAnup = (ImageView) view.findViewById(R.id.imgAnup);

		Bitmap bm1 = BitmapFactory.decodeResource(getResources(),
				R.drawable.chyon);
		Bitmap bm2 = BitmapFactory.decodeResource(getResources(),
				R.drawable.emon);
		Bitmap bm3 = BitmapFactory.decodeResource(getResources(),
				R.drawable.anup);

		roundImage1 = new RoundImage(bm1);
		roundImage2 = new RoundImage(bm2);
		roundImage3 = new RoundImage(bm3);

		imgEmon.setImageDrawable(roundImage2);

		imgChyon.setImageDrawable(roundImage1);

		imgAnup.setImageDrawable(roundImage3);
		return view;
	}

}
