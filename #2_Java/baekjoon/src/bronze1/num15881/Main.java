package bronze1.num15881;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 물건의 총 개수를 변수 itemNum에 할당
		int itemNum = Integer.parseInt(in.readLine());
		
		// 만들 수 있는 펜-파인애플-애플-펜의 최대 개수를 저장할 변수 maxCount 초기화
		int maxCount = 0;
		
		// readLine() 및 toCharArray() 메서드를 사용해 입력 받은 물건의 목록을 배열 itemList에 할당 
		char[] itemList = in.readLine().toCharArray();
		
		// for 반복문을 사용해 각 위치를 순회
		for (int idx = 0; idx < itemNum - 3; idx++) {
			
			// 해당 위치에서 펜-파인애플-애플-펜을 만들 수 있는 경우
			if (itemList[idx] == 'p' && itemList[idx + 1] == 'P'
					&& itemList[idx + 2] == 'A' && itemList[idx + 3] == 'p') {
				
				// 만들 수 있는 펜-파인애플-애플-펜의 최대 개수 및 현재 위치를 갱신
				maxCount++;
				idx += 3;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 만들 수 있는 펜-파인애플-애플-펜의 최대 개수를 출력
		out.write(String.valueOf(maxCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}