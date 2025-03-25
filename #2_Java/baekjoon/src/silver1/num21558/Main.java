package silver1.num21558;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 민족의 수를 변수 ethnicityNum에 할당
		int ethnicityNum = Integer.parseInt(in.readLine());
		
		// 전체 병사의 수를 저장할 변수 totalCount 초기화
		int totalCount = 0;
		
		// 각 민족의 병사 수, 각 평화의 돌의 개수별 가장 큰 열의 수를 저장할 각 배열 초기화
		int[] ethnicities = new int[ethnicityNum];
		int[] maxColumns = new int[ethnicityNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 민족의 병사 수를 순회
		for (int idx = 0; idx < ethnicities.length; idx++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 민족의 병사 수를 배열 ethnicities에 저장
			ethnicities[idx] = Integer.parseInt(st.nextToken());
			
			// 전체 병사의 수를 갱신
			totalCount += ethnicities[idx];
		}
		
		// for 반복문을 사용해 각 평화의 돌의 개수별 가장 큰 열의 수를 출력
		for (int maxColumn : maxColumns)
			out.write(maxColumn + " ");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}