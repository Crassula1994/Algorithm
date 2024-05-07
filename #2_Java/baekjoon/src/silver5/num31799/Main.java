package silver5.num31799;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 다닌 학기의 수를 변수 semesterNum에 할당
		int semesterNum = Integer.parseInt(in.readLine());
		
		// 각 학기의 성적을 저장할 배열 grades 초기화
		String[] grades = new String[semesterNum];
		
		// readLine() 메서드를 사용해 기존 평어를 나열한 문자열을 변수 gradeStr에 할당
		String gradeStr = in.readLine();
		
		// 새로운 체제에 맞게 평어를 변환한 결과를 저장할 StringBuilder 객체 sb 초기화
		StringBuilder sb = new StringBuilder();
		
		// 현재 확인 중인 문자열의 인덱스를 나타낼 변수 index 초기화
		int index = 0;
		
		// for 반복문을 사용해 각 학기를 순회
		for (int idx = 0; idx < semesterNum; idx++) {
			
			// charAt() 메서드를 사용해 해당 학기 성적 문자열의 각 글자를 각 변수에 할당
			char front = gradeStr.charAt(index);
			char rear = (index == gradeStr.length() - 1) ? '0' : gradeStr.charAt(index + 1);
			
			// 실수로 0을 생략한 경우
			if (rear != '+' && rear != '0' && rear != '-') {
				
				// valueOf() 메서드를 사용해 해당 학기의 성적을 배열 grades에 저장
				grades[idx] = String.valueOf(front) + "0";
				
				// 다음에 확인할 문자열의 인덱스를 갱신
				index++;
				
			// 실수로 0을 생략하지 않은 경우
			} else {
				
				// valueOf() 메서드를 사용해 해당 학기의 성적을 배열 grades에 저장
				grades[idx] = String.valueOf(front) + String.valueOf(rear);
				
				// 다음에 확인할 문자열의 인덱스를 갱신
				index += 2;
			}
			
			// switch 조건문을 사용해 각 성적의 종류에 따라 새로운 평어를 갱신
			switch (grades[idx]) {
				
				// 평어가 C-, C0, C+ 가운데 하나인 경우
				case "C-":
				case "C0":
				case "C+":
					sb.append("B");
					break;
					
				// 평어가 B-, B0 가운데 하나인 경우
				case "B-":
				case "B0":
					if (idx == 0 || grades[idx - 1].charAt(0) == 'C') {
						sb.append("D");
					} else {
						sb.append("B");
					}
					break;
				
				// 평어가 B+, A- 가운데 하나인 경우
				case "B+":
				case "A-":
					if (idx == 0 || grades[idx - 1].charAt(0) == 'C'
							|| grades[idx - 1].equals("B-") || grades[idx - 1].equals("B0")) {
						sb.append("P");
					} else {
						sb.append("D");
					}
					break;
					
				// 평어가 A0인 경우
				case "A0":
					if (idx == 0 || grades[idx - 1].charAt(0) == 'C'
							|| grades[idx - 1].charAt(0) == 'B' || grades[idx - 1].equals("A-")) {
						sb.append("E");
					} else {
						sb.append("P");
					}
					break;
					
				// 평어가 A+인 경우
				default:
					sb.append("E");
			}
		}
		
		// toString() 및 write() 메서드를 사용해 새로운 체제에 맞게 평어를 변환한 결과를 출력
		out.write(sb.toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}