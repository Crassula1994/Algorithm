package level2.num154539;

// 필요한 패키지 불러오기
import java.util.Arrays;
import java.util.Stack;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static int[] solution(int[] numbers) {
		
		// 뒷 큰수를 찾아 저장할 Stack 객체 numberFinder 초기화
        Stack<int[]> numberFinder = new Stack<>();
		
		// 주어진 배열의 뒷 큰수를 저장할 배열 largeNums 초기화
		int[] largeNums = new int[numbers.length];
		
		// fill() 메서드를 사용해 배열 largeNums의 값을 -1로 초기화
        Arrays.fill(largeNums, -1);
        
        // for 반복문을 사용해 배열 numbers의 각 숫자를 차례로 순회
        for (int index = 0; index < numbers.length; index++) {
            
        	// 해당 숫자를 변수 number에 할당
            int number = numbers[index];
            
            // numberFinder가 비어 있지 않고 가장 마지막에 저장된 숫자가 현재 숫자보다 작은 경우
            if (!numberFinder.isEmpty() && numberFinder.peek()[0] < number) {
                
            	// while 반복문을 사용해 numberFinder가 빌 때까지 순회
                while (!numberFinder.isEmpty()) {
                	
                	// numberFinder에 가장 마지막에 저장된 숫자가 현재 숫자보다 크거나 같은 경우 반복문 탈출
                    if (numberFinder.peek()[0] >= number)
                        break;
                    
                    // pop() 메서드를 사용해 뒷 큰수를 찾은 숫자의 정보를 배열 frontNum에 할당
                    int[] frontNum = numberFinder.pop();
                    
                    // 해당 숫자의 뒷 큰수를 갱신
                    largeNums[frontNum[1]] = number;
                }
            }
            
            // push() 메서드를 사용해 해당 숫자의 정보를 numberFinder에 추가
            numberFinder.push(new int[] {number, index});
        }
        
        // 주어진 배열의 뒷 큰수를 저장한 배열을 반환
        return largeNums;
    }
}