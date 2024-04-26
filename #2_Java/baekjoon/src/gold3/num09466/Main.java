package gold3.num09466;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 해당 학생들을 확인했는지, 팀을 만들었는지 여부를 저장할 각 상수 초기화
	static final int NOT_CHECKED = 0;
	static final int TEAM_MADE = -1;
	
	// 프로젝트 팀에 속하지 않은 학생들의 수를 저장할 변수 count 초기화
	static int count;
	
	// 선택된 학생들의 번호, 각 학생에 대한 확인이 끝났는지 여부를 저장할 각 배열 초기화
	static int[] selection;
	static int[] checked;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 학생의 수를 변수 studentNum에 할당
			int studentNum = Integer.parseInt(in.readLine());
			
			// 프로젝트 팀에 속하지 않은 학생들의 수를 저장할 변수 count 초기화
			count = 0;
			
			// 선택된 학생들의 번호, 각 학생에 대한 확인이 끝났는지 여부를 저장할 각 배열 초기화
			selection = new int[studentNum + 1];
			checked = new int[studentNum + 1];
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 선택된 학생들의 번호를 배열 selection에 저장
			for (int idx = 1; idx < selection.length; idx++)
				selection[idx] = Integer.parseInt(st.nextToken());
			
			// for 반복문을 사용해 각 학생을 순회
			for (int student = 1; student < selection.length; student++) {
				
				// 해당 학생에 대한 확인이 필요한 경우 teamMaker() 메서드를 호출해 해당 학생이 프로젝트 팀에 속했는지 여부를 갱신
				if (checked[student] == NOT_CHECKED)
					teamMaker(student);
			}
			
			// for 반복문을 사용해 각 학생을 순회
			for (int student = 1; student < checked.length; student++) {
				
				// 해당 학생이 팀에 속하지 않은 경우 프로젝트 팀에 속하지 못한 학생들의 수 갱신
				if (checked[student] != TEAM_MADE)
					count++;
			}
			
			// write() 메서드를 사용해 프로젝트 팀에 속하지 못한 학생들의 수를 출력
			out.write(count + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// teamMaker() 메서드 정의
	public static void teamMaker(int student) {
		
		// 현재 확인 중인 학생을 나타낼 변수 curStudent 초기화
		int curStudent = student;
		
		// while 반복문을 사용해 확인이 필요한 모든 학생을 순회
		while (true) {
			
			// 현재 확인 중인 학생의 확인 여부를 갱신
			checked[curStudent] = student;
			
			// 현재 확인 중인 학생을 갱신
			curStudent = selection[curStudent];
			
			// 해당 학생이 이번에 팀을 이루게 된 경우
			if (checked[curStudent] == student) {
				
				// while 반복문을 사용해 팀을 이룬 학생의 확인 여부를 갱신
				while (checked[curStudent] != TEAM_MADE) {
					checked[curStudent] = TEAM_MADE;
					curStudent = selection[curStudent];
				}
				
				// 메서드 종료
				return;
			
			// 해당 학생을 이전에 확인한 경우 메서드 종료
			} else if (checked[curStudent] != NOT_CHECKED) {
				return;
			}
		}
	}
}