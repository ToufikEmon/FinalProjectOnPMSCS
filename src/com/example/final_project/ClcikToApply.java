package com.example.final_project;

import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.save_data_in_database.JSONParser;

public class ClcikToApply extends Activity {

	private ProgressDialog pDialog;
	JSONParser jsonParser = new JSONParser();
	Spinner spSex,spBloodGroup;

	EditText edtApplicantName, edtFatherName, edtMotherName, edtNationality,
			edtPermanentAddress,edtPresentAddress, edtContactNumber,edtEmail,edtDateOfBirth;
	// ,
	// , edtSSC, edtHSC, edtHons, edtOthers, edtGroupSSC,
	// edtGroupHSC, edtGroupHons, edtGroupOther, edtBoardSSC, edtBoardHSC,
	// edtBoardHons, edtBoardOthers, edtSSCPassingYear, edtHSCPassingYear,
	// edtHonsPassingYear, edtOthersPassingyear,
	// edtPresentStatusAndOrganization, edtExperience;

	Button btnSubmit;

	private static String url_insert_into_database = "http://10.62.32.213/final_project/insert_data.php";

	// JSON Node names
	private static final String TAG_SUCCESS = "success";

	private static int RESULT_LOAD_IMG = 1;

	// GUI components
	// The button
	private ImageView imageView_profilepic;// ImageView

