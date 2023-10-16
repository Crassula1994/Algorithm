package level2.num132265;

// 필요한 패키지 불러오기
import java.util.HashSet;
import java.util.Set;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static int solution(int[] topping) {
		
		// 롤케이크를 공평하게 자르는 방법의 수를 저장할 변수 count 초기화
		int count = 0;
		
		// 각 위치에서 토핑의 개수를 저장할 2차원 배열 counts 초기화
        int[][] counts = new int [2][topping.length + 1];
        
        // 지금까지 나온 토핑의 종류를 저장할 Set 객체 category 초기화
        Set<Integer> category = new HashSet<>();
        
        // for 반복문을 사용해 각 위치의 롤케이크를 잘랐을 경우를 순회
        for (int idx = 1; idx <= topping.length; idx++) {
            
        	// 해당 위치의 토핑이 지금까지 나온 토핑인 경우 토핑의 개수 유지
            if (category.contains(topping[idx - 1])) {
                counts[0][idx] = counts[0][idx - 1];
            
            // 해당 위치의 토핑이 지금까지 나오지 않은 토핑인 경우
            } else {
            	
            	// 토핑의 개수 갱신
                counts[0][idx] = counts[0][idx - 1] + 1;
                
                // add() 메서드를 사용해 토핑의 종류를 추가
                category.add(topping[idx - 1]);
            }
        }
        
        // 지금까지 나온 토핑의 종류를 저장할 Set 객체 category 초기화
        category = new HashSet<>();
        
        // for 반복문을 사용해 각 위치의 롤케이크를 잘랐을 경우를 거꾸로 순회
        for (int idx = topping.length - 1; idx >= 0; idx--) {
            
        	// 해당 위치의 토핑이 지금까지 나온 토핑인 경우 토핑의 개수 유지
            if (category.contains(topping[idx])) {
                counts[1][idx] = counts[1][idx + 1];
            
            // 해당 위치의 토핑이 지금까지 나오지 않은 토핑인 경우
            } else {
            	
            	// 토핑의 개수 갱신
                counts[1][idx] = counts[1][idx + 1] + 1;
                
                // add() 메서드를 사용해 토핑의 종류를 추가
                category.add(topping[idx]);
            }
            
            // 현재 위치까지의 토핑의 개수가 각각 일치하는 경우 롤케이크를 공평하게 자르는 방법의 수를 갱신
            if (counts[0][idx] == counts[1][idx])
                count++;
        }
        
        // 롤케이크를 공평하게 자르는 방법의 수를 반환
        return count;
    }
}