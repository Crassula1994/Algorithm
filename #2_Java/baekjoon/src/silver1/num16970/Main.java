package silver1.num16970;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 좌표의 범위, 선분이 지나가야 하는 점의 개수를 각 변수에 할당
		int limitX = Integer.parseInt(st.nextToken());
		int limitY = Integer.parseInt(st.nextToken());
		int targetCount = Integer.parseInt(st.nextToken());
		
		// 지나가야 하는 점의 개수를 지나는 선분의 수를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 선분의 시작 점을 순회
		for (int startX = 0; startX <= limitX; startX++) {
			for (int startY = 0; startY <= limitY; startY++) {
				
				// for 반복문을 사용해 선분의 끝 점을 순회
				for (int endX = 0; endX <= limitX; endX++) {
					for (int endY = 0; endY <= limitY; endY++) {
						
						// abs() 메서드를 사용해 두 점 사이의 좌표 간 거리를 각 변수에 할당
						int distX = Math.abs(endX - startX);
						int distY = Math.abs(endY - startY);
						
						/* 각 거리의 최대공약수가 선분이 지나가야 하는 점의 개수에서 1을 뺀 것과 같은 경우
						해당 선분은 지나가야 하는 점의 개수만큼의 점을 지나가므로
						지나가야 하는 점의 개수를 지나는 선분의 수를 갱신 */
						if (gcdCalculator(Math.max(distX, distY), Math.min(distX, distY)) == targetCount - 1)
							count++;
					}
				}
			}
		}
		
		// 시작점과 끝점이 뒤바뀌더라도 같은 선분이므로 중복된 선분의 수를 제거
		count /= 2;
		
		// valueOf() 및 write() 메서드를 사용해 지나가야 하는 점의 개수를 지나는 선분의 수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// gcdCalculator() 메서드 정의
	public static int gcdCalculator(int numberA, int numberB) {
		
		// 한 숫자가 0인 경우 다른 숫자가 최대공약수이므로 다른 숫자를 반환
		if (numberB == 0)
			return numberA;
		
		// gcdCalculator() 메서드를 재귀 호출해 최대공약수를 반환
		return gcdCalculator(numberB, numberA % numberB);
	}
}