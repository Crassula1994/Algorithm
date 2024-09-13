package gold4.num10881;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 선물 상자들의 크기를 저장할 2차원 배열 giftBoxes 초기화
	static int[][] giftBoxes = new int[6][2];
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// 선물을 안전하게 포장하기 위한 포장 상자의 최소 크기를 저장할 변수 minSize 초기화
			int minSize = Integer.MAX_VALUE;
			
			// for 반복문을 사용해 각 선물 상자의 크기를 순회
			for (int idx = 0; idx < 3; idx++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 할당
				StringTokenizer st = new StringTokenizer(in.readLine());
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 상자의 가로와 세로 길이를 2차원 배열 giftBoxes에 저장
				giftBoxes[idx][0] = Integer.parseInt(st.nextToken());
				giftBoxes[idx][1] = Integer.parseInt(st.nextToken());
				
				// 해당 박스를 90도 회전시킨 길이를 2차원 배열 giftBoxes에 저장
				giftBoxes[idx + 3][0] = giftBoxes[idx][1];
				giftBoxes[idx + 3][1] = giftBoxes[idx][0];
			}
			
			// for 반복문을 사용해 배치할 각 선물 상자 조합을 순회
			for (int box1 = 0; box1 < 6; box1++) {
				for (int box2 = 0; box2 < 6; box2++) {
					for (int box3 = 0; box3 < 6; box3++) {
						
						// 같은 박스를 선택한 경우 다음 선물 상자 조합을 순회
						if (box1 % 3 == box2 % 3 || box1 % 3 == box3 % 3 || box2 % 3 == box3 % 3)
							continue;
						
						// max() 메서드를 사용해 박스를 일렬로 배치했을 때의 가로와 세로 길이를 계산해 각 변수에 할당
						int width = giftBoxes[box1][0] + giftBoxes[box2][0] + giftBoxes[box3][0];
						int height = Math.max(giftBoxes[box1][1], Math.max(giftBoxes[box2][1], giftBoxes[box3][1]));
						
						// min() 메서드를 사용해 선물을 안전하게 포장하기 위한 포장 상자의 최소 크기를 갱신
						minSize = Math.min(width * height, minSize);
						
						// max() 메서드를 사용해 박스를 1개, 2개로 나누어 일렬로 배치했을 때의 가로와 세로 길이를 계산해 각 변수에 할당
						width = Math.max(giftBoxes[box1][0], giftBoxes[box2][0] + giftBoxes[box3][0]);
						height = giftBoxes[box1][1] + Math.max(giftBoxes[box2][1], giftBoxes[box3][1]);
						
						// min() 메서드를 사용해 선물을 안전하게 포장하기 위한 포장 상자의 최소 크기를 갱신
						minSize = Math.min(width * height, minSize);
					}
				}
			}
			
			// write() 메서드를 사용해 선물을 안전하게 포장하기 위한 포장 상자의 최소 크기를 출력
			out.write(minSize + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}