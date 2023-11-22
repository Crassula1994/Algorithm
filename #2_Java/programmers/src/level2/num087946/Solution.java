package level2.num087946;

// Solution 클래스 정의
public class Solution {
	
	// 유저가 탐험할 수 있는 최대 던전 수를 저장할 변수 maxCount 초기화
	static int maxCount = 0;
	
	// 해당 던전을 방문 가능한지 확인 여부를 저장할 배열 checked 초기화
    static boolean[] checked;
    
    // 각 던전의 피로도 정보를 저장할 2차원 배열 dungeonInfo 초기화
    static int[][] dungeonInfo;
    
    // ----------------------------------------------------------------------------------------------------
	
	// solution() 메서드 정의
	public static int solution(int k, int[][] dungeons) {

		// 해당 던전을 방문 가능한지 확인 여부를 저장할 배열 checked 초기화
		checked = new boolean[dungeons.length];
		
		// 각 던전의 피로도 정보를 저장할 2차원 배열 dungeonInfo 초기화
		dungeonInfo = dungeons;
        
		// dungeonSearcher() 메서드를 호출해 유저가 탐험할 수 있는 최대 던전 수를 갱신
		dungeonSearcher(0, 0, k);
        
        // 유저가 탐험할 수 있는 최대 던전 수를 반환
        return maxCount;
    }
	
	// ----------------------------------------------------------------------------------------------------
    
	// dungeonSearcher() 메서드 정의
    public static void dungeonSearcher(int checkCnt, int visitCnt, int fatigability) {
        
    	// 모든 던전의 방문 가능 여부를 확인한 경우
        if (checkCnt == dungeonInfo.length) {
        	
        	// max() 메서드를 사용해 유저가 탐험할 수 있는 최대 던전 수를 갱신 후 메서드 종료 
            maxCount = Math.max(visitCnt, maxCount);
            return;
        }
            
        // for 반복문을 사용해 각 던전의 피로도 정보를 차례로 순회
        for (int idx = 0; idx < dungeonInfo.length; idx++) {
            
        	// 해당 던전을 이미 확인한 경우 다음 던전을 순회
            if (checked[idx])
                continue;
            
            // 해당 던전을 확인한 것으로 처리
            checked[idx] = true;
            
            // 해당 던전을 탐험할 수 있는 경우 dungeonSearcher() 메서드 재귀 호출
            if (fatigability >= dungeonInfo[idx][0]) {
            	dungeonSearcher(checkCnt + 1, visitCnt + 1, fatigability - dungeonInfo[idx][1]);
            	
            // 해당 던전을 탐험할 수 없는 경우 dungeonSearcher() 메서드 재귀 호출
            } else {
            	dungeonSearcher(checkCnt + 1, visitCnt, fatigability);
            }
            
            // 해당 던전을 확인하지 않은 것으로 원상 복구
            checked[idx] = false;
        }
    }
}