package level2.num159993;

// 필요한 패키지 불러오기
import java.util.LinkedList;
import java.util.Queue;

// Solution 클래스 정의
public class Solution {
	
	// 미로의 행과 열의 크기를 저장할 각 변수 초기화
	static int row;
    static int column;
    
    // 미로의 인접한 위치를 저장할 각 델타 배열 초기화
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    // 미로의 상태를 저장할 2차원 배열 maze 초기화
    static char[][] maze;
    
    // Cell 클래스 정의
    public static class Cell {
    	
    	// 해당 칸의 위치 정보와 레버를 당겼는지 여부를 나타내는 각 변수 초기화
        int row;
        int column;
        int activated;
        
        // 인자를 입력 받는 생성자 정의
        public Cell(int row, int column, int activated) {
            this.row = row;
            this.column = column;
            this.activated = activated;
        }
    }
	
	// ----------------------------------------------------------------------------------------------------
	
	// solution() 메서드 정의
	public static int solution(String[] maps) {
		
		// 미로의 행과 열의 크기를 나타내는 각 변수 초기화
		row = maps.length;
        column = maps[0].length();
        
        // 미로의 상태를 저장할 2차원 배열 maze 초기화
        maze = new char[row][column];
        
        // 출발 지점의 위치를 저장할 각 변수 초기화
        int startRow = -1;
        int startCol = -1;
        
        // for 반복문을 사용해 미로의 각 행을 순회
        for (int r = 0; r < row; r++) {
        	
        	// 미로의 행 정보를 변수 line에 할당
            String line = maps[r];
            
            // for 반복문을 사용해 미로의 각 열을 순회
            for (int c = 0; c < column; c++) {
            	
            	// charAt() 메서드를 사용해 각 칸의 정보를 2차원 배열 maze에 저장
                maze[r][c] = line.charAt(c);
                
                // 해당 칸이 출발 지점인 경우 출발 지점의 위치를 갱신
                if (maze[r][c] == 'S') {
                    startRow = r;
                    startCol = c;
                }
            }
        }
        
        // timeCalculator() 메서드를 호출해 미로를 탈출하는 데 필요한 최소 시간을 변수 minTime에 할당
        int minTime = timeCalculator(startRow, startCol);
        
        // 미로를 탈출하는 데 필요한 최소 시간을 반환
        return minTime;
    }
    
	// ----------------------------------------------------------------------------------------------------
	
	// timeCalculator() 메서드 정의
    public static int timeCalculator(int startRow, int startCol) {
        
    	// 해당 미로 칸을 방문했는지를 나타낼 3차원 배열 visited 초기화
    	Integer[][][] visited = new Integer[2][row][column];
    	
    	// 다음에 방문할 칸을 저장할 Queue 객체 cellList 초기화
        Queue<Cell> cellList = new LinkedList<>();
        
        // offer() 메서드를 사용해 출발 지점을 cellList에 추가 및 방문 처리
        cellList.offer(new Cell(startRow, startCol, 0));
        visited[0][startRow][startCol] = 0;
        
        // while 반복문을 사용해 cellList가 빌 때까지 순회
        while (!cellList.isEmpty()) {
            
        	// poll() 메서드를 사용해 현재 방문한 칸의 정보를 변수 curCell에 할당
            Cell curCell = cellList.poll();
            
            // 레버를 당겼고, 해당 칸이 출구인 경우 해당 칸까지 소요된 시간을 반환
            if (curCell.activated == 1 && maze[curCell.row][curCell.column] == 'E')
                return visited[curCell.activated][curCell.row][curCell.column];
            
            // for 반복문을 사용해 각 인접한 칸을 순회
            for (int d = 0; d < 4; d++) {
            	
            	// 인접한 새로운 위치를 각 변수에 할당
                int nr = curCell.row + dr[d];
                int nc = curCell.column + dc[d];
                
                // 미로의 범위를 벗어나는 경우 다음 인접한 칸을 순회
                if (nr < 0 || nr >= row || nc < 0 || nc >= column)
                    continue;
                
                // 벽이거나 이미 방문한 곳인 경우 다음 인접한 칸을 순회
                if (maze[nr][nc] == 'X' || visited[curCell.activated][nr][nc] != null)
                    continue;
                
                // 레버를 당기지 않았고, 해당 칸이 레버인 경우
                if (curCell.activated == 0 && maze[nr][nc] == 'L') {
                	
                	// offer() 메서드를 사용해 레버를 당긴 것으로 처리해 cellList에 추가 및 방문 처리
                    cellList.offer(new Cell(nr, nc, 1));
                    visited[1][nr][nc] = visited[0][curCell.row][curCell.column] + 1;
                    
                // 레버를 당겼거나, 해당 칸이 레버가 아닌 경우
                } else {
                	
                	// offer() 메서드를 사용해 해당 칸을 cellList에 추가 및 방문 처리
                    cellList.offer(new Cell(nr, nc, curCell.activated));
                    visited[curCell.activated][nr][nc] = visited[curCell.activated][curCell.row][curCell.column] + 1;
                }
            }
        }
        
        // 미로를 탈출할 수 없는 경우 -1 반환
        return -1;
    }
}