package bronze3.num10833;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 학교의 수를 변수 schoolNum에 할당
		int schoolNum = Integer.parseInt(in.readLine());
     
		// 남는 사과의 총 개수를 저장할 변수 remains 초기화
		int remains = 0;
     
		// for 반복문을 사용해 각 학교를 차례로 순회
		for (int s = 0; s < schoolNum; s++) {
         
			// StringTokenizer 객체를 불러와 변수 st에 할당
		    StringTokenizer st = new StringTokenizer(in.readLine());
         
		    // nextToken() 및 parseInt() 메서드를 사용해 입력 받은 학생 수와 사과 수를 각 변수에 할당
		    int studentNum = Integer.parseInt(st.nextToken());
		    int appleNum = Integer.parseInt(st.nextToken());
         
	         // 남는 사과의 총 개수를 갱신
		    remains += appleNum % studentNum;
		}
		
		// valueOf() 및 write() 메서드를 사용해 남는 사과의 총 개수를 출력
		out.write(String.valueOf(remains));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}