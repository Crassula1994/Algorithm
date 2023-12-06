package level2.num172927;

// Solution 클래스 정의
public class Solution {
	
	// 최소한의 피로도를 저장할 변수 minFatigue 초기화
	static int minFatigue = Integer.MAX_VALUE;
	
	// 각 곡괭이의 개수를 저장할 배열 pickaxes 초기화
    static int[] pickaxes;
	
	// ----------------------------------------------------------------------------------------------------
	
	// solution() 메서드 정의
	public static int solution(int[] picks, String[] minerals) {
		
		// 각 곡괭이의 개수를 저장할 배열 pickaxes 초기화
		pickaxes = picks;
        
		// fatigueCalculator() 메서드를 호출해 최소한의 피로도를 갱신
        fatigueCalculator(0, 0, minerals);
        
        // 최소한의 피로도를 반환
        return minFatigue;
    }
	
	// ----------------------------------------------------------------------------------------------------

	// fatigueCalculator() 메서드 정의
	public static void fatigueCalculator(int mined, int fatigue, String[] minerals) {
		
		// 모든 광물을 캤거나 모든 곡괭이를 사용한 경우
        if (mined == minerals.length || pickaxes[0] + pickaxes[1] + pickaxes[2] == 0) {
        	
        	// min() 메서드를 사용해 최소한의 피로도를 갱신 후 메서드 종료
            minFatigue = Math.min(fatigue, minFatigue);
            return;
        }
        
        // min() 메서드를 사용해 곡괭이로 광물을 캘 수 있는 최대 광물의 순서를 변수 boundary에 할당
        int boundary = Math.min(mined + 5, minerals.length);
        
        // 다이아몬드 곡괭이를 사용할 수 있는 경우
        if (pickaxes[0] > 0) {
        	
        	// 광물 채취 후 피로도를 저장할 변수 newFatigue 초기화
            int newFatigue = fatigue;
            
            // 다이아몬드 곡괭이를 사용한 것으로 처리
            pickaxes[0]--;
            
            // for 반복문을 사용해 채취한 광물의 수만큼 피로도를 갱신
            for (int idx = mined; idx < boundary; idx++)
                newFatigue++;
            
            // fatigueCalculator() 메서드 재귀 호출
            fatigueCalculator(boundary, newFatigue, minerals);
            
            // 다이아몬드 곡괭이를 사용하지 않은 것으로 처리
            pickaxes[0]++;
        }
        
        // 철 곡괭이를 사용할 수 있는 경우
        if (pickaxes[1] > 0) {
        	
        	// 광물 채취 후 피로도를 저장할 변수 newFatigue 초기화
            int newFatigue = fatigue;
            
            // 철 곡괭이를 사용한 것으로 처리
            pickaxes[1]--;
            
            // for 반복문을 사용해 채취할 수 있는 광물을 순회
            for (int idx = mined; idx < boundary; idx++) {
            	
            	// 현재 채취한 광물을 변수 mineral에 할당
                String mineral = minerals[idx];
                
                // 현재 채취한 광물이 다이아몬드인 경우 5의 피로도를 갱신
                if (mineral.equals("diamond")) {
                    newFatigue += 5;
                    
                // 현재 채취한 광물이 철 또는 돌인 경우 1의 피로도를 갱신
                } else {
                    newFatigue++;
                }
            }
            
            // fatigueCalculator() 메서드 재귀 호출
            fatigueCalculator(boundary, newFatigue, minerals);
            
            // 철 곡괭이를 사용하지 않은 것으로 처리
            pickaxes[1]++;
        }
        
        // 돌 곡괭이를 사용할 수 있는 경우
        if (pickaxes[2] > 0) {
        	
        	// 광물 채취 후 피로도를 저장할 변수 newFatigue 초기화
            int newFatigue = fatigue;
            
            // 돌 곡괭이를 사용한 것으로 처리
            pickaxes[2]--;
            
            // for 반복문을 사용해 채취할 수 있는 광물을 순회
            for (int idx = mined; idx < boundary; idx++) {
            	
            	// 현재 채취한 광물을 변수 mineral에 할당
                String mineral = minerals[idx];
                
                // 현재 채취한 광물이 다이아몬드인 경우 25의 피로도를 갱신
                if (mineral.equals("diamond")) {
                    newFatigue += 25;
                    
                // 현재 채취한 광물이 철인 경우 5의 피로도를 갱신
                } else if (mineral.equals("iron")) {
                    newFatigue += 5;
                    
                // 현재 채취한 광물이 돌인 경우 1의 피로도를 갱신
                } else {
                    newFatigue++;
                }
            }
            
            // fatigueCalculator() 메서드 재귀 호출
            fatigueCalculator(boundary, newFatigue, minerals);
            
            // 돌 곡괭이를 사용하지 않은 것으로 처리
            pickaxes[2]++;
        }
    }
}