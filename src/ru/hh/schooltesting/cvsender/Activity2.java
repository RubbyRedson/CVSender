package ru.hh.schooltesting.cvsender;

import ru.hh.schooltesting.cvsender.CVclass.CV;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();
		CV Applicant = (CV) intent.getSerializableExtra("ru.hh.schooltesting.cvsender.ApplicantCV");	
		setContentView(R.layout.activity_activity2);
		if (Applicant == null)
			return;
		TextView name = (TextView) findViewById(R.id.Name2);
		TextView sex = (TextView) findViewById(R.id.Sex2);
    	TextView date = (TextView) findViewById(R.id.DateOfBirth2);
    	TextView position = (TextView) findViewById(R.id.Position2);
    	TextView wage = (TextView) findViewById(R.id.Wage2);
    	TextView phone = (TextView) findViewById(R.id.Phone2);
    	TextView email = (TextView) findViewById(R.id.Email2);
    	String nameTxt = Applicant.getName().toString();
    	if (nameTxt == null)
    		return;
    	String sexTxt = Applicant.getSex().toString();
    	if (sexTxt == null)
    		return;
    	String dateTxt = Integer.toString(Applicant.getDay())+"."+Integer.toString(Applicant.getMonth())+"."+Integer.toString(Applicant.getYear());
    	String positionTxt = Applicant.getPosition().toString();
    	if (positionTxt == null)
    		return;
    	String wageTxt =  Applicant.getWage().toString();
    	if (wageTxt == null)
    		return;
    	String phoneNumb = Applicant.getPhone().toString();
    	if (phoneNumb == null)
    		return;
    	String e_mail = Applicant.getEmail().toString();
    	if (e_mail == null)
    		return;
    	name.setText(name.getText().toString() + ": " + nameTxt);
    	sex.setText(sex.getText().toString() + ": " + sexTxt);
    	position.setText(position.getText().toString() + ": " + positionTxt);
    	wage.setText(wage.getText().toString() + ": " + wageTxt);
    	phone.setText(phone.getText().toString() + ": " + phoneNumb);
    	email.setText(email.getText().toString() + ": " + e_mail);
    	date.setText(date.getText().toString() + ": " + dateTxt);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity2, menu);
		return true;
	}
	public void answer(View view)
	{
		EditText answ = (EditText) findViewById(R.id.Answer);
		Intent i = new Intent(this, Activity2.class);
		i.putExtra("Answer", answ.getText().toString());
		setResult(Activity.RESULT_OK, i);
		super.onActivityResult(1, Activity.RESULT_OK, i);
		finish();
	}
}
