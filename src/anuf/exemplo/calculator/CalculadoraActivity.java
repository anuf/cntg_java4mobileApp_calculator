package anuf.exemplo.calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalculadoraActivity extends Activity {
	
	private enum State {START, OP1, OPERATOR, OP2, EQUALS};
	private enum Operator {
		PLUS('+'), MINUS('-'), MULTIPLY('X'), DIVIDE('/');
		private Character sign;
		Operator(Character sign) { this.sign = sign; }
		public Character getSign() { return sign; }
	};
	
	private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
	private Button btnPoint;
	private Button btnAdd, btnSubtract, btnMultiply, btnDivide, btnEquals;
	private EditText txtResult;
	
	private State state = State.START;
	
	private String sOperand1 = "", sOperand2 = "";
	private Operator op;
	
	private float operand1, operand2, result;
	private boolean op1Point = false, op2Point = false;
	
	private boolean isCalled = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_calc);
		btn0 = (Button)findViewById(R.id.btn0);
		btn0.setOnClickListener(new NumberButtonOnClickListener(0));
		btn1 = (Button)findViewById(R.id.btn1);
		btn1.setOnClickListener(new NumberButtonOnClickListener(1));
		btn2 = (Button)findViewById(R.id.btn2);
		btn2.setOnClickListener(new NumberButtonOnClickListener(2));
		btn3 = (Button)findViewById(R.id.btn3);
		btn3.setOnClickListener(new NumberButtonOnClickListener(3));
		btn4 = (Button)findViewById(R.id.btn4);
		btn4.setOnClickListener(new NumberButtonOnClickListener(4));
		btn5 = (Button)findViewById(R.id.btn5);
		btn5.setOnClickListener(new NumberButtonOnClickListener(5));
		btn6 = (Button)findViewById(R.id.btn6);
		btn6.setOnClickListener(new NumberButtonOnClickListener(6));
		btn7 = (Button)findViewById(R.id.btn7);
		btn7.setOnClickListener(new NumberButtonOnClickListener(7));
		btn8 = (Button)findViewById(R.id.btn8);
		btn8.setOnClickListener(new NumberButtonOnClickListener(8));
		btn9 = (Button)findViewById(R.id.btn9);
		btn9.setOnClickListener(new NumberButtonOnClickListener(9));
		
		btnAdd = (Button)findViewById(R.id.btnPlus);
		btnAdd.setOnClickListener(new OperatorButtonOnClickListener(Operator.PLUS));
		btnSubtract = (Button)findViewById(R.id.btnMinus);
		btnSubtract.setOnClickListener(new OperatorButtonOnClickListener(Operator.MINUS));
		btnMultiply = (Button)findViewById(R.id.btnMultiply);
		btnMultiply.setOnClickListener(new OperatorButtonOnClickListener(Operator.MULTIPLY));
		btnDivide = (Button)findViewById(R.id.btnDivide);
		btnDivide.setOnClickListener(new OperatorButtonOnClickListener(Operator.DIVIDE));
		
		btnEquals = (Button)findViewById(R.id.btnEquals);
		
		btnPoint = (Button)findViewById(R.id.btnPoint);
		btnPoint.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				switch (state) {
				case START:
					state = State.OP1;
					op1Point = true;
					sOperand1 = "0.";
					txtResult.setText(sOperand1);
					break;
				case OP1:
					if (!op1Point) {
						op1Point = true;
						sOperand1 += ".";
						txtResult.setText(txtResult.getText() + ".");
					}
					break;
				case OPERATOR:
					state = State.OP2;
					op2Point = true;
					sOperand2 = "0.";
					txtResult.setText(txtResult.getText() + sOperand2);
					break;
				case OP2:
					if (!op2Point) {
						op2Point = true;
						sOperand2 += ".";
						txtResult.setText(txtResult.getText() + ".");
					}
					break;
				case EQUALS:
					break;
				}
			}
		});
		
		txtResult = (EditText)findViewById(R.id.txtResult);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		Intent intent = getIntent();
		if (intent != null) {
			Bundle extras = intent.getExtras();
			if (extras != null)
				isCalled = intent.getExtras().containsKey("extern");
		}
		btnEquals.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				switch (state) {
				case OP2:
					state = State.EQUALS;
					result = getResult();
					if (isCalled) {
						Intent data = new Intent();
						data.putExtra("result", result);
						setResult(RESULT_OK, data);
						finish();
					} else {
						txtResult.setText(txtResult.getText() + " = " + result);
					}
					break;
				default:
					break;
				}
				
				// This intent returns the result of the calculation to the main activity
				Intent data = new Intent();
				data.putExtra("result", String.valueOf(result));
				setResult(RESULT_OK,data);
				finish();
			}
		});
	}

	private float getResult() {
		Log.i("calculadora", "getResult() - " + sOperand1 + " " + sOperand2);
		operand1 = Float.parseFloat(sOperand1);
		operand2 = Float.parseFloat(sOperand2);
		float result = 0;
		switch (op) {
		case PLUS:
			result = operand1 + operand2;
			break;
		case MINUS:
			result = operand1 - operand2;
			break;
		case MULTIPLY:
			result = operand1 * operand2;
			break;
		case DIVIDE:
			result = operand1 / operand2;
			break;
		}
		return result;
	}
	
	class NumberButtonOnClickListener implements View.OnClickListener {
		
		private int nb;
		
		public NumberButtonOnClickListener(int nb) {
			this.nb = nb;
		}

		@Override
		public void onClick(View v) {
			switch (state) {
			case START:
				state = State.OP1;
			case OP1:
				sOperand1 += Integer.toString(nb);
				txtResult.setText(txtResult.getText() + Integer.toString(nb));
				break;
			case OPERATOR:
				state = State.OP2;
			case OP2:
				sOperand2 += Integer.toString(nb);
				txtResult.setText(txtResult.getText() + Integer.toString(nb));
				break;
			case EQUALS:
				// TODO Start new operation
				break;
			}
		}
	}

	class OperatorButtonOnClickListener implements View.OnClickListener {

		private Operator operator;
		
		OperatorButtonOnClickListener(Operator operator) {
			this.operator = operator;
		}
		
		@Override
		public void onClick(View v) {
			switch (state) {
			case OP1:
				state = State.OPERATOR;
				op = operator;
				txtResult.setText(txtResult.getText() + " " + op.getSign() + " ");
				break;
			default:
				// TODO ERROR
				break;
			}
		}
	}
}
