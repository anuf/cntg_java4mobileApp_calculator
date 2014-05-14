package anuf.exemplo.calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class PpalActivity extends Activity{
	
	Button btnOpenCalculator;
	Button btnRandomGenerator;
	TextView tvRandom;
	TextView tvResult;
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);		
		setContentView(R.layout.activity_ppal);
		
		btnOpenCalculator = (Button) findViewById(R.id.btnOpenCalculator);
		btnRandomGenerator = (Button) findViewById(R.id.btnRandomGenerator);
		tvRandom = (TextView) findViewById(R.id.tvRandomCalculation);
		tvResult = (TextView) findViewById(R.id.tvResult);
		btnOpenCalculator.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent calculatorIntent = new Intent(getApplicationContext(), CalculadoraActivity.class);
				startActivityForResult(calculatorIntent, 3);
				
			}
		});
		
		btnRandomGenerator.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String operator = new String();
				switch (1 + (int)(Math.random()*4)) {
				case 1:
					operator = " + ";
					break;
				case 2:
					operator = " - ";
					break;
				case 3:
					operator = " * ";
					break;
				case 4:
					operator = " / ";
					break;
				default:
					break;
				}
				tvRandom.setText(String.format("%.2f", Math.random()*100) + operator + String.format("%.2f", Math.random()*100));
				
			}
		});
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK){
			tvResult.setText(data.getStringExtra("result"));
		}
	}

}
