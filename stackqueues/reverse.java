// use stack to reverse a word

////////////////////////////////////

import java.io.*;
////////////////////////////////////
class StackX {

	private int maxSize;
	private char[] stackArray;
	private int top;
//----------------------------------
	public StackX(int s) {
		maxSize = s;
		stackArray = new char[maxSize] ;
		top = -1;
	}
//-----------------------------------
	public void push(char j) {
		stackArray[++top] = j;
	}
//-----------------------------------
	public char pop() {
		return stackArray[top--];
	}
//-----------------------------------
	public char peek() {
		return stackArray[top];
	}
//------------------------------------
	public boolean isEmpty() {
		return (top == -1);
	}
//------------------------------------
	public boolean isFull() {
		return (top == maxSize-1);
	}
}
/////////////////////////////////////
class Reverser {

	private String input;
	private String output;
//----------------------------------
	public Reverser (String in) {
		input = in;
	}
//----------------------------------
	public String doRev() {

		int stackSize = input.length();
		StackX theStack = new StackX(stackSize);

		for (int j = 0; j < stackSize; j++) {
			char ch = input.charAt(j);
			theStack.push(ch);
		}

		output = "";

		while (!isEmpty()) {
			char ch = theStack.pop();
			output = output + ch;
		}
		return output;
	}
}
/////////////////////////////////////
class ReverseApp {
	public static void main (String args[]) {

		String input;
		String output;

		System.out.println("Enter a string: ");
	}
}