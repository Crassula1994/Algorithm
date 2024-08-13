package silver5.num01817;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 책의 개수 및 박스에 넣을 수 있는 최대 무게를 각 변수에 할당
		int bookNum = Integer.parseInt(st.nextToken());
		int weightLimit = Integer.parseInt(st.nextToken());
		
		// 현재 박스의 무게 및 필요한 박스의 개수 최솟값을 저장할 각 변수 초기화
		int curWeight = 0;
		int minCount = (bookNum == 0) ? 0 : 1;
		
		// 책이 존재하는 경우
		if (bookNum > 0) {

			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 각 책을 순회
			for (int book = 0; book < bookNum; book++) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 해당 책의 무게를 변수 weight에 할당
				int weight = Integer.parseInt(st.nextToken());
				
				// 책을 박스에 더 이상 넣을 수 없는 경우 필요한 박스의 개수 및 현재 박스의 무게 갱신
				if (curWeight + weight > weightLimit) {
					minCount++;
					curWeight = weight;
					
				// 책을 박스에 넣을 수 있는 경우 현재 박스의 무게 갱신
				} else {
					curWeight += weight;
				}
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 필요한 박스의 개수 최솟값을 출력
		out.write(String.valueOf(minCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}