package level2.num131127;

// 필요한 패키지 불러오기
import java.util.HashMap;
import java.util.Map;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static int solution(String[] want, int[] number, String[] discount) {

		// 정현이가 원하는 제품 목록과 정현이가 아직 구하지 못한 제품 목록을 저장할 각 Map 객체 초기화
		Map<String, Integer> wantList = new HashMap<>();
        Map<String, Integer> remainList = new HashMap<>();
        
        // 현재 구하지 못한 제품의 개수 및 회원 등록이 가능한 총 일수를 저장할 각 변수 초기화
        int remains = 0;
        int count = 0;
        
        // for 반복문을 사용해 정현이가 원하는 제품을 순회
        for (int idx = 0; idx < want.length; idx++) {
        	
        	// put() 메서드를 사용해 정현이가 원하는 제품 목록과 아직 구하지 못한 제품 목록을 갱신
            wantList.put(want[idx], number[idx]);
            remainList.put(want[idx], number[idx]);
            
            // 정현이가 현재 구하지 못한 제품의 개수를 갱신
            remains += number[idx];
        }
        
        // for 반복문을 사용해 첫 10일 간의 할인 제품을 순회
        for (int idx = 0; idx < 10; idx++) {
        	
        	// 해당 날짜의 품목을 변수 product에 할당
            String product = discount[idx];
            
            // 해당 날짜의 품목이 정현이가 원하는 제품인 경우
            if (wantList.containsKey(product)) {
            	
            	// 정현이가 아직 구하지 못한 제품인 경우 현재 구하지 못한 제품의 개수를 갱신
                if (remainList.get(product) > 0)
                    remains--;
                
                // get() 및 replace() 메서드를 사용해 정현이가 아직 구하지 못한 제품 목록을 갱신
                remainList.replace(product, remainList.get(product) - 1);
            }
        }
        
        // 회원 등록이 가능한 경우 회원 등록이 가능한 총 일수를 갱신
        if (remains == 0)
        	count++;
        
        // for 반복문을 사용해 다음 날짜의 할인 제품을 순회
        for (int idx = 0; idx < discount.length - 10; idx++) {
            
        	// 10일 간의 할인 품목에서 빠지는 품목과 들어오는 품목을 각 변수에 할당
            String outProduct = discount[idx];
            String inProduct = discount[idx + 10];
            
            // 할인 품목에서 빠지는 품목이 정현이가 원하는 제품인 경우
            if (wantList.containsKey(outProduct)) {
            	
            	// get() 및 replace() 메서드를 사용해 정현이가 아직 구하지 못한 제품 목록을 갱신
                remainList.replace(outProduct, remainList.get(outProduct) + 1);
                
                // 정현이가 아직 구하지 못한 제품인 경우 현재 구하지 못한 제품의 개수를 갱신
                if (remainList.get(outProduct) > 0)
                    remains++;
            }
            
            // 할인 품목에 들어오는 품목이 정현이가 원하는 제품인 경우
            if (wantList.containsKey(inProduct)) {
            	
            	// 정현이가 아직 구하지 못한 제품인 경우 현재 구하지 못한 제품의 개수를 갱신
                if (remainList.get(inProduct) > 0)
                    remains--;
                
                // get() 및 replace() 메서드를 사용해 정현이가 아직 구하지 못한 제품 목록을 갱신
                remainList.replace(inProduct, remainList.get(inProduct) - 1);
            }
            
            // 회원 등록이 가능한 경우 회원 등록이 가능한 총 일수를 갱신
            if (remains == 0)
                count++;
        }
        
        // 회원 등록이 가능한 총 일수를 반환
        return count;
	}
}