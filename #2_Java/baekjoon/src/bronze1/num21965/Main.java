package bronze1.num21965;

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

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수열의 길이를 변수 length에 할당
		int length = Integer.parseInt(in.readLine());
		
		// 해당 수열이 산인지 여부, 현재 증가하고 있는지 여부를 저장할 각 변수 초기화
		boolean isMountain = true;
		boolean isIncreasing = true;
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 이전 수열의 원소를 변수 prevElement에 할당
		int prevElement = Integer.parseInt(st.nextToken());
		
		// while 반복문을 사용해 각 수열의 원소를 순회
		while (length-- > 1) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 현재 수열의 원소를 변수 curElement에 할당
			int curElement = Integer.parseInt(st.nextToken());
			
			// 현재 원소가 이전 원소와 같은 경우 해당 수열이 산인지 여부를 갱신 후 반복문 탈출
			if (prevElement == curElement) {
				isMountain = false;
				break;
				
			// 현재 원소가 이전 원소보다 작은 경우 현재 증가하고 있는지 여부를 갱신
			} else if (prevElement > curElement) {
				isIncreasing = false;
				
			// 현재 원소가 이전 원소보다 크지만 이미 감소하고 있는 경우 해당 수열이 산인지 여부를 갱신 후 반복문 탈출
			} else if (!isIncreasing) {
				isMountain = false;
				break;
			}
			
			// 이전 수열의 원소를 갱신
			prevElement = curElement;
		}
		
		// write() 메서드를 사용해 주어진 수열이 산인지 여부를 출력
		out.write((isMountain) ? "YES" : "NO");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}