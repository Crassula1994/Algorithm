package bronze3.num04880;

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
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (true) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 수열의 정수를 각 변수에 할당
			int elementA = Integer.parseInt(st.nextToken());
			int elementB = Integer.parseInt(st.nextToken());
			int elementC = Integer.parseInt(st.nextToken());
			
			// 모든 테스트 케이스를 확인한 경우 반복문 탈출
			if (elementA == 0 && elementB == 0 && elementC == 0)
				break;
			
			// 첫 두 정수 사이의 차이를 저장할 변수 difference 초기화
			int difference = elementB - elementA;
			
			// 해당 수열이 등차수열인 경우 다음 항을 정해진 형식대로 출력
			if (difference == elementC - elementB) {
				out.write(String.format("AP %d\n", elementC + difference));
			
			// 해당 수열이 등비수열인 경우 다음 항을 정해진 형식대로 출력
			} else {
				out.write(String.format("GP %d\n", elementC * (elementB / elementA)));
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}