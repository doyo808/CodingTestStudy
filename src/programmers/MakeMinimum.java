package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MakeMinimum {
	 public static int solution(int []A, int []B)
	    {
	        Arrays.sort(A);
	        Arrays.sort(B);
	        
	        int len = A.length;
	        int sum = 0;
	        for (int i = 0; i < len; i++) {
	            sum += A[i] * B[len - 1 - i];
	        }
	        return sum;
	    }
	 public static void main(String[] args) {
		
	}
	
	 public static int solution2(int []A, int []B)
	    {
		 Arrays.sort(A);
	        // B를 내림차순 정렬
	        Integer[] Bdesc = Arrays.stream(B).boxed()
	                                .sorted(Comparator.reverseOrder())
	                                .toArray(Integer[]::new);
	        
	        int sum = 0;
	        for (int i = 0; i < A.length; i++) {
	            sum += A[i] * Bdesc[i];
	        }
	        return sum;
	    }
	 
	 // 우선순위 큐는 항상 최소값부터 꺼낸다. reverseOrder를 해주면 최대값부터 꺼낸다
	 public int solution3(int[] A, int[] B) {
	        PriorityQueue<Integer> minHeapA = new PriorityQueue<>();
	        PriorityQueue<Integer> maxHeapB = new PriorityQueue<>(Collections.reverseOrder());
	        
	        for (int a : A) minHeapA.offer(a);
	        for (int b : B) maxHeapB.offer(b);
	        
	        int sum = 0;
	        while (!minHeapA.isEmpty()) {
	            sum += minHeapA.poll() * maxHeapB.poll();
	        }
	        return sum;
	    }
}
