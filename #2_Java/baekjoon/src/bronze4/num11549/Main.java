package bronze4.num11549;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 차의 종류를 변수 teaType에 할당
		int teaType = Integer.parseInt(in.readLine());
		
		// 정답을 맞춘 도전자의 수를 저장할 변수 count 초기화
		int count = 0;
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 도전자의 정답을 순회
		for (int contestant = 0; contestant < 5; contestant++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 도전자의 정답을 변수 answer에 할당
			int answer = Integer.parseInt(st.nextToken());
			
			// 도전자가 정답을 맞춘 경우 정답을 맞춘 도전자의 수를 갱신
			if (answer == teaType)
				count++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 정답을 맞춘 도전자의 수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}