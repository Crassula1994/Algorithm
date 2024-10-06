package silver3.num13932;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// Room 클래스 정의
	static class Room {
		
		// 고사실의 번호와 해당 고사실의 학생 수를 저장할 각 변수 초기화
		int number;
		int studentNum;
		
		// 매개변수를 입력 받는 생성자 정의
		public Room(int number, int studentNum) {
			this.number = number;
			this.studentNum = studentNum;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 고사실의 수를 변수 roomNum에 할당
		int roomNum = Integer.parseInt(in.readLine());
		
		// 전체 학생 수를 저장할 변수 studentSum 초기화
		int studentSum = 0;
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// 고사실 정보를 저장할 배열 rooms 초기화
		Room[] rooms = new Room[roomNum];
		
		// for 반복문을 사용해 입력 받은 고사실 정보를 순회
		for (int idx = 0; idx < rooms.length; idx++) {
			
			// nextToken() 및 parseIntt() 메서드를 사용해 입력 받은 고사실 정보를 배열 rooms에 저장
			rooms[idx] = new Room(idx + 1, Integer.parseInt(st.nextToken()));
			
			// 전체 학생 수를 갱신
			studentSum += rooms[idx].studentNum;
		}
		
		// sort() 메서드를 사용해 고사실을 학생 수가 많은 순으로 정렬
		Arrays.sort(rooms, (r1, r2) -> {
			return r2.studentNum - r1.studentNum;
		});
		
		/* 가장 많은 학생을 가진 고사실의 인원이 전체 인원의 절반을 초과하는 경우 시험지를 안전하게 나눠줄 수 없으므로
		'impossible' 출력 */
		if (rooms[0].studentNum * 2 > studentSum) {
			out.write("impossible");
			
		// 가장 많은 학생을 가진 고사실의 인원이 전체 인원의 절반 이하인 경우
		} else {
			
			// for 반복문을 사용해 시험지를 안전하게 나눠줄 고사실의 이동 순서를 출력
			for (Room room : rooms)
				out.write(room.number + " ");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}