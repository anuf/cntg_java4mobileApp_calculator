package anuf.exemplo.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Calculator extends Activity {
	private Button btn_zero;
	private Button btn_one;
	private Button btn_two;
	private Button btn_three;
	private Button btn_four;
	private Button btn_five;
	private Button btn_six;
	private Button btn_seven;
	private Button btn_eight;
	private Button btn_nine;
	private Button btn_plus;
	private Button btn_minus;
	private Button btn_times;
	private Button btn_divide;
	private Button btn_dot;
	private Button btn_equals;
	private EditText display;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculator);

		fillViews();
		sindicateEvents();

	}

	private void fillViews() {
		display = (EditText) findViewById(R.id.display);
		btn_zero = (Button) findViewById(R.id.button_zero);
		btn_one = (Button) findViewById(R.id.button_one);
		btn_two = (Button) findViewById(R.id.button_two);
		btn_three = (Button) findViewById(R.id.button_three);
		btn_four = (Button) findViewById(R.id.button_four);
		btn_five = (Button) findViewById(R.id.button_five);
		btn_six = (Button) findViewById(R.id.button_six);
		btn_seven = (Button) findViewById(R.id.button_seven);
		btn_eight = (Button) findViewById(R.id.button_eight);
		btn_nine = (Button) findViewById(R.id.button_nine);
		btn_plus = (Button) findViewById(R.id.button_plus);
		btn_minus = (Button) findViewById(R.id.button_minus);
		btn_times = (Button) findViewById(R.id.button_times);
		btn_divide = (Button) findViewById(R.id.button_divide);
		btn_dot = (Button) findViewById(R.id.button_dot);
		btn_equals = (Button) findViewById(R.id.button_equals);

	}
	
	/**Concatenates text to displayed text*/
	private void addTextTodisplay(View v){
		if(v instanceof Button){
			String theText = ((Button) v).getText().toString(); 
			display.setText(display.getText().toString()+theText);
		}
		display.setText(display.getText().toString());
	}
	private void sindicateEvents() {
		btn_zero.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				addTextTodisplay(arg0);
			}
		});
		btn_one.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				addTextTodisplay(arg0);
			}
		});
		btn_two.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				addTextTodisplay(arg0);
			}
		});
		btn_three.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				addTextTodisplay(arg0);
			}
		});
		btn_four.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				addTextTodisplay(arg0);
			}
		});
		btn_five.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				addTextTodisplay(arg0);
			}
		});
		btn_six.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				addTextTodisplay(arg0);
			}
		});
		btn_seven.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				addTextTodisplay(arg0);
			}
		});
		btn_eight.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				addTextTodisplay(arg0);
			}
		});
		btn_nine.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				addTextTodisplay(arg0);
			}
		});
		btn_zero.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				addTextTodisplay(arg0);
			}
		});
		btn_dot.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				//TODO if dot does not exists
				if(!display.getText().toString().contains((String) ".")){
					addTextTodisplay(arg0);
				}
			}
		});
		btn_plus.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

			}
		});
		btn_minus.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

			}
		});
		btn_times.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

			}
		});

		btn_divide.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

			}
		});
		btn_equals.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

			}
		});

	}
}
