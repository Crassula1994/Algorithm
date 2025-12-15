package bronze3.num17263;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 원소의 개수를 변수 elementNum에 할당
		int elementNum = Integer.parseInt(in.readLine());
		
		// 오름차순으로 정렬했을 때 배열의 마지막 원소를 저장할 변수 lastElement 초기화
		int lastElement = 0;
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// while 반복문을 사용해 오름차순으로 정렬했을 때 배열의 마지막 원소를 갱신
		while (elementNum-- > 0)
			lastElement = Math.max(Integer.parseInt(st.nextToken()), lastElement);
		
		// valueOf() 및 write() 메서드를 사용해 오름차순으로 정렬했을 때 배열의 마지막 원소를 출력
		out.write(String.valueOf(lastElement));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}