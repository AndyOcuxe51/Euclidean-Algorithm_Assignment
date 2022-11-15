// Euclidean_AssignmentOne and Main Method
// Course: CS 3626
// Name: Andy Martinez Reyes
// Professor: Xinyue, Zhang
// Assignment #: One

import java.util.Scanner;

// Following the terms from the slides
public class Euclidean_AssignmentOne {

	private double InputA, InputB, InputR;

	// No Default Constructor made
	// Followed structure and speudocode from slides
	public void EuclideanAlgorithm(double NumberA, double NumberB) {
		setInputA(NumberA);// Sets the passed numbers to the private ones,
		setInputB(NumberB);// Helps save the old numbers for final answer.
		// With minimal changes, this steps can be removed.

		double QValue;

		// Set up automatically corrects the Values based on a higher number
		do {

			setInputR(getInputA() % getInputB());
			// System.out.println(getInputR()); //used for debugging

			QValue = Math.ceil(getInputA() / (getInputR() + getInputB())); // needs the ceiling number to be more
			// accurate.

			System.out.println(getInputA() + " = " + QValue + " * " + getInputB() + " + " + getInputR());

			// Prevents numbers from being changed if B goes to zero or below.
			if (getInputB() > 0) {
				setInputA(getInputB());
				setInputB(getInputR());
			}
		} while (getInputR() > 0);

		// Gives Users the final answer.
		System.out.println("GCD of " + NumberA + " modulo " + NumberB + " is " + getInputA());

	}

	// Followed Speudocode from slides
	public void Extended_EuclideanAlgorithm(double NumberA, double NumberB) {
		double p = 0, p2 = 1, QValue;
		boolean HasInverse = false; // Made to help with which statement should be printed to the Terminal

		// Statement used to make sure that the larger number is always at the front of
		// the modulo equations
		if (NumberA < NumberB) {
			double TempNum = NumberA;
			NumberA = NumberB;
			NumberB = TempNum;
		}

		setInputA(NumberA);// Sets the passed numbers to the private ones
		setInputB(NumberB);// Helps save the old numbers for final answer.
		// With minimal changes, this steps can be removed.

		while (getInputB() != 0) {
			QValue = Math.floor(getInputA() / getInputB());
			setInputR(getInputA() % getInputB());

			double TempP;
			if (p < p2) {
				TempP = NumberA + (p - p2 * QValue);
			} else {
				TempP = (p - p2 * QValue) % NumberA;
			}
			setInputA(getInputB());
			setInputB(getInputR());

			if (getInputB() == 1) {
				HasInverse = true;

				System.out.println(
						" = " + p + " - " + p2 + "*" + QValue + " Mod " + NumberA + " = " + (p - (p2 * QValue)));
				System.out.println("Inerse is " + TempP);

				break;
			}
			System.out.println(" = " + p + " - " + p2 + "*" + QValue + " Mod " + NumberA + " = " + TempP);

			p = p2;
			p2 = TempP;

		}
		if (!HasInverse) {
			System.out.println("No Inverse");
		}

	}

	// Getters and Setter Methods for private variables
	public double getInputA() {
		return InputA;
	}

	public void setInputA(double inputA) {
		InputA = inputA;
	}

	public double getInputB() {
		return InputB;
	}

	public void setInputB(double inputB) {
		InputB = inputB;
	}

	public double getInputR() {
		return InputR;
	}

	public void setInputR(double inputR) {
		InputR = inputR;
	}

	public static void main(String args[]) {
		Double ValueA, ValueB;
		Scanner scan = new Scanner(System.in); // Scanner for user input
		try {
			// Program starts by asking user to enter values
			System.out.print("Input N(A): ");
			ValueA = scan.nextDouble();
			System.out.print("Input B: ");

			ValueB = scan.nextDouble();
			Euclidean_AssignmentOne test = new Euclidean_AssignmentOne();
			System.out.println("Finding the GCD");
			System.out.println();
			test.EuclideanAlgorithm(ValueA, ValueB);

			// PrintLn Statements to help user readability
			System.out.println();
			System.out.println("Finding possible Inverse");
			System.out.println();
			test.Extended_EuclideanAlgorithm(ValueA, ValueB);
		} catch (Exception ex) {
			System.out.println("An Error has occured, make sure to use the appropriate data types");
		}
		scan.close();
	}

}
