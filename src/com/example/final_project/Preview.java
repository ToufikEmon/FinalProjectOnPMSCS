package com.example.final_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Preview extends Activity {

	TextView tvApplicantName, tvFatherName, tvMotherName, tvNationality,
			tvPermanentAddress, tvPresentAddress, tvContactNumber, tvEmail,
			tvDateOfBirth, tvSSC, tvHSC, tvHons, tvOthers, tvGroupSSC,
			tvGroupHSC, tvGroupHons, tvGroupOther, tvBoardSSC, tvBoardHSC,
			tvBoardHons, tvBoardOthers, tvSSCCGPA, tvHSCCGPA, tvHONSCGPA,
			tvOthersCGPA, tvSSCPassingYear, tvHSCPassingYear,
			tvHonsPassingYear, tvOthersPassingyear,
			tvPresentStatusAndOrganization, tvExperience, tvSex, tvBlood_group;

	Button btnOk;
	ImageView  imgLoafImage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.preview_activity);

		tvApplicantName = (TextView) findViewById(R.id.tvApplicantName);
		tvFatherName = (TextView) findViewById(R.id.tvApplicantFathhersName);
		tvMotherName = (TextView) findViewById(R.id.tvApplicantMothersName);
		tvNationality = (TextView) findViewById(R.id.tvNationality);
		tvPermanentAddress = (TextView) findViewById(R.id.tvPermanentAddress);
		tvPresentAddress = (TextView) findViewById(R.id.tvPresentAddress);
		tvContactNumber = (TextView) findViewById(R.id.tvContactNumber);
		tvEmail = (TextView) findViewById(R.id.tvEmail);
		tvDateOfBirth = (TextView) findViewById(R.id.tvDateOfBirth);
		tvSSC = (TextView) findViewById(R.id.tvSSC);
		tvHSC = (TextView) findViewById(R.id.tvHSC);
		tvHons = (TextView) findViewById(R.id.tvHons);
		tvOthers = (TextView) findViewById(R.id.tvOthers);
		tvGroupSSC = (TextView) findViewById(R.id.tvSSCGroup);
		tvGroupHSC = (TextView) findViewById(R.id.tvHSCGroup);
		tvGroupHons = (TextView) findViewById(R.id.tvHonsGroup);
		tvGroupOther = (TextView) findViewById(R.id.tvOtherGroup);
		tvBoardSSC = (TextView) findViewById(R.id.tvSSCBoard);
		tvBoardHSC = (TextView) findViewById(R.id.tvHSCBoard);
		tvBoardHons = (TextView) findViewById(R.id.tvHonsBoard);
		tvBoardOthers = (TextView) findViewById(R.id.tvOtherBoard);
		tvSSCCGPA = (TextView) findViewById(R.id.tvSSCCGPA);
		tvHSCCGPA = (TextView) findViewById(R.id.tvHSCCGPA);
		tvHONSCGPA = (TextView) findViewById(R.id.tvHONSCGPA);
		tvOthersCGPA = (TextView) findViewById(R.id.tvOtherSCGPA);
		tvSSCPassingYear = (TextView) findViewById(R.id.tvSSCYear);
		tvHSCPassingYear = (TextView) findViewById(R.id.tvHSCYear);
		tvHonsPassingYear = (TextView) findViewById(R.id.tvHONSYear);
		tvOthersPassingyear = (TextView) findViewById(R.id.tvOtherYear);
		tvPresentStatusAndOrganization = (TextView) findViewById(R.id.tvPresentStatusAndOrganization);
		tvExperience = (TextView) findViewById(R.id.tvPresentExperience);
		tvSex = (TextView) findViewById(R.id.tvSex);
		tvBlood_group = (TextView) findViewById(R.id.tvBloodGroup);

		btnOk = (Button) findViewById(R.id.btnOK);

		Intent intent = getIntent();

		String applicant_name = intent.getStringExtra("applicant_name");
		String father_name = intent.getStringExtra("father_name");
		String mother_name = intent.getStringExtra("mother_name");
		String nationality = intent.getStringExtra("nationality");
		String permanent_addres = intent.getStringExtra("permanent_addres");
		String present_addres = intent.getStringExtra("present_addres");
		String contact_number = intent.getStringExtra("contact_number");
		String email = intent.getStringExtra("email");
		String date_of_birth = intent.getStringExtra("date_of_birth");
		String sex = intent.getStringExtra("sex");
		String blood_group = intent.getStringExtra("blood_group");
		String ssc = intent.getStringExtra("ssc");
		String hsc = intent.getStringExtra("hsc");
		String hons = intent.getStringExtra("hons");
		String others = intent.getStringExtra("others");
		String group_ssc = intent.getStringExtra("group_ssc");
		String group_hsc = intent.getStringExtra("group_hsc");
		String group_hons = intent.getStringExtra("group_hons");
		String group_other = intent.getStringExtra("group_other");
		String board_ssc = intent.getStringExtra("board_ssc");
		String board_hsc = intent.getStringExtra("board_hsc");
		String board_hons = intent.getStringExtra("board_hons");
		String board_others = intent.getStringExtra("board_others");
		String ssc_cgpa = intent.getStringExtra("ssc_cgpa");
		String hsc_cgpa = intent.getStringExtra("hsc_cgpa");
		String hons_cgpa = intent.getStringExtra("hons_cgpa");
		String others_cgpa = intent.getStringExtra("others_cgpa");
		String ssc_passing_year = intent.getStringExtra("ssc_passing_year");
		String hsc_passing_year = intent.getStringExtra("hsc_passing_year");
		String hons_passing_year = intent.getStringExtra("hons_passing_year");
		String others_passing_year = intent
				.getStringExtra("others_passing_year");
		String present_status_and_organization = intent
				.getStringExtra("present_status_and_organization");
		String experience = intent.getStringExtra("experience");

		tvApplicantName.setText(applicant_name);
		tvFatherName.setText(father_name);
		tvMotherName.setText(mother_name);
		tvNationality.setText(nationality);
		tvPermanentAddress.setText(permanent_addres);
		tvPresentAddress.setText(present_addres);
		tvContactNumber.setText(contact_number);
		tvEmail.setText(email);
		tvDateOfBirth.setText(date_of_birth);
		tvSSC.setText(ssc);
		tvHSC.setText(hsc);
		tvHons.setText(hons);
		tvOthers.setText(others);
		tvGroupSSC.setText(group_ssc);
		tvGroupHSC.setText(group_hsc);
		tvGroupHons.setText(group_hons);
		tvGroupOther.setText(group_other);
		tvBoardSSC.setText(board_ssc);
		tvBoardHSC.setText(board_hsc);
		tvBoardHons.setText(board_hons);
		tvBoardOthers.setText(board_others);
		tvSSCCGPA.setText(ssc_cgpa);
		tvHSCCGPA.setText(hsc_cgpa);
		tvHONSCGPA.setText(hons_cgpa);
		tvOthersCGPA.setText(others_cgpa);
		tvSSCPassingYear.setText(ssc_passing_year);
		tvHSCPassingYear.setText(hsc_passing_year);
		tvHonsPassingYear.setText(hons_passing_year);
		tvOthersPassingyear.setText(others_passing_year);
		tvPresentStatusAndOrganization.setText(present_status_and_organization);
		tvExperience.setText(experience);
		tvSex.setText("You Are :" + sex);
		tvBlood_group.setText("Blood Group :" + blood_group);
		
		
		

		btnOk.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
//				Intent intentGetClcikToApply = new Intent(getApplicationContext(), ClcikToApply.class);
//
//				startActivity(intentGetClcikToApply);
				finish();

			}
		});

	}

}
