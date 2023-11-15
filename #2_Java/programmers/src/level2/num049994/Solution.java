package level2.num049994;

// 필요한 패키지 불러오기
import java.util.HashSet;
import java.util.Set;

// Solution 클래스 정의
public class Solution {
	
	// 각 이동 방향을 저장할 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
	
	// solution() 메서드 정의
	public static int solution(String dirs) {
		
		// 캐릭터가 처음 걸어본 길의 길이, 게임 캐릭터의 현재 위치 정보를 저장할 각 변수 초기화
		int length = 0;
        int curRow = 5;
        int curCol = 5;

		// 좌표 평면의 이동 정보를 저장할 2차원 배열 visitedMap 초기화
		@SuppressWarnings("unchecked")
		Set<Character>[][] visitedMap = new HashSet[11][11];
		
		// for 반복문을 사용해 좌표 평면의 이동 정보를 저장할 Set 객체 초기화
        for (int r = 0; r < 11; r++) {
            for (int c = 0; c < 11; c++)
                visitedMap[r][c] = new HashSet<>();
        }
        
        // for 반복문을 사용해 각 명령어를 순회
        for (int idx = 0; idx < dirs.length(); idx++) {
        	
        	// charAt() 메서드를 사용해 현재 입력된 명령어의 방향을 변수 curDir에 할당
            char curDir = dirs.charAt(idx);
            
            // 다음에 이동할 위치, 다음에 이동할 위치에 저장할 방향 정보를 저장할 각 변수 초기화
            int nextRow = curRow;
            int nextCol = curCol;
            char nextDir;
            
            // switch 조건문을 사용해 현재 입력된 명령어의 방향에 따라 다음에 이동할 위치, 다음에 이동할 위치에 저장할 방향 정보를 갱신
            switch (curDir) {
                case 'U':
                    nextRow += dr[0];
                    nextDir = 'D';
                    break;
                case 'D':
                    nextRow += dr[1];
                    nextDir = 'U';
                    break;
                case 'R':
                    nextCol += dc[2];
                    nextDir = 'L';
                    break;
                default:
                    nextCol += dc[3];
                    nextDir = 'R';
            }
            
            // 다음에 이동할 위치가 좌표평면의 경계를 벗어나는 경우 다음 명령어를 순회
            if (nextRow < 0 || nextRow > 10 || nextCol < 0 || nextCol > 10)
                continue;
            
            // 해당 길이 처음 걸어본 길의 길이인 경우
            if (!visitedMap[nextRow][nextCol].contains(nextDir)) {
            	
            	// add() 메서드를 사용해 현재 위치의 이동 방향 및 다음 위치의 이동 방향을 추가
                visitedMap[curRow][curCol].add(curDir);
                visitedMap[nextRow][nextCol].add(nextDir);
                
                // 처음 걸어본 길의 길이를 갱신
                length++;
            }
            
            // 게임 캐릭터의 현재 위치를 갱신
            curRow = nextRow;
            curCol = nextCol;
        }
        
        // 처음 걸어본 길의 길이를 반환
        return length;
	}
}