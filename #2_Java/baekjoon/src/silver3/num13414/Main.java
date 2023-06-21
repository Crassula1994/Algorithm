package silver3.num13414;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedHashSet;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 수강 가능 인원 및 대기 목록의 길이를 각 변수에 할당
		int quota = Integer.parseInt(st.nextToken());
		int waitingListLen = Integer.parseInt(st.nextToken());
		
		// 실제 대기 목록을 저장할 LinkedHashSet 객체 waitingList 초기화
		LinkedHashSet<String> waitingList = new LinkedHashSet<>();
		
		// for 반복문을 사용해 입력 받은 대기 목록을 차례로 순회
		for (int w = 0; w < waitingListLen; w++) {
			
			// readLine() 메서드를 사용해 입력 받은 학번을 변수 studentSeq에 저장
			String studentSeq = in.readLine();
			
			// 해당 학번이 대기 목록에 있는 경우 해당 학번을 제거
			if (waitingList.contains(studentSeq))
				waitingList.remove(studentSeq);
			
			// add() 메서드를 사용해 해당 학번을 대기 목록에 추가
			waitingList.add(studentSeq);
		}
		
		// 수강 신청에 성공한 학생의 수를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 대기 목록의 학번을 차례로 순회
		for (String studentSeq : waitingList) {
			
			// write() 메서드를 사용해 해당 학번을 출력
			out.write(studentSeq + "\n");
			
			// 수강 신청에 성공한 학생의 수를 갱신
			count++;
			
			// 수강 신청에 성공한 학생 수가 수강 가능 인원을 만족한 경우 반복문 탈출
			if (count == quota)
				break;
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}