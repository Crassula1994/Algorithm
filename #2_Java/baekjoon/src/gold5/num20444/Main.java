package gold5.num20444;

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
		
		// nextToken() 및 parseLong() 메서드를 사용해 입력 받은 가위질의 횟수 및 목표로 하는 색종이 조각의 수를 각 변수에 할당
		long cutCount = Long.parseLong(st.nextToken());
		long targetCount = Long.parseLong(st.nextToken());
		
		// 가로로 자르는 가위질의 횟수를 찾기 위해 필요한 각 변수, 목표로 하는 색종이 조각을 만들 수 있는지 여부를 나타낼 변수 초기화
		long left = 0;
		long right = cutCount / 2;
		boolean isPossible = false;
		
		// while 반복문을 사용해 가로로 자르는 가위질의 횟수를 찾을 때까지 순회
		while (left <= right) {
			
			// 가로로 자르는 가위질의 횟수, 세로로 자르는 가위질의 횟수, 생기는 조각의 수를 계산해 각 변수에 할당
			long widthCount = (left + right) / 2;
			long heightCount = cutCount - widthCount;
			long count = (widthCount + 1) * (heightCount + 1);
			
			// 해당 조각의 수가 목표로 하는 색종이 조각의 수와 같은 경우 목표로 하는 색종이 조각을 만들 수 있는지 여부를 갱신 후 반복문 탈출
			if (count == targetCount) {
				isPossible = true;
				break;
			}
			
			// 해당 조각의 수가 목표로 하는 색종이 조각의 수보다 작은 경우 왼쪽 범위를 갱신
			if (count < targetCount) {
				left = widthCount + 1;
				
			// 해당 조각의 수가 목표로 하는 색종이 조각의 수보다 많은 경우 오른쪽 범위를 갱신
			} else {
				right = widthCount - 1;
			}
		}
		
		// write() 메서드를 사용해 목표로 하는 색종이 조각을 만들 수 있는지 여부를 출력
		out.write((isPossible) ? "YES" : "NO");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}