package gold5.num28377;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;  
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 개구리의 수를 변수 frogNum에 할당
		int frogNum = Integer.parseInt(in.readLine());
		
		// 각 개구리가 위치한 수련 잎의 위치를 저장할 배열 frogs 초기화
		int[] frogs = new int[frogNum];
		
		// 현재 비어 있는 수련 잎의 위치를 저장할 TreeSet 객체 lilyPads 초기화
		TreeSet<Integer> lilyPads = new TreeSet<>();
		
		// for 반복문을 사용해 현재 비어 있는 수련 잎의 위치를 lilyPads에 저장
		for (int pad = 1; pad <= 1_200_000; pad++)
			lilyPads.add(pad);
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 개구리가 위치한 수련 잎의 위치를 순회
		for (int idx = 0; idx < frogs.length; idx++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 해당 개구리가 위치한 수련 잎의 위치를 배열 frogs에 저장
			frogs[idx] = Integer.parseInt(st.nextToken());
			
			// remove() 메서드를 사용해 현재 개구리가 위치한 수련 잎의 위치를 lilyPads에서 제거
			lilyPads.remove(frogs[idx]);
		}
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 기록된 점프 횟수를 변수 jumpCount에 할당
		int jumpCount = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 점프 횟수를 순회
		while (jumpCount-- > 0) {
			
			// readLine() 및 parseInt() 메서드를 사용해 점프한 개구리의 번호를 변수 frog에 할당
			int frog = Integer.parseInt(in.readLine()) - 1;
			
			// higher() 메서드를 사용해 현재 개구리가 위치한 수련 잎의 위치와 개구리가 이동할 수련 잎의 위치를 각 변수에 할당
			int curPosition = frogs[frog];
			int nextPosition = lilyPads.higher(curPosition);
			
			// add() 및 remove() 메서드를 사용해 비어 있는 수련 잎의 위치를 갱신
			lilyPads.add(curPosition);
			lilyPads.remove(nextPosition);
			
			// 현재 개구리의 위치를 갱신
			frogs[frog] = nextPosition;
			
			// write() 메서드를 사용해 현재 개구리가 이동할 수련 잎의 위치를 출력
			out.write(nextPosition + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}