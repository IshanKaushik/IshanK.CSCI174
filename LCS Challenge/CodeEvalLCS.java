import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CodeEvalLCS {
	
    public static void main(String[] args) {
    	
        try {
            File file = new File("Path to your File");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String nextLine;
            while ((nextLine = br.readLine()) != null) {
                if (nextLine.trim().equals(""))
                    continue;
                String[] splittedStringArray = nextLine.split(";");
                if (splittedStringArray.length > 0) {
                    // Process line of input Here
                    calculateLCS(splittedStringArray);
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }
    }


    private static void calculateLCS(String[] splittedStringArray) {
        String fisrtString = splittedStringArray[0].trim();
        String scondString = splittedStringArray[1].trim();
        String calculatingLCS = returnedCalculatedLCS(fisrtString, scondString);
        System.out.println(calculatingLCS.trim());
    }

    public static String returnedCalculatedLCS(String firstString, String secondString) {
        int firstStringLength = firstString.length();
        int secondStringLength = secondString.length();
        int[][] lcs2dintArray = new int[firstStringLength + 1][secondStringLength + 1];
        String[][] lcs2dStringArray = new String[firstStringLength + 1][secondStringLength + 1];
        for (int i = 0; i <= firstStringLength; i++) {
            lcs2dintArray[i][0] = 0;
            lcs2dStringArray[i][0] = "";
        }
        for (int j = 0; j <= secondStringLength; j++) {
            lcs2dintArray[0][j] = 0;
            lcs2dStringArray[0][j] = "";
        }
        for (int i = 1; i <= firstStringLength; i++)
            for (int j = 1; j <= secondStringLength; j++) {
                if (firstString.charAt(i - 1) == secondString.charAt(j - 1)) {
                    lcs2dintArray[i][j] = lcs2dintArray[i - 1][j - 1] + 1;
                    lcs2dStringArray[i][j] = lcs2dStringArray[i - 1][j - 1]
                            + String.valueOf(firstString.charAt(i - 1));
                } else {
                    lcs2dintArray[i][j] = Math.max(lcs2dintArray[i - 1][j], lcs2dintArray[i][j - 1]);
                    if (lcs2dintArray[i - 1][j] > lcs2dintArray[i][j - 1])
                        lcs2dStringArray[i][j] = lcs2dStringArray[i - 1][j];
                    else
                        lcs2dStringArray[i][j] = lcs2dStringArray[i][j - 1];
                }
            }
        return lcs2dStringArray[firstStringLength][secondStringLength];
    }
}
    


