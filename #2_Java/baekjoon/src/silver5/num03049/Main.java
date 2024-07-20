package silver5.num03049;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 볼록다각형의 꼭짓점의 수를 변수 vertexNum에 할당
		int vertexNum = Integer.parseInt(in.readLine());
		
		// 각 대각선의 교차점을 만들기 위해서는 4개의 꼭짓점이 필요하므로 교차점의 개수를 계산해 변수 crossPointNum에 할당
		int crossPointNum = vertexNum * (vertexNum - 1) * (vertexNum - 2) * (vertexNum - 3) / 24;
		
		// valueOf() 및 write() 메서드를 사용해 교차점의 개수를 출력
		out.write(String.valueOf(crossPointNum));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}