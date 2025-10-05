package bronze1.num14709;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 손가락 쌍의 개수를 변수 pairNum에 할당
		int pairNum = Integer.parseInt(in.readLine());
		
		// 도주의 손 모양이 여우 사인이라고 할 수 있는지 여부를 저장할 변수 isFoxSign 초기화
		boolean isFoxSign = true;
		
		// 각 손가락 쌍을 저장할 2차원 배열 connected 초기화
		boolean[][] connected = new boolean[6][6];
		
		// while 반복문을 사용해 각 손가락 쌍의 개수를 순회
		while (pairNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 해당 쌍의 각 손가락을 각 변수에 할당
			int firstFinger = Integer.parseInt(st.nextToken());
			int secondFinger = Integer.parseInt(st.nextToken());
			
			/* 해당 손가락이 검지이거나 새끼손가락인 경우
			도주의 손 모양이 여우 사인이라고 할 수 있는지 여부를 갱신 후 반복문 탈출 */
			if (firstFinger == 2 || firstFinger == 5 || secondFinger == 2 || secondFinger == 5) {
				isFoxSign = false;
				break;
			}
			
			// 연결된 손가락 쌍의 정보를 2차원 배열 connected에 추가
			connected[firstFinger][secondFinger] = true;
			connected[secondFinger][firstFinger] = true;
		}
		
		// 연결된 손가락 쌍 중 검지와 새끼손가락이 없는 경우 도주의 손 모양을 여우 사인이라고 할 수 있는지 여부를 갱신
		if (isFoxSign)
			isFoxSign = connected[1][3] && connected[1][4] && connected[3][4];
		
		// write() 메서드를 사용해 도주의 손 모양이 여우 사인이라고 할 수 있는지 여부를 출력
		out.write((isFoxSign) ? "Wa-pa-pa-pa-pa-pa-pow!" : "Woof-meow-tweet-squeek");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}