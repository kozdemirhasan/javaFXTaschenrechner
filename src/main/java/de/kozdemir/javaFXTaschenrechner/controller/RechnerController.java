package de.kozdemir.javaFXTaschenrechner.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RechnerController {

//	@FXML
//	private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnReverse, btnPlus, btnMinus,
//			btnMultiplication, btnDivision, btnBackClear, btnClear, btnCalculate, btnComma;
	@FXML
	private TextField txtEingabe;
	@FXML
	private Label label;

	static String eingabe = "";
	static String etiket = "";
	static double ergebnis = 0;
	static String operation;
	static boolean neuRechnung = true;

	@FXML
	public void click0() {

		eingabe(0);
	}

	@FXML
	public void click1() {

		eingabe(1);
	}

	@FXML
	public void click2() {
		eingabe(2);
	}

	@FXML
	public void click3() {
		eingabe(3);
	}

	@FXML
	public void click4() {
		eingabe(4);
	}

	@FXML
	public void click5() {
		eingabe(5);
	}

	@FXML
	public void click6() {
		eingabe(6);
	}

	@FXML
	public void click7() {
		eingabe(7);
	}

	@FXML
	public void click8() {
		eingabe(8);
	}

	@FXML
	public void click9() {
		eingabe(9);
	}

//	math operations

	@FXML
	public void clickDivision() {
		if (neuRechnung == false) {
			etiket += "/";
		}
		operation = "/";
		rechnen();

	}

	@FXML
	public void clickReverse() {

	}

	@FXML
	public void clickBackClear() {

	}

	@FXML
	public void clickClear() {

		etiket = "";
		eingabe = "";
		ergebnis = 0;
		label.setText(etiket);
		txtEingabe.setText(eingabe);
	}

	@FXML
	public void clickComma() {

	}

	@FXML
	public void clickPlus() {
		if (neuRechnung == false) {
			etiket += "+";
		}

		operation = "+";
		rechnen();
	}

	@FXML
	public void clickMinus() {
		if (neuRechnung == false) { // devam eden islem ise
			etiket += "-";
		}
		operation = "-";
		rechnen();
	}

	@FXML
	public void clickMultiplication() {
		if (neuRechnung == false) {
			etiket += "*";
		}
		operation = "*";
		rechnen();

	}

	@FXML
	public void calculate() { // sadece esittire basinca calisiyor
		neuRechnung = true;
		rechnen();

		etiket += " = " + ergebnis;
		label.setText(etiket);
		txtEingabe.setText("" + ergebnis);

	}

	public void rechnen() {

		double wert = 0.0;
		try {
			wert = Double.parseDouble(eingabe);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		switch (operation) {

		case "+":
			ergebnis += wert;
			break;

		case "-":
			if (etiket.lastIndexOf("-") == etiket.indexOf("-"))
				ergebnis = wert;
			else
				ergebnis -= wert;
			break;

		case "*":
			if (etiket.lastIndexOf("*") == etiket.indexOf("*")) {
				ergebnis = 1;
				ergebnis *= wert;
			} else {
				ergebnis *= wert;
			}
			break;

		case "/":
			ergebnis /= wert;
			break;
		}

		label.setText(etiket);
		txtEingabe.setText("" + ergebnis);
		eingabe = "";

	}

	public void eingabe(int x) {

		if (neuRechnung == true) {
			eingabe = "";
			etiket = "";
			ergebnis = 0.0;
			neuRechnung = false;
		}

		eingabe += x;
		etiket += x;

		txtEingabe.setText(eingabe);
		label.setText(etiket);

	}

}
