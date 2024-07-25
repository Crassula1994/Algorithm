package bronze4.num30033;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 임스가 계획하고 공부한 일수를 변수 dayNum에 할당
		int dayNum = Integer.parseInt(in.readLine());
		
		// 임스가 계획한 페이지 수 이상으로 공부한 횟수를 저장할 변수 count 초기화
		int count = 0;
		
		// StringTokenizer 객체를 불러와 각 변수에 할당
		StringTokenizer planStr = new StringTokenizer(in.readLine());
		StringTokenizer realityStr = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 일수를 순회
		for (int day = 0; day < dayNum; day++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 해당 날짜의 계획한 페이지 수 및 공부한 페이지 수를 각 변수에 할당
			int plan = Integer.parseInt(planStr.nextToken());
			int reality = Integer.parseInt(realityStr.nextToken());
			
			// 계획한 페이지 수 이상으로 공부한 경우 해당 횟수를 갱신
			if (reality >= plan)
				count++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 임스가 계획한 페이지 수 이상으로 공부한 횟수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}