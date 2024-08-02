package bronze4.num09699;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 1; tc <= testCase; tc++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// 알아민 고아원으로 보낼 쌀 포대의 무게를 저장할 변수 maxWeight 초기화
			int maxWeight = 0;
			
			// for 반복문을 사용해 알아민 고아원으로 보낼 쌀 포대의 무게를 갱신
			for (int sack = 0; sack < 5; sack++)
				maxWeight = Math.max(Integer.parseInt(st.nextToken()), maxWeight);
			
			// write() 메서드를 사용해 알아민 고아원으로 보낼 쌀 포대의 무게를 출력
			out.write("Case #" + tc + ": " + maxWeight + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}