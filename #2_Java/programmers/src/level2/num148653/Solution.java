package level2.num148653;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static int solution(int storey) {

		// 0층으로 가기 위해 필요한 마법의 돌의 최솟값을 저장할 변수 minAmount 초기화
		int minAmount = 0;
        
		// while 반복문을 사용해 현재 엘리베이터가 있는 층이 0층이 될 때까지 순회
        while (storey > 0) {
            
        	// 현재 층수의 일의 자리수를 변수 number에 할당
            int number = storey % 10;
            
            // 일의 자리수가 5보다 크거나, 일의 자리수가 5이고 십의 자리수가 5와 같거나 큰 경우
            if (number > 5 || (number == 5 && (storey / 10) % 10 >= 5)) {
            	
            	// 엘리베이터를 타고 올라가는 것이 유리하므로 마법의 돌 최솟값과 층수를 올라간 경우로 갱신
                minAmount += 10 - number;
                storey += 10 - number;
                
            // 나머지가 5보다 같거나 작고, 나머지가 5가 아니거나 다음 나머지가 5보다 작은 경우
            } else {
            	
            	// 엘리베이터를 타고 내려가는 것이 유리하므로 마법의 돌 최솟값과 층수를 내려간 경우로 갱신
                minAmount += number;
                storey -= number;
            }
            
            // 현재 층수를 10으로 나누어 다음 자리수를 순회
            storey /= 10;
        }
        
        // 0층으로 가기 위해 필요한 마법의 돌의 최솟값을 반환
        return minAmount;
	}
}