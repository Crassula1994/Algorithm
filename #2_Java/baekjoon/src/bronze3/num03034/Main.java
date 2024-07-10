package bronze3.num03034;

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
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 던진 성냥의 개수 및 박스의 크기를 각 변수에 할당
		int matchNum = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 각 성냥의 길이를 순회
		for (int match = 0; match < matchNum; match++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 성냥의 길이를 변수 length에 할당
			int length = Integer.parseInt(in.readLine());
			
			// max() 및 write() 메서드를 사용해 성냥이 박스 안에 들어갈 수 있는지를 출력
			out.write((length * length > width * width + height * height) ? "NE" : "DA");
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}