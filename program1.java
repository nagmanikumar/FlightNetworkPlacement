import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StackApplication {
  private int [] numArray = new int[10];
	private int count = 0;
	private Stack stack = new Stack();
	
	public static void main(String args[]){
		
		StackApplication stackApp = new StackApplication();
		try {
			  System.out.println("Please enter the digit(0-9) pattern:");
		      InputStreamReader is = new InputStreamReader(System.in);
		      BufferedReader br = new BufferedReader(is);
		      String numbers = br.readLine();
		      //System.out.println(numbers);
		      if(numbers == null || numbers.equals("")){
		    	  System.exit(0);
		      }
		      String [] numCharArr = numbers.split(" ");
		      
		      for(int i=0;i<numCharArr.length;i++ ){
		    	  stackApp.numArray[i] = Integer.parseInt(numCharArr[i]);
		    	  //System.out.println(numArray[i]);
		      }
		    } catch (NumberFormatException e) {
		    	System.out.println("Only Digits(0-9)are allowed in pattern.");
		    } catch (IOException e){
		    	System.out.println("Some IO error occured while reading input from keyboard. Please check below stacktrace.");
		    	e.printStackTrace();
		    }
		    
		    for(int i = 0; i <= 9; i++){
		    	stackApp.stack.push(i);
		    	stackApp.checkWithOutput();
		    	
		    }
		    System.out.println("This is a valid pattern. This can be done by using below operations:");
		    stackApp.stack.printOperationMessages();
		    
	}
	public void checkWithOutput(){
		
			if(!(this.stack.isEmpty()) && (this.stack.getTopElement() >= this.numArray[this.count])){
				checkSequence();
				this.stack.pop();
				this.count = this.count + 1;
				checkWithOutput();
			}
			else {
				return;
				
			}
	}
	
	public void checkSequence(){
		
		if( this.numArray[this.count] != this.stack.getTopElement()){
			System.out.println("This pattern is not valid pattern.");
			System.exit(0);
		}
	}
		
	
}
/*
 * Stack class implements Stack. This class is having two operation: Push and Pop
 * 
 */

class Stack {
	private int top;
	private int [] elements;
	private static final int MAX_SIZE = 10; 
	private String [] message;
	private int messageCount;
	private int lastPoppedElement = -1;
	Stack (){
		this.elements = new int[MAX_SIZE];
		this.top = -1;
		this.message = new String[20];
		this.messageCount = -1;
	}
	public int getLastPoppedElement(){
		
		return this.lastPoppedElement;
	}
	public void push(int element){
		this.top = this.top + 1;
		System.out.println("PUSH :" + element);
		this.elements[top] = element;
		this.messageCount = this.messageCount + 1;
		this.message[this.messageCount] = "PUSH: " + element;
		
		
	}
	
	public int getTopElement(){
		if(!isEmpty()){
			int topElement = this.elements[this.top];
			return topElement;
		}
		else {
			return -1;
		}
	}
	
	public void pop(){
		if(!isEmpty()){
			int topElement = this.elements[this.top];
			this.top = this.top - 1;
			this.lastPoppedElement = topElement;
			this.messageCount = this.messageCount + 1;
			this.message[this.messageCount] = "POP: " + topElement;
			System.out.println("POP :" + topElement);
		}
		
	}
	public boolean isEmpty(){
		if(this.top == -1){
			System.out.println("Stack is empty.");
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isFull() {
		if(this.top == this.MAX_SIZE){
			System.out.println("Stack is full.");
			return true;
		}
		else {
			return false;
		}
	}
	
	public void printOperationMessages(){
		for(int i = 0; i< this.message.length; i++){
			System.out.println(this.message[i]);
		}
	}
	
}
