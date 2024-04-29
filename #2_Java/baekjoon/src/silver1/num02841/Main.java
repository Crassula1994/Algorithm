package silver1.num02841;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	@SuppressWarnings({ "unchecked", "unused" })
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 음의 수 및 프렛의 수를 각 변수에 할당
		int noteNum = Integer.parseInt(st.nextToken());
		int fretNum = Integer.parseInt(st.nextToken());
		
		// 멜로디를 연주하는 데 필요한 최소 손가락 움직임을 저장할 변수 minCount 초기화
		int minCount = 0;
		
		// 각 줄에서 누른 프렛의 번호를 저장할 배열 strings 초기화
		Stack<Integer>[] strings = new Stack[7];
		
		// for 반복문을 사용해 각 줄에서 누른 프렛의 번호를 저장할 Stack 객체 초기화
		for (int idx = 0; idx < strings.length; idx++)
			strings[idx] = new Stack<>();
		
		// for 반복문을 사용해 각 멜로디를 순회
		for (int note = 0; note < noteNum; note++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 줄의 번호와 프렛의 번호를 각 변수에 할당
			int string = Integer.parseInt(st.nextToken());
			int fret = Integer.parseInt(st.nextToken());
			
			// while 반복문을 사용해 해당 줄이 빌 때까지 순회
			while (!strings[string].isEmpty()) {
				
				// 가장 높게 누르고 있는 프렛보다 현재 프렛이 더 높은 경우 반복문 탈출
				if (strings[string].peek() < fret)
					break;
				
				// 가장 높게 누르고 있는 프렛과 현재 프렛이 같은 경우
				if (strings[string].peek() == fret) {
					
					// pop() 메서드를 사용해 현재 누르고 있는 프렛을 제거
					strings[string].pop();
					
					// 멜로디를 연주하는 데 필요한 최소 손가락 움직임 조정 후 반복문 탈출
					minCount--;
					break;
				}
				
				// pop() 메서드를 사용해 현재 누르고 있는 프렛을 제거
				strings[string].pop();
				
				// 멜로디를 연주하는 데 필요한 최소 손가락 움직임 갱신
				minCount++;
			}
			
			// push() 메서드를 사용해 현재 누르고 있는 프렛을 추가
			strings[string].push(fret);
			
			// 멜로디를 연주하는 데 필요한 최소 손가락 움직임 갱신
			minCount++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 멜로디를 연주하는 데 필요한 최소 손가락 움직임을 출력
		out.write(String.valueOf(minCount));
		 
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}