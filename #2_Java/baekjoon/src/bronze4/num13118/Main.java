package bronze4.num13118;

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
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 네 사람의 위치를 저장할 배열 location 초기화
		int[] location = new int[5];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 네 사람의 위치를 배열 location에 저장
		for (int idx = 1; idx <= 4; idx++)
			location[idx] = Integer.parseInt(st.nextToken());
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 사과의 정보를 각 변수에 할당 
		int locationX = Integer.parseInt(st.nextToken());
		int locationY = Integer.parseInt(st.nextToken());
		int radius = Integer.parseInt(st.nextToken());
		
		// 사과와 충돌하는 사람의 번호를 저장할 변수 answer 초기화
		int answer = 0;
		
		// for 반복문을 사용해 네 사람의 위치를 순회
		for (int idx = 1; idx <= 4; idx++) {
			
			// 해당 위치가 사과의 위치 바로 아래인 경우 사과와 충돌하는 사람의 번호를 갱신 후 반복문 탈출
			if (location[idx] == locationX) {
				answer = idx;
				break;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 사과와 충돌하는 사람의 번호를 출력
		out.write(String.valueOf(answer));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}