	public ClcikToApply() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.click_to_apply);

		edtApplicantName = (EditText) findViewById(R.id.edtApplicantName);
		edtFatherName = (EditText) findViewById(R.id.edtApplicantFathhersName);
		edtMotherName = (EditText) findViewById(R.id.edtApplicantMothersName);
		edtNationality = (EditText) findViewById(R.id.edtNationality);
		edtPermanentAddress = (EditText) findViewById(R.id.edtPermanentAddress);
		edtPresentAddress = (EditText) findViewById(R.id.edtPresentAddress);
		edtContactNumber = (EditText) findViewById(R.id.edtContactNumber);
		 edtEmail = (EditText) findViewById(R.id.edtEmail);
		 edtDateOfBirth = (EditText) findViewById(R.id.edtDateOfBirth);
		 //spSex = (Spinner) findViewById(R.id.spSex);
		// spBloodGroup = (Spinner) findViewById(R.id.spBloodGroup);
		// edtSSC = (EditText) findViewById(R.id.edtSSC);
		// edtHSC = (EditText) findViewById(R.id.edtHSC);
		// edtHons = (EditText) findViewById(R.id.edtHons);
		// edtOthers = (EditText) findViewById(R.id.edtOthers);
		// edtGroupSSC = (EditText) findViewById(R.id.edtSSCGroup);
		// edtGroupHSC = (EditText) findViewById(R.id.edtHSCGroup);
		// edtGroupHons = (EditText) findViewById(R.id.edtHonsGroup);
		// edtGroupOther = (EditText) findViewById(R.id.edtOtherGroup);
		// edtBoardSSC = (EditText) findViewById(R.id.edtSSCBoard);
		// edtBoardHSC = (EditText) findViewById(R.id.edtHSCBoard);
		// edtBoardHons = (EditText) findViewById(R.id.edtHonsBoard);
		// edtBoardOthers = (EditText) findViewById(R.id.edtOtherBoard);
		// edtSSCPassingYear = (EditText) findViewById(R.id.edtSSCYear);
		// edtHSCPassingYear = (EditText) findViewById(R.id.edtHSCYear);
		// edtHonsPassingYear = (EditText) findViewById(R.id.edtHONSYear);
		// edtOthersPassingyear = (EditText) findViewById(R.id.edtOtherYear);
		// edtPresentStatusAndOrganization = (EditText)
		// findViewById(R.id.edtPresentStatusAndOrganization);
		// edtExperience = (EditText) findViewById(R.id.edtPresentExperience);

		btnSubmit = (Button) findViewById(R.id.btnSubmit);
		btnSubmit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				new InsertData().execute();

			}
		});

		/*
		 * Initialize all the editText to add them action
		 */

		// edtApplicantName = (EditText)
		// view.findViewById(R.id.edtApplicantName);
		// edtApplicantName.setOnClickListener(new OnClickListener() {
		//
		// @Override
		// public void onClick(View v) {
		//
		// edtApplicantName.setFocusableInTouchMode(true);
		//
		// }
		// });

		imageView_profilepic = (ImageView) findViewById(R.id.imgLoadImage);
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

	}

	class InsertData extends AsyncTask<String, String, String> {

		@Override
		protected void onPreExecute() {

			super.onPreExecute();
			pDialog = new ProgressDialog(ClcikToApply.this);
			pDialog.setMessage("Please Wait ....\nInserting Into Database...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(true);
			pDialog.show();
		};

		protected String doInBackground(String... arg0) {

			String applicant_name = edtApplicantName.getText().toString();
			String father_name = edtFatherName.getText().toString();
			String mother_name = edtMotherName.getText().toString();

			String nationality = edtNationality.getText().toString();
			String permanent_address = edtPermanentAddress.getText().toString();
			 String present_address = edtPresentAddress.getText().toString();
			 String contact_number = edtContactNumber.getText().toString();
			 String email = edtEmail.getText().toString();
			 String date_of_birth = edtDateOfBirth.getText().toString();
			// String sex = spSex.getItemIdAtPosition(0).toString();
			// String blood_group = spBloodGroup.getContext().toString();
			// String degree1 = edtSSC.getText().toString();
			// String degree2 = edtHSC.getText().toString();
			// String degree3 = edtHons.getText().toString();
			// String degree4 = edtOthers.getText().toString();
			// String group1 = edtGroupSSC.getText().toString();
			// String group2 = edtGroupHSC.getText().toString();
			// String group3 = edtGroupHons.getText().toString();
			// String group4 = edtGroupOther.getText().toString();
			// String board1 = edtBoardSSC.getText().toString();
			// String board2 = edtBoardHSC.getText().toString();
			// String board3 = edtBoardHons.getText().toString();
			// String board4 = edtBoardOthers.getText().toString();
			// String passing_year1 = edtSSCPassingYear.getText().toString();
			// String passing_year2 = edtHSCPassingYear.getText().toString();
			// String passing_year3 = edtHonsPassingYear.getText().toString();
			// String passing_year4 = edtOthersPassingyear.getText().toString();
			// String status = edtPresentStatusAndOrganization.getText()
			// .toString();
			// String organization = edtExperience.getText().toString();

			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("applicant_name", applicant_name));
			params.add(new BasicNameValuePair("father_name", father_name));
			params.add(new BasicNameValuePair("mother_name", mother_name));
			params.add(new BasicNameValuePair("nationality", nationality));
			params.add(new BasicNameValuePair("permanent_address",
					permanent_address));
			 params.add(new BasicNameValuePair("present_address",
			 present_address));
			 params.add(new BasicNameValuePair("contact_number",
			 contact_number));
			 params.add(new BasicNameValuePair("email", email));
			 params.add(new BasicNameValuePair("date_of_birth", date_of_birth));
			// params.add(new BasicNameValuePair("sex",sex));
			// params.add(new BasicNameValuePair("blood_group",blood_group));
			// params.add(new BasicNameValuePair("degree1", degree1));
			// params.add(new BasicNameValuePair("degree2", degree2));
			// params.add(new BasicNameValuePair("degree3", degree3));
			// params.add(new BasicNameValuePair("degree4", degree4));
			// params.add(new BasicNameValuePair("group1", group1));
			// params.add(new BasicNameValuePair("group2", group2));
			// params.add(new BasicNameValuePair("group3", group3));
			// params.add(new BasicNameValuePair("group4", group4));
			// params.add(new BasicNameValuePair("board1", board1));
			// params.add(new BasicNameValuePair("board2", board2));
			// params.add(new BasicNameValuePair("board3", board3));
			// params.add(new BasicNameValuePair("board4", board4));
			// params.add(new BasicNameValuePair("passing_year1",
			// passing_year1));
			// params.add(new BasicNameValuePair("passing_year2",
			// passing_year2));
			// params.add(new BasicNameValuePair("passing_year3",
			// passing_year3));
			// params.add(new BasicNameValuePair("passing_year4",
			// passing_year4));
			// params.add(new BasicNameValuePair("organization", organization));
			// params.add(new BasicNameValuePair("status", status));

			JSONObject json = jsonParser.makeHttpRequest(
					url_insert_into_database, "POST", params);

			// check log cat fro response
			Log.d("Create Response", json.toString());

			// check for success tag
			try {
				int success = json.getInt(TAG_SUCCESS);

				if (success == 1) {
					// successfully created product
					Intent i = new Intent(getApplicationContext(),
							ClcikToApply.class);
					startActivity(i);
					Toast.makeText(getApplicationContext(),
							"Successfully Inerted Data", Toast.LENGTH_LONG)
							.show();

					// closing this screen
					finish();
				} else {
					// failed to create product
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}

			return null;
		}

		@Override
		protected void onPostExecute(String file_url) {
			pDialog.dismiss();
		}

	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		try {
			// When an Image is picked
			if (requestCode == RESULT_LOAD_IMG
					&& resultCode == ClcikToApply.RESULT_OK && null != data) {
				// Get the Image from data
				decodeUri(data.getData());

			} else {
				Toast.makeText(ClcikToApply.this, "You haven't picked Image",
						Toast.LENGTH_LONG).show();
			}
		} catch (Exception e) {
			Toast.makeText(ClcikToApply.this, "Something went wrong",
					Toast.LENGTH_LONG).show();
		}
	}

	@SuppressWarnings("hiding")
	public void decodeUri(Uri uri) {
		ParcelFileDescriptor parcelFD = null;
		try {
			parcelFD = getContentResolver().openFileDescriptor(uri, "r");
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