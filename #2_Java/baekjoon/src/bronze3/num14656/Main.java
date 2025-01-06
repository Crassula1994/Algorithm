package bronze3.num14656;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받는 헌우네 반 학생의 수를 변수 studentNum에 할당
		int studentNum = Integer.parseInt(in.readLine());
		
		// 맞게 될 학생의 수를 저장할 변수 count 초기화
		int count = 0;
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 현재 줄을 서 있는 순서를 순회
		for (int order = 1; order <= studentNum; order++) {
			
			// 번호 순서대로 선 학생인 경우 다음 순서를 순회
			if (Integer.parseInt(st.nextToken()) == order)
				continue;
			
			// 맞게 될 학생의 수를 갱신
			count++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 맞게 될 학생의 수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}