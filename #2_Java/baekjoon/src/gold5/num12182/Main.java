package gold5.num12182;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 숫자의 방이 위치한 행과 열을 저장할 각 배열 초기화
	static int[] roomR;
	static int[] roomC;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// readLine() 메서드를 사용해 빈 줄을 제거
		in.readLine();
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 1; tc <= testCase; tc++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 정사각형 미로의 한 변의 길이를 변수 length에 할당
			int length = Integer.parseInt(in.readLine());
			
			// 방의 개수, 우승자의 방의 번호, 이동한 방의 개수를 저장할 각 변수 초기화
			int roomNum = length * length;
			int maxNumber = roomNum;
			int maxCount = 1;
			
			// 각 숫자의 방이 위치한 행과 열, 해당 방에서 이동할 수 있는 방의 개수를 저장할 각 배열 초기화
			roomR = new int[roomNum + 1];
			roomC = new int[roomNum + 1];
			int[] counts = new int[roomNum + 1];
			
			// for 반복문을 사용해 정사각형 미로의 각 행을 순회
			for (int r = 0; r < length; r++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 할당
				StringTokenizer st = new StringTokenizer(in.readLine());
				
				// for 반복문을 사용해 정사각형 미로의 각 칸을 순회
				for (int c = 0; c < length; c++) {
					
					// nextToken() 및 parseInt() 메서드를 사용해 해당 칸에 위치한 방의 번호를 변수 number에 할당
					int number = Integer.parseInt(st.nextToken());
					
					// 해당 방 번호의 위치를 각 배열에 저장
					roomR[number] = r;
					roomC[number] = c;
				}
			}
			
			// 가장 끝 번호에서 이동할 수 있는 방의 개수를 초기화
			counts[roomNum] = 1;
			
			// for 반복문을 사용해 각 방의 번호를 거꾸로 순회
			for (int number = roomNum - 1; number > 0; number--) {
				
				// 해당 방에서 다음 방으로 이동할 수 있는지 여부에 따라 이동할 수 있는 방의 개수를 배열 counts에 저장
				counts[number] = (roomChecker(number)) ? counts[number + 1] + 1 : 1;
				
				// 해당 방에서 이동할 수 있는 방의 개수가 우승자의 이동한 방의 개수와 같은 경우 우승자의 방의 번호를 갱신
				if (counts[number] == maxCount) {
					maxNumber = number;
					
				/* 해당 방에서 이동할 수 있는 방의 개수가 우승자의 이동한 방의 개수보다 많은 경우
				우승자의 방의 번호와 우승자가 이동한 방의 개수를 갱신 */
				} else if (counts[number] > maxCount) {
					maxNumber = number;
					maxCount = counts[number];
				}
			}
			
			// format() 및 write() 메서드를 사용해 우승자의 방의 번호 및 이동한 방의 개수를 출력
			out.write(String.format("Case #%d: %d %d\n", tc, maxNumber, maxCount));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// roomChecker() 메서드 정의
	public static boolean roomChecker(int number) {
		
		// abs() 메서드를 사용해 현재 방과 다음 방의 거리를 각 변수에 할당
		int distanceR = Math.abs(roomR[number + 1] - roomR[number]);
		int distanceC = Math.abs(roomC[number + 1] - roomC[number]);
		
		// 두 방이 인접했는지 여부를 반환
		return (distanceR + distanceC) == 1;
	}
}