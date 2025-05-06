package silver2.num33183;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 입력 받은 게시판의 각 줄, 3개의 자격증을 취득하기 위해 수강해야 할 최소 강의의 수를 저장할 각 변수 초기화
		String line;
		int minCount = Integer.MAX_VALUE;
		
		// 입력 받은 게시판의 내용 및 각 교육 과정 정보를 저장할 각 List 객체 초기화
		List<char[]> board = new ArrayList<char[]>();
		List<Set<String>> curricula = new ArrayList<>();
		
		// while 반복문을 사용해 각 게시판의 내용을 board에 저장
		while ((line = in.readLine()) != null)
			board.add(line.toCharArray());
			
		// for 반복문을 사용해 각 게시판의 줄을 순회
		for (int sr = 1; sr < board.size() - 1; sr++) {
			
			// get() 메서드를 사용해 현재 게시판의 줄을 배열 curRow에 할당
			char[] curRow = board.get(sr);
			
			// for 반복문을 사용해 각 칸을 순회
			for (int sc = 1; sc < curRow.length - 1; sc++) {
				
				// 교육 과정 박스의 왼쪽 끝이 아닌 경우 다음 칸을 순회
				if (curRow[sc] != '+' || curRow[sc - 1] == '-' || board.get(sr - 1)[sc] == '|')
					continue;
				
				// 해당 교육 과정 박스의 끝행과 끝열을 나타낼 각 변수 초기화
				int er = sr + 1;
				int ec = sc + 1;
				
				// 해당 교육 과정에 속한 강의를 저장할 Set 객체 curriculum 초기화
				Set<String> curriculum = new HashSet<>();
				
				// while 반복문을 사용해 해당 교육 과정 박스의 끝열을 갱신
				while (curRow[ec] == '-')
					ec++;
				
				// while 반복문을 사용해 해당 교육 과정 박스의 각 행을 순회
				while (board.get(er)[sc] == '|') {
					
					// get() 메서드를 사용해 해당 교육 과정 박스의 행을 배열 row에 할당
					char[] row = board.get(er);
					
					// 해당 강의의 이름을 저장할 StringBuilder 객체 sb 초기화
					StringBuilder sb = new StringBuilder();
					
					// for 반복문을 사용해 각 칸을 순회
					for (int c = sc + 1; c < ec; c++) {
						
						// 빈 칸인 경우 다음 칸을 순회
						if (row[c] == ' ')
							continue;
						
						// toLowerCase() 및 append() 메서드를 사용해 해당 글자를 sb에 추가
						sb.append(Character.toLowerCase(row[c]));
					}
					
					// 강의가 존재하는 경우 curriculum에 추가
					if (sb.length() > 0)
						curriculum.add(sb.toString());
					
					// 해당 교육 과정 박스의 끝행을 갱신
					er++;
				}
				
				// add() 메서드를 사용해 해당 교육 과정 정보를 curricula에 저장
				curricula.add(curriculum);
			}
		}
		
		// size() 메서드를 사용해 교육 과정의 수를 변수 curriculumNum에 할당
		int curriculumNum = curricula.size();
		
		// for 반복문을 사용해 각 커리큘럼 조합을 순회
		for (int c1 = 0; c1 < curriculumNum - 2; c1++) {
			for (int c2 = c1 + 1; c2 < curriculumNum - 1; c2++) {
				for (int c3 = c2 + 1; c3 < curriculumNum; c3++) {
					
					// 해당 커리큘럼 조합을 선택했을 때 들어야 하는 강의를 저장할 Set 객체 courses 초기화
					Set<String> courses = new HashSet<>();
					
					// get() 및 addAll() 메서드를 사용해 해당 커리큘럼 조합을 선택했을 때 들어야 하는 강의를 갱신
					courses.addAll(curricula.get(c1));
					courses.addAll(curricula.get(c2));
					courses.addAll(curricula.get(c3));
					
					// size() 및 min() 메서드를 사용해 3개의 자격증을 취득하기 위해 수강해야 할 최소 강의의 수를 갱신
					minCount = Math.min(courses.size(), minCount);
				}
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 3개의 자격증을 취득하기 위해 수강해야 할 최소 강의의 수를 출력
		out.write(String.valueOf(minCount));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}