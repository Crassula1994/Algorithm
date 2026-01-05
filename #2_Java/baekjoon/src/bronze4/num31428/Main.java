package bronze4.num31428;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 친구의 수를 변수 friendNum에 할당
		int friendNum = Integer.parseInt(in.readLine());
		
		// 각 트랙에 등록한 친구들의 수를 저장할 배열 counts 초기화
		int[] counts = new int[26];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// while 반복문을 사용해 각 트랙에 등록한 친구들의 수를 갱신
		while (friendNum-- > 0)
			counts[st.nextToken().charAt(0) - 'A']++;
		
		// readLine(), charAt(), valueOf(), write() 메서드를 사용해 헬로빗과 같은 트랙에 등록한 친구들의 수를 출력
		out.write(String.valueOf(counts[in.readLine().charAt(0) - 'A']));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}