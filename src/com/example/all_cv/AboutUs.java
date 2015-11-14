package com.example.all_cv;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.final_project.R;
import com.example.round_image.RoundImage;

public class AboutUs extends Fragment implements OnClickListener {

	Button btnPhone;

	ImageView imgChyon, imgEmon, imgAnup;
	RoundImage roundImage1, roundImage2, roundImage3;
	TextView txtChyonEmail, txtChyonNumber, txtEmonMail, txtEmonNumber,
			txtAnumMail, txtAnupNumber;

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

		txtChyonEmail = (TextView) view.findViewById(R.id.txtChyonMail);
		txtChyonNumber = (TextView) view.findViewById(R.id.txtChyonNumber);
		txtEmonMail = (TextView) view.findViewById(R.id.textEmonMail);
		txtEmonNumber = (TextView) view.findViewById(R.id.txtEmonNumber);
		txtAnumMail = (TextView) view.findViewById(R.id.txtAnupMail);
		txtAnupNumber = (TextView) view.findViewById(R.id.txtAnupNumber);

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

		txtChyonEmail.setOnClickListener(this);
		txtChyonNumber.setOnClickListener(this);
		txtEmonMail.setOnClickListener(this);
		txtEmonNumber.setOnClickListener(this);
		txtAnumMail.setOnClickListener(this);
		txtAnupNumber.setOnClickListener(this);

		return view;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.txtChyonMail:

			Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
					"mailto", "asmmr@juniv.edu", null));

			startActivity(Intent.createChooser(intent,
					"Choose an Email client :"));

			break;
		case R.id.txtChyonNumber:

			Intent callIntent = new Intent(Intent.ACTION_CALL);
			callIntent.setData(Uri.parse("tel:+8801927129603"));
			startActivity(callIntent);

			break;
		case R.id.textEmonMail:

			Intent intentEmonMail = new Intent(Intent.ACTION_SENDTO,
					Uri.fromParts("mailto", "toufikahmedemon@gmail.com", null));

			startActivity(Intent.createChooser(intentEmonMail,
					"Choose an Email client :"));

			break;
		case R.id.txtEmonNumber:
			Intent callIntentEmon = new Intent(Intent.ACTION_CALL);
			callIntentEmon.setData(Uri.parse("tel:+8801760568639"));
			startActivity(callIntentEmon);

			break;
		case R.id.txtAnupMail:

			Intent intentAnupMail = new Intent(Intent.ACTION_SENDTO,
					Uri.fromParts("mailto", "anupju.cse20@gmail.com", null));

			startActivity(Intent.createChooser(intentAnupMail,
					"Choose an Email client :"));

			break;
		case R.id.txtAnupNumber:
			Intent callIntentAnup = new Intent(Intent.ACTION_CALL);
			callIntentAnup.setData(Uri.parse("tel:+8801725228874"));
			startActivity(callIntentAnup);

			break;

		default:
			break;
		}

	}

}
