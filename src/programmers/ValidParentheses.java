package programmers;

import java.util.Stack;

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
		System.out.println(solution2("({}[])"));
	}
    
    /*
     	* 추가학습내용:
     	* s.charAt()보다 s.toCharArray()후 비교하는게 미세하게 빠르다
     	* 이유는 charAt()은 메서드호출과정에서 항상 인덱스가 올바른값인가 검증을 해야하기 때문.
     	
     	* JVM(자바 가상머신)이 바이트코드를 하나씩 해석하며 기계어로 컴파일함
     	* 이때 자주쓰이는 부분은 JIT(Just In Time)이 작동하며 좀 더 효율적으로 기계어로 컴파일함
     	* ex> 인라이닝, 루프 언롤링, dead code등
     	* 위에서 char[]는 jit가 작업하니까 미세하게 빠름
     */
    
    // 심화: 복합괄호 문제 (), {}, []를 사용할때 올바른 괄호인지 판별하는 문제
    static boolean solution2(String s) {
    	char[] chs = s.toCharArray();
    	
    	Stack<Character> stack = new Stack<>();
    	
    	for (char c : chs) {
    		if (c == '(' || c == '{' || c == '[') {
    			stack.push(c);
    			
    		} else if (c == ')') {
    			if (stack.isEmpty()) {return false;}
    			else if (stack.peek() == '(') {stack.pop();}
    			else {return false;}
    			
    		} else if (c == '}') {
    			if (stack.isEmpty()) {return false;}
    			else if (stack.peek() == '{') {stack.pop();}
    			else {return false;}
    			
    		} else if (c == ']') {
    			if (stack.isEmpty()) {return false;}
    			else if (stack.peek() == '[') {stack.pop();}
    			else {return false;}
    			
    		} else {return false;}
    	}
    	return stack.isEmpty();
    }
    
    /* !리펙터링 버전
 
 static boolean solution2(String s) {
    Stack<Character> stack = new Stack<>();
    Map<Character, Character> pairs = Map.of(
        ')', '(',
        '}', '{',
        ']', '['
    );

    for (char c : s.toCharArray()) {
        if (pairs.containsValue(c)) {  // 여는 괄호면
            stack.push(c);
        } else if (pairs.containsKey(c)) {  // 닫는 괄호면
            if (stack.isEmpty() || stack.pop() != pairs.get(c)) {	// ||는 단락평가라서 왼쪽이 true면 바로 넘어감
                return false;
            }
        } else {
            return false;  // 괄호 외 문자 처리
        }
    }
    return stack.isEmpty();
}


     */
    
}

