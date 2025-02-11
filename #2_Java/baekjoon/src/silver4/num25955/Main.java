package silver4.num25955;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// Question 클래스 정의
	static class Question implements Comparable<Question> {
		
		// 각 문제 난이도의 표기와 변환 난이도를 저장할 각 변수 초기화
		String origDiff;
		int convDiff;
		
		// 매개변수를 입력 받는 생성자 정의
		public Question(String origDiff) {
			
			// charAt() 메서드를 사용해 입력 받은 티어를 변수 tier에 할당
			char tier = origDiff.charAt(0);
			
			// substring() 및 parseInt() 메서드를 사용해 입력 받은 단계를 변수 stage에 할당
			int stage = Integer.parseInt(origDiff.substring(1));
			
			// switch 조건문을 사용해 각 티어에 따른 변환 난이도를 갱신
			switch (tier) {
				case 'B':
					stage += 10000;
				case 'S':
					stage += 10000;
				case 'G':
					stage += 10000;
				case 'P':
					stage += 10000;
				default:
					stage += 10000;
			}
			
			// 입력 받은 문제 난이도 표기와 변환 난이도를 각 변수에 할당
			this.origDiff = origDiff;
			this.convDiff = stage;
		}

		// compareTo() 메서드 정의
		@Override
		public int compareTo(Question anotherQuestion) {
			
			// 변환 난이도가 낮은 순서대로 정렬
			return anotherQuestion.convDiff - this.convDiff;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 문제의 수를 저장할 변수 questionNum에 할당
		int questionNum = Integer.parseInt(in.readLine());
		
		// 입력 받은 각 문제를 순서대로 저장할 배열 questions 초기화
		Question[] questions = new Question[questionNum];
		
		// 잘못 배치된 문제를 저장할 List 객체 switchedQuestions 초기화
		List<String> switchedQuestions = new ArrayList<>();
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 문제를 배열 questions에 저장
		for (int idx = 0; idx < questions.length; idx++)
			questions[idx] = new Question(st.nextToken());
		
		// clone() 메서드를 사용해 입력 받은 각 문제를 정렬할 배열 sortedQuestions 초기화
		Question[] sortedQuestions = questions.clone();
		
		// sort() 메서드를 사용해 입력 받은 각 문제를 정렬
		Arrays.sort(sortedQuestions);
		
		// for 반복문을 사용해 각 문제를 순회
		for (int idx = 0; idx < questionNum; idx++) {
			
			// 해당 문제가 일치하는 경우 다음 문제를 순회
			if (questions[idx].convDiff == sortedQuestions[idx].convDiff)
				continue;
			
			// add() 메서드를 사용해 잘못 배치된 문제를 switchedQuestions에 추가
			switchedQuestions.add(questions[idx].origDiff);
			
			// 잘못 배치된 문제를 모두 찾은 경우 반복문 탈출
			if (switchedQuestions.size() == 2)
				break;
		}
		
		// 난이도가 쉬운 순으로 잘 배치되어 있는 경우 'OK'를 출력
		if (switchedQuestions.isEmpty()) {
			out.write("OK");
			
		// 난이도가 쉬운 순으로 잘 배치되어 있지 않은 경우
		} else {
			
			// write() 메서드를 사용해 'KO'를 출력
			out.write("KO");
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
			
			// get() 및 write() 메서드를 사용해 잘못 배치된 문제의 난이도를 쉬운 순으로 출력
			out.write(switchedQuestions.get(1) + " " + switchedQuestions.get(0));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}