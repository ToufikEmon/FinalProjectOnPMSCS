package com.example.final_project;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class FAQ extends Fragment{
	
	TextView tvOffice;
	public FAQ() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.f_a_q,
				container, false);
		
		tvOffice = (TextView) view.findViewById(R.id.tvOffice);
		tvOffice.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent callIntent = new Intent(Intent.ACTION_CALL);
				callIntent.setData(Uri.parse("tel:+8801941336337"));
				startActivity(callIntent);
			}
		});
		return view;
	}

}
