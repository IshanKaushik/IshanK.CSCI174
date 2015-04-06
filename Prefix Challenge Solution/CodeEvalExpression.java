
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class CodeEvalExpression {
	public static void main(String[] args) throws IOException {

		File file = new File("Path to your file Or as ARGS");
		BufferedReader br = new BufferedReader(new FileReader(file));
		try {
			String sentence = br.readLine();
			while (sentence != null && sentence.length() > 0) {
				String prefixExpression = sentence.toString();
				StringTokenizer tokenisedString = new StringTokenizer(prefixExpression);

				Stack<String> operatorList = new Stack<String>();
				Stack<Float> numberList = new Stack<Float>();
				boolean lastoperator = false;

				while (tokenisedString.hasMoreElements()) {
					String strng = tokenisedString.nextToken();

					if (strng.equals("*") || strng.equals("+") || strng.equals("/")) {
						operatorList.add(strng);
						lastoperator = true;
					} else if (lastoperator || numberList.isEmpty()) {
						numberList.add(Float.valueOf(strng));
						lastoperator = false;
					} else {
						numberList.add(doOperation(operatorList.pop(), numberList.pop(),
								Float.valueOf(strng)));
					}
				}

				// result
				System.out.println(Math.round(numberList.pop()));
				sentence = br.readLine();
			}
		} finally {
			br.close();
		}
	}

	public static Float doOperation(String op, Float a, Float b) {
		if (op.equals("+")) {
			return a + b;
		} else if (op.equals("*")) {
			return a * b;
		} else if (op.equals("/")) {
			return a / b;
		}
		return (float) 0;
	}

}