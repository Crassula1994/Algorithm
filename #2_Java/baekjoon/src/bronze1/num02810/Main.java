package bronze1.num02810;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 사람의 수를 변수 people에 할당
		int people = Integer.parseInt(in.readLine());
		
		// readLine() 및 toCharArray() 메서드를 사용해 좌석의 배치를 배열 seats에 저장
		char[] seats = in.readLine().toCharArray();

		// 컵홀더의 개수를 저장할 변수 cupHolder 초기화
		int cupHolder = people + 1;
		
		// 커플석의 개수를 저장할 변수 coupleSeats 초기화
		int coupleSeats = 0;
		
		// for 반복문을 사용해 각 좌석을 순회
		for (char seat : seats) {
			
			// 커플석이 있는 경우 커플의 개수 조정
			if (seat == 'L')
				coupleSeats += 1;
		}
		
		// 컵홀더의 개수를 커플석의 개수를 반영해 조정
		cupHolder -= coupleSeats / 2;
		
		// min() 메서드를 사용해 컵홀더의 개수가 사람 수보다 많은지 검사한 후 사용할 수 있는 최대 사람의 수를 갱신
		cupHolder = Math.min(people, cupHolder);
		
		// valueOf() 및 write() 메서드를 사용해 컵홀더를 사용할 수 있는 최대 사람의 수를 출력
		out.write(String.valueOf(cupHolder));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}