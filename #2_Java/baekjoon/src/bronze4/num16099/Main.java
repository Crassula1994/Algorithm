package bronze4.num16099;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseLong() 메서드를 사용해 입력 받은 텔레콤 파리테크와 유레콤의 운동장 크기를 각 변수에 할당
			long areaT = Long.parseLong(st.nextToken()) * Long.parseLong(st.nextToken());
			long areaE = Long.parseLong(st.nextToken()) * Long.parseLong(st.nextToken());
			
			// 유레콤의 운동장 크기가 텔레콤 파리테크의 그것보다 큰 경우 'Eurecom'을 출력
			if (areaE > areaT) {
				out.write("Eurecom");
				
			// 유레콤의 운동장 크기가 텔레콤 파리테크의 그것보다 작은 경우 'TelecomParisTech'를 출력
			} else if (areaE < areaT) {
				out.write("TelecomParisTech");
				
			// 유레콤의 운동장 크기와 텔레콤 파리테크의 운동장 크기가 같은 경우 'Tie'를 출력
			} else {
				out.write("Tie");
			}
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}