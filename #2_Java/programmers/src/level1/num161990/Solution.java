package level1.num161990;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static int[] solution(String[] wallpaper) {
		
		// 드래그의 시작점과 끝점을 저장할 각 변수 초기화
		int lux = Integer.MAX_VALUE, luy = Integer.MAX_VALUE;
		int rdx = Integer.MIN_VALUE, rdy = Integer.MIN_VALUE;
		
		// for 반복문을 사용해 바탕화면의 각 행을 순회
		for (int r = 0; r < wallpaper.length; r++) {
			
			// for 반복문을 사용해 바탕화면의 각 칸을 순회
			for (int c = 0; c < wallpaper[r].length(); c++) {
			
				// 해당 위치가 빈 칸인 경우 다음 칸을 순회
				if (wallpaper[r].charAt(c) == '.')
					continue;
				
				// min() 메서드를 사용해 드래그의 시작점을 갱신
				lux = Math.min(r, lux);
				luy = Math.min(c, luy);
				
				// max() 메서드를 사용해 드래그의 끝점을 갱신
				rdx = Math.max(r, rdx);
				rdy = Math.max(c, rdy);
			}
		}
		
		// 드래그의 끝점의 값을 갱신
		rdx++;
		rdy++;
		
		// 드래그의 시작점과 끝점을 담은 정수 배열 반환
        return new int[] {lux, luy, rdx, rdy};
    }
}