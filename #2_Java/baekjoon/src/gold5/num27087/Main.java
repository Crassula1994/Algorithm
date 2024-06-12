package gold5.num27087;

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
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 직육면체의 크기를 각 변수에 할당
			int cuboidA = Integer.parseInt(st.nextToken());
			int cuboidB = Integer.parseInt(st.nextToken());
			int cuboidC = Integer.parseInt(st.nextToken());
			int cuboidP = Integer.parseInt(st.nextToken());
			
			// 큰 직육면체의 각 변의 길이가 작은 직육면체의 길이로 나누어 떨어지는 경우의 수를 저장할 변수 count 초기화
			int count = 0;
			
			// 첫 번째 변이 나누어 떨어지는 경우 경우의 수를 갱신
			if (cuboidA % cuboidP == 0)
				count++;
			
			// 두 번째 변이 나누어 떨어지는 경우 경우의 수를 갱신
			if (cuboidB % cuboidP == 0)
				count++;
			
			// 세 번째 변이 나누어 떨어지는 경우 경우의 수를 갱신
			if (cuboidC % cuboidP == 0)
				count++;
			
			// write() 메서드를 사용해 직육면체를 채울 수 있는지 여부를 출력
			out.write((count >= 2 ? 1 : 0) + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}