package programmers;

public class BinaryToOne {
	// 1차 풀이
    public int[] solution(String s) {
        int zeroNum = 0;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        
        while (!s.equals("1")) {
            char[] chs = s.toCharArray();
            for (char c : chs) {
                if (c == '1') sb.append(c);
                else zeroNum++;
            }
            int len = sb.length();
            s = Integer.toString(len, 2);
            sb.setLength(0);
            count++;
        }
        return new int[] {count, zeroNum};
    }
    
    // 참고풀이
    public int[] solution2(String s) {
        int[] answer = new int[2];
        int temp;
        while( !s.equals("1") ) {
            answer[1] += s.length();
            s = s.replaceAll("0", "");
            temp = s.length();
            s = Integer.toBinaryString(temp);
            //System.out.println("s : " + s ); 
            answer[0]++;
            answer[1] -= temp;
        }
        return answer;  
    }

}
