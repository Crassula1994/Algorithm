package bronze4.num2083;

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
		
		// while 반복문을 사용해 마지막 줄까지 순회
		while (true) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 이름, 나이, 몸무게를 각 변수에 할당
			String name = st.nextToken();
			int age = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			// 마지막 줄인 경우 반복문 탈출
			if (name.equals("#"))
				break;
			
			// 나이가 17세보다 많거나 몸무게가 80kg 이상인 경우 이름과 함께 'Senior' 출력
			if (age > 17 || weight >= 80) {
				out.write(name + " Senior\n");
			
			// 나머지 경우 이름과 함께 'Junior' 출력
			} else {
				out.write(name + " Junior\n");
			}
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}