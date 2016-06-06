package teisei.algo.bop;

/**
 * Created by Teisei on 2016/4/23.
 */
public class P6 {
    public static void main(String[] args) {
        String str = "hphp";
        System.out.println(Puzzle(str));

    }
    public static Boolean Puzzle(String str) {
        if (str.length() > 1){
            for(int i=1;i<=str.length()/2;i++) {
                String substring = str.substring(0, i);
                if (canBeDivided(str, substring)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean canBeDivided(String str, String substring) {
        String tmpString = "";
        while (tmpString.length() < str.length()) {
            tmpString += substring;
        }
        return tmpString.equals(str);
    }
}
