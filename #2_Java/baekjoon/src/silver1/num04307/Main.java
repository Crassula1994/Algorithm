package silver1.num04307;

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
		for (int tc = 0; tc < testCase; tc++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 막대의 길이와 개미의 수를 각 변수에 할당
			int length = Integer.parseInt(st.nextToken());
			int antNum = Integer.parseInt(st.nextToken());
			
			// 개미가 땅으로 떨어지는 가능한 시간 중 가장 빠른 시간과 가장 늦은 시간을 저장할 각 변수 초기화
			int minTime = 0;
			int maxTime = 0;
			
			// while 반복문을 사용해 각 개미를 순회
			while (antNum-- > 0) {
				
				// readLine() 및 parseInt() 메서드를 사용해 개미의 위치를 변수 location에 할당
				int location = Integer.parseInt(in.readLine());
				
				// max() 및 min() 메서드를 사용해 개미가 땅으로 떨어지는 가능한 시간 중 가장 빠른 시간과 가장 늦은 시간을 갱신
				minTime = Math.max(Math.min(location, length - location), minTime);
				maxTime = Math.max(Math.max(location, length - location), maxTime);
			}
			
			// write() 메서드를 사용해 개미가 땅으로 떨어지는 가능한 시간 중 가장 빠른 시간과 가장 늦은 시간을 출력
			out.write(minTime + " " + maxTime + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}