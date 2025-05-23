package silver5.num21194;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 운동의 수 및 선택할 운동의 수를 각 변수에 할당
		int exerciseNum = Integer.parseInt(st.nextToken());
		int selectLimit = Integer.parseInt(st.nextToken());
		
		// 선택한 운동의 최대 점수를 저장할 변수 maxScore 초기화
		int maxScore = 0;
		
		// 입력 받은 각 운동의 점수를 저장할 배열 scores 초기화
		Integer[] scores = new Integer[exerciseNum];
		
		// for 반복문을 사용해 입력 받은 각 운동의 점수를 배열 scores에 저장
		for (int idx = 0; idx < scores.length; idx++)
			scores[idx] = Integer.parseInt(in.readLine());
		
		// sort() 및 reverseOrder() 메서드를 사용해 각 운동의 점수를 내림차순으로 정렬
		Arrays.sort(scores, Collections.reverseOrder());
		
		// for 반복문을 사용해 선택한 운동의 최대 점수를 갱신
		for (int idx = 0; idx < selectLimit; idx++)
			maxScore += scores[idx];
		
		// valueOf() 및 write() 메서드를 사용해 선택한 운동의 최대 점수를 출력
		out.write(String.valueOf(maxScore));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}