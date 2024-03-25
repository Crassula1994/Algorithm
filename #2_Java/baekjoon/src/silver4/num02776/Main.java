package silver4.num02776;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
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
		for (int tc = 0; tc < testCase; tc++) {
			
			// 수첩 1에 저장된 정수를 저장할 Set 객체 note1 초기화
			Set<Integer> note1 = new HashSet<>();
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수첩 1의 정수의 개수를 변수 note1Cnt에 할당
			int note1Cnt = Integer.parseInt(in.readLine());
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 수첩 1의 정수를 note1에 저장
			for (int n1 = 0; n1 < note1Cnt; n1++)
				note1.add(Integer.parseInt(st.nextToken()));
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수첩 2의 정수의 개수를 변수 note2Cnt에 할당
			int note2Cnt = Integer.parseInt(in.readLine());
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 수첩 2의 정수를 순회
			for (int n2 = 0; n2 < note2Cnt; n2++) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 수첩 2의 정수를 변수 number에 할당
				int number = Integer.parseInt(st.nextToken());
				
				// 수첩 2의 정수가 수첩 1에 있는 경우 1을 출력
				if (note1.contains(number)) {
					out.write(1 + "\n");
					
				// 수첩 2의 정수가 수첩 1에 없는 경우 0을 출력
				} else {
					out.write(0 + "\n");
				}
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}