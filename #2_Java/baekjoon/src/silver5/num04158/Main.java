package silver5.num04158;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 상근이가 가진 CD의 종류를 저장할 Set 객체 listSK 초기화
	static Set<Integer> listSK;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (true) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 상근이와 선영이가 가진 CD의 수를 각 변수에 할당
			int countSK = Integer.parseInt(st.nextToken());
			int countSY = Integer.parseInt(st.nextToken());
			
			// 마지막 테스트 케이스인 경우 반복문 탈출
			if (countSK == 0 && countSY == 0)
				break;
			
			// 상근이와 선영이가 동시에 가지고 있는 CD의 개수를 저장할 변수 count 초기화
			int count = 0;
			
			// 상근이가 가진 CD의 종류를 저장할 Set 객체 listSK 초기화
			listSK = new HashSet<>();
			
			// while 반복문을 사용해 입력 받은 상근이가 가진 CD를 listSK에 저장
			while (countSK-- > 0)
				listSK.add(Integer.parseInt(in.readLine()));
			
			// while 반복문을 사용해 선영이가 가진 CD를 순회
			while (countSY-- > 0) {
				
				// 상근이가 선영이가 가진 CD를 가지고 있는 경우 동시에 가지고 있는 CD의 개수를 갱신
				if (listSK.contains(Integer.parseInt(in.readLine())))
					count++;
			}
			
			// write() 메서드를 사용해 상근이와 선영이가 동시에 가지고 있는 CD의 개수를 출력
			out.write(count + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}