package bronze1.num01333;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 노래의 수, 노래의 길이, 전화벨이 울리는 간격을 각 변수에 할당
		int songNum = Integer.parseInt(st.nextToken());
		int songLength = Integer.parseInt(st.nextToken());
		int ringTerm = Integer.parseInt(st.nextToken());
		
		// 전화벨을 들을 수 있는 시간을 저장할 변수 curTime 초기화
		int curTime = 0;
		
		// 각 시간에서 전화벨을 들을 수 있는지 여부를 저장할 배열 canListen 초기화
		boolean[] canListen = new boolean[songNum * (songLength + 5) + 20];
		
		// for 반복문을 사용해 각 시간을 순회
		for (int time = 0; time < canListen.length; time++) {
			
			// 전화벨을 들을 수 있는 시간인 경우 전화벨을 들을 수 있는지 여부를 갱신
			if (time % (songLength + 5) >= songLength || time >= songNum * (songLength + 5))
				canListen[time] = true;
		}
		
		// while 반복문을 사용해 전화벨을 들을 수 있는 시간을 갱신
		while (!canListen[curTime])
			curTime += ringTerm;
		
		// valueOf() 및 write() 메서드를 사용해 전화벨을 들을 수 있는 시간을 출력
		out.write(String.valueOf(curTime));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}