package level2.num043165;

// Solution 클래스 정의
public class Solution {
	
	// 타겟 넘버와 타겟 넘버를 만드는 방법의 수를 저장할 각 변수 초기화
	public static int targetNumber;
	public static int count = 0;
	
	// 사용할 수 있는 숫자를 저장할 배열 numberList 초기화
	public static int[] numberList;
	
	// ----------------------------------------------------------------------------------------------------
	
	// solution() 메서드 정의
	public static int solution(int[] numbers, int target) {

		// 타겟 넘버를 변수 targetNumber에 저장
		targetNumber = target;
		
		// 사용할 수 있는 숫자를 저장할 배열 numberList 초기화
		numberList = numbers;
        
		// calculator() 메서드를 호출해 타겟 넘버를 만드는 방법의 수를 갱신
        calculator(0, 0);
        
        // 타겟 넘버를 만드는 방법의 수를 반환
        return count;
    }
	
	// ----------------------------------------------------------------------------------------------------
    
	// calculator() 메서드 정의
    public static void calculator(int checkedNum, int sum) {
        
    	// 사용할 수 있는 숫자를 모두 사용한 경우
        if (checkedNum == numberList.length) {
        	
        	// 타겟 넘버를 만든 경우 타겟 넘버를 만드는 방법의 수를 갱신
            if (sum == targetNumber)
                count++;
            
            // 메서드 종료
            return;
        }
        
        // 더하기 부호를 사용한 경우를 상정해 calculator() 메서드 재귀 호출
        calculator(checkedNum + 1, sum + numberList[checkedNum]);
        
        // 빼기 부호를 사용한 경우를 상정해 calculator() 메서드 재귀 호출
        calculator(checkedNum + 1, sum - numberList[checkedNum]);
    }
}