package ru.hh.schooltesting.cvsender;

import ru.hh.schooltesting.cvsender.CVclass.CV;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

public class Activity1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity1, menu);
        return true;
    }
    public void TrySend(View view)
    {
    	Intent intent = new Intent(this, Activity2.class);
    	EditText name = (EditText) findViewById(R.id.Name);
    	Spinner sex = (Spinner) findViewById(R.id.SexSpinner);
    	DatePicker date = (DatePicker) findViewById(R.id.DateOfBirth);
    	EditText position = (EditText) findViewById(R.id.Position);
    	EditText wage = (EditText) findViewById(R.id.Wage);
    	EditText phone = (EditText) findViewById(R.id.PhoneNumber);
    	EditText email = (EditText) findViewById(R.id.Email);    	
    	String nameTxt = name.getText().toString();
    	if (nameTxt.isEmpty())
    	{ShowDialog(getString(R.string.Oops), getString(R.string.FullNameError1)); return;}
    	if (!CheckName(nameTxt))
    	{ShowDialog(getString(R.string.Oops), getString(R.string.FullNameError2)); return;}
    	String sexTxt = sex.getSelectedItem().toString();
    	int day = date.getDayOfMonth();
    	int month = date.getMonth();
    	int year = date.getYear();
    	String positionTxt = position.getText().toString();
    	if (positionTxt.isEmpty())
    	{ShowDialog(getString(R.string.Oops), getString(R.string.PositionError1)); return;}
    	if (!CheckPosition(positionTxt))
    	{ShowDialog(getString(R.string.Oops), getString(R.string.PositionError2)); return;}
    	String wageTxt =  wage.getText().toString();
    	if (wageTxt.isEmpty())
    	{ShowDialog(getString(R.string.Oops), getString(R.string.WageError)); return;}
    	String phoneNumb = phone.getText().toString();
    	if (phoneNumb.isEmpty())
    	{ShowDialog(getString(R.string.Oops), getString(R.string.PhoneNumberError)); return;}
    	String e_mail = email.getText().toString();
    	if (e_mail.isEmpty())
    	{ShowDialog(getString(R.string.Oops), getString(R.string.EmailError)); return;}
    	CV Applicant = new CV(nameTxt, sexTxt, day, month, year, positionTxt, wageTxt, phoneNumb, e_mail);
    	String ApplicantCV = "ru.hh.schooltesting.cvsender.ApplicantCV";
    	intent.putExtra(ApplicantCV, Applicant);
    	startActivityForResult(intent, 1);
    }
    private boolean CheckName(String name)
    {
    	String[] Words = name.split(" ");
    	for (String t : Words)
    		if (Character.toUpperCase(t.charAt(0)) != t.charAt(0))
    			return false;
    	return true;
    }
    private boolean CheckPosition(String pos)
    {
    	String[] Words = pos.split(". ");
    	for (String t : Words)
    		if (Character.isLetter(t.charAt(0)))
    			if (Character.toUpperCase(t.charAt(0)) != t.charAt(0))
    				return false;
    	return true;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent Answer) {
        Bundle b = Answer.getExtras(); 
        String answer = b.getString("Answer");
        String s = getString(R.string.title_activity_activity2);
        ShowDialog(s, answer);
    }
    private void ShowDialog(String title, String text)
    {
    	 AlertDialog.Builder builder = new AlertDialog.Builder(this);
	     AlertDialog dialog = builder.create();
	     dialog.setMessage(text);
	     dialog.setTitle(title);
	     dialog.show();
    }
}
