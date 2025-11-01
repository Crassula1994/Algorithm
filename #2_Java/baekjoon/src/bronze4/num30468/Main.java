package bronze4.num30468;

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
		
		// 각 스탯의 합을 저장할 변수 sum 초기화
		int sum = 0;
		
		// for 반복문을 사용해 각 스탯의 합을 갱신
		for (int stat = 0; stat < 4; stat++)
			sum += Integer.parseInt(st.nextToken());
		
		/* nextToken(), parseInt(), max() 메서드를 사용해
		주어진 평균 수치를 만들기 위해 필요한 축복의 최소 횟수를 변수 minCount에 할당 */
		int minCount = Math.max(Integer.parseInt(st.nextToken()) * 4 - sum, 0);
		
		// valueOf() 및 write() 메서드를 사용해 주어진 평균 수치를 만들기 위해 필요한 축복의 최소 횟수를 출력
		out.write(String.valueOf(minCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}