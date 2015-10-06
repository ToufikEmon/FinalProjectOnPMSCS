package com.example.final_project;

import android.app.Fragment;
import android.content.Intent;
import android.database.Cursor;

import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ClcikToApply extends Fragment {

	ImageView imgView;
	private static int RESULT_LOAD_IMAGE = 1;

	public ClcikToApply() {
		// TODO Auto-generated constructor stub
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.click_to_apply, container, false);

		imgView = (ImageView) view.findViewById(R.id.imageView1);
		imgView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(
						Intent.ACTION_PICK,
						android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

				startActivityForResult(i, RESULT_LOAD_IMAGE);
				// TODO Auto-generated method stub

			}

		});
		return view;
	}

}
