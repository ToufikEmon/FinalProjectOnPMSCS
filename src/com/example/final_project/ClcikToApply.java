package com.example.final_project;

import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

public class ClcikToApply extends Fragment {

	private static int RESULT_LOAD_IMG = 1;

	// GUI components
	// The button
	private ImageView imageView_profilepic;// ImageView

	public ClcikToApply() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.click_to_apply, container, false);

		imageView_profilepic = (ImageView) view.findViewById(R.id.imgLoadImage);
		imageView_profilepic.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setType("image/*");
				intent.setAction(Intent.ACTION_GET_CONTENT);
				startActivityForResult(
						Intent.createChooser(intent, "Select Picture"),
						RESULT_LOAD_IMG);
			}
		});
		return view;

	}

	@SuppressWarnings("static-access")
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		try {
			// When an Image is picked
			if (requestCode == RESULT_LOAD_IMG
					&& resultCode == getActivity().RESULT_OK && null != data) {
				// Get the Image from data
				decodeUri(data.getData());

			} else {
				Toast.makeText(getActivity(), "You haven't picked Image",
						Toast.LENGTH_LONG).show();
			}
		} catch (Exception e) {
			Toast.makeText(getActivity(), "Something went wrong",
					Toast.LENGTH_LONG).show();
		}
	}

	@SuppressWarnings("hiding")
	public void decodeUri(Uri uri) {
		ParcelFileDescriptor parcelFD = null;
		try {
			parcelFD = getActivity().getContentResolver().openFileDescriptor(
					uri, "r");
			FileDescriptor imageSource = parcelFD.getFileDescriptor();

			// Decode image size
			BitmapFactory.Options o = new BitmapFactory.Options();
			o.inJustDecodeBounds = true;
			BitmapFactory.decodeFileDescriptor(imageSource, null, o);

			// the new size we want to scale to
			final int REQUIRED_SIZE = 1024;

			// Find the correct scale value. It should be the power of 2.
			int width_tmp = o.outWidth, height_tmp = o.outHeight;
			int scale = 1;
			while (true) {
				if (width_tmp < REQUIRED_SIZE && height_tmp < REQUIRED_SIZE) {
					break;
				}
				width_tmp /= 2;
				height_tmp /= 2;
				scale *= 2;
			}

			// decode with inSampleSize
			BitmapFactory.Options o2 = new BitmapFactory.Options();
			o2.inSampleSize = scale;
			Bitmap bitmap = BitmapFactory.decodeFileDescriptor(imageSource,
					null, o2);

			imageView_profilepic.setImageBitmap(bitmap);

		} catch (FileNotFoundException e) {
			// handle errors
		} catch (IOException e) {
			// handle errors
		} finally {
			if (parcelFD != null)
				try {
					parcelFD.close();
				} catch (IOException e) {
					// ignored
				}
		}
	}

}