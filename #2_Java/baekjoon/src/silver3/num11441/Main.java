package silver3.num11441;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수의 개수를 변수 numberCnt에 할당
		int numberCnt = Integer.parseInt(in.readLine());
		
		// 각 숫자까지의 합을 저장할 각 변수 초기화
		int[] sum = new int[numberCnt + 1];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 숫자까지의 합을 갱신
		for (int idx = 1; idx <= numberCnt; idx++)
			sum[idx] = sum[idx - 1] + Integer.parseInt(st.nextToken());
			
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 구간의 개수를 변수 sectionNum에 할당
		int sectionNum = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 구간을 순회
		for (int section = 0; section < sectionNum; section++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 각 구간의 시작과 끝을 각 변수에 할당
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			// valueOf() 및 write() 메서드를 사용해 구간 합을 출력
			out.write(String.valueOf(sum[end] - sum[start - 1]));
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}