package gold4.num05527;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 전구의 개수를 변수 bulbNum에 할당
		int bulbNum = Integer.parseInt(in.readLine());
		
		// 가장 긴 교대 패턴의 길이를 저장할 변수 maxLength 초기화
		int maxLength = 0;
		
		// 입력 받은 전구의 상태를 저장할 배열 bulbs 초기화
		int[] bulbs = new int[bulbNum];
		
		// 초기 전구에서 차례로 나타나는 교대 패턴의 길이를 저장할 List 객체 patterns 초기화
		List<Integer> patterns = new ArrayList<>();
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// add() 메서드를 사용해 첫 교대 패턴에 기계를 사용하는 경우를 상정한 값을 삽입
		patterns.add(0);
		
		// for 반복문을 사용해 각 전구의 상태를 순회
		for (int idx = 0, count = 0; idx < bulbs.length; idx++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 전구의 상태를 배열 bulbs에 저장
			bulbs[idx] = Integer.parseInt(st.nextToken());
			
			// 현재 전구가 첫 전구이거나 이전 전구와 교대 패턴을 이루고 있는 경우 교대 패턴의 길이를 갱신
			if (idx == 0 || bulbs[idx - 1] != bulbs[idx]) {
				count++;
			
			// 현재 전구가 이전 전구와 교대 패턴을 이루지 않는 경우 교대 패턴의 길이를 patterns에 저장 후 교대 패턴의 길이를 초기화 
			} else {
				patterns.add(count);
				count = 1;
			}
			
			// 현재 전구가 마지막 전구인 경우 교대 패턴의 길이를 patterns에 저장
			if (idx == bulbs.length - 1)
				patterns.add(count);
		}
		
		// add() 메서드를 사용해 마지막 교대 패턴에 기계를 사용하는 경우를 상정한 값을 삽입
		patterns.add(0);
		
		// for 반복문을 사용해 가장 긴 교대 패턴의 길이를 갱신
		for (int idx = 1; idx < patterns.size() - 1; idx++) 
			maxLength = Math.max(patterns.get(idx - 1) + patterns.get(idx) + patterns.get(idx + 1), maxLength);
		
		// valueOf() 및 write() 메서드를 사용해 가장 긴 교대 패턴의 길이를 출력
		out.write(String.valueOf(maxLength));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}