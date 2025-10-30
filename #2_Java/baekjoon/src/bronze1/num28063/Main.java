package bronze1.num28063;

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

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 기계의 한 변의 길이를 변수 length에 할당
		int length = Integer.parseInt(in.readLine());
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 동전의 처음 위치를 각 변수에 할당
		int startX = Integer.parseInt(st.nextToken());
		int startY = Integer.parseInt(st.nextToken());
		
		// 기계의 최소 작동횟수를 저장할 변수 minCount 초기화
		int minCount = 4;
		
		// 기계를 왼쪽으로 작동시킬 필요가 없는 경우 기계의 최소 작동횟수를 갱신
		if (startX == 1)
			minCount--;
		
		// 기계를 오른쪽으로 작동시킬 필요가 없는 경우 기계의 최소 작동횟수를 갱신
		if (startX == length)
			minCount--;
		
		// 기계를 아래쪽으로 작동시킬 필요가 없는 경우 기계의 최소 작동횟수를 갱신
		if (startY == 1)
			minCount--;
		
		// 기계를 위쪽으로 작동시킬 필요가 없는 경우 기계의 최소 작동횟수를 갱신
		if (startY == length)
			minCount--;
		
		// valueOf() 및 write() 메서드를 사용해 기계의 최소 작동횟수를 출력
		out.write(String.valueOf(minCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}