import java.io.*;

public class program {
	public static void main(String args[]) {
		File file = new File(args[0]);
		StringBuilder sb = new StringBuilder();
		try {
			FileReader reader = new FileReader(file);
			BufferedReader bReader = new BufferedReader(reader);
	        String s = "";
	        while ((s =bReader.readLine()) != null) {
	            sb.append(s);
	        }
	        bReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String in = sb.toString();
		int i,judge=0,begin=0;
		String str;
		for(i=0;i<in.length();i++) {
			if(in.charAt(i)=='+'||in.charAt(i)=='*'||in.charAt(i)==','||in.charAt(i)=='('||in.charAt(i)==')') {
				if(judge==0) {
					begin=i+1;
				}
				else {
					if(judge==1) {
						str=in.substring(begin,i);
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
							System.out.println("Ident("+in.substring(begin,i)+")");
						begin=i+1;
					}
					else if(judge==2) {
						System.out.println("Int("+Integer.valueOf(in.substring(begin,i))+")");
						begin=i+1;
					}
				}
				if(in.charAt(i)=='+')
					System.out.println("Plus");
				if(in.charAt(i)=='*')
					System.out.println("Star");
				if(in.charAt(i)==',')
					System.out.println("Comma");
				if(in.charAt(i)=='(')
					System.out.println("LParenthesis");
				if(in.charAt(i)==')')
					System.out.println("RParenthesis");
				judge=0;
			}
			else if(in.charAt(i)<='9'&&in.charAt(i)>='0') {
				if(judge==0)
					judge=2;
			}
			else if(in.charAt(i)<='z'&&in.charAt(i)>='a'||in.charAt(i)<='Z'&&in.charAt(i)>='A') {
				if(judge==0) {
					judge=1;
				}
				else {
					if(judge==2) {
						System.out.println("Int("+Integer.valueOf(in.substring(begin,i))+")");
						begin=i;
						judge=1;
					}
				}
			}
			else if(in.charAt(i)==':') {
				if(judge==1) {
					str=in.substring(begin,i);
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
						System.out.println("Ident("+in.substring(begin,i)+")");
				}
				else if(judge==2) {
					System.out.println("Int("+Integer.valueOf(in.substring(begin,i))+")");
				}
				if(i+1<in.length()&&in.charAt(i+1)=='=') {
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
				break;
			}
		}
		if(judge==1) {
			str=in.substring(begin,i);
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
				System.out.println("Ident("+in.substring(begin,i)+")");
		}
		else if(judge==2)
			System.out.println("Int("+Integer.valueOf(in.substring(begin,i))+")");
	}
}
