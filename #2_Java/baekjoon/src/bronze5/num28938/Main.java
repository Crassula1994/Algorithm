package bronze5.num28938;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수열의 길이를 변수 sequenceLength에 할당
		int sequenceLength = Integer.parseInt(in.readLine());
		
		// 컨베이어 벨트가 이동한 결과를 저장할 변수 sum 초기화
		int sum = 0;
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// while 반복문을 사용해 컨베이어 벨트가 이동한 결과를 갱신
		while (sequenceLength-- > 0)
			sum += Integer.parseInt(st.nextToken());
		
		// 컨베이어 벨트가 왼쪽으로 이동하는 경우 'Left'를 출력
		if (sum < 0) {
			out.write("Left");
			
		// 컨베이어 벨트가 오른쪽으로 이동하는 경우 'Right'를 출력
		} else if (sum > 0) {
			out.write("Right");
			
		// 컨베이어 벨트가 처음 위치로 되돌아오는 경우 'Stay'를 출력
		} else {
			out.write("Stay");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}