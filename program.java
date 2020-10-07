import java.util.*;

public class program {
	public static void main(String argc[]) {
		Scanner read = new Scanner(System.in);
		String input=read.nextLine();
		int i,judge=0,begin=0;
		String str;
		for(i=0;i<input.length();i++) {
			if(input.charAt(i)=='+'||input.charAt(i)=='*'||input.charAt(i)==','||input.charAt(i)=='('||input.charAt(i)==')') {
				if(input.charAt(i)=='+')
					System.out.println("Plus");
				if(input.charAt(i)=='*')
					System.out.println("Star");
				if(input.charAt(i)==',')
					System.out.println("Comma");
				if(input.charAt(i)=='(')
					System.out.println("LParenthesis");
				if(input.charAt(i)==')')
					System.out.println("RParenthesis");
				if(judge==0) {
					begin=i+1;
				}
				else {
					if(judge==1) {
						str=input.substring(begin,i);
						if(str.equals("BEGIN")) {
							System.out.println("Begin");
						}
						else if(str.equals("END")) {
							System.out.println("End");
						}
						else if(str.equals("FOR")) {
							System.out.println("For");
						}
						else if(str.equals("IF")) {
							System.out.println("If");
						}
						else if(str.equals("THEN")) {
							System.out.println("Then");
						}
						else if(str.equals("ELSE")) {
							System.out.println("Else");
						}
						else
							System.out.println("Ident("+input.substring(begin,i)+")");
						begin=i+1;
					}
					else if(judge==2) {
						System.out.println("Int("+Integer.valueOf(input.substring(begin,i))+")");
						begin=i+1;
					}
				}
				judge=0;
			}
			else if(input.charAt(i)<='9'&&input.charAt(i)>='0') {
				if(judge==0)
					judge=2;
			}
			else if(input.charAt(i)<='z'&&input.charAt(i)>='a'||input.charAt(i)<='Z'&&input.charAt(i)>='A') {
				if(judge==0) {
					judge=1;
				}
				else {
					if(judge==2) {
						System.out.println("Int("+Integer.valueOf(input.substring(begin,i))+")");
						begin=i;
						judge=1;
					}
				}
			}
			else if(input.charAt(i)==':') {
				if(judge==1) {
					str=input.substring(begin,i);
					if(str.equals("BEGIN")) {
						System.out.println("Begin");
					}
					else if(str.equals("END")) {
						System.out.println("End");
					}
					else if(str.equals("FOR")) {
						System.out.println("For");
					}
					else if(str.equals("IF")) {
						System.out.println("If");
					}
					else if(str.equals("THEN")) {
						System.out.println("Then");
					}
					else if(str.equals("ELSE")) {
						System.out.println("Else");
					}
					else
						System.out.println("Ident("+input.substring(begin,i)+")");
				}
				else if(judge==2) {
					System.out.println("Int("+Integer.valueOf(input.substring(begin,i))+")");
				}
				if(i+1<input.length()&&input.charAt(i+1)=='=') {
					System.out.println("Assign");
					i++;
				}
				else {
					System.out.println("Colon");
				}
				begin=i+1;
				judge=0;
			}
			else {
				System.out.println("Unknown");
				return;
			}
		}
		if(judge==1) {
			str=input.substring(begin,i);
			if(str.equals("BEGIN")) {
				System.out.println("Begin");
			}
			else if(str.equals("END")) {
				System.out.println("End");
			}
			else if(str.equals("FOR")) {
				System.out.println("For");
			}
			else if(str.equals("IF")) {
				System.out.println("If");
			}
			else if(str.equals("THEN")) {
				System.out.println("Then");
			}
			else if(str.equals("ELSE")) {
				System.out.println("Else");
			}
			else
				System.out.println("Ident("+input.substring(begin,i)+")");
		}
		else if(judge==2)
			System.out.println("Int("+Integer.valueOf(input.substring(begin,i))+")");
	}
}
