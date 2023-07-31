package level2.num131704;

// 필요한 패키지 불러오기
import java.util.Stack;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static int solution(int[] order) {

		// 컨테이너 벨트와 보조 컨테이너 벨트를 나타낼 각 Stack 객체 초기화
		Stack<Integer> primaryBelt = new Stack<>();
        Stack<Integer> assistBelt = new Stack<>();
        
        // for 반복문을 사용해 각 상자를 컨테이너 벨트에 추가
        for (int n = order.length; n > 0; n--)
            primaryBelt.add(n);
        
        // 영재가 실을 수 있는 상자의 수와 상자를 더 이상 실을 수 없는지를 나타낼 각 변수 초기화
        int count = 0;
        boolean isCompleted = false;
        
        // for 반복문을 사용해 각 상자 순서를 순회
        for (int idx = 0; idx < order.length; idx++) {
            
        	// 현재 싣고자 하는 택배 상자를 변수 targetBox에 할당
            int targetBox = order[idx];
            
            // 보조 컨테이너 벨트가 비어 있지 않고 싣고자 하는 택배 상자가 가장 앞에 있는 경우
            if (!assistBelt.isEmpty() && assistBelt.peek() == targetBox) {
            	
            	// pop() 메서드를 사용해 택배 상자를 보조 컨테이너 벨트에서 제거
                assistBelt.pop();
                
                // 영재가 실을 수 있는 상자의 수 갱신
                count++;
                
                // 다음 순서의 택배 상자를 순회
                continue;
            }
            
            // while 반복문을 사용해 컨테이너 벨트가 빌 때까지 순회
            while (!primaryBelt.isEmpty()) {
                
            	// pop() 메서드를 사용해 컨테이너 벨트에서 뺀 박스를 변수 box에 할당
                int box = primaryBelt.pop();
                
                // 해당 박스가 목표로 하는 상자인 경우 영재가 실을 수 있는 상자의 수 갱신 후 반복문 탈출
                if (box == targetBox) {
                    count++;
                    break;
                }
                
                // add() 메서드를 사용해 뺀 박스를 보조 컨테이너 벨트에 추가
                assistBelt.add(box);
            }
            
            // 컨테이너 벨트가 빈 경우
            if (primaryBelt.isEmpty()) {
                
            	// 보조 컨테이너 벨트까지 확인한 경우 반복문 탈출
                if (isCompleted) {
                    break;
                    
                // 보조 컨테이너 벨트를 확인하지 않은 경우 보조 컨테이너 벨트를 확인했는지 여부를 갱신
                } else {
                    isCompleted = true;
                }
            }
        }
        
        // 영재가 실을 수 있는 상자의 수를 반환
        return count;
    }
}