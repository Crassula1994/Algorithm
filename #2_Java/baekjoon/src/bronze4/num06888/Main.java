package bronze4.num06888;

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
		
		// StringBuilder 객체를 불러와 변수 sb에 할당
		StringBuilder sb = new StringBuilder();
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 시작 연도와 끝 연도를 각 변수에 할당
		int startYear = Integer.parseInt(in.readLine());
		int endYear = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 모든 직위가 변경되는 연도를 sb에 저장
		for (int year = startYear; year <= endYear; year += 60)
			sb.append("All positions change in year ").append(year).append("\n");
		
		// toString() 및 write() 메서드를 사용해 모든 직위가 변경되는 연도를 출력
		out.write(sb.toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}