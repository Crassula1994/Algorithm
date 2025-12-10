package bronze3.num06322;

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
		
		// 테스트 케이스의 번호를 저장할 변수 testCase 초기화
		int testCase = 0;
		
		// StringBuilder 객체를 불러와 변수 sb에 할당
		StringBuilder sb = new StringBuilder();
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (true) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseDouble() 메서드를 사용해 각 변의 길이를 각 변수에 할당
			double sideA = Double.parseDouble(st.nextToken());
			double sideB = Double.parseDouble(st.nextToken());
			double sideC = Double.parseDouble(st.nextToken());
			
			// 모든 테스트 케이스를 확인한 경우 반복문 탈출
			if (sideA == 0)
				break;
			
			// 두 번째 테스트 케이스 이상인 경우 줄바꿈을 sb에 추가
			if (testCase > 0)
				sb.append("\n");
			
			// append() 메서드를 사용해 해당 테스트 케이스의 번호를 sb에 추가
			sb.append("Triangle #").append(++testCase).append("\n");
			
			// 변 a의 길이를 알 수 없는 경우 변 a의 길이를 정해진 형식으로 sb에 추가
			if (sideA == -1) {
				sb.append((sideB >= sideC) ? "Impossible." : String.format("a = %.3f", Math.sqrt(sideC * sideC - sideB * sideB)));
				
			// 변 b의 길이를 알 수 없는 경우 변 b의 길이를 정해진 형식으로 sb에 추가
			} else if (sideB == -1) {
				sb.append((sideA >= sideC) ? "Impossible." : String.format("b = %.3f", Math.sqrt(sideC * sideC - sideA * sideA)));
				
			// 변 c의 길이를 알 수 없는 경우 변 c의 길이를 정해진 형식으로 sb에 추가
			} else {
				sb.append(String.format("c = %.3f", Math.sqrt(sideA * sideA + sideB * sideB)));
			}
			
			// append() 메서드를 사용해 줄바꿈을 sb에 추가
			sb.append("\n");
		}
		
		// toString() 및 write() 메서드를 사용해 각 테스트 케이스의 알 수 없는 변의 길이를 출력
		out.write(sb.toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}