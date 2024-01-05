package bronze1.num01551;

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
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 수열의 크기와 반복 횟수를 각 변수에 할당
		int size = Integer.parseInt(st.nextToken());
		int count = Integer.parseInt(st.nextToken());
		
		// 현재 수열과 바꾼 수열을 저장할 각 List 객체 초기화
		List<Integer> curSequence = new ArrayList<>();
		List<Integer> nextSequence = new ArrayList<>();
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine(), ",");
		
		// for 반복문을 사용해 입력 받은 수열을 curSequence에 저장
		for (int idx = 0; idx < size; idx++)
			curSequence.add(Integer.parseInt(st.nextToken()));
		
		// for 반복문을 사용해 반복 횟수만큼 순회
		for (int c = 0; c < count; c++) {
			
			// for 반복문을 사용해 현재 수열의 각 원소을 순회
			for (int idx = 0; idx < curSequence.size() - 1; idx++) {
				
				// get() 메서드를 사용해 새로운 수열의 원소를 계산해 변수 newElement에 할당
				int newElement = curSequence.get(idx + 1) - curSequence.get(idx);
				
				// add() 메서드를 사용해 새로운 수열의 원소를 nextSequence에 추가
				nextSequence.add(newElement);
			}
			
			// 현재 수열을 새로운 수열으로 갱신 후 새로운 수열 초기화
			curSequence = new ArrayList<>(nextSequence);
			nextSequence = new ArrayList<>();
		}
		
		// for 반복문을 사용해 변형한 수열의 원소를 순회
		for (int idx = 0; idx < curSequence.size(); idx++) {
			
			// 제일 마지막 원소인 경우 ','을 빼고 출력
			if (idx == curSequence.size() - 1) {
				out.write(String.valueOf(curSequence.get(idx)));
			
			// 제일 마지막 원소가 아닌 경우 ','을 붙여 출력
			} else {
				out.write(curSequence.get(idx) + ",");
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}