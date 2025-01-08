package bronze1.num16466;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 1차 티켓팅에서 팔린 티켓의 개수를 변수 ticketNum에 할당
		int ticketNum = Integer.parseInt(in.readLine());
		
		// 2차 티켓팅에서 양한이가 가질 수 있는 가장 작은 티켓의 번호를 저장할 변수 minNumber 초기화
		int minNumber = 1;
		
		// 1차 티켓팅에서 팔린 티켓의 번호를 저장할 Set 객체 tickets 초기화
		Set<Integer> tickets = new HashSet<>();
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// while 반복문을 사용해 입력 받은 1차 티켓팅에서 팔린 티켓의 번호를 tickets에 저장
		while (ticketNum-- > 0)
			tickets.add(Integer.parseInt(st.nextToken()));
		
		// while 반복문을 사용해 2차 티켓팅에서 양한이가 가질 수 있는 가장 작은 티켓의 번호를 갱신
		while (tickets.contains(minNumber))
			minNumber++;
		
		// valueOf() 및 write() 메서드를 사용해 2차 티켓팅에서 양한이가 가질 수 있는 가장 작은 티켓의 번호를 출력
		out.write(String.valueOf(minNumber));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}