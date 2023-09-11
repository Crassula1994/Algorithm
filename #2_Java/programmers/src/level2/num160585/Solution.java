package level2.num160585;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static int solution(String[] board) {
		
		// 'O'와 'X'의 개수를 저장할 각 변수 초기화
		int oNum = 0;
        int xNum = 0;
        
        // 틱택토의 판의 상태를 저장할 2차원 배열 newBoard 초기화
        char[][] newBoard = new char[3][3];
        
        // for 반복문을 사용해 틱택토 판의 각 칸을 순회
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board.length; c++) {
            	
            	// charAt() 메서드를 사용해 틱택토 판의 상태를 2차원 배열 newBoard에 저장
                newBoard[r][c] = board[r].charAt(c);
                
                // 해당 칸이 'O'인 경우 'O'의 개수를 갱신 
                if (newBoard[r][c] == 'O') {
                    oNum++;
                
                // 해당 칸이 'X'인 경우 'X'의 개수를 갱신
                } else if (newBoard[r][c] == 'X') {
                    xNum++;
                }
            }
        }
        
        // 후공이 선공의 차례에 표기한 경우 0을 반환
        if (xNum > oNum) {
            return 0;
        
        // 선공과 후공의 개수를 잘못 적은 경우 0을 반환
        } else if (Math.abs(oNum - xNum) > 1) {
            return 0;
        
        // 틱택토의 결과 확인이 필요한 경우
        } else {
            
        	// boardChecker() 메서드를 호출해 세 칸을 만든 'O'와 'X'의 개수를 배열 checkResult에 저장
            int[] checkResult = boardChecker(newBoard);
            
            // 게임이 종료되었음에도 추가로 진행한 경우 0을 반환
            if ((checkResult[0] > 0 && checkResult[1] > 0) || checkResult[0] > 2 || checkResult[1] > 1) {
                return 0;
            
            // 선공이 이겼음에도 후공이 추가로 진행한 경우 0을 반환
            } else if (checkResult[0] > 0 && oNum <= xNum) {
                return 0;
            
            // 후공이 이겼음에도 선공이 추가로 진행한 경우 0을 반환
            } else if (checkResult[1] > 0 && oNum > xNum) {
                return 0;
            }
        } 
        
        // 틱택토를 진행했을 때 가능한 경우 1을 반환
        return 1;
    }
	
    // ----------------------------------------------------------------------------------------------------
    
	// boardChecker() 메서드 정의
    public static int[] boardChecker(char[][] board) {
        
    	// 틱택토를 완성한 개수를 저장할 배열 result 초기화
        int[] result = new int[2];
        
        // for 반복문을 사용해 틱택토 판의 가로를 순회
        outer: for (int r = 0; r < 3; r++) {
            
            // 'O'와 'X'의 개수를 저장할 각 변수 초기화
            int oNum = 0;
            int xNum = 0;
            
            // for 반복문을 사용해 틱택토 판의 각 칸을 순회
            for (int c = 0; c < 3; c++) {
                
                // 한 칸이라도 빈칸일 경우 다음 줄을 순회
                if (board[r][c] == '.') {
                    continue outer;
                
                // 해당 칸이 'O'인 경우 'O'의 개수를 갱신
                } else if (board[r][c] == 'O') {
                    oNum++;
                    
                // 해당 칸이 'X'인 경우 'X'의 개수를 갱신
                } else {
                    xNum++;
                }
            }
            
            // 'O'로 한 줄이 완성된 경우 'O'의 완성된 줄 수를 갱신
            if (oNum == 3)
                result[0]++;
            
            // 'X'로 한 줄이 완성된 경우 'X'의 완성된 줄 수를 갱신
            if (xNum == 3)
                result[1]++;
        }
        
        // for 반복문을 사용해 틱택토 판의 세로를 순회
        outer: for (int c = 0; c < 3; c++) {

        	// 'O'와 'X'의 개수를 저장할 각 변수 초기화
            int oNum = 0;
            int xNum = 0;
            
            // for 반복문을 사용해 틱택토 판의 각 칸을 순회
            for (int r = 0; r < 3; r++) {
                
            	// 한 칸이라도 빈칸일 경우 다음 줄을 순회
                if (board[r][c] == '.') {
                    continue outer;
                
                // 해당 칸이 'O'인 경우 'O'의 개수를 갱신
                } else if (board[r][c] == 'O') {
                    oNum++;
                    
                // 해당 칸이 'X'인 경우 'X'의 개수를 갱신
                } else {
                    xNum++;
                }
            }
            
            // 'O'로 한 줄이 완성된 경우 'O'의 완성된 줄 수를 갱신
            if (oNum == 3)
            	result[0]++;
            
            // 'X'로 한 줄이 완성된 경우 'X'의 완성된 줄 수를 갱신
            if (xNum == 3)
            	result[1]++;
        }
        
        // 'O'와 'X'의 개수를 저장할 각 변수 초기화
        int oNum = 0;
        int xNum = 0;
        
        // for 반복문을 사용해 정방향의 대각선을 순회
        for (int i = 0; i < 3; i++) {
            
        	// 한 칸이라도 빈칸일 경우 넘기기
            if (board[i][i] == '.') {
                continue;

            // 해당 칸이 'O'인 경우 'O'의 개수를 갱신
            } else if (board[i][i] == 'O') {
                oNum++;
                
            // 해당 칸이 'X'인 경우 'X'의 개수를 갱신
            } else {
                xNum++;
            }
        }
        
        // 'O'로 한 줄이 완성된 경우 'O'의 완성된 줄 수를 갱신
        if (oNum == 3)
        	result[0]++;

        // 'X'로 한 줄이 완성된 경우 'X'의 완성된 줄 수를 갱신
        if (xNum == 3)
        	result[1]++;
        
        // 'O'와 'X'의 개수를 저장할 각 변수 초기화
        oNum = 0;
        xNum = 0;
        
        // for 반복문을 사용해 역방향의 대각선을 순회
        for (int i = 0; i < 3; i++) {
            
        	// 한 칸이라도 빈칸일 경우 넘기기
            if (board[2 - i][i] == '.') {
                continue;

            // 해당 칸이 'O'인 경우 'O'의 개수를 갱신
            } else if (board[2 - i][i] == 'O') {
                oNum++;
                
            // 해당 칸이 'X'인 경우 'X'의 개수를 갱신  
            } else {
                xNum++;
            }
        }
        
        // 'O'로 한 줄이 완성된 경우 'O'의 완성된 줄 수를 갱신
        if (oNum == 3)
        	result[0]++;

        // 'X'로 한 줄이 완성된 경우 'X'의 완성된 줄 수를 갱신
        if (xNum == 3)
        	result[1]++;

        // 틱택토를 완성한 개수를 반환
        return result;
    }
}