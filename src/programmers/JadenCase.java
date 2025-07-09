package programmers;

public class JadenCase {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean afterBlank = true;
        
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);    
            
            if (Character.isWhitespace(ch)) {
                sb.append(ch);
                afterBlank = true;
                continue;
            }
            
            if (afterBlank) {
                ch = Character.toUpperCase(ch);
                afterBlank = false;
            } else {
                ch = Character.toLowerCase(ch);
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}
