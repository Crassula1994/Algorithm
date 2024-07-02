package gold4.num15368;

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
	
	// 각 직원이 벌어들인 돈, 총 부하 직원의 수, 부하 직원 현황을 저장할 각 배열 초기화
	static long[] earnings;
	static int[] counts;
	static List<Integer>[] assistants;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 직원의 수를 변수 employeeNum에 할당
		int employeeNum = Integer.parseInt(in.readLine());
		
		// 각 직원이 벌어들인 돈, 총 부하 직원의 수, 부하 직원 현황을 저장할 각 배열 초기화
		earnings = new long[employeeNum + 1];
		counts = new int[employeeNum + 1];
		assistants = new ArrayList[employeeNum + 1];
		
		// for 반복문을 사용해 각 직원의 부하 직원 현황을 저장할 List 객체 초기화
		for (int idx = 0; idx < assistants.length; idx++)
			assistants[idx] = new ArrayList<>();
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 상사가 존재하는 각 직원을 순회
		for (int assistant = 2; assistant <= employeeNum; assistant++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 해당 직원의 상사를 변수 boss에 할당
			int boss = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 해당 상사의 부하 직원을 배열 assistants에 저장
			assistants[boss].add(assistant);
		}
		
		// earningCalculator() 메서드를 호출해 각 직원이 벌어들인 돈을 갱신
		earningCalculator(1);
		
		// for 반복문을 사용해 각 직원이 벌어들인 돈을 차례로 출력
		for (int idx = 1; idx < earnings.length; idx++)
			out.write(earnings[idx] + " ");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// earningCalculator() 메서드 정의
	public static void earningCalculator(int employee) {
		
		// for 반복문을 사용해 해당 직원의 부하 직원을 순회
		for (int assistant : assistants[employee]) {
			
			// earningCalculator() 메서드 재귀 호출
			earningCalculator(assistant);
			
			// 해당 직원의 부하 직원의 수 및 벌어들인 돈을 갱신
			counts[employee] += counts[assistant] + 1;
			earnings[employee] += earnings[assistant];
		}
		
		// 자기자신이 일을 할 때 및 부하 직원이 일을 할 때 추가로 버는 돈을 갱신
		earnings[employee] += counts[employee] + 1;
	}
}