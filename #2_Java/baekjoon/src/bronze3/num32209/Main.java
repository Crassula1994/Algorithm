package bronze3.num32209;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 이벤트의 수를 변수 eventNum에 할당
		int eventNum = Integer.parseInt(in.readLine());
		
		// 현재 저장된 문제의 수 및 월간 향유회가 해산되었는지 여부를 저장할 각 변수 초기화
		int totalCount = 0;
		boolean isDisbanded = false;
		
		// for 반복문을 사용해 각 이벤트를 순회
		for (int event = 0; event < eventNum; event++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 이벤트의 종류 및 추가 혹은 사용한 문제의 수를 각 변수에 할당
			int category = Integer.parseInt(st.nextToken());
			int count = Integer.parseInt(st.nextToken());
			
			// 문제 포럼에 문제를 추가하는 경우 추가한 문제의 수를 저장된 문제의 수에 갱신
			if (category == 1) {
				totalCount += count;
				
			// 대회가 열려 문제를 사용하는 경우
			} else {
				
				// 저장된 문제보다 사용할 문제가 더 많은 경우 월간 향유회가 해산되었는지 여부를 갱신 후 반복문 탈출
				if (count > totalCount) {
					isDisbanded = true;
					break;
				}
				
				// 사용한 문제의 수를 저장된 문제의 수에 갱신
				totalCount -= count;
			}
		}
		
		// write() 메서드를 사용해 월간 향유회의 해산 여부를 출력
		out.write((isDisbanded) ? "Adios" : "See you next month");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}