package silver3.num14241;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 슬라임의 개수를 변수 slimeNum에 할당
		int slimeNum = Integer.parseInt(in.readLine());
		
		// 영선이와 효빈이가 얻을 수 있는 점수의 최댓값을 저장할 변수 maxScore 초기화
		int maxScore = 0;
		
		// 각 슬라임의 크기를 저장할 배열 slimes 초기화
		int[] slimes = new int[slimeNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 슬라임의 크기를 배열 slimes에 저장
		for (int idx = 0; idx < slimes.length; idx++)
			slimes[idx] = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 각 슬라임을 순회
		for (int idx = 1; idx < slimes.length; idx++) {
			
			// 두 슬라임을 합친 점수를 영선이와 효빈이가 얻을 수 있는 점수의 최댓값에 갱신
			maxScore += slimes[idx] * slimes[idx - 1];
			
			// 현재 슬라임의 크기를 갱신
			slimes[idx] += slimes[idx - 1];
		}
		
		// valueOf() 및 write() 메서드를 사용해 영선이와 효빈이가 얻을 수 있는 점수의 최댓값을 출력
		out.write(String.valueOf(maxScore));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}