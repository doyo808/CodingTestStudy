package programmers;

public class ValidParentheses {

    static boolean solution(String s) {
        char[] chs = s.toCharArray();
        
        int count = 0;
        
        for (char c : chs) {
            if (c == '(') {count++;}
            else if (c == ')') {count--;}
            
            if (count < 0) return false;
        }
        
        return count == 0;
    }
    
    public static void main(String[] args) {
		System.out.println(solution("(()"));
	}
}
