package bronze3.num05354;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 준섭이가 그린 선의 개수를 변수 lineCount에 할당
		int lineCount = Integer.parseInt(in.readLine());
		
		// 직선 좌표에 투사된 선의 총 길이 합을 저장할 변수 sum 초기화
		int sum = 0;
		
		// 준섭이가 그린 선의 위치를 표시한 좌표를 저장할 배열 coordinates 초기화
		boolean[] coordinates = new boolean[10000];
		
		// while 반복문을 사용해 준섭이가 그린 각 선을 순회
		while (lineCount-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 시작 좌표와 끝 좌표를 각 변수에 할당
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			// for 반복문을 사용해 해당 선의 각 좌표를 순회
			for (int idx = start; idx < end; idx++) {
				
				// 해당 좌표에 이미 선이 존재하는 경우 다음 좌표를 순회
				if (coordinates[idx])
					continue;
				
				// 해당 좌표에 선이 존재하는 것으로 갱신 후 직선 좌표에 투사된 선의 총 길이 합을 갱신
				coordinates[idx] = true;
				sum++;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 직선 좌표에 투사된 선의 총 길이 합을 출력
		out.write(String.valueOf(sum));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}