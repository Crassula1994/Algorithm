package level2.num154540;

// 필요한 패키지 불러오기
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

// Solution 클래스 정의
public class Solution {

	// 지도의 행의 수와 열의 수를 저장할 각 변수 초기화
	static int rowNum;
    static int colNum;
	
    // 인접한 위치를 나타낼 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    // 각 섬에서 최대 머무를 수 있는 날짜를 저장할 배열 counter 초기화
    static int[] counter;
    
    // 지도의 정보를 저장할 2차원 배열 map 초기화
    static int[][] map;
    
    // 각 섬에서 머물 수 있는 날짜를 오름차순으로 정렬할 PriorityQueue 객체 sorter 초기화
    static PriorityQueue<Integer> sorter = new PriorityQueue<>();
    
    // ----------------------------------------------------------------------------------------------------
	
	// solution() 메서드 정의
	public static int[] solution(String[] maps) {

		// length() 메서드를 사용해 지도의 행의 수와 열의 수를 각 변수에 할당
		rowNum = maps.length;
        colNum = maps[0].length();
        
        // 지도의 정보를 저장할 2차원 배열 map 초기화
        map = new int[rowNum][colNum];
        
        // for 반복문을 사용해 지도의 각 행을 순회
        for (int r = 0; r < rowNum; r++) {
        	
        	// 해당 지도의 행 정보를 변수 row에 할당
            String row = maps[r];
            
            // for 반복문을 사용해 지도의 각 열을 순회
            for (int c = 0; c < colNum; c++) {
            	
            	// charAt() 메서드를 사용해 해당 위치의 식량 정보를 변수 foodInfo에 할당
                char foodInfo = row.charAt(c);
                
                // 해당 위치가 바다인 경우 2차원 배열 map에 0을 저장
                if (foodInfo == 'X') {
                    map[r][c] = 0;
                    
                // 해당 위치가 섬인 경우 2차원 배열 map에 식량 정보를 저장
                } else {
                    map[r][c] = foodInfo - '0';
                }
            }
        }
        
        // for 반복문을 사용해 지도의 행과 열을 순회
        for (int r = 0; r < rowNum; r++) {
            for (int c = 0; c < colNum; c++) {
                
            	// 해당 위치가 섬인 경우 dayCounter() 메서드를 호출해 해당 섬에서 머무를 수 있는 최대 일수를 갱신
                if (map[r][c] != 0)
                    dayCounter(r, c);
            }
        }
        
        // 지낼 수 있는 무인도가 없는 경우
        if (sorter.size() == 0) {
        	
        	// 각 섬에서 최대 머무를 수 있는 날짜를 저장할 배열 counter 초기화
            counter = new int[1];
            
            // -1을 배열에 저장
            counter[0] = -1;
            
        // 지낼 수 있는 무인도가 있는 경우
        } else {
            
        	// 각 섬에서 최대 머무를 수 있는 날짜를 저장할 배열 counter 초기화
            counter = new int[sorter.size()];
            
            // 저장할 배열의 인덱스를 나타낼 변수 index 초기화
            int index = 0;
            
            // while 반복문을 사용해 모든 섬의 최대 머무를 수 있는 날짜를 배열 counter에 저장
            while (!sorter.isEmpty()) {
                counter[index] = sorter.poll();
                index++;
            }
        }
        
        // 모든 섬의 최대 체류일수를 저장한 배열 counter 반환
        return counter;
    }
	
	// ----------------------------------------------------------------------------------------------------
	
	// dayCounter() 메서드 정의
	public static void dayCounter(int startRow, int startCol) {
		
		// 해당 섬에서 머무를 수 있는 날짜를 저장할 변수 dayCnt 초기화
		int dayCnt = 0;
        
		// 다음에 방문할 위치를 저장할 Queue 객체 visitList 초기화
        Queue<int[]> visitList = new LinkedList<>();
        
        // offer() 메서드를 사용해 시작 위치를 visitList에 추가
        visitList.offer(new int[] {startRow, startCol});
        
        // 해당 섬에서 머무를 수 있는 날짜를 갱신 후 해당 위치를 방문 처리
        dayCnt += map[startRow][startCol];
        map[startRow][startCol] = 0;
        
        // while 반복문을 사용해 visitList가 빌 때까지 순회
        while (!visitList.isEmpty()) {
            
        	// poll() 메서드를 사용해 현재 방문 중인 위치를 배열 curLoc에 할당
            int[] curLoc = visitList.poll();
            
            // for 반복문을 사용해 각 인접한 위치를 순회
            for (int d = 0; d < 4; d++) {
                
            	// 인접한 위치의 정보를 각 변수에 할당
                int nr = curLoc[0] + dr[d];
                int nc = curLoc[1] + dc[d];
                
                // 해당 위치가 지도의 범위를 벗어난 경우 다음 위치를 순회
                if (nr < 0 || nr >= rowNum || nc < 0 || nc >= colNum)
                    continue;
                
                // 해당 위치가 바다이거나 이미 방문한 곳인 경우 다음 위치를 순회
                if (map[nr][nc] == 0)
                    continue;
                
                // offer() 메서드를 사용해 다음 섬의 위치를 visitList에 추가
                visitList.offer(new int[] {nr, nc});
                
                // 해당 섬에서 머무를 수 있는 날짜를 갱신 후 해당 위치를 방문 처리
                dayCnt += map[nr][nc];
                map[nr][nc] = 0;
            }
        }
        
        // offer() 메서드를 사용해 해당 섬에서 머무를 수 있는 날짜를 sorter에 추가
        sorter.offer(dayCnt);
    }
}