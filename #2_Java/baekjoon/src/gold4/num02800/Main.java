package gold4.num02800;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

// Main 클래스 정의
public class Main {
	
	// 입력 받은 수식 및 각 괄호의 제거 여부를 저장할 각 배열 초기화
	static char[] expression;
	static boolean[] removed;
	
	// 각 괄호의 정보를 저장할 List 객체 brackets 초기화
	static List<Bracket> brackets = new ArrayList<>();
	
	// 괄호를 제거한 수식을 저장할 Set 객체 results 초기화
	static Set<String> results = new TreeSet<>();
	
	// ----------------------------------------------------------------------------------------------------
	
	// Bracket 클래스 정의
	public static class Bracket {
		
		// 괄호의 시작 위치와 끝 위치를 저장할 각 변수 초기화
		int start;
		int end;
		
		// 매개변수를 입력 받는 생성자 정의
		public Bracket(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 toCharArray() 메서드를 사용해 입력 받은 수식을 배열 expression에 저장
		expression = in.readLine().toCharArray();
		
		// 각 괄호의 제거 여부를 저장할 배열 removed 초기화
		removed = new boolean[expression.length];
		
		// 각 괄호를 찾을 Stack 객체 bracketFinder 초기화
		Stack<Integer> bracketFinder = new Stack<>();
		
		// for 반복문을 사용해 수식의 각 글자를 순회
		for (int idx = 0; idx < expression.length; idx++) {
			
			// 해당 글자가 여는 괄호인 경우 bracketFinder에 해당 인덱스를 저장
			if (expression[idx] == '(') {
				bracketFinder.push(idx);
				
			// 해당 글자가 닫는 괄호인 경우 brackets에 해당 괄호의 정보를 저장
			} else if (expression[idx] == ')') {
				brackets.add(new Bracket(bracketFinder.pop(), idx));
			}
		}
		
		// bracketRemover() 메서드를 호출해 각 괄호를 제거한 식을 results에 저장
		bracketRemover(0, 0);
		
		// for 반복문을 사용해 괄호를 제거한 식을 사전 순으로 출력
		for (String result : results)
			out.write(result + "\n");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// bracketRemover() 메서드 정의
	public static void bracketRemover(int curBracket, int count) {
		
		// 모든 괄호를 확인한 경우
		if (curBracket == brackets.size()) {
			
			// 어떤 괄호도 제거하지 않은 경우 메서드 종료
			if (count == 0)
				return;
			
			// 괄호를 제거한 수식을 저장할 StringBuilder 객체 sb 초기화
			StringBuilder sb = new StringBuilder();
			
			// for 반복문을 사용해 수식의 각 글자를 순회
			for (int idx = 0; idx < expression.length; idx++) {
				
				// 해당 글자가 제거한 괄호인 경우 다음 글자를 순회
				if (removed[idx])
					continue;
				
				// append() 메서드를 사용해 해당 글자를 sb에 추가
				sb.append(expression[idx]);
			}
			
			// toString() 및 add() 메서드를 사용해 괄호를 제거한 수식을 results에 추가
			results.add(sb.toString());
			
			// 메서드 종료
			return;
		}
		
		// 해당 괄호를 제거하지 않은 것을 상정해 bracketRemover() 메서드 재귀 호출
		bracketRemover(curBracket + 1, count);
		
		// get() 메서드를 사용해 현재 괄호를 변수 bracket에 할당
		Bracket bracket = brackets.get(curBracket);
		
		// 괄호를 제거한 것으로 처리
		removed[bracket.start] = true;
		removed[bracket.end] = true;
		
		// 해당 괄호를 제거한 것을 상정해 bracketRemover() 메서드 재귀 호출
		bracketRemover(curBracket + 1, count + 1);
		
		// 괄호를 제거하지 않은 것으로 원상복구
		removed[bracket.start] = false;
		removed[bracket.end] = false;
	}
}