package silver1.num11278;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 변수의 개수, 절의 개수, 2-CNF식을 true로 만들 수 있는지 여부를 나타낼 각 변수 초기화
	static int variableNum;
	static int clauseNum;
	static boolean hasSolution = false;
	
	// 각 변수의 true 및 false 여부를 저장할 배열 variables 초기화
	static int[] variables;
	
	// 각 항의 절을 저장할 2차원 배열 clauses 초기화
	static int[][] clauses;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 변수의 개수와 절의 개수를 각 변수에 할당
		variableNum = Integer.parseInt(st.nextToken());
		clauseNum = Integer.parseInt(st.nextToken());
		
		// 각 변수의 true 및 false 여부를 저장할 배열 variables 초기화
		variables = new int[variableNum + 1];
		
		// 각 항의 절을 저장할 2차원 배열 clauses 초기화
		clauses = new int[clauseNum][2];
		
		// for 반복문을 사용해 각 항의 정보를 순회
		for (int idx = 0; idx < clauseNum; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 항의 정보를 2차원 배열 clauses에 저장
			clauses[idx][0] = Integer.parseInt(st.nextToken());
			clauses[idx][1] = Integer.parseInt(st.nextToken());
		}
		
		// solutionFinder() 메서드를 호출해 2-CNF식을 true로 만들 수 있는지 여부를 갱신
		solutionFinder(0, 0);
		
		// 2-CNF식을 true로 만들 수 있는 경우
		if (hasSolution) {
			
			// write() 메서드를 사용해 1을 출력
			out.write(1 + "\n");
			
			// for 반복문을 사용해 2-CNF식을 true로 만드는 각 변수를 출력
			for (int idx = 1; idx < variables.length; idx++)
				out.write(variables[idx] + " ");
			
		// 2-CNF식을 true로 만들 수 없는 경우 0을 출력
		} else {
			out.write(String.valueOf(0));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// solutionFinder() 메서드 정의
	public static void solutionFinder(int curVariable, int curState) {
		
		// 2-CNF식을 true로 만드는 해를 찾은 경우 메서드 종료
		if (hasSolution)
			return;
		
		// 모든 변수를 확인한 경우
		if (curVariable > variableNum) {
			
			// 해당 변수 조합이 해인 경우 2-CNF식을 true로 만들 수 있는지 여부를 갱신
			if (solutionChecker())
				hasSolution = true;
			
			// 메서드 종료
			return;
		}
		
		// 현재 변수를 갱신
		variables[curVariable] = curState;
		
		// 해당 변수를 false와 true인 것으로 각각 상정해 solutionFinder() 메서드 재귀 호출
		solutionFinder(curVariable + 1, 0);
		solutionFinder(curVariable + 1, 1);
	}
	
	// ----------------------------------------------------------------------------------------------------

	// solutionChecker() 메서드 정의
	public static boolean solutionChecker() {
		
		// for 반복문을 사용해 각 항을 순회
		for (int[] clause : clauses) {
			
			// abs() 메서드를 사용해 각 변수의 true 및 false 여부를 각 변수에 할당
			boolean variable1 = (clause[0] < 0)
					? !(variables[Math.abs(clause[0])] == 1) : variables[Math.abs(clause[0])] == 1;
			boolean variable2 = (clause[1] < 0)
					? !(variables[Math.abs(clause[1])] == 1) : variables[Math.abs(clause[1])] == 1;
			
			// 두 변수가 모두 false인 경우 false 반환
			if (!variable1 && !variable2)
				return false;
		}
		
		// 해당 변수 조합이 해인 경우 true 반환
		return true;
	}
}